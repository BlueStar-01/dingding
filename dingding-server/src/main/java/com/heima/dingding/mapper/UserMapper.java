package com.heima.dingding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.dingdign.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
