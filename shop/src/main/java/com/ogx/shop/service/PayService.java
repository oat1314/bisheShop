package com.ogx.shop.service;

import com.alipay.api.AlipayApiException;
import com.ogx.shop.entity.AlipayBean;
/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

/*支付服务*/
public interface PayService {

    /*支付宝*/
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
