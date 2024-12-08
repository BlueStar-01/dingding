package com.heima.dingding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.dingdign.pojo.entity.Book;

import java.util.List;

/**
* @author 碧蓝小新星
* @description 针对表【book(书籍信息表)】的数据库操作Service
* @createDate 2024-11-19 22:36:41
*/
public interface BookService extends IService<Book> {

    /**
     * 条件查询
     * @param dto
     * @return
     */
    List listByBook(Book dto);
}
