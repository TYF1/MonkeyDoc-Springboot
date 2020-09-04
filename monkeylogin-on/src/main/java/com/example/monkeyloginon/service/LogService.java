package com.example.monkeyloginon.service;

import com.example.monkeyloginon.entity.Message;
import com.example.monkeyloginon.entity.Responsemsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@FeignClient(name = "service-provider")
@Component
public interface LogService {
    @CrossOrigin(origins = "*")
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    Responsemsg login(@RequestBody Message mes)throws IOException;
    @RequestMapping(value ="/logon",method = RequestMethod.POST)
    Responsemsg logon(@RequestBody Message mes)throws IOException;
    @ResponseBody
    @RequestMapping(value ="/pswmodify",method = RequestMethod.POST)
    Responsemsg pswmodify(@RequestBody Message mes) throws IOException;
}
