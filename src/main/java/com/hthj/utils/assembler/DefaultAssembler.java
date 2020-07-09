package com.hthj.utils.assembler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hthj.utils.WrapperCondition;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/16 16:49
 */
@FunctionalInterface
public interface DefaultAssembler<C extends WrapperCondition> {

    void assemble(QueryWrapper qw, C obj, String fieldName, Object fieldValue);
}
