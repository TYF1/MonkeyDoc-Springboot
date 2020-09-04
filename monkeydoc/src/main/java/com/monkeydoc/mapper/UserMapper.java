package com.monkeydoc.mapper;
import  com.monkeydoc.Bean.UserBean;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    UserBean getinfobytel(String tel);
    UserBean getinfobyemail(String email);
    int addnewuser(UserBean user);
    int pswmodify(String userid,String newpsw);
}
