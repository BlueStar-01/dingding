package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.dingdign.pojo.dto.CartDto;
import com.heima.dingdign.pojo.entity.BookCart;
/**
 * <p>
 * 购物内容表 服务类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
public interface IBookCartService extends IService<BookCart> {

    void addBook(CartDto cartDto);
}
