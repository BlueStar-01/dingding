package com.heima.dingding.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.dingdign.pojo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 书籍信息表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
