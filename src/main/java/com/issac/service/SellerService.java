package com.issac.service;

import com.issac.dataobject.SellerInfo;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);

    SellerInfo findSellerInfoByUsernameAndPassword(String username,String password);
}