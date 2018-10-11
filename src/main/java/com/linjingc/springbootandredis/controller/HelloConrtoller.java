package com.linjingc.springbootandredis.controller;

import com.linjingc.springbootandredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author cxc
 * @date 2018/10/8 17:09
 */
@RestController
@RequestMapping("hello")
public class HelloConrtoller {
    @Value("${server.port}")
    String port;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "")
    public String index(){
        return "helloWord";
    }

    @RequestMapping(value = "findUser")
    public String findUser( String id){
       return userService.findUser(id);
    }

    @RequestMapping(value = "delUser")
    public String delUser( String id){
         userService.delUser(id);
        return "删除success";
    }

    @RequestMapping(value = "updateUser")
    public String updateUser( String id){
        userService.updateUser(id);
        return "更新success"; 
    }



    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
        return map;
    }



}
