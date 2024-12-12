package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.heima.dingdign.pojo.dto.BookCollectionDto;
import com.heima.dingdign.pojo.entity.BookCollection;
import com.heima.dingding.domain.Result;
import com.heima.dingding.service.IBookCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/BookCollection")
public class BookCollectionController {

    private final IBookCollectionService bookCollectionService;

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
        //添加进数据库
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
