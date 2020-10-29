package com.ogx.shop.vo;

/**
 * @program: shop
 * @description:保存个人资料
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public class userVo {
    private String custName;
    private String sex;
    private String telNo;
    private String zip;
    private String email;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
