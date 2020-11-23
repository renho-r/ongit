package com.renho.test.mybatisplus.common.ext.idgenerator.common;

public class Constants {

	public static final String DEFAULT_PATH = "/org/mohrss/leaf/core/idgenerator";

	public static final String KEY_DB_INDEX = "dbIndex";
	public static final String KEY_START_INDEX = "startIndex";
	public static final String KEY_REDIS_SERVERS = "servers";
	public static final String KEY_STEP = "step";
	/** redis default port*/
	public static final int REDIS_DEFAULT_PORT = 6379;

	public static final String DEFUALT_CHARSET = "UTF-8";

	public static final String REDIS_PAUSE_SINGAL = "-1";

	public static final String LEAF_JDBC_URL = "spring.datasource.url";
	public static final String LEAF_JDBC_USERNAME = "spring.datasource.username";
	public static final String LEAF_JDBC_PASSWORD = "spring.datasource.password";

	public static final String LEAF_SEGMENT_ENABLE = "leaf.segment.enable";

	public static final String LEAF_SNOWFLAKE_ENABLE = "leaf.snowflake.enable";
	public static final String LEAF_SNOWFLAKE_PORT = "leaf.snowflake.port";
	public static final String LEAF_SNOWFLAKE_ZK_ADDRESS = "leaf.snowflake.zk.address";

}
