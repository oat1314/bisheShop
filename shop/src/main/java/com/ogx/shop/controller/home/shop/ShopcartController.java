package com.ogx.shop.controller.home.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ogx.shop.entity.Customer;
import com.ogx.shop.entity.Product;
import com.ogx.shop.entity.Shopcart;
import com.ogx.shop.service.ProductService;
import com.ogx.shop.service.SaleItemService;
import com.ogx.shop.service.SalesService;
import com.ogx.shop.service.ShopcartService;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;


/**
 * @program: shop
 * @description:购物车
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: ShopcartController
 **/

@Controller
@RequestMapping(value = "${frontPath}")
public class ShopcartController {

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private ProductService productService;
    @Autowired
    private SaleItemService saleItemService;
    @Autowired
    private SalesService salesService;

    /**
     * 个人购物车
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/shopcart")
    public String shopcart(HttpServletRequest request, HttpServletResponse response, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectById(id);
        HttpSession session = request.getSession();
        model.addAttribute("product", product);
        return "home/shopcart";
    }


    /**
     * 展示购物车
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/shopcartlist")
    public String shopcartlist(HttpServletRequest request, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Shopcart> shopcartList = shopcartService.selectByCustId(customer.getCustId());
        model.addAttribute("shopcartList", shopcartList);
        return "home/shopcart";
    }

    /**
     * 添加购物车
     *
     * @param request
     * @return
     */
    @PostMapping("/shopcartadd")
    @ResponseBody
    public String shopcartadd(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject obj) {
        String data = obj.toJSONString();
        JSONObject json = JSON.parseObject(data);
        int pid = Integer.parseInt(json.getString("id"));
        int num = Integer.parseInt(json.getString("num"));
        String flag = json.getString("flag");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        //将商品添加进购物车,
        Product product = productService.selectById(pid);
        //总金额
        BigDecimal proTotamt = product.getUnitPrice().multiply(new BigDecimal(num));
        Shopcart shopcart = new Shopcart();
        shopcart.setCustId(customer.getCustId());
        shopcart.setProdId(pid);
        shopcart.setUnitPrice(product.getUnitPrice());
        shopcart.setQty(num);
        shopcart.setProTotamt(proTotamt);
        shopcart.setImage(product.getImage());
        shopcart.setBuy(flag);
        int flag1 = shopcartService.insertSelective(shopcart);
        return "ok";
    }

    /**
     * 通过购物车id将商品移除购物车
     *
     * @param request
     * @return
     */
    @PostMapping("del")
    @ResponseBody
    public String del(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject obj) {
        String data = obj.toJSONString();
        JSONObject json = JSON.parseObject(data);
        int id = Integer.parseInt(json.getString("delId"));
        int flag = shopcartService.updateById(id);
        return "ok";
    }

    /**
     * 批量删除购物车
     *
     * @param request
     * @param response
     * @param obj
     * @return
     */
    @PostMapping("delall")
    @ResponseBody
    public String delall(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject obj) {
        String data = obj.toJSONString();
        JSONObject json = JSON.parseObject(data);
        List id = json.getJSONArray("deleIds");
        ResultVo resultVo = new ResultVo();
        for (int i = 0; i < id.size(); i++) {
            int flag = shopcartService.updateById(Integer.parseInt(id.get(i).toString()));
        }
        return "ok";
    }

}
