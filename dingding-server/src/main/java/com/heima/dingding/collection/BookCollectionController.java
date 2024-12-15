package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.heima.dingdign.pojo.dto.BookCollectionDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingdign.pojo.entity.BookCollection;
import com.heima.dingdign.pojo.entity.Collection;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.domain.Result;
import com.heima.dingding.service.IBookCollectionService;
import com.heima.dingding.service.IBookService;
import com.heima.dingding.service.ICollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/BookCollection")
public class BookCollectionController {

    private final IBookCollectionService bookCollectionService;

    private final IBookService bookService;

    private final ICollectionService collectionService;

    /**
     * 获得收藏夹中的所有书籍
     *
     * @param collectionId
     * @return
     */
    @GetMapping("/getList")
    public Result<List<Book>> getList(@RequestParam Long collectionId) {
        //查询所有的数据
        List<BookCollection> list = bookCollectionService.lambdaQuery()
                .eq(BookCollection::getCollectionId, collectionId)
                .list();
        //获得所有的书籍id
        ArrayList<Long> bookIds = new ArrayList<>();
        list.forEach(s -> bookIds.add(s.getBookId()));
        //查询书籍
        List<Book> books = bookService.listByIds(bookIds);
        return Result.success(books);
    }


    /**
     * 把书籍添加进收藏夹
     *
     * @param bookCollectionDto
     * @return
     */
    @PutMapping("/add")
    public Result addBookCollection(@RequestBody BookCollectionDto bookCollectionDto) {
        BookCollection controller = new BookCollection();
        BeanUtils.copyProperties(bookCollectionDto, controller);
        //检查书籍和收藏夹是否存在
        Long bookCount = bookService.lambdaQuery().eq(Book::getId, bookCollectionDto.getBookId()).count();
        Long collectionCount = collectionService.lambdaQuery().eq(Collection::getId, bookCollectionDto.getCollectionId()).count();
        //添加进数据库
        if (bookCount <= 0 || collectionCount <= 0) {
            return Result.error(MessageConstant.BOOK_OR_COLLECTION_NOT_FOUND);
        }
        //检查是否重复添加
        Long cowCount = bookCollectionService.lambdaQuery()
                .eq(BookCollection::getBookId, bookCollectionDto.getBookId())
                .eq(BookCollection::getCollectionId, bookCollectionDto.getCollectionId())
                .count();
        if (cowCount != 0) {
            return Result.error(MessageConstant.COL_ALREADY_EXISTS);
        }
        bookCollectionService.save(controller);
        return Result.success();
    }

    /**
     * 把书籍移除收藏夹
     *
     * @param bookCollectionDto
     * @return
     */
    @DeleteMapping("/del")
    public Result delBookCollection(@RequestBody BookCollectionDto bookCollectionDto) {
        LambdaQueryChainWrapper<BookCollection> wrapper = bookCollectionService.lambdaQuery()
                .eq(BookCollection::getCollectionId, bookCollectionDto.getCollectionId())
                .eq(BookCollection::getBookId, bookCollectionDto.getBookId());
        bookCollectionService.remove(wrapper);
        return Result.success();
    }

}
