package com.issac.service.impl;

import com.issac.dataobject.SellerInfo;
import com.issac.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerService sellerService;

    public static final String openid = "abc";

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(result.getOpenid(),openid);
    }
}