package com.ogx.shop.service.impl;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.ProVedioMapper;
import com.ogx.shop.entity.ProVedio;
import com.ogx.shop.service.ProVedioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 22:52
 * @title: ProImgServiceImpl
 **/
@Service
public class ProVedioServiceImpl implements ProVedioService {

    @Resource
    ProVedioMapper proVedioMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proVedioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProVedio record) {
        return proVedioMapper.insert(record);
    }

    @Override
    public int insertSelective(ProVedio record) {
        return proVedioMapper.insertSelective(record);
    }

    @Override
    public ProVedio selectByPrimaryKey(Integer id) {
        return proVedioMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProVedio record) {
        return proVedioMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProVedio record) {
        return proVedioMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProVedio> selectByProId(Integer proId) {
        return proVedioMapper.selectByProId(proId);
    }

    @Override
    public List<ProVedio> selectAll() {
        return proVedioMapper.selectAll();
    }

    @Override
    public PageInfo<ProVedio> pageList(int currentPage, int pageSize) {
        return null;
    }
}
