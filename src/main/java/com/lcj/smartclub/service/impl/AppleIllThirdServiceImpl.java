package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.AppleIllThirdMapper;
import com.lcj.smartclub.pojo.AppleIllThird;
import com.lcj.smartclub.service.AppleIllThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleIllThirdServiceImpl implements AppleIllThirdService {

    @Autowired
    private AppleIllThirdMapper appleIllThirdMapper;

    /**
     * 查询数据
     */
    @Override
    public List<AppleIllThird> findAll() {
        return appleIllThirdMapper.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     */
    @Override
    public AppleIllThird findById(int id) {
        return appleIllThirdMapper.findById(id);
    }

    /**
     * 添加数据
     *
     * @param appleIllThird
     */
    @Override
    public int insert(AppleIllThird appleIllThird) {
        return appleIllThirdMapper.insert(appleIllThird);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return appleIllThirdMapper.deleteById(id);
    }
}
