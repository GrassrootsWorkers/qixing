package com.dream.qixing.mobile;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisUtils {
	private static JedisPool pool;
	private static int defaultPort = 6379;
	private static String defaultHost = DomainNameConfige.getStringProperty("front_redis_domain_name");
	private static RedisUtils instance;

	private RedisUtils() {
	}

	public static RedisUtils getInstance() {
		if (instance == null) {
			String host = ReloadableConfig.getStringProperty("host");
			Integer port = ReloadableConfig.getIntProperty("port");
			Integer timeOut = ReloadableConfig.getIntProperty("timeout");
			Integer maxTotal = ReloadableConfig.getIntProperty("maxTotal");
			if (port == null || timeOut == null || maxTotal == null) {
				port = defaultPort;
				timeOut = 1000;
				maxTotal = 200;
			}
			if (host == null ) {
				host = defaultHost;
			}
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
		if(jedis == null){
			return ;
		}
		// jedis.set("test-slave", "test-slave success");
		System.out.println(jedis.get("test-slave"));
		instance.returnResource(jedis);
	}

}
