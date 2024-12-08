package com.heima.dingding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.dingdign.pojo.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 碧蓝小新星
* @description 针对表【shopping_cart(购物车表)】的数据库操作Mapper
* @createDate 2024-11-19 22:36:41
* @Entity com.heima.dingding.domian.ShoppingCart
*/
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}




