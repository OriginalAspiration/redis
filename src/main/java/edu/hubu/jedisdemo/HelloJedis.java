package edu.hubu.jedisdemo;

import redis.clients.jedis.Jedis;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName HelloJedis
 * @Description TODO
 * @createTime 2019年10月15日 14:28:00
 */
public class HelloJedis {
    public static void main(String[] args) throws Exception {

        asyncSave();
    }

    //向redis中存储字符串
    public static void redisSetString() {
        //实例化一个jedis对象，连接到指定的服务器，指定连接端口号
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //将key为message的信息写入redis数据库中
        jedis.set("message", "Hello Redis!");
        //从数据库中取出key为message的数据
        String value = jedis.get("message");
        System.out.println(value);
        //关闭连接
        jedis.close();
    }

    //立即保存，同步保存
    public static void syncSave() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i < 1000; i++) {
            jedis.set("key" + i, "Hello" + i);
            System.out.println("设置key" + i + "的数据到redis");
            Thread.sleep(2);
        }
        //执行保存，会在服务器下生成一个dump.rdb数据库文件
        jedis.save();
        jedis.close();
        System.out.println("写入完成");
    }

    //异步保存
    public static void asyncSave() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i < 1000; i++) {
            jedis.set("key" + i, "Hello" + i);
            System.out.println("设置key" + i + "的数据到redis");
            Thread.sleep(2);
        }
        //执行异步保存，会在服务器下生成一个dump.rdb数据库文件
        jedis.bgsave();
        jedis.close();
        System.out.println("写入完成");
    }
}
