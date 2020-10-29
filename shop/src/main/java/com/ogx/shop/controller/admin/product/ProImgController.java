package com.ogx.shop.controller.admin.product;

import com.ogx.shop.entity.ProImg;
import com.ogx.shop.service.ProImgService;
import com.ogx.shop.vo.Json.ProImgVo;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 23:09
 * @title: ProImgController
 **/
@Controller
@RequestMapping(value = "${adminPath}")
public class ProImgController {

    @Autowired
    ProImgService proImgService;

    @RequestMapping("/getProImg")
    @ResponseBody
    public Map<String, Object> getProImg(HttpServletRequest request) {
        Integer proId = Integer.parseInt(request.getParameter("shopId"));
        Map<String, Object> result = new HashMap<>();
        List<ProImg> proImgList = proImgService.selectByProId(proId);
        List<String> list = new ArrayList();
        String imgUrls[] = new String[proImgList.size()];
        for (ProImg pro:proImgList
             ) {
            list.add(pro.getUrl());

        }
        int count = 0;
        for (int i = 0; i< list.size();i++) {
            imgUrls[count] = list.get(i);
            count++;
        }

        result.put("errno", 0);
        result.put("data", imgUrls);
/*        result.put("id",id);*/
        return result;
    }

    @RequestMapping("/getProImg1")
    @ResponseBody
    public Map<String, Object> getProImg1(HttpServletRequest request) {
        Integer proId = Integer.parseInt(request.getParameter("shopId"));
        Map<String, Object> result = new HashMap<>();
        ProImg proImg = proImgService.selectByPrimaryKey(proId);
        String imgUrl = proImg.getUrl();
        int id = proImg.getId();

        result.put("errno", 0);
        result.put("data", imgUrl);
        result.put("id",id);
        return result;
    }

    @RequestMapping("/saveProImg")
    @ResponseBody
    public ResultVo saveProImg(HttpServletRequest request, @RequestBody ProImgVo proImgVo) {

        ProImg proImg = new ProImg();
        proImg.setProId(proImgVo.getShopId());
        proImg.setUrl(proImgVo.getUrl());
        proImg.setFlag(proImgVo.getFlag());
        proImgService.insertSelective(proImg);

        return new ResultVo(1, "商品添加成功", null);

    }

    @RequestMapping("/updateProImg")
    @ResponseBody
    public ResultVo updateProImg(HttpServletRequest request, @RequestBody ProImgVo proImgVo) {

        ProImg proImg = new ProImg();
        proImg.setId(proImgVo.getId());
        proImg.setProId(proImgVo.getShopId());
        proImg.setUrl(proImgVo.getUrl());
        proImg.setFlag(proImgVo.getFlag());
        proImgService.updateByPrimaryKeySelective(proImg);

        return new ResultVo(1, "更新成功", null);

    }


}
