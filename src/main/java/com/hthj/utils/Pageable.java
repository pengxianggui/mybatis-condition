package com.hthj.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 23:52
 */
public interface Pageable<T> {
    int pageIndex();

    int pageSize();

    String orderBy();

    boolean isAsc();

    IPage<T> toPage();
}
