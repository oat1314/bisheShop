package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Mapper
public interface ProductService {
    int deleteByPrimaryKey(Integer prodId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByHot(Integer hot);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByName(String name);

    List<Product> selectByKindNo(String kindno);



    List<Product> selectPinglunById(Integer proId);

    /**
     * 分页展示
     * @param product
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> pageList(Product product, int currentPage, int pageSize);

    /*
    * 模糊查询*/
    PageInfo<Product> pageList1(Product product, int currentPage, int pageSize);

    /*
     * 分类查询*/
    PageInfo<Product> pageList2(Product product, int currentPage, int pageSize);

    /*
     * 营销方式查询*/
    PageInfo<Product> pageList3(Product product, int currentPage, int pageSize);

    /**
     * 遍历全部商品
     * @return
     */
    List<Product> selectAll();

    Product selectById(int id);

    /**
     * 根据关键字查找商品
     * @param desc
     * @return
     */
    List<Product> selectByDesc(String desc);
}
