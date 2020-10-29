package com.ogx.shop.controller.admin.product;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Role;
import com.ogx.shop.service.RoleService;
import com.ogx.shop.vo.LayuiPageVo;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: KindController
 **/

@Controller
@RequestMapping(value = "${adminPath}")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取商品类型信息
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getRoleAll")
    @ResponseBody
    public LayuiPageVo getRoleAll(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        LayuiPageVo lpv = new LayuiPageVo();
        PageInfo<Role> pageInfo = null;
        pageInfo = roleService.pageList(currentPage, pageSize);
        List<Role> productList = pageInfo.getList();
        lpv.setCode(1);
        lpv.setMsg("获取数据成功");
        lpv.setTotal(pageInfo.getTotal());
        lpv.setData(productList);
        return lpv;
    }

    /**
     * 编辑商品分类信息
     * @param request
     * @return
     */
    @RequestMapping("/editRole")
    @ResponseBody
    public ResultVo editRole(HttpServletRequest request) {
        Integer roleNo = Integer.parseInt(request.getParameter("roleNo"));
        String name = request.getParameter("name");
        Role role = new Role();
        role.setRoleNo(roleNo);
        role.setRoleName(name);
        if (roleService.updateByPrimaryKeySelective(role) != 0) {
            return new ResultVo(1, "信息更新成功", null);
        } else {
            return new ResultVo(0, "信息更新失败", null);
        }

    }

    /**
     * 添加商品分类信息
     * @param request
     * @return
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public ResultVo addRole(HttpServletRequest request) {
        String name = request.getParameter("name");
        Role role = new Role();
        role.setRoleName(name);
        if (roleService.insertSelective(role)!=0) {
            return new ResultVo(1, "分类添加成功", null);
        } else {
            return new ResultVo(0, "分类添加失败", null);
        }

    }



    /**
     * 删除商品分类信息
     * @param request
     * @return
     */
    @RequestMapping("/delRole")
    @ResponseBody
    public ResultVo delRole(HttpServletRequest request) {
        int roleNo = Integer.parseInt(request.getParameter("roleNo"));
        Role role = new Role();
        role.setRoleNo(roleNo);
        role.setFlag("0");
        if (roleService.updateByPrimaryKeySelective(role)!=0) {
            return new ResultVo(1, "分类删除成功", null);
        } else {
            return new ResultVo(0, "分类删除失败", null);
        }

    }

}
