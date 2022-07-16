package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.OtherDataMapper;
import com.lcj.smartclub.pojo.OtherData;
import com.lcj.smartclub.service.OtherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherDataServiceImpl implements OtherDataService {

    @Autowired
    private OtherDataMapper otherDataMapper;

    /**
     * 查询所有
     */
    @Override
    public List<OtherData> findAll() {
        return otherDataMapper.findAll();
    }

    /**
     * 添加
     *
     * @param otherData
     */
    @Override
    public int insert(OtherData otherData) {
        return otherDataMapper.insert(otherData);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return otherDataMapper.deleteById(id);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public OtherData findById(int id) {
        return otherDataMapper.findById(id);
    }
}
