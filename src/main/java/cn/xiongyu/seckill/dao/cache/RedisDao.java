package cn.xiongyu.seckill.dao.cache;

import cn.xiongyu.seckill.entity.Seckill;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName: RedisDao
 * Package: cn.xiongyu.seckill.dao.cache
 * Description:
 * Date: 19-8-15 下午12:07
 * Author: xiongyu
 */
@Component
public class RedisDao {

    private String ip;
    private int port;
    private JedisPool jedisPool;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
    public RedisDao() {
        jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379, 6000,"123");
    }

    public void putSeckill(Seckill seckill) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = "seckill" + seckill.getSeckillId();
            byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            int time = 60 * 60;
            jedis.setex(key.getBytes(), time, bytes);
        } finally {
            jedis.close();
        }
    }

    public Seckill getSeckill(int seckillId){
        Jedis jedis = jedisPool.getResource();
        try {
            String key = "seckill" + seckillId;
            byte[] bytes = jedis.get(key.getBytes());
            if (bytes != null){
                Seckill seckill = schema.newMessage();
                ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                return seckill;
            }
        } finally {
            jedis.close();
        }
        return null;
    }
}
