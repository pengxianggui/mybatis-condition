package com.hthj.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author pengxg
 * @date 2021/2/19 3:00 下午
 */
@Getter
@Setter
@TableName
public class User {
    @TableId
    private String id;
    private String username;
    private Integer age;
    private LocalDate birthday;
}
