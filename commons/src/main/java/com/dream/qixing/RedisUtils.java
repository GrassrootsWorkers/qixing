package com.dream.qixing;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisUtils {
	private static JedisPool pool;
	private static RedisUtils instance;

	private RedisUtils() {
	}

	public static RedisUtils getInstance() {
		if (instance == null) {
			String host = "master.redis.binggou.com";
			Integer port = 6379;
			Integer timeOut =200;
			Integer maxTotal =200;
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(maxTotal);
			pool = new JedisPool(config, host, port, timeOut);
			instance = new RedisUtils();
		}
		return instance;
	}

	public Jedis getJedis() {
		try {
			return pool.getResource();
		} catch (JedisConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void returnResource(Jedis jedis) {
		pool.returnResource(jedis);
	}

	public static void main(String[] args) {
		RedisUtils instance = RedisUtils.getInstance();
		Jedis jedis = instance.getJedis();
		if(jedis == null) {
			return;
		}
//		for(int i =0 ;i<100;i++){
//			jedis.hset("activity_id","user_00"+i,"(lat1,lon1)_"+i);
//		}
		System.out.println(jedis.hvals("activity_id"));
		System.out.println(jedis.hkeys("activity_id"));
		instance.returnResource(jedis);
	}

}
