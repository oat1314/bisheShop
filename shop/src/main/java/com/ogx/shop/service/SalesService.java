package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Sales;
import com.ogx.shop.vo.OrderVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface SalesService {
    int deleteByPrimaryKey(Integer orderNo);

    int insert(Sales record);

    String insertSelective(OrderVo orderVo);

    Sales selectByInvoiceNo(String invoiceNo);


    int updateByPrimaryKeySelective3(Sales record,String status);

    int updateByInvoiceNo(String invoiceNo);

    /*
    * 确认发货*/
    int updateAdminOrder(String invoiceNo);

    /*
     * 取消发货*/
    int updateAdminOrder1(String invoiceNo);

    /*
    * 确认收货*/
    int updateStatus(String invoiceNo);


    List<Sales> selectByCustId(int custId);

    /**
     * 待收货
     * @param custId
     * @return
     */
    List<Sales> selectByCustId1(int custId);

    /**
     * 待收货
     * @param custId
     * @return
     */
    List<Sales> selectByCustId2(int custId);

    List<Sales> selectByCustId3(int custId);

    /*查找已收货*/
    List<Sales> selectByCustId4(int custId);

    List<Sales> findAll(int custId);
    List<Sales> findWeek();


    List<Sales> findToday(Date today);
    BigDecimal[] Lastweek();

    BigDecimal[] Lastweek1();

    /**
     * 订单分页查询
     * @param sales
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Sales> pageList(Sales sales, int currentPage, int pageSize);

}
