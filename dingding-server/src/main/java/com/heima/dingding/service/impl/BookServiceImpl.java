package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.dto.BookDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingding.mapper.BookMapper;
import com.heima.dingding.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 书籍信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    /**
     * 书籍条件查询
     *
     * @param dto
     * @return
     */
    @Override
    public List listByBook(Book dto) {
        return List.of();
    }

    /**
     * 添加书籍
     *
     * @param bookdto
     */
    @Transactional
    @Override
    public void addBook(BookDto bookdto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookdto, book);
        baseMapper.insert(book);
    }
}
