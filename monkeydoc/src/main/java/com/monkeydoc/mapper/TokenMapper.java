package com.monkeydoc.mapper;

import com.monkeydoc.Bean.TokenBean;
import org.springframework.stereotype.Component;

@Component
public interface TokenMapper {
    TokenBean getinfobytoken(String token);
    int writetoken(TokenBean token);
    int modifytoken(String token,String userid);
    TokenBean getinfobyuserid(String userid);
}
