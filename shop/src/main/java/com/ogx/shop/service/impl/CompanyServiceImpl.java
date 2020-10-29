package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.CompanyMapper;
import com.ogx.shop.entity.Company;
import com.ogx.shop.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public int deleteByPrimaryKey(Integer supNo) {
        return companyMapper.deleteByPrimaryKey(supNo);
    }

    @Override
    public int insert(Company record) {
        return companyMapper.insert(record);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Integer supNo) {
        return companyMapper.selectByPrimaryKey(supNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }

    @Override
    public Company selectByName(String name) {
        return companyMapper.selectByName(name);
    }


    @Override
    public PageInfo<Company> pageList(int currentPage, int pageSize) {
        List<Company> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = companyMapper.selectAll();
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<String> selectAll() {
        List<Company> companies= companyMapper.selectAll();
        List<String> list=new ArrayList<>();
        for(int i=0;i<companies.size();i++){
            list.add(companies.get(i).getSupName());
        }
        return list;
    }




}
