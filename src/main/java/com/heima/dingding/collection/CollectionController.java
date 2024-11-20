package com.heima.dingding.collection;

import com.heima.dingding.pojo.dto.CollectionDto;
import com.heima.dingding.pojo.entity.Collection;
import com.heima.dingding.pojo.result.Result;
import com.heima.dingding.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collection")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    /**
     * 修改
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

    @PutMapping()
    public Result addCollection(@RequestBody CollectionDto dto) {
        Collection collection = new Collection();
        BeanUtils.copyProperties(dto, collection);
        collectionService.save(collection);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Collection> getCollection(@PathVariable long id) {
        Collection byId = collectionService.getById(id);
        return Result.success(byId);
    }

    @DeleteMapping("/{id}")
    public Result delCollection(@PathVariable long id) {
        Collection byId = collectionService.getById(id);
        if (byId != null) {
            collectionService.removeById(id);
        }
        return Result.success();
    }
}
