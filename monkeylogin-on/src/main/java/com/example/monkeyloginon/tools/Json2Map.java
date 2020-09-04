package com.example.monkeyloginon.tools;

import com.google.gson.Gson;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Json2Map {
    public Map JsontoMap(HttpServletRequest request) throws IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        Gson gson=new Gson();
        Map<String ,Object> map = gson.fromJson(responseStrBuilder.toString(),Map.class);
        return map;
    }
}
