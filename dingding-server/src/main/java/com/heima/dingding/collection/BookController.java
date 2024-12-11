package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dingdign.pojo.dto.BookDto;
import com.heima.dingdign.pojo.dto.BookPageDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingding.result.Result;
import com.heima.dingding.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * 分页查询书籍
     *
     * @param bookPageDto
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Book>> page(@RequestBody BookPageDto bookPageDto) {
        Page<Book> books = bookService.bookPage(bookPageDto);
        return Result.success(books);
    }

    /**
     * 根据书籍对象中的条件来进行条件查询。
     *
     * @param dto
     * @return
     */
    @GetMapping("/list")
    public Result<List<Book>> list(@RequestBody Book dto) {
        List list = bookService.listByBook(dto);
        return Result.success(list);
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
}
