package com.heima.dingding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.dingdign.pojo.entity.BookCollection;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 碧蓝小新星
* @description 针对表【book_collection(记录了收藏集里的书)】的数据库操作Mapper
* @createDate 2024-11-19 22:36:41
* @Entity com.heima.dingding.domian.BookCollection
*/
@Mapper
public interface BookCollectionMapper extends BaseMapper<BookCollection> {

}




