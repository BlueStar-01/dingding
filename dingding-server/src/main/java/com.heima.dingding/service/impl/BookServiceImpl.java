package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingding.mapper.BookMapper;
import com.heima.dingding.service.BookService;
import com.itheima.dingdign.pojo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 碧蓝小新星
 * @description 针对表【book(书籍信息表)】的数据库操作Service实现
 * @createDate 2024-11-19 22:36:41
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {

    @Override
    public List listByBook(Book dto) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Book> like = queryWrapper.lambda()
                .like(Book::getName, dto.getName())
                .like(Book::getAuthor, dto.getAuthor())
                .like(Book::getIsbn, dto.getIsbn());
        List<Book> list = list(like);
        return list;
    }
}




