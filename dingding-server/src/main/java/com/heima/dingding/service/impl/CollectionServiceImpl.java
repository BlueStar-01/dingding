package com.heima.dingding.service.impl;


import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.entity.BookCollection;
import com.heima.dingdign.pojo.entity.Collection;
import com.heima.dingding.mapper.BookCollectionMapper;
import com.heima.dingding.mapper.CollectionMapper;
import com.heima.dingding.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 收藏夹表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Autowired
    private BookCollectionMapper bookCollectionMapper;

    /**
     * 删除收藏夹
     *
     * @param collectionId
     * @return
     */
    @Override
    @Transactional
    public Boolean reById(Long collectionId) {
        //删除收藏夹中的书籍
        LambdaQueryChainWrapper<BookCollection> BCwrapper = new LambdaQueryChainWrapper<>(bookCollectionMapper);
        BCwrapper.eq(BookCollection::getCollectionId, collectionId);
        int deleted = bookCollectionMapper.delete(BCwrapper);
        //删除收藏夹
        LambdaQueryChainWrapper<Collection> wrapper = lambdaQuery().eq(Collection::getId, collectionId);
        return remove(wrapper);
    }
}
