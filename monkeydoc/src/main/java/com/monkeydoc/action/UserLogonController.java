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
public class UserLogonController {
    @Autowired
    UserService userService;
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping(value ="/logon",method = RequestMethod.POST)
    public Responsemsg logon(@RequestBody Message mes) throws IOException {
        Map<String ,Object> map = mes.getMap();
        UserBean newuser=new UserBean((String) map.get("tel"),(String) map.get("email"),(String) map.get("userName"), Security.encryptPwd((String) map.get("password")));
        UserBean u1=userService.loginbyemail((String) map.get("email"));
        UserBean u2=userService.loginbytel((String) map.get("tel"));
        if(u1!=null && u2!=null)
           return new Responsemsg("both_have_been_logon","");
        else if(u1!=null)
            return new Responsemsg("email_has_been_logon","");
        else if(u2!=null)
            return new Responsemsg("phone_has_been_logon","");
        else if(u1==null && u2==null){
            userService.logonuser(newuser);
            return new Responsemsg("logon_succeed","");
        }
        return null;
    }
}
