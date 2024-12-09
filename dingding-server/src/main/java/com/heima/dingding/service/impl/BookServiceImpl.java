package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingding.mapper.BookMapper;
import com.heima.dingding.service.IBookService;
import org.springframework.stereotype.Service;

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

}
