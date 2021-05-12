package com.hthj.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 23:57
 */
public abstract class DefaultPageCondition<T> implements Pageable<T> {
    Integer pageIndex = 1;
    Integer pageSize = 10;
    String orderBy = "created_time";
    Boolean isAsc = false;

    @Override
    public int pageIndex() {
        return pageIndex;
    }

    @Override
    public int pageSize() {
        return pageSize;
    }

    @Override
    public String orderBy() {
        return orderBy;
    }

    @Override
    public boolean isAsc() {
        return isAsc;
    }

    @Override
    public IPage<T> toPage() {
        Page page = new Page(pageIndex(), pageSize());
        return page.addOrder(isAsc() ? OrderItem.asc(orderBy()) : OrderItem.desc(orderBy()));
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getAsc() {
        return isAsc;
    }

    public void setAsc(Boolean asc) {
        isAsc = asc;
    }
}
