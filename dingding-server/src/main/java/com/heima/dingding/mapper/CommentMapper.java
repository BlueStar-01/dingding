package com.heima.dingding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.dingdign.pojo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户评论表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
