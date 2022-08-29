package com.imooc.pay.controller;

import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.impl.PayServiceImpl;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Resource
    private PayServiceImpl payService;

    @Resource
    private WxPayConfig wxPayConfig;

    @GetMapping("/creat")
    public ModelAndView creat(@RequestParam("orderId") String orderId,
                              @RequestParam("amount") BigDecimal amount) {
        PayResponse response = payService.creat(orderId, amount);

        Map map = new HashMap<>();
        map.put("codeUrl", response.getCodeUrl());
        map.put("orderId", orderId);
        map.put("returnUrl", wxPayConfig.getReturnUrl());
        return new ModelAndView("creat", map);
    }

    @PostMapping("/notify")
    @ResponseBody
    public String asyncNotify(@RequestBody String notifyData) {
        return payService.asyncNotify(notifyData);
    }

    @GetMapping("/queryByOrderId")
    @ResponseBody
    public PayInfo queryByOrderId(@RequestParam String orderId) {
        return payService.queryByOrderId(orderId);
    }
}
