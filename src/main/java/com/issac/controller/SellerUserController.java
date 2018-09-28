package com.issac.controller;

import com.issac.dataobject.SellerInfo;
import com.issac.enums.ResultEnum;
import com.issac.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                                  Map<String, Object> map) {

        // 1. openid 去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByUsernameAndPassword(username,password);
        if(sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/isell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        // 2. 设置token至redis
        redisTemplate.opsForValue().set("abc","fadasdad");

        // 3. 设置token至cookie

        map.put("url", "/isell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/logout")
    public void logout() {

    }
}