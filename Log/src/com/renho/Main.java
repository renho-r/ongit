package com.renho;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author song
 *
 */
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
	}
}
