package com.ogx.shop.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public class Sales {
    private Integer orderNo;

    private Integer custId;

    private BigDecimal totAmt;

    private Date orderDate;

    private String invoiceNo;

    private String orderStatus;

    private Date delivDate;

    private String flag;

    private String extend2;

    private String extend3;

    private String submitFlag;

    public String getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public BigDecimal getTotAmt() {
        return totAmt;
    }

    public void setTotAmt(BigDecimal totAmt) {
        this.totAmt = totAmt;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getDelivDate() {
        return delivDate;
    }

    public void setDelivDate(Date delivDate) {
        this.delivDate = delivDate;
    }


    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    @Override
    public String toString() {
        return "Sales{" +
                "orderNo=" + orderNo +
                ", custId=" + custId +
                ", totAmt=" + totAmt +
                ", orderDate=" + orderDate +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", delivDate=" + delivDate +
                ", flag='" + flag + '\'' +
                ", extend2='" + extend2 + '\'' +
                ", extend3='" + extend3 + '\'' +
                ", submitFlag='" + submitFlag + '\'' +
                '}';
    }
}