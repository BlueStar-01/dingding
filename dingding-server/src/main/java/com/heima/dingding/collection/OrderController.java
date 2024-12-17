package com.heima.dingding.collection;

import com.heima.dingdign.pojo.entity.Orders;
import com.heima.dingdign.pojo.vo.OrderDetailVO;
import com.heima.dingding.domain.Result;
import com.heima.dingding.service.IOrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final IOrdersService ordersService;


    /**
     * 清空购物车生成订单信息
     *
     * @return
     */
    @PutMapping("/clean")
    private Result<Orders> cleanCart() {
        Orders order = ordersService.cleanCart();
        return Result.success();
    }

    /**
     * 查看订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    private Result<List<OrderDetailVO>> orderDetail(@RequestParam Long orderId) {
        List<OrderDetailVO> ret = ordersService.getOrderDetail(orderId);
        return Result.success(ret);
    }
}
