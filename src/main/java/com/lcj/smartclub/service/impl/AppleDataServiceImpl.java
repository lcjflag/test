package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.AppleDataMapper;
import com.lcj.smartclub.pojo.AppleData;
import com.lcj.smartclub.service.AppleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleDataServiceImpl implements AppleDataService {

    @Autowired
    private AppleDataMapper appleDataMapper;

    /**
     * 查询数据
     */
    @Override
    public List<AppleData> findAll() {
        return appleDataMapper.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     */
    @Override
    public AppleData findById(int id) {
        return appleDataMapper.findById(id);
    }

    /**
     * 添加数据
     *
     * @param appleData
     */
    @Override
    public int insert(AppleData appleData) {
        return appleDataMapper.insert(appleData);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return appleDataMapper.deleteById(id);
    }
}
