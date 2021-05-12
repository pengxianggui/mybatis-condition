package com.hthj.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hthj.utils.condition.UserCondition;
import com.hthj.utils.entity.User;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author pengxg
 * @date 2021/2/19 3:36 下午
 */
public class MainTest {

    @Test
    public void test() {
        UserCondition userCondition = new UserCondition();
        userCondition.setAge(12);
        userCondition.setUsername("zhangsan");
        userCondition.setBirthdayStart(LocalDate.now().minusDays(100));
        userCondition.setBirthdayEnd(LocalDate.now());
        userCondition.setAsc(true);
        userCondition.setOrderBy("age");
        userCondition.setPageIndex(1);
        userCondition.setPageSize(10);

        IPage<User> page = userCondition.toPage();
        Wrapper<User> wrapper = userCondition.toWrapper();
        // execute your query
        // baseMapper.selectList(wrapper)
        // or
        // baseMapper.selectPage(page, wrapper)
    }
}
