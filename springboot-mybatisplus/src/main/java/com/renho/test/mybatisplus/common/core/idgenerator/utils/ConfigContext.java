package com.renho.test.mybatisplus.common.core.idgenerator.utils;

import redis.clients.jedis.JedisCluster;

public class ConfigContext {

	/** redis database */

	private JedisCluster pool;
	/** 步长 */
	private int step;



	public ConfigContext(ConfigContextBuilder builder){
		this.pool = builder.pool;
		this.step = builder.step;

	}

	public JedisCluster getPool() {
		return pool;
	}

	public int getStep() {
		return step;
	}

	public static class ConfigContextBuilder{

		private JedisCluster pool;
		private int step;

		public ConfigContextBuilder(JedisCluster pool, int step){
			this.pool = pool;
			this.step = step;
		}

		public ConfigContext build(){
			return new ConfigContext(this);
		}

	}
}
