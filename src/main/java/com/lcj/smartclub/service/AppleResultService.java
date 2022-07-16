package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.AppleResult;

import java.util.List;

public interface AppleResultService {
    /**
     * 查询数据
     */
    List<AppleResult> findAll();

    /**
     * 根据id查询数据
     */
    AppleResult findById(int id);

    /**
     * 添加数据
     */
    int insert(AppleResult appleResult);

    /**
     * 删除数据
     */
    int deleteById(int id);
}
