package com.lcj.smartclub.mapper;

import com.lcj.smartclub.pojo.AppleIllThird;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppleIllThirdMapper {
    /**
     * 查询数据
     */
    List<AppleIllThird> findAll();

    /**
     * 根据id查询数据
     */
    AppleIllThird findById(int id);

    /**
     * 添加数据
     */
    int insert(AppleIllThird appleIllThird);

    /**
     * 删除数据
     */
    int deleteById(int id);
}
