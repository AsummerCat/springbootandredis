package com.linjingc.springbootandredis.service;

import cn.hutool.db.nosql.redis.RedisDS;
import com.linjingc.springbootandredis.dao.UserDao;
import com.linjingc.springbootandredis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.awt.print.Book;


/**
 * @author cxc
 * @date 2018/10/8 17:43
 */
@Slf4j
@CacheConfig(cacheNames = "user")
@Service()
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(key = "'user_'+#id")
    public String findUser(String id){
        log.info("进入方法 查询id:{}",id);
        Jedis jedis = RedisDS.create().getJedis();
            jedis.set("测试","测试set--->"+id);


        return userDao.findUser(id).toString();
    }

    @CacheEvict(key="'user_'+#id")
    public void delUser(String id){
        log.info("进入方法 删除id:{}",id);
    }

    @CachePut(key="'user_'+#id")
    public String updateUser(String id){
        log.info("更新id缓存:{}",id);
       User user= userDao.updateUser(id);
       return user.toString();
    };

}
