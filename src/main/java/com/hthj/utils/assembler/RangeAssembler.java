package com.hthj.utils.assembler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hthj.utils.DefaultCondition;
import com.hthj.utils.RangeScope;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/16 16:54
 */
@FunctionalInterface
public interface RangeAssembler<C extends DefaultCondition> {

    void assemble(QueryWrapper qw, RangeScope rangeScope);
}
