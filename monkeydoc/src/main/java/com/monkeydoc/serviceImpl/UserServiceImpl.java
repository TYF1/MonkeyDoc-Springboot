package com.monkeydoc.serviceImpl;

import com.monkeydoc.Bean.UserBean;
import com.monkeydoc.mapper.UserMapper;
import com.monkeydoc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginbytel(String tel) {
        return userMapper.getinfobytel(tel);
    }

    @Override
    public UserBean loginbyemail(String email) {
        return userMapper.getinfobyemail(email);
    }

    @Override
    public int logonuser(UserBean user) {
        userMapper.addnewuser(user);
        return 0;
    }

    @Override
    public int changepsw(String userid, String newpsw) {
        userMapper.pswmodify(userid,newpsw);
        return 0;
    }
}