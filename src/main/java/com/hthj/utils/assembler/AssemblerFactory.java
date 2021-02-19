package com.hthj.utils.assembler;


import com.hthj.utils.Conditions;

import java.util.Iterator;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 11:00
 */
final public class AssemblerFactory {

    public static DefaultAssembler createDefaultAssembler(Conditions value) {
        DefaultAssembler assembler = null;
        switch (value) {
            case Like:
                assembler = (qw, obj, fieldName, fieldValue) -> qw.like(fieldName, fieldValue);
                break;
            case Eq:
                assembler = ((qw, obj, fieldName, fieldValue) -> qw.eq(fieldName, fieldValue));
                break;
            case Ne:
                assembler = ((qw, obj, fieldName, fieldValue) -> qw.ne(fieldName, fieldValue));
                break;
            case IsNull:
                assembler = ((qw, obj, fieldName, fieldValue) -> qw.isNull(fieldName));
                break;
            case IsNotNull:
                assembler = (((qw, obj, fieldName, fieldValue) -> qw.isNotNull(fieldName)));
                break;
        }
        return assembler;
    }

    public static RangeAssembler createRangeAssemble(Conditions value) {
        RangeAssembler assembler = null;
        switch (value) {
            case Between:
                assembler = (qw, rangeScope) -> {
                    Iterator<String> iterator = rangeScope.iterator();
                    while (iterator.hasNext()) {
                        String fieldName = iterator.next();
                        qw.between(fieldName, rangeScope.getStart(fieldName), rangeScope.getEnd(fieldName));
                    }
                };
                break;
        }
        return assembler;
    }
}
