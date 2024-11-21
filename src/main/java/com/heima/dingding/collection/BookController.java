package com.heima.dingding.collection;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dingding.pojo.entity.Book;
import com.heima.dingding.pojo.result.Result;
import com.heima.dingding.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private  BookService bookService;

    @GetMapping("/page")
    public Result<Page<Book>> page(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Book> books = bookService.page(new Page<>(pageNo, pageSize));
        return Result.success(books);
    }

    @GetMapping("/list")
    public Result<List<Book>> list(Book dto) {
        List list = bookService.listByBook(dto);
        return Result.success(list);
    }


}
