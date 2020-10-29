package com.ogx.shop.controller.admin.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ogx.shop.dao.CustomerMapper;
import com.ogx.shop.entity.Customer;
import com.ogx.shop.entity.Product;
import com.ogx.shop.entity.Sales;
import com.ogx.shop.service.ProductService;
import com.ogx.shop.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: Index1Controller
 **/


@Controller
@RequestMapping(value = "${adminPath}")
public class Index1Controller {

    @Autowired
    private SalesService salesService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/test123")
    public String test123() {
        return "admin/test123";
    }

    /*@ResponseBody
    @RequestMapping(value = "/addTest123", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addTest123(@RequestBody JSONObject json ) {
        System.out.println(json.toJSONString());
        JSONObject result = new JSONObject();
        result.put("msg","ok");
        result.put("method","json");
        result.put("data",json);
*//*        Integer proId = Integer.parseInt(request.getParameter("id"));
        System.out.println(proId);*//*

        return result.toJSONString();
    }*/


    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login1() {
        return "admin/login";
    }

    @RequestMapping("/index4")
    public String index4(Model model) {
        //今日订单数和销售总额
        List<Sales> salesList = salesService.findToday(new Date());
        BigDecimal totalToday = new BigDecimal(0);
        if (salesList.size() == 0) {
            model.addAttribute("OrderTodayNum", 0);
            model.addAttribute("totalToday", 0);
        } else {

            for (int i = 1; i < salesList.size(); i++) {
                totalToday = totalToday.add(salesList.get(i-1).getTotAmt());
            }
            model.addAttribute("OrderTodayNum", salesList.size());
            model.addAttribute("totalToday", totalToday);
        }

        //本周订单和本周销售总额
        List<Sales> salesList1 = salesService.findWeek();
        BigDecimal totalWeek = new BigDecimal(0);
        if (salesList1.size() == 0) {
            model.addAttribute("OrderWeekNum", 0);
            model.addAttribute("totalWeek", 0);
        } else {
            for (int i = 1; i <salesList1.size(); i++) {
                totalWeek = totalWeek.add(salesList1.get(i-1).getTotAmt());
            }
            model.addAttribute("OrderWeekNum", salesList1.size());
            model.addAttribute("totalWeek", totalWeek);
        }

        //商品总览
        //已上架、已下架、库存紧张、全部商品
        List list1=new ArrayList();
        List list2=new ArrayList();
        List list3=new ArrayList();
        List<Product> productList=productService.selectAll();
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getStatus()==1){
                list1.add(productList.get(i));
            }else if (productList.get(i).getStatus()==2){
                list2.add(productList.get(i));
            }else if (productList.get(i).getStatus()==3){
                list3.add(productList.get(i));
            }
        }
        model.addAttribute("Online",list1.size());
        model.addAttribute("Offline",list2.size());
        model.addAttribute("Storage",list3.size());
        model.addAttribute("ProductNum",productList.size());

        //会员总览
        //今日新增,昨日新增,本周新增,会员总数
        List<Customer> customerList1=customerMapper.findToday();
        List<Customer> customerList2=customerMapper.findYestoday();
        List<Customer> customerList3=customerMapper.findWeek();
        List<Customer> customerList4=customerMapper.findAll();
        model.addAttribute("today",customerList1.size());
        model.addAttribute("yestoday",customerList2.size());
        model.addAttribute("week",customerList3.size());
        model.addAttribute("all",customerList4.size());
        return "admin/test 2";
    }

    /**
     * 销售情况折线图
     * @return
     */
    @RequestMapping("/getSale")
    @ResponseBody
    public String getSale() {
        BigDecimal[] array1= salesService.Lastweek();
        BigDecimal[] array2= salesService.Lastweek1();
        List list=new ArrayList();
        list.add(array1);
        list.add(array2);
        String json= JSON.toJSONString(list);
        return json;
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("/shopList")
    public String shopList() {
        return "admin/shopList";
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("/shopVedioList")
    public String shopVedioList() {
        return "admin/shopVedioList";
    }



    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/addGoods")
    public String addGoods() {
        return "admin/addGoods";
    }
    /**
     * 添加分类
     * @return
     */
    @RequestMapping("/classify")
    public String classify(){
        return "admin/classify";
    }
    /**
     * 订单列表
     * @return
     */
    @RequestMapping("/orderList")
    public String orderList() {
        return "admin/orderList";
    }
    /**
     * 品牌管理
     * @return
     */
    @RequestMapping("/Warehouse")
    public String Warehouse() {
        return "admin/Warehouse";
    }
    /**
     * 销售方式
     * @return
     */
    @RequestMapping("/marketing")
    public String marketing() {
        return "admin/marketing";
    }
    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/userInformation")
    public String userInformation() {
        return "admin/userInformation";
    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/adminUserInfo")
    public String adminUserInfo() {
        return "admin/adminUserInfo";
    }

    /**
     * 退货
     * @return
     */
    @RequestMapping("/returnGoods")
    public String returnGoods() {
        return "admin/returnGoods";
    }

    /**
     * 退货信息
     * @return
     */
    @RequestMapping("/returnInfor")
    public String returnInfor() {
        return "admin/returnInfor";
    }

    /*
    * 用户角色添加
    *
    * */
    @RequestMapping("role")
    public String role() { return "admin/role"; }






}
