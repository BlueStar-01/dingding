package com.heima.dingding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.dto.CartDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingdign.pojo.entity.BookCart;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.context.BaseContext;
import com.heima.dingding.exception.BookNoFoundException;
import com.heima.dingding.mapper.BookCartMapper;
import com.heima.dingding.service.IBookCartService;
import com.heima.dingding.service.IBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

/**
 * <p>
 * 购物内容表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BookCartServiceImpl extends ServiceImpl<BookCartMapper, BookCart> implements IBookCartService {

    private final IBookService bookService;


    @Override
    public void addBook(CartDto cartDto) {
        //檢查书籍是否存在
        Long count = bookService.lambdaQuery()
                .eq(Book::getId, cartDto.getBookId())
                .count();
        if (count <= 0) {
            throw new BookNoFoundException(MessageConstant.BOOK_NOT_FOUND);
        }
        cartDto.setNumber(cartDto.getNumber() != null ? cartDto.getNumber() : 1);
        BookCart cartCol = null;
        try {
            //查找是不是用重复的记录
            cartCol = lambdaQuery()
                    .eq(BookCart::getBookId, cartDto.getBookId())
                    .eq(BookCart::getUserId, BaseContext.getCurrentId())
                    .list().getFirst();
        } catch (NoSuchElementException e) {
            log.error("查找数据为空");
        }
        //如果已经有了就更新数量
        if (cartCol != null) {
            cartCol.setNumber(cartDto.getNumber() + cartCol.getNumber());
            //小于0就删除记录
            if (cartCol.getNumber() <= 0) {
                removeById(cartCol.getId());
            }
            updateById(cartCol);
        } else {
            //复制添加属性
            cartCol = new BookCart();
            BeanUtils.copyProperties(cartDto, cartCol);
            cartCol.setUserId(BaseContext.getCurrentId())
                    .setCreateTime(LocalDateTime.now())
                    .setUpdateTime(LocalDateTime.now())
                    .setNumber(cartDto.getNumber());
            save(cartCol);
        }
    }
}
