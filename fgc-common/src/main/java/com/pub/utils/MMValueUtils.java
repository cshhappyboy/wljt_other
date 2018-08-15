package com.pub.utils;

public class MMValueUtils {

	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		if (null != obj) {
			return true;
		}
		return false;
	}

}
