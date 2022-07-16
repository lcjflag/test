package com.lcj.smartclub.mapper;

import com.lcj.smartclub.pojo.OtherData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherDataMapper {
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
