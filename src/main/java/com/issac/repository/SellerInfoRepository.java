package com.issac.repository;

import com.issac.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {


    SellerInfo findByOpenid(String openId);

    SellerInfo findByUsernameAndAndPassword(String username,String password);
}