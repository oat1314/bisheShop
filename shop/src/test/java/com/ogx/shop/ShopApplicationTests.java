package com.ogx.shop;

import com.ogx.shop.dao.*;
import com.ogx.shop.entity.*;
import com.ogx.shop.service.*;
import com.ogx.shop.vo.ReturnsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

	@Autowired
	SysAuthorityService sysAuthorityService;
	@Resource
	SysAuthorityMapper sysAuthorityMapper;

	@Resource
	KindMapper kindMapper;

	@Autowired
	ProductService productService;
	@Autowired
	SalesService salesService;

	@Autowired
	CompanyService companyService;
	@Resource
	ReturnMapper returnMapper;
	@Autowired
	ReturnService returnService;
	@Resource
	SalesMapper salesMapper;
	@Autowired
	SaleItemService saleItemService;
	@Resource
	SaleItemMapper saleItemMapper;
	@Resource
	ProductMapper productMapper;
	@Resource
	RoleMapper roleMapper;
	@Resource
	PinglunMapper pinglunMapper;

	@Autowired
	ProImgService proImgService;

	@Autowired
	ProVedioService proVedioService;

	@Autowired
	AddressService addressService;

	@Test
	public void contextLoads() {
		List<Product> productLists = productService.selectPinglunById(2);
		System.out.println(productLists.toString());
		for (Product product : productLists
		) {
			for (Pinglun pinglun : product.getPinglunList()
			) {
				System.out.println(pinglun.getPinglun());
			}
		}
	}

	@Test
	public void test3() {

		List<SaleItem> saleItemList = saleItemMapper.findAll("202002250536542");
		ArrayList<List<SaleItem>> parentList = new ArrayList<>();
		List<SaleItem> childrenList = new ArrayList<>();
		for (int i = 1; i <= saleItemList.size(); i++) {
			Product product = productMapper.selectById(saleItemList.get(i).getProdId());
			saleItemList.get(i).setDisPrice(product.getUnitPrice());
			saleItemList.get(i).setExtend2(product.getImage());
			saleItemList.get(i).setExtend3(product.getProdDesc());
			for (int j = 0; j <= i; j++) {
				childrenList.add(saleItemList.get(j));
			}
		}
		parentList.add(childrenList);
		for (List<SaleItem> sale : parentList
		) {
			for (SaleItem saleitem : sale
			) {
				System.out.println(saleitem.toString());
			}
		}
	}


	@Test
	public void test1() {
		List<Sales> salesList = salesMapper.selectByCustId3(2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < salesList.size(); i++) {
			salesList.get(i).setExtend2(format.format(salesList.get(i).getOrderDate()));
		}
		for (Sales sale : salesList) {
			System.out.println(sale.toString());
		}
	}

	@Test
	public void test2() {
		/*List<SaleItem> saleItemList = saleItemService.findAll("202002250536542");
		for (SaleItem sale :saleItemList
				) {
			System.out.println(sale.toString());
		}*/
		Sales salesList3 = salesService.selectByInvoiceNo("202002250536542");
		System.out.println(salesList3.toString());
	}

	@Test
	public void test4() {
		List<SysAuthority> list = new ArrayList<>();
		list = sysAuthorityMapper.selectAll();

		List<Role> roles = roleMapper.selectAll();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < roles.size(); j++) {
				if (list.get(i).getRoleNo().equals((roles.get(j).getRoleNo()).toString())) {
					list.get(i).setExtend1(roles.get(j).getRoleName());
				}
			}
		}
		for (SysAuthority sys : list
		) {
			System.out.println(sys.toString());
		}
	}

	@Test
	public void test5() {
		List<Product> list = new ArrayList<>();
		list = productMapper.selectAll();

		List<Kind> kinds = kindMapper.selectAll();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < kinds.size(); j++) {
				if (list.get(i).getKindNo().equals((kinds.get(j).getKindNo()).toString())) {
					list.get(i).setExtend1(kinds.get(j).getKindName());
				}
			}
		}

		for (Product p : list
		) {
			System.out.println(p.toString());
		}
	}


	@Test
	public void test6(){
		SysAuthority sysAuthority = sysAuthorityService.selectByName("admin2");
		int roleno = Integer.parseInt(sysAuthority.getRoleNo());
		//获得该用户角色
		Role role = roleMapper.selectRoleNameByRoleNo(roleno);
		String str = role.getRoleName();
		System.out.println(str);
	}

	@Test
	public void test7(){
		List<ReturnsVo> returnsList = returnService.selectByCustId(2);
		List<List> lists1 = new ArrayList<>();
		for (int i = 0; i < returnsList.size(); i++) {
			//获取退款单 详细订单
			String str = returnsList.get(i).getOrderNo();
			System.out.println(str);
			List<SaleItem> saleItemList1 = saleItemService.findAll(str);
			lists1.add(saleItemList1);
		}
		System.out.println(lists1.toString());
	}

	@Test
	public void test8(){
		List<Product> productList = productMapper.selectByName("苹");
		System.out.println(productList.toString());

	}

	@Test
	public void test9(){
		List<Address> addressList = addressService.selectStatusByCustId0(2);
		System.out.println(addressList.toString());
		List<Address> addressList2 = addressService.selectStatusByCustId1(2);
		System.out.println(addressList2.toString());
	}

	@Test
	public void test10(){
		Address address = addressService.selectByPrimaryKey(29);
		addressService.updateStatus(address);
		addressService.updateStatus1(address);
	}

	@Test
	public void test11(){
		/*ProImg proImg = proImgService.selectByPrimaryKey(2);
		System.out.println(proImg.toString());*/
		ProImg proImg = new ProImg();
		proImg.setProId(2);
		proImg.setUrl("/uploaded/155592171112810.jpg");
		proImg.setFlag(0);
		proImgService.insert(proImg);
	}

	public boolean isInArray(int val,int[] array){
		for(int i = 0; i < array.length; i++){
			if(val == array[i]){
				return true;
			}
		}
		return false;
	}

	@Test
	public void test12(){
		int[] arr = {1,2,3,4};
		System.out.println(isInArray(5,arr));
	}

	@Test
	public void test13(){
		ProImg proImg = new ProImg();
		proImg.setId(7);
		proImg.setProId(2);
		proImg.setUrl("<div id=\"editor11\"></div><p><img src=\"http://127.0.0.1:8765/uploaded/80e0084294ac4d74bd00d82d74e6f8e4.jpg\" style=\"max-width:100%;\"><img src=\"http://127.0.0.1:8765/uploaded/0b132668b63a439c808cfd7d21ca5840.jpg\" style=\"max-width: 100%;\"><img src=\"http://127.0.0.1:8765/uploaded/a0b9ecdcf1604f75af0638c3a3076fe6.jpg\" style=\"max-width: 100%;\"><br></p>");
		proImg.setFlag(0);
		proImgService.updateByPrimaryKeySelective(proImg);
	}

	@Test
	public void test14(){
		ProVedio proVedio = new ProVedio();
		proVedio.setId(10);
		proVedio.setTitle("123456");
		proVedioService.updateByPrimaryKey(proVedio);
	}




}


