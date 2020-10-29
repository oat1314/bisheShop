package com.ogx.shop.dao;

import com.ogx.shop.entity.Product;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    //根据营销种类id进行查询
    List<Product> selectByHot(Integer hot);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    /**
     * 根据商品名称模糊查询
     * @param name
     * @return
     */
    List<Product> selectByName(String name);



    /**
     * 根据商品种类id进行查询
     * @param kindno
     * @return
     */
    List<Product> selectByKindNo(String kindno);

    /**
     * 根据商品号查找商品评论
     * */
    List<Product> selectPinglunById(int id);

    Product selectById(int id);

    /**
     * 根据关键字查找商品
     * @param prodDesc
     * @return
     */
    List<Product> selectByDesc(String prodDesc);

}