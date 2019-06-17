package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	static JedisPool jep=new JedisPool();
	static {
		InputStream is = JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer.parseInt(pro.getProperty("maxTotal"));
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
		config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
		jep=new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
	}
	public static Jedis getJedis() {
		return jep.getResource();
	}
}
