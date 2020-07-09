package com.hthj.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 23:54
 */
public interface WrapperCondition<T> {
    Wrapper<T> toWrapper(Class<T> clazz);
}
