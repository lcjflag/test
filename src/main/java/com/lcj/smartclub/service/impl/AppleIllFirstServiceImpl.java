package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.AppleIllFirstMapper;
import com.lcj.smartclub.pojo.AppleIllFirst;
import com.lcj.smartclub.service.AppleIllFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleIllFirstServiceImpl implements AppleIllFirstService {

    @Autowired
    private AppleIllFirstMapper appleIllFirstMapper;

    /**
     * 查询数据
     */
    @Override
    public List<AppleIllFirst> findAll() {
        return appleIllFirstMapper.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     */
    @Override
    public AppleIllFirst findById(int id) {
        return appleIllFirstMapper.findById(id);
    }

    /**
     * 添加数据
     *
     * @param appleIllFirst
     */
    @Override
    public int insert(AppleIllFirst appleIllFirst) {
        return appleIllFirstMapper.insert(appleIllFirst);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return appleIllFirstMapper.deleteById(id);
    }
}
