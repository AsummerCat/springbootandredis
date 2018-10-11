package com.linjingc.springbootandredis.dao;

import com.linjingc.springbootandredis.vo.User;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

/**
 * @author cxc
 * @date 2018/10/8 21:35
 */
@Repository
public class UserDao {


    public User findUser(String id) {
        if ("1".equals(id)) {
            User a = new User();
            a.setName("小明");
            a.setAge(18);
            return a;
        }
        if ("2".equals(id)) {
            User a = new User();
            a.setName("小敏");
            a.setAge(19);
            return a;
        }
        if ("3".equals(id)) {
            User a = new User();
            a.setName("小杰");
            a.setAge(20);
            return a;
        }
        return new User();
    }

    public User updateUser(String Id){
        User a = new User();
        a.setName("更新了缓存");
        return a;
    }
}
