package com.hthj.utils;

import lombok.Getter;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/16 17:21
 */
@Getter
public enum RangeType {
    START("start"),
    END("end");

    private String code;

    RangeType(String code) {
        this.code = code;
    }
}
