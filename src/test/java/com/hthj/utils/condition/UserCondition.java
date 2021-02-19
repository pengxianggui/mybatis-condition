package com.hthj.utils.condition;

import com.hthj.utils.Condition;
import com.hthj.utils.Conditions;
import com.hthj.utils.DefaultCondition;
import com.hthj.utils.RangeType;
import com.hthj.utils.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author pengxg
 * @date 2021/2/19 3:00 下午
 */
@Getter
@Setter
public class UserCondition extends DefaultCondition<User> {

    @Condition(Conditions.Like)
    private String username;
    @Condition(Conditions.Eq)
    private Integer age;

    @Condition(value = Conditions.Between, field = "birthday", rangeType = RangeType.START)
    private LocalDate birthdayStart;

    @Condition(value = Conditions.Between, field = "birthday", rangeType = RangeType.END)
    private LocalDate birthdayEnd;
}
