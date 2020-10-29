package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.RoleMapper;
import com.ogx.shop.dao.SysAuthorityMapper;
import com.ogx.shop.entity.Role;
import com.ogx.shop.entity.SysAuthority;
import com.ogx.shop.service.SysAuthorityService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {
    @Resource
    private SysAuthorityMapper sysAuthorityMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysAuthorityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysAuthority record) {
        return sysAuthorityMapper.insert(record);
    }

    @Override
    public int insertSelective(SysAuthority record) {
        return sysAuthorityMapper.insertSelective(record);
    }

    @Override
    public SysAuthority selectByPrimaryKey(Integer id) {
        return sysAuthorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysAuthority record) {
        return sysAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysAuthority record) {
        return sysAuthorityMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBySysId(SysAuthority record) {
        return sysAuthorityMapper.updateBySysId(record);
    }

    @Override
    public int updateInfo(SysAuthority record) {
        return sysAuthorityMapper.updateInfo(record);
    }

    public SysAuthority selectByName(String username) {
        return sysAuthorityMapper.selectByUsername(username);
    }

    public List<SysAuthority> selectAll() {
        return sysAuthorityMapper.selectAll();
    }


    public int updateFlagById(int record) {
        return sysAuthorityMapper.updateFlagById(record);
    }

    public List<SysAuthority> selectByName1(String username) {
        return sysAuthorityMapper.selectByName1(username);
    }

    @Override
    public List<SysAuthority> selectByRoleNo(String roleNo) {
        return sysAuthorityMapper.selectByRoleNo(roleNo);
    }

    @Override
    public PageInfo<SysAuthority> pageList1(SysAuthority sysAuthority, int currentPage, int pageSize) {
        List<SysAuthority> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        // PageHelper.orderBy("id asc");
        if (org.apache.commons.lang.StringUtils.isNotBlank(sysAuthority.getUsername())) {
            list = this.selectByName1(sysAuthority.getUsername());
        } else if (org.apache.commons.lang.StringUtils.isNotBlank(sysAuthority.getRoleNo())) {
            list = this.selectByRoleNo(sysAuthority.getRoleNo());
        }else {
            list = sysAuthorityMapper.selectAll();
        }
        /*List<Role> roles=roleMapper.selectAll();
        for (int i=0;i<list.size();i++){
            String str3 = roles.get(i).getRoleName();
            for (int j=0;j<roles.size();j++){
                if (list.get(i).getRoleNo().equals((roles.get(j).getRoleNo()))){
                    list.get(i).setExtend1(str3);
                }
            }
        }*/
        List<Role> roles = roleMapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < roles.size(); j++) {
//                String str3 = roles.get(i).getRoleName();
                if (list.get(i).getRoleNo().equals((roles.get(j).getRoleNo()).toString())) {
                    list.get(i).setExtend1(roles.get(j).getRoleName());
                }
            }
        }


        PageInfo<SysAuthority> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    /**
     * 注册功能
     */

    public int registerData1(SysAuthority sysAuthority) {
        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(sysAuthority.getUsername());
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String password = sysAuthority.getPassword();
        System.out.println(password);
        String newPs = new SimpleHash("MD5", password, salt, 1024).toHex();
        sysAuthority.setPassword(newPs);
        sysAuthority.setSalt(String.valueOf(salt));
        System.out.println(sysAuthority);
        // 看数据库中是否存在该账户
        SysAuthority sysAuthority1 = sysAuthorityMapper.selectByUsername(sysAuthority.getUsername());
        if(sysAuthority1 == null) {
            sysAuthorityMapper.insertSelective(sysAuthority);
            return 1;
        }else {
            sysAuthorityMapper.updateInfo(sysAuthority);
            return 0;
        }
    }

}
