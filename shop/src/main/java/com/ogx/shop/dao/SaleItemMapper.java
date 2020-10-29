package com.ogx.shop.dao;

import com.ogx.shop.entity.SaleItem;
import com.ogx.shop.vo.SaleItemVo;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface SaleItemMapper {
    int deleteByPrimaryKey(Integer orderNo);

    void insert(SaleItem record);

    int insertSelective(SaleItem record);

    SaleItem selectByPrimaryKey(Integer orderNo);

    int updateByPrimaryKeySelective(SaleItem record);

    int updateByPrimaryKey(SaleItem record);

    List<SaleItem> findAll(String invoiceNo);

    List<SaleItem> selectProdByInvoiceNo(String invoiceNo);

    /**
     * 联合查询订单详情表和商品表
     * @param invoiceNo
     * @return
     */
    List<SaleItemVo> selectProdByInvoiceNo1(String invoiceNo);
}