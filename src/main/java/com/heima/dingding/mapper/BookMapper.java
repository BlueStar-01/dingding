package com.heima.dingding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.dingding.pojo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 碧蓝小新星
* @description 针对表【book(书籍信息表)】的数据库操作Mapper
* @createDate 2024-11-19 22:36:41
* @Entity com.heima.dingding.domian.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




