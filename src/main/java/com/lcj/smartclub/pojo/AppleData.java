package com.lcj.smartclub.pojo;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppleData {
    private int id;
    private String experiment;
    private String rgb;
    private String nir;
    private int views;
}
