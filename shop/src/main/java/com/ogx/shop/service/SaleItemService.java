package com.ogx.shop.service;

import com.ogx.shop.entity.Product;
import com.ogx.shop.entity.SaleItem;
import com.ogx.shop.vo.RefundVo;
import com.ogx.shop.vo.SaleItemVo;
import com.ogx.shop.vo.shopVo;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface SaleItemService {

    int deleteByPrimaryKey(Integer orderNo);

    void insert(SaleItem record);

    int insertSelective(shopVo[] shopVo);

    SaleItem selectByPrimaryKey(Integer orderNo);

    int updateByPrimaryKeySelective(SaleItem record);

    int updateByPrimaryKey(SaleItem record);

    /**
     * 根据订单号查询所有订单详情
     * @return
     */
    List<SaleItem> findAll(String invoiceNo);

    /**
     * 根据订单查找所属商品
     * @param invoiceNo
     * @return
     */
    List<SaleItem> selectProdByInvoiceNo(String invoiceNo);

    List<SaleItemVo> selectProdByInvoiceNo1(String invoiceNo);

    /**
     *退货单
     */
    RefundVo refund(Product product, SaleItem saleItem);



}
