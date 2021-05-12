package com.hthj.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 23:54
 */
public interface WrapperCondition<T> {
    /**
     * 将condition转换为Wrapper，通过Condition上的注解确定其查询比较逻辑。
     * @return
     */
    Wrapper<T> toWrapper();
}
