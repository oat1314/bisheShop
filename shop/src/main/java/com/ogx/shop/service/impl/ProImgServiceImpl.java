package com.ogx.shop.service.impl;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.ProImgMapper;
import com.ogx.shop.entity.ProImg;
import com.ogx.shop.service.ProImgService;
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
public class ProImgServiceImpl implements ProImgService {

    @Resource
    ProImgMapper proImgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProImg record) {
        return proImgMapper.insert(record);
    }

    @Override
    public int insertSelective(ProImg record) {
        return proImgMapper.insertSelective(record);
    }

    @Override
    public ProImg selectByPrimaryKey(Integer id) {
        return proImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProImg record) {
        return proImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProImg record) {
        return proImgMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProImg> selectByProId(Integer proId) {
        return proImgMapper.selectByProId(proId);
    }

    @Override
    public List<ProImg> selectAll() {
        return proImgMapper.selectAll();
    }

    @Override
    public PageInfo<ProImg> pageList(int currentPage, int pageSize) {
        return null;
    }
}
