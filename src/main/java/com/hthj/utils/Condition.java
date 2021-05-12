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
     * 当声明 Conditions.Between时, 必须指定rangeType, 且前后区间的两个字段@Condition注解的value值必须都为对应Entity中的字段。
     * example:
     * <pre>
     * &#064;Condition(value = Conditions.Between, field = "birthday")
     * private LocalDate birthdayStart;
     *
     * &#064;Condition(value = Conditions.Between, field = "birthday", rangeType = RangeType.END)
     * private LocalDate birthdayEnd;
     * </pre>
     */
    Conditions value() default Conditions.Eq;

    /**
     * 字段名, 默认会使用Condition中声明的字段名。因此，当Condition中声明字段和entity中一致时, 无需配置此项，否则必须配置，并且值必须和
     * entity实体中的字段属性一致。
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

    /**
     * 当value为Conditions.Between时, 此配置用以区分前后区间。默认为RangeType.START
     *
     * @return
     */
    RangeType rangeType() default RangeType.START;
}
