package com.pub.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionUtil {

	private static Logger log = LoggerFactory.getLogger(ExceptionUtil.class);

	/**
	 * 打印错误日志
	 * 
	 * @param e
	 * @return
	 */
	public static void error(String msg, Throwable e) {
		e.printStackTrace();
		if (MMStringUtil.isNotEmpty(msg)) {
			log.error(msg, e);
		} else {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 打印调试日志
	 */
	public static void debug(String msg, Throwable e) {
		e.printStackTrace();
		if (MMStringUtil.isNotEmpty(msg)) {
			log.debug(msg, e);
		} else {
			log.debug(e.getMessage(), e);
		}
	}

	/**
	 * 打印调试日志
	 */
	public static void debug(String msg) {
		log.debug(msg);
	}

	/**
	 * 打印信息
	 */
	public static void info(String msg, Throwable e) {
		e.printStackTrace();
		if (MMStringUtil.isNotEmpty(msg)) {
			log.info(msg, e);
		} else {
			log.info(e.getMessage(), e);
		}
	}
	/**
	 * 打印信息
	 */
	public static void info(String msg) {
			log.info(msg);
	}

	public static void wrappedException(String msg, Throwable e) {
		e.printStackTrace();
		if (MMStringUtil.isNotEmpty(msg)) {
			log.error(msg, e);
			throw new RuntimeException(msg, e);
		} else {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
