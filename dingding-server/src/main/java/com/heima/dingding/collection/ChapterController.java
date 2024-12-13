package com.heima.dingding.collection;

import com.heima.dingdign.pojo.dto.ChapterDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingdign.pojo.entity.Chapter;
import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.domain.Result;
import com.heima.dingding.exception.DataException;
import com.heima.dingding.service.IBookService;
import com.heima.dingding.service.IChapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
@Slf4j
public class ChapterController {
    private final IChapterService chapterService;
    private final IBookService bookService;


    /**
     * 根据书籍id获得所有的章节
     *
     * @return
     */
    @GetMapping("/{bookId}")
    public Result<List<Chapter>> getChapters(@PathVariable Long bookId) {
        //查询书籍是否存在
        Long count = bookService.lambdaQuery().eq(Book::getId, bookId).count();
        if (count <= 0) {
            throw new DataException(MessageConstant.BOOK_NOT_FOUND);
        }
        //先返回所有的实体对象
        List<Chapter> list = chapterService.lambdaQuery()
                .eq(Chapter::getBookId, bookId)
                .list();
        return Result.success(list);
    }

    /**
     * 根据书籍id添加章节
     *
     * @param chapter
     * @return
     */
    @PutMapping("/{bookId}")
    public Result addChapters(@RequestBody ChapterDto chapter) {
        if (chapter.getTitle() == null || chapter.getContent() == null || chapter.getBookId() == null) {
            throw new DataException(MessageConstant.REQUEST_PARAMETERS_ARE_MISSING);
        }
        //查询书籍是否存在
        Long count = bookService.lambdaQuery().eq(Book::getId, chapter.getBookId()).count();
        if (count <= 0) {
            throw new DataException(MessageConstant.BOOK_NOT_FOUND);
        }
        //添加章节
        Chapter saveChapter = null;
        //log.info("{}", chapter);
        saveChapter = new Chapter();
        saveChapter.setBookId(chapter.getBookId());
        saveChapter.setTitle(chapter.getTitle());
        saveChapter.setContent(chapter.getContent());
        Integer orderNum = Math.toIntExact(chapter.getOrderNum() != null ? chapter.getOrderNum() :
                chapterService.lambdaQuery().eq(Chapter::getBookId, chapter.getBookId()).count());
        saveChapter.setOrderNum(orderNum);
        //检查属性
        chapterService.save(saveChapter);
        return Result.success();
    }

}
