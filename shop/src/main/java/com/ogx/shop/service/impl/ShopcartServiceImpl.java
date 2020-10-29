package com.ogx.shop.service.impl;

import com.ogx.shop.dao.ProductMapper;
import com.ogx.shop.dao.ShopcartMapper;
import com.ogx.shop.entity.Product;
import com.ogx.shop.entity.Shopcart;
import com.ogx.shop.service.ShopcartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class ShopcartServiceImpl implements ShopcartService {
    @Resource
    private ShopcartMapper shopcartMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Integer shopNo) {
        return shopcartMapper.deleteByPrimaryKey(shopNo);
    }

    @Override
    public int insert(Shopcart record) {
        return shopcartMapper.insert(record);
    }

    @Override
    public int insertSelective(Shopcart record) {
        return shopcartMapper.insertSelective(record);
    }

    @Override
    public Shopcart selectByPrimaryKey(Integer shopNo) {
        return shopcartMapper.selectByPrimaryKey(shopNo);
    }

    @Override
    public int updateById(Integer shopNo) {
        return shopcartMapper.updateById(shopNo);
    }

    @Override
    public int updateByShopId(Integer shopNo) {
        return shopcartMapper.updateByShopId(shopNo);
    }

    @Override
    public int updateByPrimaryKey(Shopcart record) {
        return shopcartMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Shopcart> selectByCustId(Integer custId) {

        List<Shopcart> shopcartList=  shopcartMapper.selectByCustId(custId);
        for (int i=0;i<shopcartList.size();i++){
           Product product= productMapper.selectById(shopcartList.get(i).getProdId());
           shopcartList.get(i).setExtend3(product.getProdDesc());
        }
        return  shopcartList;

    }
}
