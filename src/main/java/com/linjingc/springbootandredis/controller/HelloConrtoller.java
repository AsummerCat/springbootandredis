package com.linjingc.springbootandredis.controller;

import com.linjingc.springbootandredis.service.UserService;
import com.linjingc.springbootandredis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


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
    public String index() {
        return "helloWord";
    }

    @RequestMapping(value = "findUser")
    public String findUser(String id) {
        return userService.findUser(id);
    }

    @RequestMapping(value = "delUser")
    public String delUser(String id) {
        userService.delUser(id);
        return "删除success";
    }

    @RequestMapping(value = "updateUser")
    public String updateUser(String id) {
        userService.updateUser(id);
        return "更新success";
    }


    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 " + port);
        return map;
    }

    @RequestMapping(value = "/huToolsTest", method = RequestMethod.GET)
    public Object huToolsTest() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("普通插入(无过期时间)-->test0", RedisUtil.set("test0", "测试内容"));
        map.put("如果key存在才插入-->test1", RedisUtil.set("test1", "测试内容", "XX", "EX", 10));
        map.put("如果key不存在才插入-->test2", RedisUtil.set("test2", "测试内容", "NX", "EX", 10));
        map.put("使用get获取内容-->test2", RedisUtil.get("test2"));
        map.put("查看缓存是否存在-->test2", RedisUtil.exists("test2"));


        return map;
    }


}
