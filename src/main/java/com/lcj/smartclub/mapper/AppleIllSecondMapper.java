package com.lcj.smartclub.mapper;

import com.lcj.smartclub.pojo.AppleIllSecond;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppleIllSecondMapper {
    /**
     * 查询数据
     */
    List<AppleIllSecond> findAll();

    /**
     * 根据id查询数据
     */
    AppleIllSecond findById(int id);

    /**
     * 添加数据
     */
    int insert(AppleIllSecond appleIllSecond);

    /**
     * 删除数据
     */
    int deleteById(int id);
}
