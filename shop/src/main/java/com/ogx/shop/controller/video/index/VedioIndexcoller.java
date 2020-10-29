package com.ogx.shop.controller.video.index;

import com.ogx.shop.entity.ProVedio;
import com.ogx.shop.service.ProImgService;
import com.ogx.shop.service.ProVedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-22 13:23
 * @title: VedioIndexcoller
 **/
@Controller
@RequestMapping(value = "${frontPath}")
public class VedioIndexcoller {

    @Autowired
    ProImgService proImgService;
    @Autowired
    ProVedioService proVedioService;

    @RequestMapping("/videoIndex")
    public String videoIndex(HttpServletRequest request, HttpSession session, Model model) {
        List<ProVedio> proVedioList = proVedioService.selectAll();
        List<ProVedio> proVedios = new ArrayList();
        if (proVedioList.size() > 3) {
            proVedios = proVedioList.subList(proVedioList.size()-3, proVedioList.size());
        } else {
            proVedios = proVedioList;
        }

        model.addAttribute("proVedios",proVedios);
        return "video/index";
    }
    @RequestMapping("/single")
    public String single(HttpServletRequest request, HttpSession session, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProVedio proVedio = proVedioService.selectByPrimaryKey(id);

        model.addAttribute("proVedio",proVedio);
        return "video/single";
    }
    @RequestMapping("/upload")
    public String upload() {return "video/upload";}

}
