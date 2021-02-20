package com.hthj.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import com.hthj.utils.assembler.AssemblerFactory;
import com.hthj.utils.assembler.DefaultAssembler;
import com.hthj.utils.assembler.RangeAssembler;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * package     com.hthjsj.mutitenant.api
 * file        BaseCondition
 * create-time 2019-11-25
 * comment     基础条件查询
 *
 * @Author fyt
 */
public abstract class DefaultCondition<T> extends DefaultPageCondition<T> implements WrapperCondition<T> {

    @Override
    public Wrapper<T> toWrapper() {
        QueryWrapper<T> qw = new QueryWrapper<T>();

        Field[] fields = this.getClass().getDeclaredFields();
        RangeScope rangeScope = new RangeScope();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                String fieldName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
                Object fieldValue = field.get(this);

                if (fieldValue == null || StringUtils.isEmpty(String.valueOf(fieldValue))) continue;

                Condition conditionAnnotation = field.getAnnotation(Condition.class);
                if (conditionAnnotation == null) {
                    qw.eq(fieldName, fieldValue);
                    continue;
                }

                if (conditionAnnotation.ignore()) continue;

                if (!StringUtils.isEmpty(conditionAnnotation.field())) {
                    fieldName = conditionAnnotation.field();
                }

                if (conditionAnnotation.value().equals(Conditions.Custom)) {
                    Class<? extends DefaultAssembler> assemblerClazz = conditionAnnotation.custom();
                    DefaultAssembler assembler = assemblerClazz.newInstance();
                    assembler.assemble(qw, this, fieldName, fieldValue);
                    continue;
                }

                if (conditionAnnotation.value().equals(Conditions.Between)) {
                    if (conditionAnnotation.rangeType().equals(RangeType.START)) {
                        rangeScope.putStart(fieldName, fieldValue);
                    }
                    if (conditionAnnotation.rangeType().equals(RangeType.END)) {
                        rangeScope.putEnd(fieldName, fieldValue);
                    }
                } else {
                    DefaultAssembler assembler = AssemblerFactory.createDefaultAssembler(conditionAnnotation.value());
                    assembler.assemble(qw, this, fieldName, fieldValue);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 处理RangeAssembler
        if (rangeScope.hasElement()) {
            RangeAssembler assembler = AssemblerFactory.createRangeAssemble(Conditions.Between);
            assembler.assemble(qw, rangeScope);
        }
        return qw;
    }
}
