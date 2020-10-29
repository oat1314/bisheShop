package com.ogx.shop.controller.admin.order;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.CustomerMapper;
import com.ogx.shop.entity.Address;
import com.ogx.shop.entity.Customer;
import com.ogx.shop.entity.Delivery;
import com.ogx.shop.entity.Sales;
import com.ogx.shop.service.AddressService;
import com.ogx.shop.service.DeliveryService;
import com.ogx.shop.service.SaleItemService;
import com.ogx.shop.service.SalesService;
import com.ogx.shop.vo.LayuiPageVo;
import com.ogx.shop.vo.ResultVo;
import com.ogx.shop.vo.SaleItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: Order1Controller
 **/


@Controller
@RequestMapping(value = "${adminPath}")
public class Order1Controller {

    @Autowired
    private SalesService salesService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private SaleItemService saleItemService;
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 获取订单信息
     *
     * @param sales
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getSaleAll")
    @ResponseBody
    public LayuiPageVo getSale(Sales sales, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        sales.setInvoiceNo(sales.getInvoiceNo());
        LayuiPageVo lpv = new LayuiPageVo();
        PageInfo<Sales> pageInfo = null;
        pageInfo = salesService.pageList(sales, currentPage, pageSize);
        List<Sales> productList = pageInfo.getList();
        lpv.setCode(1);
        lpv.setMsg("获取数据成功");
        lpv.setTotal(pageInfo.getTotal());
        lpv.setData(productList);
        return lpv;
    }

    /**
     * 订单详情表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/orderDetails")
    public String getSale(HttpServletRequest request,Model model) {
        String invoiceNo=request.getParameter("no");
        Address address=new Address();
        Sales sales=salesService.selectByInvoiceNo(invoiceNo);
        Delivery delivery=deliveryService.selectByInvoiceNo(invoiceNo);
        if (delivery==null){
            address=null;
        }else {
            address=addressService.selectByPrimaryKey(Integer.parseInt(delivery.getAddr()));
        }

        List<SaleItemVo> saleItemVos=saleItemService.selectProdByInvoiceNo1(invoiceNo);
        Customer customer=customerMapper.selectByPrimaryKey(sales.getCustId());
        model.addAttribute("customer",customer);
        model.addAttribute("sales",sales);
        model.addAttribute("address",address);
        model.addAttribute("saleItemVos",saleItemVos);
        return "admin/orderDetails";
    }


    /**
     * 删除订单,
     *
     * @param request
     * @return
     */
    @PostMapping("/delAdminOrder")
    @ResponseBody
    public ResultVo delAdminOrder(HttpServletRequest request) {
        String invoiceNo = request.getParameter("invoiceNo");
        int flag = salesService.updateByInvoiceNo(invoiceNo);
        if (flag != 0) {
            return new ResultVo(1, "删除成功", null);
        } else {
            return new ResultVo(0, "删除失败", null);
        }
    }


    @PostMapping("/updateAdminOrder")
    @ResponseBody
    public ResultVo updateAdminOrder(HttpServletRequest request) {
        String invoiceNo = request.getParameter("invoiceNo");
        int flag = salesService.updateAdminOrder(invoiceNo);
        if (flag != 0) {
            return new ResultVo(1, "发货成功", null);
        } else {
            return new ResultVo(0, "发货失败", null);
        }
    }

    @PostMapping("/updateAdminOrder1")
    @ResponseBody
    public ResultVo updateAdminOrder1(HttpServletRequest request) {
        String invoiceNo = request.getParameter("invoiceNo");
        int flag = salesService.updateAdminOrder1(invoiceNo);
        if (flag != 0) {
            return new ResultVo(1, "发货成功", null);
        } else {
            return new ResultVo(0, "发货失败", null);
        }
    }

}
