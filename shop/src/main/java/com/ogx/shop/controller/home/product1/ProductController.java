package com.ogx.shop.controller.home.product1;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.*;
import com.ogx.shop.service.*;
import com.ogx.shop.vo.OrderVo;
import com.ogx.shop.vo.ResultVo;
import com.ogx.shop.vo.shopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:商品
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: ProductController
 **/

@Controller
@RequestMapping(value = "${frontPath}")
public class ProductController {


    @Autowired
    private ShopcartService shopcartService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SaleItemService saleItemService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PinglunService pinglunService;
    @Autowired
    private ProImgService proImgService;

    /**
     * 商品详情介绍
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/introduction")
    public String introduction(HttpServletRequest request, HttpServletResponse response, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectById(id);
        ProImg proImg = proImgService.selectByPrimaryKey(id);
//        List<Product> product = productService.selectPinglunById(id);
        List<Pinglun> pinglunList = pinglunService.selectAllById(id);
        List<Pinglun> list = new ArrayList();
        List<Product> productlist = productService.selectAll();
        List<Product> tjList = new ArrayList();

        for (int i = 0;i<pinglunList.size();i++){
            int custId = pinglunList.get(i).getCustId();
            Customer customer =  customerService.selectByPrimaryKey(custId);
            String str = customer.getCustName();
            pinglunList.get(i).setExtend1(str);
            list.add(pinglunList.get(i));
        }
        int x = (int)(Math.random()*productlist.size());
        if (productlist.size() > 3) {
            tjList = productlist.subList(productlist.size()-x, productlist.size());
        } else {
            tjList = productlist;
        }

        model.addAttribute("tjList", tjList);
        model.addAttribute("product", product);
        model.addAttribute("list",list);
        model.addAttribute("proImg",proImg);
//        model.addAttribute("productList",productList);
        return "home/introduction";
    }



    @RequestMapping("/pay")
    public String pay(){
        return "home/pay";
    }
    /**
     * 展示商品购买支付页面,并生成订单表
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @PostMapping("/paylist")
    @ResponseBody
    public ResultVo pay(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody shopVo[] shopVo  ) {
        //获取前端封装vo对象,根据商品id,查找商品,传单价,总价
        HttpSession session=request.getSession();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Address> addressList = addressService.selectByCustId(customer.getCustId());
        //查询默认地址
        List<Address> addressList0 = addressService.selectStatusByCustId0(customer.getCustId());
        List<Address> addressList1 = addressService.selectStatusByCustId1(customer.getCustId());
        List<Product> productList = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        OrderVo orderVo=new OrderVo();
        BigDecimal proTotamt=new BigDecimal(0);
        for (int i=0;i<shopVo.length;i++){
            //单个结算
            if (shopVo[i].getFlag()==1){
                int pid=shopVo[i].getpId();
                Product product = productService.selectById(pid);
                if (product.getSupply()<shopVo[i].getNum()||product.getSupply()==0){
                    return new ResultVo(0,"库存不足",null);
                }
                product.setStorage(shopVo[i].getNum());
                product.setExtend1(shopVo[i].getPrice());
                productList.add(product);
                proTotamt=proTotamt.add(product.getUnitPrice().multiply(new BigDecimal(shopVo[i].getNum())));
            }else {
                //批量结算
                int pid = shopVo[i].getShopId();
                list.add(pid);
                Shopcart shopcart= shopcartService.selectByPrimaryKey(pid);
                Product product = productService.selectById(shopcart.getProdId());
                if (product.getSupply()<shopVo[i].getNum()||product.getSupply()==0){
                    return new ResultVo(0,"库存不足",null);
                }
                product.setStorage(shopVo[i].getNum());
                product.setExtend1((shopVo[i].getPrice()));
                productList.add(product);
                shopVo[i].setpId(shopcart.getProdId());
                proTotamt=proTotamt.add(product.getUnitPrice().multiply(new BigDecimal(shopVo[i].getNum())));
            }

        }
        //生成订单表(发货日期为下单日期的后一天)
        orderVo.setQty(shopVo.length);
        orderVo.setCustId(customer.getCustId());
        orderVo.setTotAmt(proTotamt);
        String orderNo= salesService.insertSelective(orderVo);
        //生成订单从表
        shopVo[0].setOrderNO(orderNo);
        saleItemService.insertSelective(shopVo);
        session.setAttribute("pidList",list);
        session.setAttribute("productList", productList);
        session.setAttribute("addressList", addressList);
        session.setAttribute("total", proTotamt);
        session.setAttribute("orderNo",orderNo);
        session.setAttribute("addressList0",addressList0);
        session.setAttribute("addressList1",addressList1);
        return new ResultVo(1,"",null);
    }

    @ResponseBody
    @RequestMapping("/test")
    public PageInfo<Product> test(HttpServletRequest request,
                                  HttpServletResponse response,
                                  HttpSession session,
                                  Product product,
                                  @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        String desc=request.getParameter("name");
        product.setName(desc);
        return productService.pageList(product,currentPage,pageSize);
    }

    @ResponseBody
    @RequestMapping("/test2")
    public PageInfo<Product> select1(HttpServletRequest request,
                                  HttpServletResponse response,
                                  HttpSession session,
                                  Product product,
                                  @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        String desc=request.getParameter("name");
        product.setName(desc);
        return productService.pageList1(product,currentPage,pageSize);
    }

    @ResponseBody
    @RequestMapping("/test3")
    public PageInfo<Product> select2(HttpServletRequest request,
                                     HttpServletResponse response,
                                     HttpSession session,
                                     Product product,
                                     @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        String desc=request.getParameter("name");
        product.setKindNo(desc);
        return productService.pageList2(product,currentPage,pageSize);
    }

    @ResponseBody
    @RequestMapping("/test4")
    public PageInfo<Product> select3(HttpServletRequest request,
                                     HttpServletResponse response,
                                     HttpSession session,
                                     Product product,
                                     @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        String desc=request.getParameter("name");
        System.out.println(desc);

        product.setIsHot(Integer.valueOf(desc));
        return productService.pageList3(product,currentPage,pageSize);
    }

    @RequestMapping("test1")
    public String index(HttpServletRequest request, HttpServletResponse response,
                        Model model, HttpSession session,
                        String name){

        session.setAttribute("name",name);
        return "home/search";
    }

    @RequestMapping(value = "/zwy")
    public String zyx(HttpServletRequest request,
                      HttpSession session,
                      Model model){
        return "home/search";
    }
}
