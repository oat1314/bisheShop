package com.ogx.shop.vo;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/


public class addressVo {
   private int  custId;
   private String  shouhuoer;
   private String phone;
   private String  shengfen;
   private String city;
   private String qu;
   private String address1;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getShouhuoer() {
        return shouhuoer;
    }

    public void setShouhuoer(String shouhuoer) {
        this.shouhuoer = shouhuoer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShengfen() {
        return shengfen;
    }

    public void setShengfen(String shengfen) {
        this.shengfen = shengfen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
}
