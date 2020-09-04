package com.example.monkeyloginon.controller;

import com.example.monkeyloginon.entity.Message;
import com.example.monkeyloginon.entity.Responsemsg;
import com.example.monkeyloginon.service.LogService;
import com.example.monkeyloginon.tools.Json2Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    LogService logservice;
    @CrossOrigin(origins = "*")
    @RequestMapping("/logiN")
    @ResponseBody
    public String Login() throws IOException {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        String method = request.getMethod();
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Expose-Headers","responsemsg,token,userid");
        response.setCharacterEncoding("UTF-8");
        String usrtoken = request.getHeader("token");
        Map<String ,Object> map = new Json2Map().JsontoMap(request);
        Message mes=new Message(map,usrtoken);
        Responsemsg res=logservice.login(mes);
        if(!res.getResponsemsg().equals(""))
            response.setHeader("responsemsg",res.getResponsemsg());
        if(!res.getUserid().equals(""))
            response.setHeader("userid",res.getUserid());
        return null;
    }
    @CrossOrigin(origins = "*")
    @RequestMapping("/logoN")
    @ResponseBody
    public String Logon() throws IOException {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        String method = request.getMethod();
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Expose-Headers","responsemsg,token");
        response.setCharacterEncoding("UTF-8");
        Map<String ,Object> map = new Json2Map().JsontoMap(request);
        Message mes=new Message(map,"");
        Responsemsg res=logservice.logon(mes);
        if(!res.getResponsemsg().equals(""))
            response.setHeader("responsemsg",res.getResponsemsg());
        return null;
    }
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping("/pswmodifY")
    public String Pswmodify() throws IOException {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Expose-Headers","responsemsg,token");
        response.setCharacterEncoding("UTF-8");
        Map<String ,Object> map = new Json2Map().JsontoMap(request);
        Message mes=new Message(map,"");
        Responsemsg res=logservice.pswmodify(mes);
        if(!res.getResponsemsg().equals(""))
            response.setHeader("responsemsg",res.getResponsemsg());
        return null;
    }
}
