package com.ogx.shop.service.impl;

import com.ogx.shop.dao.DiscountMapper;
import com.ogx.shop.entity.Discount;
import com.ogx.shop.service.DiscountService;
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
public class DiscountServiceImpl implements DiscountService {

    @Resource
    private DiscountMapper discountMapper;
    @Override
    public int deleteByPrimaryKey(String custLevel) {
        return discountMapper.deleteByPrimaryKey(custLevel);
    }

    @Override
    public int insert(Discount record) {
        return discountMapper.insert(record);
    }

    @Override
    public int insertSelective(Discount record) {
        return discountMapper.insertSelective(record);
    }

    @Override
    public Discount selectByPrimaryKey(String custLevel) {
        return discountMapper.selectByPrimaryKey(custLevel);
    }

    @Override
    public int updateByPrimaryKeySelective(Discount record) {
        return discountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Discount record) {
        return discountMapper.updateByPrimaryKey(record);
    }
}
