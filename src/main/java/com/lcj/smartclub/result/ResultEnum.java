package com.lcj.smartclub.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败"),



    FlAG(1000,"无用的");

    private final int code;
    private final String message;
}
