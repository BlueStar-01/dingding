package com.heima.dingding.collection;

import com.heima.dingdign.pojo.dto.CartDto;
import com.heima.dingdign.pojo.entity.BookCart;
import com.heima.dingdign.pojo.vo.BookVO;
import com.heima.dingding.context.BaseContext;
import com.heima.dingding.domain.Result;
import com.heima.dingding.service.IBookCartService;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final IBookCartService cartService;

    /**
     * 添加或减少书籍进购物车
     *
     * @param cartDto
     * @return
     */
    @ApiModelProperty("添加或减少书籍进购物车(number为负数就是减少,为null就设为默认1)")
    @PutMapping("/add")
    public Result addBook(@RequestBody CartDto cartDto) {
        cartService.addBook(cartDto);
        return Result.success();
    }

    /**
     * 返回当前用户的所有的购物车数据
     *
     * @return
     */
    //todo
    @GetMapping("/list")
    public Result<List<BookVO>> list() {
        List<BookCart> list = cartService.lambdaQuery().eq(BookCart::getUserId, BaseContext.getCurrentId()).list();
        return Result.success();
    }
}
