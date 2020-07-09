package com.hthj.utils;

import com.hthj.utils.assembler.DefaultAssembler;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Condition {
    /**
     * 声明自定义时, 必须指定custom的值。
     * 当声明 Conditions.Between时, 必须指定rangeType
     */
    Conditions value() default Conditions.Eq;

    /**
     * 字段名, 默认会使用Condition中声明的字段名
     *
     * @return
     */
    String field() default "";

    /**
     * 特殊条件装配器： 自定义实现
     *
     * @return
     */
    Class<? extends DefaultAssembler> custom() default DefaultAssembler.class;

    /**
     * 忽略此条件装配
     *
     * @return
     */
    boolean ignore() default false;

    String rangeType() default "";
}
