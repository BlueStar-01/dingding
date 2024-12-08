package com.heima.dingding.collection;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heima.dingding.result.Result;
import com.heima.dingding.service.CollectionService;
import com.itheima.dingdign.pojo.dto.CollectionDto;
import com.itheima.dingdign.pojo.entity.Collection;
import com.itheima.dingdign.pojo.vo.CollectionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collection")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    /**
     * 查询当前用户的所有的收藏夹
     */
    @GetMapping("/userId/{userId}")
    public Result<List<CollectionVO>> getCollection(@PathVariable Long userId) {
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
     * 根据id获得收藏夹
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Collection> getCollection(@PathVariable long id) {
        Collection byId = collectionService.getById(id);
        return Result.success(byId);
    }

    /**
     * 根据id删除收藏夹
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delCollection(@PathVariable long id) {
        Collection byId = collectionService.getById(id);
        if (byId != null) {
            collectionService.removeById(id);
        }
        return Result.success();
    }
}
