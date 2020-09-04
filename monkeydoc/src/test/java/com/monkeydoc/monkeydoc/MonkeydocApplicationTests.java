package com.monkeydoc.monkeydoc;

import com.google.gson.Gson;
import com.monkeydoc.Bean.UserBean;
import com.monkeydoc.MonkeydocApplication;
import com.monkeydoc.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@SpringBootTest(classes = {MonkeydocApplication.class})
@RunWith(SpringRunner.class)
public class MonkeydocApplicationTests {

        @Autowired
        UserService userService;
        @Test
        public void   contextLoads() throws IOException {
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
            String method = request.getMethod();
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Access-Control-Expose-Headers","responsemsg,token");
            response.setCharacterEncoding("UTF-8");
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            String usrtoken = request.getHeader("token");
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            Gson gson=new Gson();
            Map<String ,Object> map = gson.fromJson(responseStrBuilder.toString(),Map.class);
            UserBean userBean = userService.loginbytel("szc1");
            System.out.println("该用户ID为：");
            System.out.println(userBean.getId());
        }


}
