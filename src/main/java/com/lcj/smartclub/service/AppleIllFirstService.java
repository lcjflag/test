package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.AppleIllFirst;

import java.util.List;

public interface AppleIllFirstService {
    /**
     * 查询数据
     */
    List<AppleIllFirst> findAll();

    /**
     * 根据id查询数据
     */
    AppleIllFirst findById(int id);

    /**
     * 添加数据
     */
    int insert(AppleIllFirst appleIllFirst);

    /**
     * 删除数据
     */
    int deleteById(int id);
}
