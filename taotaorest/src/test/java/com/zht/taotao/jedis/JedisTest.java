package com.zht.taotao.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

/**
 * Created by zhouhantong on 2018/4/12.
 *
 * @author 周寒通
 */
public class JedisTest {
    /**
     * 测试jedis连接单机版redis
     */
    @Test
    public void testJedistSingle(){
        //创建一个jedis对象
        Jedis jedis=new Jedis("192.168.145.128");
        //调用jedis对象的方法,方法名称和redis的命令一致
        jedis.set("name","张三");
        String name=jedis.get("name");
        System.out.println(name);
        //关闭jedis
        jedis.close();
    }
    /**
     * 连接池连接redis单机版
     */
    @Test
    public void testJedisPool(){
        //创建jedis连接池对象
        JedisPool pool=new JedisPool("192.168.145.128",6379);
        //获取jedis对象
        Jedis jedis = pool.getResource();
        //获取参数
        String name = jedis.get("name");
        System.out.println(name);
        //关闭jedis对象
        jedis.close();
        //关闭连接池
        pool.close();
    }
    @Test
    public void testJedisCluster(){
        HashSet<HostAndPort>nodes=new HashSet<>();
        nodes.add(new HostAndPort("192.168.145.128",7001));
        nodes.add(new HostAndPort("192.168.145.128",7002));
        nodes.add(new HostAndPort("192.168.145.128",7003));
        nodes.add(new HostAndPort("192.168.145.128",7004));
        nodes.add(new HostAndPort("192.168.145.128",7005));
        nodes.add(new HostAndPort("192.168.145.128",7006));
        JedisCluster cluster=new JedisCluster(nodes);
        cluster.set("name","李四");
        String name = cluster.get("name");
        System.out.println(name);
        cluster.close();
    }
}
