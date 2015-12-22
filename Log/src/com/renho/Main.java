package com.renho;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	/**
	 * @param args
	 */
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info(StringUtils.trim("   renho"));
		logger.debug("1111");
		logger.info(StringUtils.trim("    renho").length() + "");
		logger.info("test git");
		logger.info("test git dev-renho");
		logger.info("test git dev-renho-sec");
	}
}
