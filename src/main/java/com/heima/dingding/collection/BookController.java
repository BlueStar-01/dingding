package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dingding.pojo.entity.Book;
import com.heima.dingding.pojo.result.Result;
import com.heima.dingding.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    /**
     * 分页查询书籍
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Book>> page(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Book> page = new Page<>(pageNo, pageSize);
        Page<Book> books = bookService.page(page);
        return Result.success(books);
    }


    /**
     * 根据书籍对象中的条件来进行条件查询。
     * @param dto
     * @return
     */
    @GetMapping("/list")
    public Result<List<Book>> list(Book dto) {
        List list = bookService.listByBook(dto);
        return Result.success(list);
    }

    /**
     * 根据ID来查询书籍
     * @param bookId
     * @return
     */
    @GetMapping("/{bookId}")
    public Result<Book> getById(@PathVariable Long bookId) {
        if (bookId == null) {
            return  Result.error("ID为空");
        }
        Book book = bookService.getById(bookId);
        return book != null ? Result.success(book) : Result.error("不存在的书籍");
    }
}
