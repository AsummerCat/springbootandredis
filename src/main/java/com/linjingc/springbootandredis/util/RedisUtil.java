package com.linjingc.springbootandredis.util;

import cn.hutool.db.nosql.redis.RedisDS;
import redis.clients.jedis.Jedis;

/**
 * @author cxc
 * @date 2018/11/13 11:52
 * hutool的redis工具类
 */
public class RedisUtil {
    private static Jedis jedis = RedisDS.create().getJedis();


    /**
     * 普通set一个值到redis 无过期时间
     *
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value) {
        return jedis.set(key, value);
    }

    /**
     * 存储数据到缓存中，并制定过期时间和当Key存在时是否覆盖。
     *
     * @param key
     * @param value
     * @param nxxx  nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
     * @param expx  expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
     * @param time
     * @return
     */
    public static String set(String key, String value, String nxxx, String expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    /**
     * 从缓存中根据key取得其String类型的值，如果key不存在则返回null，如果key存在但value不是string类型的，
     * 则返回一个error。这个方法只能从缓存中取得value为string类型的值。
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return jedis.get(key);
    }

    /**
     * 检查某个key是否在缓存中存在，如果存在返回true，否则返回false；需要注意的是，即使该key所对应的value是一个空字符串，
     * 也依然会返回true
     *
     * @param key
     * @return
     */
    public static Boolean exists(String key) {
        jedis.exists(key);
        return jedis.exists(key);
    }

    /**
     * 如果一个key设置了过期时间，则取消其过期时间，使其永久存在。
     *
     * @param key
     * @return 返回1或者0, 1代表取消过期时间成功，0代表不成功(只有当key不存在时这种情况才会发生)
     */
    public static Long persist(String key) {
        return jedis.persist(key);
    }

    /**
     * 返回某个key所存储的数据类型，返回的数据类型有可能是"none", "string", "list", "set", "zset",
     * "hash". "none"代表key不存在。
     *
     * @param key
     * @return
     */
    public static String type(String key) {
        return jedis.type(key);
    }

    /**
     * * 为key设置一个特定的过期时间，单位为秒。过期时间一到，redis将会从缓存中删除掉该key。
     * 即使是有过期时间的key，redis也会在持久化时将其写到硬盘中，并把相对过期时间改为绝对的Unix过期时间。
     * 在一个有设置过期时间的key上重复设置过期时间将会覆盖原先设置的过期时间。
     *
     * @param key
     * @param seconds
     * @return 返回1表示成功设置过期时间，返回0表示key不存在。
     */
    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }
}
