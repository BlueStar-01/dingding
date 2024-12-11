package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.dingdign.pojo.dto.BookDto;
import com.heima.dingdign.pojo.dto.BookPageDto;
import com.heima.dingdign.pojo.entity.Book;

import java.util.List;

/**
 * <p>
 * 书籍信息表 服务类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
public interface IBookService extends IService<Book> {


    List listByBook(Book dto);

    void addBook(BookDto book);

    Page<Book> bookPage(BookPageDto bookPageDto);
}
