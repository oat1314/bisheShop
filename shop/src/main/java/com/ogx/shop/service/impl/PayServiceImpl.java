package com.ogx.shop.service.impl;

import com.alipay.api.AlipayApiException;
import com.ogx.shop.config.AlipayUtil;
import com.ogx.shop.entity.AlipayBean;
import com.ogx.shop.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

/* 支付服务 */
@Service(value = "payService")
public class PayServiceImpl implements PayService {


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }

}
