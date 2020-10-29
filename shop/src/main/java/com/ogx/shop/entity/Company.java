package com.ogx.shop.entity;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public class Company {
    private Integer supNo;

    private String supName;

    private String flag;

    private String extend2;

    private String extend3;

    public Company() {
    }

    public Company(Integer supNo, String supName, String flag, String extend2, String extend3) {
        this.supNo = supNo;
        this.supName = supName;
        this.flag = flag;
        this.extend2 = extend2;
        this.extend3 = extend3;
    }

    public Integer getSupNo() {
        return supNo;
    }

    public void setSupNo(Integer supNo) {
        this.supNo = supNo;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName == null ? null : supName.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
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
        return "Company{" +
                "supNo=" + supNo +
                ", supName='" + supName + '\'' +
                ", flag='" + flag + '\'' +
                ", extend2='" + extend2 + '\'' +
                ", extend3='" + extend3 + '\'' +
                '}';
    }
}