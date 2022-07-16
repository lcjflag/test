package com.lcj.smartclub.pojo;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppleResult {
    private int id;
    private String ndviName; //名称
    private String ndvi; //图片
    private float ndviData; //数据
    private int views;
}
