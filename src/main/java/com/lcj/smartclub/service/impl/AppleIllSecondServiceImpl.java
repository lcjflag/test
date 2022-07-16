package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.AppleIllSecondMapper;
import com.lcj.smartclub.pojo.AppleIllSecond;
import com.lcj.smartclub.service.AppleIllSecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleIllSecondServiceImpl implements AppleIllSecondService {

    @Autowired
    private AppleIllSecondMapper appleIllSecondMapper;

    /**
     * 查询数据
     */
    @Override
    public List<AppleIllSecond> findAll() {
        return appleIllSecondMapper.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     */
    @Override
    public AppleIllSecond findById(int id) {
        return appleIllSecondMapper.findById(id);
    }

    /**
     * 添加数据
     *
     * @param appleIllSecond
     */
    @Override
    public int insert(AppleIllSecond appleIllSecond) {
        return appleIllSecondMapper.insert(appleIllSecond);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return appleIllSecondMapper.deleteById(id);
    }
}
