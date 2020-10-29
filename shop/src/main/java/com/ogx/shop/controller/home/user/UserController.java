package com.ogx.shop.controller.home.user;

import com.ogx.shop.entity.Address;
import com.ogx.shop.entity.Customer;
import com.ogx.shop.service.AddressService;
import com.ogx.shop.service.CustomerService;
import com.ogx.shop.vo.ResultVo;
import com.ogx.shop.vo.addressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: UserController
 **/
@Controller
@RequestMapping(value = "${frontPath}")
public class UserController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private CustomerService customerService;


    /**
     * 添加地址
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("address1")
    @ResponseBody
    public ResultVo address(HttpServletRequest request, HttpServletResponse response, @RequestBody addressVo addressVo) {

        Customer customer = (Customer) request.getSession().getAttribute("customer");

        Address address = new Address();
        address.setAddress(addressVo.getAddress1());
        address.setCity(addressVo.getCity());
        address.setConsignee(addressVo.getShouhuoer());
        address.setCustId(customer.getCustId());
        address.setDistrict(addressVo.getQu());
        address.setProvince(addressVo.getShengfen());
        address.setPhone(addressVo.getPhone());
        address.setStatus(0);
        int flag = addressService.insertSelective(address);
        if (flag != 0) {
            return new ResultVo(1, "地址添加成功", null);
        } else {
            return new ResultVo(0, "地址添加失败", null);
        }
    }

    /**
     * 保存个人资料
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("updateinfo")
    @ResponseBody
    public ResultVo updateinfo(HttpServletRequest request, HttpServletResponse response, @RequestBody Customer customer1) {

        Customer customer = (Customer) request.getSession().getAttribute("customer");
        customer.setCustName(customer1.getCustName());
        customer.setSex(customer1.getSex());
        customer.setZip(customer1.getZip());
        customer.setTelNo(customer1.getTelNo());
        customer.setEmail(customer1.getEmail());

        int flag = customerService.updateByPrimaryKeySelective(customer);
        if (flag != 0) {
            return new ResultVo(1, "信息保存成功", null);
        }
        return new ResultVo(0, "信息保存失败", null);

    }


}
