package com.issac.service.impl;

import com.issac.dataobject.SellerInfo;
import com.issac.repository.SellerInfoRepository;
import com.issac.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndAndPassword(username,password);
    }
}