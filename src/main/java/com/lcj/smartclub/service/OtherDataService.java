package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.OtherData;

import java.util.List;

public interface OtherDataService {
    /**
     * 查询所有
     */
    List<OtherData> findAll();

    /**
     * 添加
     */
    int insert(OtherData otherData);

    /**
     * 删除
     */
    int deleteById(int id);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    OtherData findById(int id);
}
