package com.heima.dingding.collection;

import com.heima.dingdign.pojo.entity.Chapter;
import com.heima.dingding.result.Result;
import com.heima.dingding.service.IChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {
    private final IChapterService chapterService;

    /**
     * 根据书籍id
     * 获得所有的章节
     * @return
     */
    @GetMapping("/{bookId}")
    public Result<List<Chapter>> getChapters(@PathVariable Long bookId) {
        //先返回所有的实体对象
        List<Chapter> list = chapterService.lambdaQuery()
                .eq(Chapter::getBookId, bookId)
                .list();
        return Result.success(list);
    }

    /**
     * 根据书籍id
     * 获得所有的章节
     * @return
     */
    @PutMapping("/{bookId}")
    public Result<List<Chapter>> addChapters(@PathVariable Long bookId) {
        //先返回所有的实体对象
        List<Chapter> list = chapterService.lambdaQuery()
                .eq(Chapter::getBookId, bookId)
                .list();
        return Result.success(list);
    }

}
