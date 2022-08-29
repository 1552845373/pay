package com.imooc.pay.config;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BestPayConfig {

    @Resource
    private WxAccountConfig wxAccountConfig;

    @Bean
    public BestPayService bestPayService(WxPayConfig wxPayConfig) {
//        AliPayConfig aliPayConfig = new AliPayConfig();
//        aliPayConfig.setAppId("xxxxxx");
//        aliPayConfig.setPrivateKey("xxxxxx");
//        aliPayConfig.setAliPayPublicKey("xxxxxx");
//        aliPayConfig.setReturnUrl("http://xxxxx");
//        aliPayConfig.setNotifyUrl("http://xxxxx");

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
//        bestPayService.setAliPayConfig(aliPayConfig);
        return bestPayService;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        //微信支付配置
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getAppId());          //公众号Id
        //支付商户资料
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
        return wxPayConfig;
    }

}
