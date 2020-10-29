package com.ogx.shop.service.impl;

import com.ogx.shop.dao.AddressMapper;
import com.ogx.shop.entity.Address;
import com.ogx.shop.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/


@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public int deleteByPrimaryKey(Integer addId) {
        return addressMapper.deleteByPrimaryKey(addId);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public Address selectByPrimaryKey(Integer addId) {
        return addressMapper.selectByPrimaryKey(addId);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStatus(Address record) {
        return addressMapper.updateStatus(record);
    }

    @Override
    public int updateStatus1(Address record) {
        return addressMapper.updateStatus1(record);
    }

    @Override
    public List<Address> selectByCustId(int custId) {
        return addressMapper.selectByCustId(custId);
    }

    @Override
    public List<Address> selectStatusByCustId0(int custId) {
        return addressMapper.selectStatusByCustId0(custId);
    }

    @Override
    public List<Address> selectStatusByCustId1(int custId) {
        return addressMapper.selectStatusByCustId1(custId);
    }
}
