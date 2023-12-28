package com.qifa.pileadmin.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.qifa.pileadmin.util.JwtUtilForManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if(token != null){
            boolean result = JwtUtilForManager.verify(token);
            if(result){
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{
            JSONObject json = new JSONObject();
            json.put("message","token验证失败");
            json.put("code","401");
            response.getWriter().append(json.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
