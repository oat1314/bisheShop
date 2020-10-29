package com.ogx.shop.controller.admin.product;

import com.ogx.shop.entity.ProVedio;
import com.ogx.shop.service.ProVedioService;
import com.ogx.shop.vo.Json.ProVedioVo;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-23 22:48
 * @title: ProVedioController
 **/
@Controller
@RequestMapping(value = "${adminPath}")
public class ProVedioController {

    @Autowired
    ProVedioService proVedioService;


    @RequestMapping("/getProVedio")
    @ResponseBody
    public Map<String, Object> getProVedio(HttpServletRequest request) {
        Integer proId = Integer.parseInt(request.getParameter("shopId"));
        Map<String, Object> result = new HashMap<>();
        ProVedio proVedio = proVedioService.selectByPrimaryKey(proId);
        String imgUrl = proVedio.getUrl();
        int id = proVedio.getId();
        String title = proVedio.getTitle();

        result.put("errno", 0);
        result.put("data", imgUrl);
        result.put("id",id);
        result.put("title",title);
        return result;
    }

    @RequestMapping("/saveProVedio")
    @ResponseBody
    public ResultVo saveProImg(HttpServletRequest request, @RequestBody ProVedioVo proVedioVo) {

        ProVedio proVedio = new ProVedio();
        proVedio.setId(proVedioVo.getId());
        proVedio.setProId(proVedioVo.getShopId());
        proVedio.setUrl(proVedioVo.getUrl());
        proVedio.setFlag(proVedioVo.getFlag());
        proVedioService.insertSelective(proVedio);

        return new ResultVo(1, "商品添加成功", null);

    }

    @RequestMapping("/updateProVedio")
    @ResponseBody
    public ResultVo updateProVedio(HttpServletRequest request, @RequestBody ProVedioVo proVedioVo) {

        ProVedio proVedio = new ProVedio();
        proVedio.setId(proVedioVo.getId());
        proVedio.setProId(proVedioVo.getShopId());
        proVedio.setUrl(proVedioVo.getUrl());
        proVedio.setFlag(proVedioVo.getFlag());
        proVedioService.updateByPrimaryKeySelective(proVedio);

        return new ResultVo(1, "更新成功", null);

    }

    @RequestMapping("/updateProVedioTile")
    @ResponseBody
    public ResultVo updateProVedioTile(HttpServletRequest request, @RequestBody ProVedioVo proVedioVo) {

        ProVedio proVedio = new ProVedio();
        proVedio.setId(proVedioVo.getId());
        proVedio.setTitle(proVedioVo.getTitle());
        proVedioService.updateByPrimaryKey(proVedio);

        return new ResultVo(1, "更新成功", null);

    }


}
