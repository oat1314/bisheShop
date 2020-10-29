package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.ReturnMapper;
import com.ogx.shop.dao.SalesMapper;
import com.ogx.shop.entity.Returns;
import com.ogx.shop.entity.Sales;
import com.ogx.shop.service.ReturnService;
import com.ogx.shop.vo.ReturnsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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
public class ReturnServiceImpl implements ReturnService {
    @Resource
    private ReturnMapper returnMapper;
    @Resource
    private SalesMapper salesMapper;

    @Override
    public int deleteByPrimaryKey(String chanNo) {
        return returnMapper.deleteByPrimaryKey(chanNo);
    }

    @Override
    public int insert(Returns record) {
        return returnMapper.insert(record);
    }

    @Override
    public int insertSelective(Returns record) {
        return returnMapper.insertSelective(record);
    }

    @Override
    public Returns selectByPrimaryKey(String chanNo) {
        return returnMapper.selectByPrimaryKey(chanNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Returns record) {
        return returnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Returns record) {
        return returnMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ReturnsVo> selectByCustId(int CustId) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Returns> returnsList=returnMapper.selectByCustId(CustId);
        List<ReturnsVo> list=new ArrayList<>();
        for (int  i=0;i<returnsList.size();i++){
            ReturnsVo returnsVo=new ReturnsVo();
            Sales sales= salesMapper.selectByInvoiceNo(returnsList.get(i).getOrderNo());
            returnsVo.setTotal(String.valueOf(sales.getTotAmt()));
            returnsVo.setChanNo(returnsList.get(i).getChanNo());
            returnsVo.setChanReason(returnsList.get(i).getChanReason());
            returnsVo.setCustId(returnsList.get(i).getCustId());
            returnsVo.setOrderNo(returnsList.get(i).getOrderNo());
            returnsVo.setDelivDate(returnsList.get(i).getDelivDate());
            returnsVo.setChanReason(returnsList.get(i).getChanReason());
            returnsVo.setContent(returnsList.get(i).getContent());
            returnsVo.setStatus(returnsList.get(i).getStatus());
            list.add(returnsVo);
        }
        return list;
    }


    @Override
    public PageInfo<Returns> pageList(int currentPage, int pageSize) {
        List<Returns> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = returnMapper.selectAll();
        PageInfo<Returns> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Returns> selectByCustId2(Integer custId) {
        return returnMapper.selectByCustId2(custId);
    }
}
