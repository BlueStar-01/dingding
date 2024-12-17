package com.heima.dingding.collection;

import com.heima.dingdign.pojo.entity.Orders;
import com.heima.dingdign.pojo.vo.OrderDetailVO;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.context.BaseContext;
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
     * 返回当前用户的所有订单
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<Orders>> list() {
        List<Orders> orders = ordersService.lambdaQuery().eq(Orders::getUserId, BaseContext.getCurrentId()).list();
        if (orders == null || orders.isEmpty()) {
            return Result.success(MessageConstant.COL_NOT_FOUND, null);
        }
        return Result.success(orders);
    }


    /**
     * 清空购物车生成订单信息
     *
     * @return
     */
    @PutMapping("/clean")
    private Result<Orders> cleanCart() {
        Orders order = ordersService.cleanCart();
        return Result.success(order);
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
