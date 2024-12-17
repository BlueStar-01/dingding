package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.dingdign.pojo.entity.Orders;
import com.heima.dingdign.pojo.vo.OrderDetailVO;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
public interface IOrdersService extends IService<Orders> {

    Orders cleanCart();

    List<OrderDetailVO> getOrderDetail(Long orderId);
}
