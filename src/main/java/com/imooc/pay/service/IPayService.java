package com.imooc.pay.service;

import com.imooc.pay.pojo.PayInfo;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

public interface IPayService {

    /**
     * 创建支付
     */
    PayResponse creat(String orderId, BigDecimal amount);

    /**
     * 异步通知处理
     */
    String asyncNotify(String notifyData);

    PayInfo queryByOrderId(String orderId);
}
