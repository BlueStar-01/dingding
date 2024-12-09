package com.heima.dingding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.entity.BookCollection;
import com.heima.dingding.mapper.BookCollectionMapper;
import com.heima.dingding.service.IBookCollectionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记录了收藏集里的书 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class BookCollectionServiceImpl extends ServiceImpl<BookCollectionMapper, BookCollection> implements IBookCollectionService {

}
