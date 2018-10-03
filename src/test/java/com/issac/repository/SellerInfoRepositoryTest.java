package com.issac.repository;

import com.issac.dataobject.SellerInfo;
import com.issac.util.KeyUtil;
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
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo sellerInfo1 =  repository.save(sellerInfo);
        Assert.assertNotNull(sellerInfo1);
    }

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("abc");
        Assert.assertEquals(sellerInfo.getOpenid(),"abc");
    }

    @Test
    public void findByUsernameAndPassword() {
        SellerInfo sellerInfo = repository.findByUsernameAndAndPassword("admin","admin");
        Assert.assertEquals(sellerInfo.getUsername(),"admin");
    }
}