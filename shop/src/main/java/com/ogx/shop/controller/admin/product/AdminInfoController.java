package com.ogx.shop.controller.admin.product;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.RoleMapper;
import com.ogx.shop.dao.SysAuthorityMapper;
import com.ogx.shop.entity.SysAuthority;
import com.ogx.shop.service.ProductService;
import com.ogx.shop.service.RoleService;
import com.ogx.shop.service.SysAuthorityService;
import com.ogx.shop.vo.Json.SysVo;
import com.ogx.shop.vo.LayuiPageVo;
import com.ogx.shop.vo.ResultVo;
import com.util.ncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: Product1Controller
 **/


@Controller
@RequestMapping(value = "${adminPath}")
public class AdminInfoController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SysAuthorityService sysAuthorityService;

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    @Autowired
    private RoleService roleService;

    @Resource
    private RoleMapper roleMapper;

    /**
     * 获取用户信息
     *
     * @param sysAuthority
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getSysAll")
    @ResponseBody
    public LayuiPageVo getSysAll(SysAuthority sysAuthority, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        sysAuthority.setUsername(sysAuthority.getUsername());
        LayuiPageVo lpv = new LayuiPageVo();
        PageInfo<SysAuthority> pageInfo = null;
        pageInfo =sysAuthorityService.pageList1(sysAuthority, currentPage, pageSize);
        List<SysAuthority> sysAuthorityList = pageInfo.getList();
        lpv.setCode(1);
        lpv.setMsg("获取数据成功");
        lpv.setTotal(pageInfo.getTotal());
        lpv.setData(sysAuthorityList);
        return lpv;
    }

    /**
     * 获取角色
     *
     * @return
     */
    @RequestMapping("/getRole")
    @ResponseBody
    public String getRole() {
        List<String> roles = roleService.selectAll();

        List<List> lists = new ArrayList<>();
        lists.add(roles);

        String JsonString = JSON.toJSONString(lists);
        return JsonString;
    }


    @RequestMapping("/saveSys1")
    @ResponseBody
    public ResultVo saveSys1(HttpServletRequest request, @RequestBody SysVo sysVo) {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setId(sysVo.getId());
        sysAuthority.setUsername(sysVo.getUsername());
        sysAuthority.setPassword(sysVo.getPassword());
        sysAuthority.setRoleNo((roleService.selectByRoleName(sysVo.getRoleNo1()).getRoleNo()).toString());
//        if ("1".equals(sysAuthority.getFlag())) {
        if (sysAuthorityService.registerData1(sysAuthority) == 0) {
            return new ResultVo(1, "更新成功", null);
        } else {
            return new ResultVo(0, "更新失败", null);
        }

//        }
    }

    @RequestMapping("/saveSys2")
    @ResponseBody
    public ResultVo saveSys(HttpServletRequest request, @RequestBody SysVo sysVo) {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setId(sysVo.getId());
        sysAuthority.setUsername(sysVo.getUsername());
        sysAuthority.setPassword(sysVo.getPassword());
        sysAuthority.setRoleNo((roleService.selectByRoleName(sysVo.getRoleNo1()).getRoleNo()).toString());
        /*if ("1".equals(sysAuthority.getFlag())) {
            if (sysAuthorityService.registerData1(sysAuthority) != 0) {
                return new ResultVo(1, "更新成功", null);
            } else {
                return new ResultVo(0, "更新失败", null);
            }
        } else {
            sysAuthorityService.registerData1(sysAuthority);
            return new ResultVo(1, "添加成功", null);
        }*/
        if (sysAuthorityService.registerData1(sysAuthority) != 0) {
            return new ResultVo(1, "添加成功", null);
        } else {
            return new ResultVo(0, "添加失败", null);
        }

    }

        /**
         * 删除商品
         * @param request
         * @return
         */
        @RequestMapping("/delSys")
        @ResponseBody
        public ResultVo delSys (HttpServletRequest request){
            int id = Integer.parseInt(request.getParameter("id"));
            if (sysAuthorityMapper.updateFlagById(id) != 0) {
                return new ResultVo(1, "删除成功", null);
            } else {
                return new ResultVo(0, "删除失败", null);
            }
        }

        /**
         * 重置顾客密码
         * @return
         */
        @RequestMapping("/resetPassword1")
        @ResponseBody
        public ResultVo resetPassword (HttpServletRequest request){
            Integer id = Integer.parseInt(request.getParameter("id"));
            SysAuthority sysAuthority = sysAuthorityService.selectByPrimaryKey(id);
            String ps = ncryptionUtil.createPassword1("123456", sysAuthority);
            sysAuthority.setPassword(ps);
            if (sysAuthorityService.registerData1(sysAuthority) != 1) {
                return new ResultVo(1, "密码重置成功,密码为123456", null);
            }
            return new ResultVo(0, "密码重置失败", null);
        }

    /**
     * 新增(编辑)用户信息
     *
     * @param request
     * @param
     * @return
     */
    /*@RequestMapping("/saveSys")
    @ResponseBody
    public ResultVo saveSys(HttpServletRequest request, @RequestBody SysVo sysVo) {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setId(sysVo.getId());
        sysAuthority.setUsername(sysVo.getUsername());
        sysAuthority.setPassword(sysVo.getPassword());
        sysAuthority.setSalt(sysVo.getSalt());
        sysAuthority.setRoleNo((roleMapper.selectByName(sysVo.getRoleNo1()).getRoleNo()).toString());
        int num = sysAuthorityService.registerData1(sysAuthority);
        if ("1".equals(sysVo.getFlag())) {
            if (num != 0) {
                return new ResultVo(1, "更新成功", null);
            } else {
                return new ResultVo(0, "更新失败", null);
            }
        } else {
            return new ResultVo(1, "添加成功", null);
        }

    }*/

}
