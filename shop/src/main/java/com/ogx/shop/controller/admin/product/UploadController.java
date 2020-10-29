package com.ogx.shop.controller.admin.product;


import com.ogx.shop.entity.AppConfig;
import com.ogx.shop.entity.WangEditorResponse;
import com.ogx.shop.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: shop
 * @description:上传图片
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: UploadController
 **/



@Controller
@RequestMapping(value = "${adminPath}")
public class UploadController {

    private static final String UPLOAD_IMAGE = "/uploaded";

    @PostMapping("/upload")
    @ResponseBody
    public ResultVo uplaod(HttpServletRequest req, @RequestParam("file") MultipartFile file) {
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file
        //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        try {
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;

            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）

            File destFile = new File(destFileName);
            if (!destFile.getParentFile().exists()) {
                //如果目标文件所在的目录不存在，则创建父目录
                destFile.getParentFile().mkdirs();
            }
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResultVo(0,e.getMessage(),null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultVo(0,e.getMessage(),null);
        }
        return new ResultVo(1,"上传成功",fileName);
    }


    //这个注入配置文件，主要是因为本地的路径和服务器url路径需要动态配置，可以自己写死，也可以动态获取
    @Autowired
    AppConfig appConfig;

    @RequestMapping("/editor")
    @ResponseBody
    public Object editor(@RequestParam("file") MultipartFile file) {
        String fileName ="";
        if(!file.isEmpty()){
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileName = System.currentTimeMillis()+suffix;
            String saveFileName = appConfig.getFilepath()+"/article/"+fileName;
            System.out.println(saveFileName);
            File dest = new File(saveFileName);
            System.out.println(dest.getParentFile().getPath());
            if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
            } catch (Exception e) {
                e.printStackTrace();
                return new WangEditorResponse("1","上传失败"+e.getMessage());
                //return ApiReturnUtil.error("上传失败"+e.getMessage());
            }
        }else {
            return new WangEditorResponse("1","上传出错");
        }
        String imgUrl=appConfig.getUrlpath()+"article/"+fileName;
        return new WangEditorResponse("0",imgUrl );
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadImage(@RequestParam(value = "files", required = false) List<MultipartFile> files,
                                           HttpServletRequest request) {
        System.out.println(">>>>>" + files);
        Map<String, Object> result = new HashMap<>();
        String imgUrls[] = new String[files.size()];

        // 文件存放的路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_IMAGE);
        System.out.println(filePath);

        if (files != null && files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
                MultipartFile multipartFile = files.get(i);
                // System.out.println(String.format("文件名称:%s",multipartFile.getOriginalFilename()));
                String fileName = multipartFile.getOriginalFilename();
                String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                // System.out.println(String.format("后缀名:%s", fileSuffix));
                fileName = UUID.randomUUID().toString().replace("-", "") + fileSuffix;
                // System.out.println(fileName);

                // 判断路径是否存在，不存在则创建文件夹
                File file = new File(filePath);
                if (!file.exists()) {
                    file.mkdir();
                }

                // 将文件写入目标
                file = new File(filePath, fileName);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 获取服务端路径 ,为了图片显示
                String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), request.getServerName(),
                        request.getServerPort(), request.getContextPath(), UPLOAD_IMAGE);
                ;

                imgUrls[i]=serverPath+"/"+fileName;
                System.out.println(imgUrls[i]);
            }

        }

        result.put("errno", 0);
        result.put("data", imgUrls);

        return result;
    }




}
