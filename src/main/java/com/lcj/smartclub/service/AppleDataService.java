package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.AppleData;

import java.util.List;

public interface AppleDataService {
    /**
     * 查询数据
     */
    List<AppleData> findAll();

    /**
     * 根据id查询数据
     */
    AppleData findById(int id);

    /**
     * 添加数据
     */
    int insert(AppleData appleData);

    /**
     * 删除数据
     */
    int deleteById(int id);
}
