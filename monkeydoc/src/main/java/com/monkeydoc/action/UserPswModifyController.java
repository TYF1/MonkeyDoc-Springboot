package com.monkeydoc.action;

import com.monkeydoc.Bean.Message;
import com.monkeydoc.Bean.Responsemsg;
import com.monkeydoc.Bean.UserBean;
import com.monkeydoc.Service.UserService;
import com.monkeydoc.tools.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Map;

@Controller
public class UserPswModifyController {
    @Autowired
    UserService userService;
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping(value ="/pswmodify",method = RequestMethod.POST)
    public Responsemsg pswmodify(@RequestBody Message msg) throws IOException {
        Map<String ,Object> map = msg.getMap();
        UserBean userBean=null;
        String loginfor= (String) map.get("tel");
        String password= Security.encryptPwd((String)map.get("password"));
        String newpsw=Security.encryptPwd((String) map.get("newpassword"));
        String resu="";
        if(map.get("tel").equals("")&&!map.get("email").equals("")) {
            loginfor = (String) map.get("email");
            resu="email";
        }
        else if(!map.get("tel").equals("")&&map.get("email").equals("")) {
            loginfor = (String) map.get("tel");
            resu="tel";
        }
        if(resu.equals("tel")){
            userBean = userService.loginbytel(loginfor);
        }
        else if(resu.equals("email")){
            userBean = userService.loginbyemail(loginfor);
        }
        if (userBean==null)
            return new Responsemsg("user_does_not_exists","");
        else {
            if(userBean.getPassword().equals(password)){
                userService.changepsw(userBean.getId(),newpsw);
                return new Responsemsg("psw_reset_success","");
            }
            else
                return new Responsemsg("psw_is_wrong","");
        }
    }
}
