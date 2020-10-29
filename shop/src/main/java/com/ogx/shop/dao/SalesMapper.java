package com.ogx.shop.dao;

import com.ogx.shop.entity.Sales;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface SalesMapper {
    int deleteByPrimaryKey(Integer orderNo);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByInvoiceNo(String invoiceNo);

    int updateByPrimaryKeySelective(Sales record);

    int updateByInvoiceNo(String invoiceNo);

    int updateAdminOrder(String invoiceNo);

    int updateAdminOrder1(String invoiceNo);

    int updateStatus(String invoiceNo);


    List<Sales> selectByCustId(int custId);

    List<Sales> selectByCustId1(int custId);
    List<Sales> selectByCustId2(int custId);
    List<Sales> selectByCustId3(int custId);

    List<Sales> selectByCustId4(int custId);
    List<Sales> findAll(int custId);
    List<Sales> findWeek();

    /**
     *查找今日订单
     * @return
     */
    List<Sales> findToday(String time);

    /**
     * 查找最近一周订单
     * @return
     */
    List<Sales> Lastweek();

    List<Sales> Lastweek1();

    /**
     * 根据时间查询当天订单总额
     * @param time
     * @return
     */
    BigDecimal selectSUMBytime(String time);

     List<Sales> selectAll();
}