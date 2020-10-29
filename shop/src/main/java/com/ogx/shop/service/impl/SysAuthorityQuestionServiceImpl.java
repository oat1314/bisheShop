package com.ogx.shop.service.impl;

import com.ogx.shop.dao.SysAuthorityQuestionMapper;
import com.ogx.shop.entity.SysAuthorityQuestion;
import com.ogx.shop.service.SysAuthorityQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class SysAuthorityQuestionServiceImpl implements SysAuthorityQuestionService {
    @Resource
    private SysAuthorityQuestionMapper sysAuthorityQuestionMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysAuthorityQuestionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysAuthorityQuestion record) {
        return sysAuthorityQuestionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysAuthorityQuestion record) {
        return sysAuthorityQuestionMapper.insertSelective(record);
    }

    @Override
    public SysAuthorityQuestion selectByPrimaryKey(Integer id) {
        return sysAuthorityQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysAuthorityQuestion record) {
        return sysAuthorityQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysAuthorityQuestion record) {
        return sysAuthorityQuestionMapper.updateByPrimaryKey(record);
    }
}
