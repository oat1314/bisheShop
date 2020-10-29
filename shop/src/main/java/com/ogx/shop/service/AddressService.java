package com.ogx.shop.service;

import com.ogx.shop.entity.Address;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface AddressService {
    int deleteByPrimaryKey(Integer addId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    int updateStatus(Address record);

    int updateStatus1(Address record);

    List<Address> selectByCustId(int custId);

    List<Address> selectStatusByCustId0(int custId);

    List<Address> selectStatusByCustId1(int custId);
}
