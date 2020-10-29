package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Returns;
import com.ogx.shop.vo.ReturnsVo;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface ReturnService {
    int deleteByPrimaryKey(String chanNo);

    int insert(Returns record);

    int insertSelective(Returns record);

    Returns selectByPrimaryKey(String chanNo);

    int updateByPrimaryKeySelective(Returns record);

    int updateByPrimaryKey(Returns record);


    /**
     * 根据客户id查询退单信息
     * @param CustId
     * @return
     */
    List<ReturnsVo>  selectByCustId(int CustId);

    /**
     * 查询全部活动分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Returns> pageList(int currentPage, int pageSize);

    //查询退货数目
    List<Returns> selectByCustId2(Integer custId);
}
