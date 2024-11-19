package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingding.mapper.BookMapper;
import com.heima.dingding.service.BookService;
import com.heima.dingding.pojo.entity.Book;
import org.springframework.stereotype.Service;

/**
* @author 碧蓝小新星
* @description 针对表【book(书籍信息表)】的数据库操作Service实现
* @createDate 2024-11-19 22:36:41
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService {

}




