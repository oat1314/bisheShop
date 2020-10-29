package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.CompanyMapper;
import com.ogx.shop.dao.KindMapper;
import com.ogx.shop.dao.ProductMapper;
import com.ogx.shop.dao.WarehouseMapper;
import com.ogx.shop.entity.*;
import com.ogx.shop.service.CompanyService;
import com.ogx.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Autowired
    private KindMapper kindMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private  ProductService productService;

    @Override
    public int deleteByPrimaryKey(Integer prodId) {
        return productMapper.deleteByPrimaryKey(prodId);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public List<Product> selectByHot(Integer hot) {
        return productMapper.selectByHot(hot);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> selectByName(String name) {
        return productMapper.selectByName(name);
    }


    @Override
    public List<Product> selectByKindNo(String kindno) {
        return productMapper.selectByKindNo(kindno);
    }



    @Override
    public List<Product> selectPinglunById(Integer proId) {
        return productMapper.selectPinglunById(proId);
    }


    @Override
    public PageInfo<Product> pageList(Product product, int currentPage, int pageSize) {

        List<Product> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
       // PageHelper.orderBy("id asc");
        if (org.apache.commons.lang.StringUtils.isNotBlank(product.getName())) {
            list = this.selectByName(product.getName());
        } else if (org.apache.commons.lang.StringUtils.isNotBlank(product.getKindNo())) {
            list = this.selectByKindNo(product.getKindNo());
        }else {
            list = productMapper.selectAll();
        }
        List<Kind> kinds=kindMapper.selectAll();
        for (int i=0;i<list.size();i++){
            for (int j=0;j<kinds.size();j++){
                if (list.get(i).getKindNo().equals((kinds.get(j).getKindNo()).toString())){
                    list.get(i).setExtend1(kinds.get(j).getKindName());
                }
            }
        }

        List<Warehouse> warehouses=warehouseMapper.selectAll();
        for (int i=0;i<list.size();i++){
            for (int j=0;j<warehouses.size();j++){
                if (list.get(i).getSupNo().equals((warehouses.get(j).getWhNo()).toString())){
                    list.get(i).setExtend2(warehouses.get(j).getWhName());
                }
            }
        }


        List<Company> activity=companyMapper.selectAll();
        for (int i=0;i<list.size();i++){
            for (int j=0;j<activity.size();j++){
                if (list.get(i).getIsHot().toString().equals((activity.get(j).getSupNo()).toString())){
                    list.get(i).setExtend3(activity.get(j).getSupName());
                }
            }
        }
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }



    @Override
    public PageInfo<Product> pageList1(Product product, int currentPage, int pageSize) {

        List<Product> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = this.selectByName(product.getName());

        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> pageList2(Product product, int currentPage, int pageSize) {
        List<Product> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);

        list = this.selectByKindNo(product.getKindNo());

        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> pageList3(Product product, int currentPage, int pageSize) {
        List<Product> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        System.out.println(product.getSupNo());
        list = productService.selectByHot(product.getIsHot());

        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product selectById(int id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<Product> selectByDesc(String desc) {
        return productMapper.selectByDesc(desc);
    }


}
