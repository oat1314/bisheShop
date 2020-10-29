package com.ogx.shop.controller.home.person;

import com.ogx.shop.entity.*;
import com.ogx.shop.service.*;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:个人中心
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: PersonControllerl
 **/

@Controller
@RequestMapping(value = "${frontPath}")
public class PersonControllerl {

    @Autowired
    private SalesService salesService;

/*    @Resource
    private  SaleItemMapper saleItemMapper;*/

    @Autowired
    private ReturnService returnService;

    @Autowired
    private SaleItemService saleItemService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private ProductService productService;


    /**
     * 个人中心首页
     *
     * @return
     */
    @RequestMapping("/person")
    public String index2(HttpServletRequest request, Model model) {
        //待付款
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Sales> salesList = salesService.selectByCustId(customer.getCustId());
        model.addAttribute("nopay", salesList.size());
        //待发货
        List<Sales> salesList1 = salesService.selectByCustId1(customer.getCustId());
        model.addAttribute("waitnum", salesList1.size());

        //待收货
        List<Sales> salesList2 = salesService.selectByCustId3(customer.getCustId());
        model.addAttribute("waitsend", salesList2.size());

        //已收货
        List<Sales> salesList3 = salesService.selectByCustId4(customer.getCustId());
        model.addAttribute("send", salesList3.size());

        //已退货
        List<Returns> returnsList = returnService.selectByCustId2(customer.getCustId());
        model.addAttribute("repay",returnsList.size());

        //收藏夹
        List<Product> productList = collectService.findAll(customer.getCustId());
        model.addAttribute("productList", productList);

        return "person/index";
    }

    @RequestMapping("/collection")
    public String collection(HttpServletRequest request, Model model) {

        //待付款
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Sales> salesList = salesService.selectByCustId(customer.getCustId());
        model.addAttribute("nopay", salesList.size());
        //待发货
        List<Sales> salesList1 = salesService.selectByCustId1(customer.getCustId());
        model.addAttribute("waitnum", salesList1.size());

        //待收货
        List<Sales> salesList2 = salesService.selectByCustId2(customer.getCustId());
        model.addAttribute("waitsend", salesList2.size());

        //收藏夹
        List<Product> productList = collectService.findAll(customer.getCustId());
        model.addAttribute("productList", productList);

        return "person/collection";
    }


    /**
     * 收货地址
     *
     * @return
     */
    @RequestMapping("/address")
    public String address(HttpServletRequest request, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Address> addressList = addressService.selectByCustId(customer.getCustId());
        //查询默认地址
        List<Address> addressList0 = addressService.selectStatusByCustId0(customer.getCustId());
        List<Address> addressList1 = addressService.selectStatusByCustId1(customer.getCustId());

        model.addAttribute("addressList", addressList);
        model.addAttribute("addressList0", addressList0);
        model.addAttribute("addressList1", addressList1);
        return "person/address";
    }



    /**
     * 个人信息
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/information")
    public String information(HttpServletRequest request, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        model.addAttribute("customer", customer);
        return "person/information";
    }


    /**
     * 订单详情
     *
     * @return
     */
    @RequestMapping("/order")
    public String order(HttpServletRequest request, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        //获取所有订单
        List<Sales> salesList = salesService.findAll(customer.getCustId());
        List<List> lists = new ArrayList<>();
        for (int i = 0; i < salesList.size(); i++) {
            //获取详细订单
            String str = salesList.get(i).getInvoiceNo();
            System.out.println(str);
            List<SaleItem> saleItemList = saleItemService.findAll(str);
            lists.add(saleItemList);
        }
        model.addAttribute("salesList", salesList);
        model.addAttribute("salesItemList", lists);


        //查询待付款订单
        List<Sales> salesList1 = salesService.selectByCustId(customer.getCustId());
        List<List> lists1 = new ArrayList<>();
        for (int i = 0; i < salesList1.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList1 = saleItemService.findAll(salesList1.get(i).getInvoiceNo());
            lists1.add(saleItemList1);
        }
        model.addAttribute("salesList1", salesList1);
        model.addAttribute("salesItemList1", lists1);


        //查询待发货订单(发货日期为下单日期的后一天)
        //待发货
        List<Sales> salesList2 = salesService.selectByCustId1(customer.getCustId());
        List<List> lists2 = new ArrayList<>();
        for (int i = 0; i < salesList2.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList2 = saleItemService.findAll(salesList2.get(i).getInvoiceNo());
            lists2.add(saleItemList2);
        }
        model.addAttribute("salesList2", salesList2);
        model.addAttribute("salesItemList2", lists2);


        //查询待收货订单(当前时间超过发货日期)
        /*List<Sales> salesList3 = salesService.selectByCustId2(customer.getCustId());
        List<List> lists3 = new ArrayList<>();
        for (int i = 0; i < salesList3.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList3 = saleItemService.findAll(salesList3.get(i).getInvoiceNo());
            lists3.add(saleItemList3);
        }
        model.addAttribute("salesList3", salesList3);
        model.addAttribute("salesItemList3", lists3);*/
        List<Sales> salesList3 = salesService.selectByCustId3(customer.getCustId());
        List<List> lists3 = new ArrayList<>();
        for (int i = 0; i < salesList3.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList3 = saleItemService.findAll(salesList3.get(i).getInvoiceNo());
            lists3.add(saleItemList3);
        }
        model.addAttribute("salesList3", salesList3);
        model.addAttribute("salesItemList3", lists3);

        /*已收货*/
        List<Sales> salesList4 = salesService.selectByCustId4(customer.getCustId());
        List<List> lists4 = new ArrayList<>();
        for (int i = 0; i < salesList4.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList4 = saleItemService.findAll(salesList4.get(i).getInvoiceNo());
            lists4.add(saleItemList4);
        }
        model.addAttribute("salesList4", salesList4);
        model.addAttribute("salesItemList4", lists4);

        return "person/order";
    }

    /**
     * 个人中心订单支付
     *
     * @param request
     * @return
     */
    @RequestMapping("/paylist1")
    public String pay1(HttpServletRequest request) {
        //根据订单号查找所属商品,获取地址
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        HttpSession session = request.getSession();
        String invoiceNo = request.getParameter("id");
        List<Address> addressList = addressService.selectByCustId(customer.getCustId());
        List<SaleItem> list = saleItemService.selectProdByInvoiceNo(invoiceNo);
        Sales sales = salesService.selectByInvoiceNo(invoiceNo);
        List<Product> productList = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Product product = productService.selectById(list.get(i).getProdId());
            productList.add(product);
            list2.add(list.get(i).getProdId());
        }
        session.setAttribute("pidList", list2);
        session.setAttribute("productList", productList);
        session.setAttribute("addressList", addressList);
        session.setAttribute("total", sales.getTotAmt());
        session.setAttribute("orderNo", sales.getInvoiceNo());
        return "home/pay";
    }

    /**
     * 删除订单,
     *
     * @param request
     * @return
     */
    @PostMapping("/delOrder")
    @ResponseBody
    public ResultVo delOrder(HttpServletRequest request) {
        String invoiceNo = request.getParameter("invoiceNo");
        int flag = salesService.updateByInvoiceNo(invoiceNo);
        if (flag != 0) {
            return new ResultVo(1, "删除成功", null);
        } else {
            return new ResultVo(0, "删除失败", null);
        }
    }

    //确认收货
    @PostMapping("/updateStauts")
    @ResponseBody
    public ResultVo updateStauts(HttpServletRequest request) {
        String invoiceNo = request.getParameter("invoiceNo");
        int flag = salesService.updateStatus(invoiceNo);
        if (flag != 0) {
            return new ResultVo(1, "收货成功", null);
        } else {
            return new ResultVo(0, "未收货", null);
        }
    }

    /**
     * 添加收藏夹
     *
     * @param request
     * @return
     */
    @RequestMapping("/addCollect")
    @ResponseBody
    public ResultVo addCollect(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        int pid = Integer.parseInt(request.getParameter("pid"));
        Collect collect = new Collect();
        collect.setCustId(customer.getCustId());
        collect.setProdId(pid);
        Collect collect1 = collectService.selectByCollect(collect);
        ResultVo resultVo = new ResultVo();
        if (collect1 != null) {
            resultVo.setCode(0);
            resultVo.setMsg("该商品已收藏");
        } else {
            int flag = collectService.insertSelective(collect);
            if (flag == 1) {
                resultVo.setCode(1);
                resultVo.setMsg("收藏成功");
            } else {
                resultVo.setCode(2);
                resultVo.setMsg("收藏失败");
            }
        }
        return resultVo;
    }

    /**
     * 移除收藏夹
     *
     * @param request
     * @return
     */
    @RequestMapping("/delCollect")
    @ResponseBody
    public ResultVo delCollect(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        int pid = Integer.parseInt(request.getParameter("id"));
        //根据商品id和顾客id更新收藏表
        Collect collect = new Collect();
        collect.setCustId(customer.getCustId());
        collect.setProdId(pid);
        collectService.updateByPrimaryKeySelective(collect);
        return new ResultVo(1, "移除成功", null);
    }

    /**
     * 删除地址接口
     * @param request
     * @return
     */
    @RequestMapping("/delAddress")
    @ResponseBody
    public ResultVo delAddress(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Customer customer=(Customer) request.getSession().getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("id"));
        //根据地址id更新地址表
        addressService.deleteByPrimaryKey(id);
        List<Address> addressList = addressService.selectByCustId(customer.getCustId());
        session.setAttribute("addressList", addressList);
        return new ResultVo(1, "删除成功", null);
    }

    /**
     * 修改默认地址接口
     * @param request
     * @return
     */
    @RequestMapping("/updateAddressStatus")
    @ResponseBody
    public ResultVo updateAddressStatus(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Customer customer=(Customer) request.getSession().getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("id"));
/*        int status = Integer.parseInt(request.getParameter("status"));*/
        //根据地址id更新地址表
        Address address = addressService.selectByPrimaryKey(id);
        List<Address> addressList = addressService.selectStatusByCustId1(customer.getCustId());
        int custId = customer.getCustId();
        System.out.println(custId);
        if (address.getStatus()==0){
            addressService.updateStatus(address);
        }
        for (Address address1:addressList
        ) {
            addressService.updateStatus1(address1);
        }
      /*  List<Address> addressList = addressService.selectByCustId(customer.getCustId());*/
        //查询地址
        List<Address> addressList0 = addressService.selectStatusByCustId0(customer.getCustId());
        List<Address> addressList1 = addressService.selectStatusByCustId1(customer.getCustId());
/*        session.setAttribute("addressList", addressList);*/
        session.setAttribute("addressList0",addressList0);
        session.setAttribute("addressList1",addressList1);
        return new ResultVo(1, "修改成功", null);
    }


    @RequestMapping("/orderinfo")
    public String orderInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String invoiceNo = request.getParameter("invoiceNo");
//        Sales salesList2 = salesService.selectByInvoiceNo(invoiceNo);
        Sales salesList3 = salesService.selectByInvoiceNo(invoiceNo);
        List<SaleItem> saleItemList5 = saleItemService.findAll(invoiceNo);
        List<Address> addressList1 = addressService.selectByCustId(customer.getCustId());
        model.addAttribute("addressList1", addressList1);
//        model.addAttribute("salesList2",salesList2);
        model.addAttribute("salesList3", salesList3);
        model.addAttribute("saleItemList5", saleItemList5);


        return "person/orderinfo";
    }


    @RequestMapping("/bill")
    public String bill() {
        return "person/bill";
    }

    @RequestMapping("/billlist")
    public String billlist() {
        return "person/billlist";
    }

    @RequestMapping("/bindphone")
    public String bindphone() {
        return "person/bindphone";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "person/blog";
    }


    @RequestMapping("/email")
    public String email() {
        return "person/email";
    }

    @RequestMapping("/idcard")
    public String idcard() {
        return "person/idcard";
    }

    /*@RequestMapping("/orderinfo")
    public String orderinfo(HttpServletRequest request, Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");

        List<Sales> salesList3 = salesService.selectByCustId3(customer.getCustId());
        List<List> lists3 = new ArrayList<>();
        for (int i = 0; i < salesList3.size(); i++) {
            //获取未付款详细订单
            List<SaleItem> saleItemList3 = saleItemService.findAll(salesList3.get(i).getInvoiceNo());
            lists3.add(saleItemList3);
        }
        model.addAttribute("salesList3", salesList3);
        model.addAttribute("salesItemList3", lists3);

        return "person/orderinfo";
    }*/



    @RequestMapping("/logistics")
    public String logistics(){return "person/logistics";}

    @RequestMapping("/password")
    public String password() {
        return "person/password";
    }

    @RequestMapping("/question")
    public String question() {
        return "person/question";
    }

    @RequestMapping("/record")
    public String record() {
        return "person/record";
    }



    @RequestMapping("/safety")
    public String safety() {
        return "person/safety";
    }


    @RequestMapping("/setpay")
    public String setpay() {
        return "person/setpay";
    }
}
