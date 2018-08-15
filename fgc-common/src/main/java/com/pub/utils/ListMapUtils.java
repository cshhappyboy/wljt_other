package com.pub.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具类 <br>
 * 名称: com.javaboy.utils.ListMapUtils<br>
 * by：javaboy<br>
 * e-mail:javaboyok@163.com<br>
 * 
 * @author 张佳宾
 * @date 2017年5月23日
 */
public class ListMapUtils {

	public static Map<Object, Object> listMapToMap(List<Map<Object, Object>> list, String[] items) {
		Map<Object, Object> result = new HashMap<>();

		if (MMCollectionUtil.isNotEmpty(list) && MMArrayUtil.isNotEmpty(items) && items.length == 2) {
			for (Map<Object, Object> map : list) {
				Object key = map.get(items[0]);
				Object value = map.get(items[1]);
				result.put(key, value);
			}
		}
		return result;
	}

}
