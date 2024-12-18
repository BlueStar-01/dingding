package com.heima.dingding;

import com.heima.dingdign.pojo.entity.OrderDetail;
import com.heima.dingding.service.IBookService;
import com.heima.dingding.service.IOrderDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MybitsPlusTest {
    @Autowired
    IBookService bookService;

    @Autowired
    IOrderDetailService orderDetailService;

    @Test

    public void test() {
        OrderDetail set = new OrderDetail().setOrderId(1L)
                .setBookId(3L)
                .setNumber(2)
                .setCreateTime(LocalDateTime.now());
        boolean save = orderDetailService.save(set);
        orderDetailService.getById(save);
        System.out.println(save);
//        List<OrderDetail> details = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setNumber(i);
//            orderDetail.setOrderId((long) i);
//        }
//        System.out.println(details);
//        boolean b = orderDetailService.saveBatch(details);
//        System.out.println(b);
    }
}
