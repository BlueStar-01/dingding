package com.heima.dingding.collection;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heima.dingdign.pojo.dto.CollectionDto;
import com.heima.dingdign.pojo.entity.Collection;
import com.heima.dingdign.pojo.vo.CollectionVO;
import com.heima.dingding.context.BaseContext;
import com.heima.dingding.result.Result;
import com.heima.dingding.service.ICollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collection")
@RequiredArgsConstructor
public class CollectionController {

    private final ICollectionService collectionService;

    /**
     * 查询当前用户的所有的收藏夹
     */
    @GetMapping("/list")
    public Result<List<CollectionVO>> getCollection() {
        //从线程变量中获得用户id
        Long userId = BaseContext.getCurrentId();
        //从数据库查询当前用户的收藏夹信息,按照修改时间。
        List<Collection> list = collectionService.list(
                new LambdaQueryWrapper<Collection>().
                        eq(Collection::getUserId, userId)
                        .orderByAsc(Collection::getUpdateTime));
        List<CollectionVO> ret = new ArrayList<>();
        //转换到view对象。
        list.forEach(t -> {
            CollectionVO vo = new CollectionVO();
            BeanUtils.copyProperties(t, vo);
            ret.add(vo);
        });
        return Result.success(ret);
    }

    /**
     * 修改收藏夹
     *
     * @param dto
     * @return
     */
    @PostMapping
    public Result postCollection(@RequestBody CollectionDto dto) {
        Collection collection = new Collection();
        BeanUtils.copyProperties(dto, collection);
        collectionService.updateById(collection);
        return Result.success();
    }

    /**
     * 添加收藏夹
     *
     * @param dto
     * @return
     */
    @PutMapping
    public Result addCollection(@RequestBody CollectionDto dto) {
        Collection collection = new Collection();
        BeanUtils.copyProperties(dto, collection);
        collectionService.save(collection);
        return Result.success();
    }


    /**
     * 获得收藏夹详细信息
     *
     * @param collectionId
     * @return
     */
    @GetMapping("/{collectionId}")
    public Result<Collection> getCollection(@PathVariable long collectionId) {
        Collection byId = collectionService.getById(collectionId);
        return Result.success(byId);
    }

    /**
     * 根据收藏夹id删除收藏夹
     *
     * @param collectionId
     * @return
     */
    @DeleteMapping("/{collectionId}")
    public Result delCollection(@PathVariable long collectionId) {
        Collection byId = collectionService.getById(collectionId);
        if (byId != null) {
            collectionService.removeById(collectionId);
        }
        return Result.success();
    }
}
