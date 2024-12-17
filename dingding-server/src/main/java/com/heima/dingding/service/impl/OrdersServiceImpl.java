package com.heima.dingding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingdign.pojo.entity.BookCart;
import com.heima.dingdign.pojo.entity.OrderDetail;
import com.heima.dingdign.pojo.entity.Orders;
import com.heima.dingdign.pojo.vo.OrderDetailVO;
import com.heima.dingding.constant.PayConstant;
import com.heima.dingding.context.BaseContext;
import com.heima.dingding.mapper.OrdersMapper;
import com.heima.dingding.service.IBookCartService;
import com.heima.dingding.service.IBookService;
import com.heima.dingding.service.IOrderDetailService;
import com.heima.dingding.service.IOrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    private final IBookCartService cartService;
    private final IBookService bookService;
    private final IOrderDetailService detailService;


    /**
     * 清除购物车并生成订单
     *
     * @return
     */
    @Override
    @Transactional
    public Orders cleanCart() {
        //查询购物车数据
        List<BookCart> carts = cartService.lambdaQuery().eq(BookCart::getUserId, BaseContext.getCurrentId())
                .list();
        //清除购物车
        cartService.removeBatchByIds(carts);
        //生成订单
        Orders orders = new Orders().setCreateTime(LocalDateTime.now())
                .setUserId(BaseContext.getCurrentId())
                .setStatus(PayConstant.NO_PAY);
        //保存
        saveOrUpdate(orders);
        //查询订单是否生成成功
        orders = getById(orders);
        //添加订单详细数据
        List<OrderDetail> details = new ArrayList<>();
        for (BookCart bookCart : carts) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(orders.getId());
            detail.setBookId(bookCart.getBookId());
            detail.setNumber(bookCart.getNumber());
            detail.setCreateTime(LocalDateTime.now());
            detail.setUpdateTime(LocalDateTime.now());
        }
        detailService.saveBatch(details);
        return orders;
    }

    @Override
    public List<OrderDetailVO> getOrderDetail(Long orderId) {
        //查询订单详情
        List<OrderDetail> details = detailService.lambdaQuery().eq(OrderDetail::getOrderId, orderId).list();
        //查询书籍信息
        Set<Long> bookIds = details.stream().map(OrderDetail::getBookId).collect(Collectors.toSet());
        List<Book> books = bookService.listByIds(bookIds);

        //构建订单信息
        List<OrderDetailVO> detailVOList = new ArrayList<>();
        for (int i = 0; i < details.size(); i++) {
            Book book = books.get(i);
            OrderDetail detail = details.get(i);
            OrderDetailVO vo = new OrderDetailVO();
            vo = vo.setBookName(book.getName())
                    .setCoverImg(book.getCoverImg())
                    .setDescription(book.getDescription())
                    .setNumber(detail.getNumber())
                    .setSumPrice(detail.getNumber() * book.getPrice());
            detailVOList.add(vo);
        }
        return detailVOList;
    }
}
