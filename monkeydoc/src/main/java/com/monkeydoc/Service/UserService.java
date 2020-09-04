package com.monkeydoc.Service;

import com.monkeydoc.Bean.UserBean;
import org.springframework.stereotype.Component;
@Component
public interface UserService {
    UserBean loginbytel(String tel);
    UserBean loginbyemail(String email);
    int logonuser(UserBean user);
    int changepsw(String userid,String newpsw);
}
