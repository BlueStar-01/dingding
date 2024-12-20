package com.heima.dingding.collection;

import com.heima.dingdign.pojo.dto.ChapterDto;
import com.heima.dingdign.pojo.entity.Book;
import com.heima.dingdign.pojo.entity.Chapter;
import com.heima.dingdign.pojo.vo.CatalogVO;
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
    public Result<List<CatalogVO>> getChapters(@PathVariable Long bookId) {
        //查询书籍是否存在
        Long count = bookService.lambdaQuery().eq(Book::getId, bookId).count();
        if (count <= 0) {
            throw new DataException(MessageConstant.BOOK_NOT_FOUND);
        }
        //先返回所有的实体对象
        List<Chapter> list = chapterService.lambdaQuery()
                .eq(Chapter::getBookId, bookId)
                .list();
        //构建vo对象
        List<CatalogVO> vos = list.stream().map(chapter ->
        {
            return CatalogVO.builder()
                    .title(chapter.getTitle())
                    .catalogId(chapter.getId())
                    .orderNum(chapter.getOrderNum()).build();
        }).toList();
        if (vos == null || vos.size() == 0) {
            return Result.error(MessageConstant.COL_NOT_FOUND);
        }
        return Result.success(vos);
    }

    /**
     * 章节详情
     *
     * @param chapterId
     * @return
     */
    @GetMapping("/show")
    public Result<Chapter> showChapters(@RequestParam Long chapterId) {
        Chapter id = chapterService.getById(chapterId);
        if (id == null) {
            throw new DataException(MessageConstant.COL_NOT_FOUND);
        }
        //添加段首空格和换行
        StringBuilder temp = new StringBuilder();
        temp.append("\n  ");
        temp.append(id.getContent());
        String s = temp.toString().replaceAll("\\n", "\n  ");
        id.setContent(s);
        return Result.success(id);
    }

    /**
     * 根据书籍id添加章节
     *
     * @param chapter
     * @return
     */
    @PutMapping
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
