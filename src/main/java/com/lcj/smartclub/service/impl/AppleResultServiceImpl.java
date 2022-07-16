package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.AppleResultMapper;
import com.lcj.smartclub.pojo.AppleResult;
import com.lcj.smartclub.service.AppleResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleResultServiceImpl implements AppleResultService {

    @Autowired
    private AppleResultMapper appleResultMapper;

    /**
     * 查询数据
     */
    @Override
    public List<AppleResult> findAll() {
        return appleResultMapper.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     */
    @Override
    public AppleResult findById(int id) {
        return appleResultMapper.findById(id);
    }

    /**
     * 添加数据
     *
     * @param appleResult
     */
    @Override
    public int insert(AppleResult appleResult) {
        return appleResultMapper.insert(appleResult);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return appleResultMapper.deleteById(id);
    }
}
