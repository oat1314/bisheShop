package com.ogx.shop.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 04:20
 * @title: WangEditorResponse
 **/
@Data
public class WangEditorResponse{
    String errno;
    List<String> data;
    public WangEditorResponse(String errno,List<String> data){
        this.errno=errno;
        this.data=data;
    }
    public WangEditorResponse(String errno,String data){
        this.errno=errno;
        this.data=new ArrayList<>();
        this.data.add(data);
    }
}
