package com.ogx.shop.vo;

import com.ogx.shop.entity.Product;

import java.math.BigDecimal;

/**
 * @program: shop
 * @description:退货单vo
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public class RefundVo extends Product {
    private String invoice;
    private int qty;
    private BigDecimal total;
    private String orderDate;
    private String proDesc;

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
