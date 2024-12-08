package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingding.mapper.BookCollectionMapper;
import com.heima.dingding.service.BookCollectionService;
import com.itheima.dingdign.pojo.entity.BookCollection;
import org.springframework.stereotype.Service;

/**
* @author 碧蓝小新星
* @description 针对表【book_collection(记录了收藏集里的书)】的数据库操作Service实现
* @createDate 2024-11-19 22:36:41
*/
@Service
public class BookCollectionServiceImpl extends ServiceImpl<BookCollectionMapper, BookCollection>
    implements BookCollectionService {

}




