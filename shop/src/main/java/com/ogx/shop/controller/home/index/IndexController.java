package com.ogx.shop.controller.home.index;

import com.ogx.shop.dao.CompanyMapper;
import com.ogx.shop.dao.KindMapper;
import com.ogx.shop.dao.ProductMapper;
import com.ogx.shop.dao.WarehouseMapper;
import com.ogx.shop.entity.Company;
import com.ogx.shop.entity.Kind;
import com.ogx.shop.entity.Product;
import com.ogx.shop.service.CompanyService;
import com.ogx.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: IndexController
 **/

@Controller
@RequestMapping(value = "${frontPath}")
public class IndexController {

    @Autowired
    private ProductService productService;


    @Autowired
    private KindMapper kindMapper;

    private WarehouseMapper warehouseMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 首页数据展示
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index1(HttpServletRequest request, HttpSession session, Model model) {

        //获取今日推荐商品
        List<Product> productList1 = productService.selectByHot(2);
        List<Product> tjList = new ArrayList();
        if (productList1.size() > 3) {
            tjList = productList1.subList(productList1.size()-3, productList1.size());
        } else {
            tjList = productList1;
        }
        model.addAttribute("tjList", tjList);

        //获取活动商品
        List<Product> productList2 = productService.selectByHot(1);
        List<Product> activityList = new ArrayList();
        if (productList2.size() > 4) {
            activityList = productList2.subList(productList2.size()-4, productList2.size());
        } else {
            activityList = productList2;
        }
        model.addAttribute("activityList", activityList);

        //获取水果
        List<Product> productList3 = productService.selectByKindNo("1");
        List<Product> fruitList = new ArrayList();
        if (productList3.size() > 8) {
            fruitList = productList3.subList(productList3.size()-8, productList3.size());
        } else {
            fruitList = productList3;
        }
        Kind kind1 = kindMapper.selectByPrimaryKey(1);
        model.addAttribute("fruitList", fruitList);
        model.addAttribute("kind1",kind1);

        //获取饮料
        List<Product> productList4 = productService.selectByKindNo("8");
        List<Product> drinkList = new ArrayList();
        if (productList4.size() > 8) {
            fruitList = productList4.subList(productList4.size()-8, productList4.size());
        } else {
            drinkList = productList4;
        }
        Kind kind2 = kindMapper.selectByPrimaryKey(8);

        model.addAttribute("drinkList", drinkList);
        model.addAttribute("kind2",kind2);




        //获取页面导航栏
        List<Kind> kinds = kindMapper.selectAll();
        Map<Kind,List<Product>> map = new HashMap<>();
        for (int i = 0; i < kinds.size(); i++) {
            List<Product> product = productService.selectByKindNo(kinds.get(i).getKindNo().toString());
            map.put(kinds.get(i),product);
        }
        model.addAttribute("map",map);


        //获取首页导航
        List<Company> companies=companyMapper.selectAll();
        model.addAttribute("companies",companies);
        return "home/home";
    }

    @RequestMapping("/sort")
    public String sort(HttpServletRequest request, HttpSession session, Model model) {
        //获取页面导航栏
        List<Kind> kinds = kindMapper.selectAll();
        Map<Kind,List<Product>> map = new HashMap<>();
        for (int i = 0; i < kinds.size(); i++) {
            List<Product> product = productService.selectByKindNo(kinds.get(i).getKindNo().toString());
            map.put(kinds.get(i),product);
        }

        //获取首页导航
        List<Company> companies=companyMapper.selectAll();
        model.addAttribute("companies",companies);
        model.addAttribute("map",map);


        return "home/sort";
    }

    @RequestMapping("/login")
    public String login() {
        return "home/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "home/register";
    }
    @RequestMapping("/search")
    public String search() {
        return "home/search";
    }
    @RequestMapping("/select1")
    public String select1() {
        return "home/select1";
    }
    @RequestMapping("/select2")
    public String select2() {
        return "home/select2";
    }
    @RequestMapping("/select3")
    public String select3() {
        return "home/select3";
    }




    @RequestMapping("/forgetPwd")
    public String forgetPwd() {
        return "home/forgetPwd";
    }

    @RequestMapping("/home")
    public String home() {
        return "home/home";
    }





}
