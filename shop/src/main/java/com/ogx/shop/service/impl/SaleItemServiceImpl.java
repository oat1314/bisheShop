package com.ogx.shop.service.impl;

import com.ogx.shop.dao.ProductMapper;
import com.ogx.shop.dao.SaleItemMapper;
import com.ogx.shop.entity.Product;
import com.ogx.shop.entity.SaleItem;
import com.ogx.shop.service.SaleItemService;
import com.ogx.shop.vo.RefundVo;
import com.ogx.shop.vo.SaleItemVo;
import com.ogx.shop.vo.shopVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class SaleItemServiceImpl implements SaleItemService {
    @Resource
    private SaleItemMapper saleItemMapper;
    @Resource
    private ProductMapper productMapper;


    @Override
    public int deleteByPrimaryKey(Integer orderNo) {
        return saleItemMapper.deleteByPrimaryKey(orderNo);
    }

    @Override
    public void insert(SaleItem record) {
        saleItemMapper.insert(record);
    }

    @Override
    public int insertSelective(shopVo[] shopVo) {
        int flag = 0;
        SaleItem saleItem = new SaleItem();
        for (int i = 0; i < shopVo.length; i++) {
            saleItem.setInvoiceNo(shopVo[0].getOrderNO());
            saleItem.setProdId(shopVo[i].getpId());
            saleItem.setQty(shopVo[i].getNum());
            saleItem.setUnitPrice(new BigDecimal(shopVo[i].getPrice()));
            saleItem.setOrderDate(new Date());
            saleItemMapper.insertSelective(saleItem);
        }
        flag = 1;
        return flag;
    }

    @Override
    public SaleItem selectByPrimaryKey(Integer orderNo) {
        return saleItemMapper.selectByPrimaryKey(orderNo);
    }

    @Override
    public int updateByPrimaryKeySelective(SaleItem record) {
        return saleItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SaleItem record) {
        return saleItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SaleItem> findAll(String invoiceNo) {
        List<SaleItem> saleItemList = saleItemMapper.findAll(invoiceNo);
        for (int i = 0; i < saleItemList.size(); i++) {
            Product product = productMapper.selectById(saleItemList.get(i).getProdId());
            saleItemList.get(i).setDisPrice(product.getUnitPrice());
            saleItemList.get(i).setExtend2(product.getImage());
            saleItemList.get(i).setExtend3(product.getProdDesc());
        }
        return saleItemList;
    }

    @Override
    public List<SaleItem> selectProdByInvoiceNo(String invoiceNo) {
        return saleItemMapper.selectProdByInvoiceNo(invoiceNo);
    }


    @Override
    public List<SaleItemVo> selectProdByInvoiceNo1(String invoiceNo) {
        List<SaleItem> saleItemList = saleItemMapper.selectProdByInvoiceNo(invoiceNo);
        List<SaleItemVo> saleItemVos = new ArrayList<>();
        for (int i = 0; i < saleItemList.size(); i++) {
            Product product = productMapper.selectById(saleItemList.get(i).getProdId());
            SaleItemVo saleItemVo = new SaleItemVo(saleItemList.get(i), product.getImage(), product.getName(),product.getProdDesc());
            saleItemVos.add(saleItemVo);
        }
        return saleItemVos;
    }

    /**
     * 退货单vo
     * @param product
     * @param saleItem
     * @return
     */
    @Override
    public RefundVo refund(Product product, SaleItem saleItem) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        RefundVo refundVo=new RefundVo();
        refundVo.setInvoice(saleItem.getInvoiceNo());
        refundVo.setUnitPrice(product.getUnitPrice());
        refundVo.setQty(saleItem.getQty());
        refundVo.setOrderDate(df.format(saleItem.getOrderDate()));
        refundVo.setImage(product.getImage());
        return refundVo;
    }
}
