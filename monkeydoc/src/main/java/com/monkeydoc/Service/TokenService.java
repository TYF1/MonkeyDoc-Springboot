package com.monkeydoc.Service;


import com.monkeydoc.Bean.TokenBean;
import org.springframework.stereotype.Component;

@Component
public interface TokenService {
    TokenBean loginbytoken(String token);
    int storetoken(TokenBean token);
    int changetoken(String token,String userid);
    TokenBean tokenbyuserid(String userid);
}
