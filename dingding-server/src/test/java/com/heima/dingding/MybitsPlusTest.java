package com.heima.dingding;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingding.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybitsPlusTest {
    @Autowired
    IBookService bookService;

    @Test
    public void test() {
        Integer a = null;
        Integer b = 100;

        Page<Book> page = bookService.lambdaQuery()
                .between(Book::getPrice, a, b)
                .page(new Page<>(1, 10));

        System.out.println(page);
    }
}
