package com.issac.repository;

import com.issac.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * author:  ywy
 * date:  2018-08-30
 * desc:
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("棒棒冰");
        productInfo.setProductPrice(new BigDecimal(6.4));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很甜的棒冰");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findProductByProductStatusTest() {

        List<ProductInfo> productInfoList = repository.findProductByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}