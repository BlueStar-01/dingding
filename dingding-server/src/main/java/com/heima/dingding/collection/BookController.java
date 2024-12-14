package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dingdign.pojo.dto.BookDto;
import com.heima.dingdign.pojo.dto.BookPageQueryDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.domain.Result;
import com.heima.dingding.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final IBookService bookService;

    /**
     * 添加书籍
     *
     * @param book
     * @return
     */
    @PutMapping("/add")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Result addBook(@RequestBody BookDto book) {
        log.info("添加书籍：{}", book);
        bookService.addBook(book);
        return Result.success();
    }

    /**
     * 条件分页查询书籍
     *
     * @param bookPageDto
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Book>> page(@RequestBody BookPageQueryDto bookPageDto) {
        Page<Book> books = bookService.bookPage(bookPageDto);
        return Result.success(books);
    }

    /**
     * 根据id查询书籍
     *
     * @param bookId
     * @return
     */
    @GetMapping("/{bookId}")
    public Result<Book> getById(@PathVariable Long bookId) {
        if (bookId == null) {
            return Result.error("ID为空");
        }
        Book book = bookService.getById(bookId);
        return book != null ? Result.success(book) : Result.error("不存在的书籍");
    }

    /**
     * 根据id删除书籍
     *
     * @param bookId
     * @return
     */
    @DeleteMapping("/{bookId}")
    public Result deleteById(@PathVariable Long bookId) {
        bookService.removeById(bookId);
        return Result.success();
    }

    /**
     * 根据ids批量删除书籍
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestBody List<Long> ids) {
        bookService.removeByIds(ids);
        return Result.success();
    }

    /**
     * 修改书籍
     *
     * @param
     * @return
     */
    @PostMapping
    public Result updateBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        boolean updated = bookService.updateById(book);
        if (!updated) {
            return Result.error(MessageConstant.UPDATE_FAILED);
        }
        return Result.success();
    }
}
