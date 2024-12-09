package com.heima.dingding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.dingdign.pojo.entity.Type;
import com.heima.dingding.mapper.TypeMapper;
import com.heima.dingding.service.ITypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍分类表 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

}
