package com.monkeydoc.serviceImpl;

import com.monkeydoc.Bean.TokenBean;
import com.monkeydoc.Service.TokenService;
import com.monkeydoc.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenMapper tokenMapper;
    @Override
    public TokenBean loginbytoken(String token) {
        return tokenMapper.getinfobytoken(token);
    }

    @Override
    public int storetoken(TokenBean token) {
        return tokenMapper.writetoken(token);
    }

    @Override
    public int changetoken(String token, String userid) {
        tokenMapper.modifytoken(token,userid);
        return 0;
    }

    @Override
    public TokenBean tokenbyuserid(String userid) {
        return tokenMapper.getinfobyuserid(userid);
    }

}
