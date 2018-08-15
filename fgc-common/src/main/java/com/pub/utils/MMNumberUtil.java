package com.pub.utils;

import java.math.BigDecimal;

/**
 * 数值工具类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月25日
 *
 *     未来离线需求
 */
public class MMNumberUtil {

	/**
	 * 判断数值是否为空或者零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isNullOrZero(BigDecimal d) {
		return null == d || d.compareTo(BigDecimal.ZERO) == 0;
	}

	/**
	 * 判断数值是否为非空或者非零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isNotNullAndNotZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) != 0;
	}

	/**
	 * 判断两个数值是否相等
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isEqual(BigDecimal d1, BigDecimal d2) {
		if (null == d1 && null == d2) {
			return true;
		}
		if (null != d1 && null != d2) {
			return d1.equals(d2);
		}
		return false;
	}

	/**
	 * 数值大于判断
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isGt(BigDecimal d1, BigDecimal d2) {
		BigDecimal d11 = null == d1 ? BigDecimal.ZERO : d1;
		BigDecimal d22 = null == d2 ? BigDecimal.ZERO : d2;
		return d11.compareTo(d22) > 0;
	}

	/**
	 * 数值大于等于判断
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isGtEqual(BigDecimal d1, BigDecimal d2) {
		BigDecimal d11 = null == d1 ? BigDecimal.ZERO : d1;
		BigDecimal d22 = null == d2 ? BigDecimal.ZERO : d2;
		return d11.compareTo(d22) >= 0;
	}

	/**
	 * 数值小于判断
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isLs(BigDecimal d1, BigDecimal d2) {
		BigDecimal d11 = null == d1 ? BigDecimal.ZERO : d1;
		BigDecimal d22 = null == d2 ? BigDecimal.ZERO : d2;
		return d11.compareTo(d22) < 0;
	}

	/**
	 * 数值小于等于判断
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isLsEqual(BigDecimal d1, BigDecimal d2) {
		BigDecimal d11 = null == d1 ? BigDecimal.ZERO : d1;
		BigDecimal d22 = null == d2 ? BigDecimal.ZERO : d2;
		return d11.compareTo(d22) <= 0;
	}

	/**
	 * 判断数值是否等于零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isEqualZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) == 0;
	}

	/**
	 * 判断数值是否大于零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isGtZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) > 0;
	}

	/**
	 * 判断数值是否大于等于零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isGtEqualZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) >= 0;
	}

	/**
	 * 判断数值是否小于零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isLsZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) < 0;
	}

	/**
	 * 判断数值是否小于等于零
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isLsEqualZero(BigDecimal d) {
		return null != d && d.compareTo(BigDecimal.ZERO) <= 0;
	}

	/**
	 * 两个数值取小
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal min(BigDecimal d1, BigDecimal d2) {
		if (null == d1) {
			return d1;
		} else if (null == d2) {
			return d2;
		}
		return d1.compareTo(d2) > 0 ? d2 : d1;
	}

	/**
	 * 两个数值取大
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal max(BigDecimal d1, BigDecimal d2) {
		if (null == d1) {
			return d2;
		} else if (null == d2) {
			return d1;
		}
		return d1.compareTo(d2) > 0 ? d1 : d2;
	}

	/**
	 * 数值相加
	 * 
	 * @param values
	 * @return
	 */
	public static BigDecimal add(BigDecimal... values) {
		if (MMArrayUtil.isEmpty(values)) {
			return null;
		}
		BigDecimal result = BigDecimal.ZERO;
		for (BigDecimal value : values) {
			if (null != value) {
				result = result.add(value);
			}
		}
		return result;
	}

	/**
	 * 数值相减
	 * 
	 * @param lvalue
	 * @param rvalues
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal lvalue, BigDecimal... rvalues) {
		if (MMArrayUtil.isEmpty(rvalues)) {
			return lvalue;
		}
		BigDecimal result = lvalue;
		if (null == lvalue) {
			result = BigDecimal.ZERO;
		}
		for (BigDecimal rvalue : rvalues) {
			if (null != rvalue) {
				result = result.subtract(rvalue);
			}
		}
		return result;
	}

	/**
	 * 绝对值相减
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal absolutesubtract(BigDecimal d1, BigDecimal d2) {
		if (null == d1 && null == d2) {
			return null;
		}
		BigDecimal d11 = null == d1 ? BigDecimal.ZERO : d1;
		BigDecimal d22 = null == d2 ? BigDecimal.ZERO : d2;
		BigDecimal temp = d11.subtract(d22);
		return temp.compareTo(BigDecimal.ZERO) >= 0 ? temp : BigDecimal.ZERO.subtract(temp);
	}

	/**
	 * 数值相乘
	 * 
	 * @param values
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal... values) {
		if (MMArrayUtil.isEmpty(values)) {
			return null;
		}
		BigDecimal result = null;
		for (BigDecimal value : values) {
			if (null == value) {
				return BigDecimal.ZERO;
			}
			if (null == result) {
				result = value;
				continue;
			}
			result = result.multiply(value);
		}
		return result;
	}

	/**
	 * 数值相除
	 * 
	 * @param lvalue
	 * @param rvalues
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal divide(BigDecimal lvalue, BigDecimal... rvalues) throws Exception {
		if (null == lvalue || MMArrayUtil.isEmpty(rvalues)) {
			return null;
		}
		BigDecimal result = lvalue;
		for (BigDecimal rvalue : rvalues) {
			if (null == rvalue || rvalue.compareTo(BigDecimal.ZERO) == 0) {
				throw new Exception("被除数不能为零");
			}
			result = result.divide(rvalue,4,BigDecimal.ROUND_HALF_UP);
		}
		return result;
	}

	/**
	 * 数值取绝对值
	 * 
	 * @param d
	 * @return
	 */
	public static BigDecimal toAbsValue(BigDecimal d) {
		if (null == d) {
			return null;
		}
		return d.abs();
	}

	/**
	 * 数值取精度
	 * 
	 * @param d
	 * @param digit
	 * @return
	 */
	public static BigDecimal toDigitValue(BigDecimal d, int digit) {
		if (null == d) {
			return null;
		}
		return d.setScale(0 - digit, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 数值取相反数
	 * 
	 * @param d
	 * @return
	 */
	public static BigDecimal toNegValue(BigDecimal d) {
		if (null == d) {
			return null;
		}
		return BigDecimal.ZERO.subtract(d);
	}

	/**
	 * 数值取非空值
	 * 
	 * @param d
	 * @return
	 */
	public static BigDecimal toNotNullValue(BigDecimal d) {
		return null == d ? BigDecimal.ZERO : d;
	}

	/**
	 * 数值向上取整
	 * 
	 * @param d
	 * @return
	 */
	public static BigDecimal toUpWardRoundNumber(BigDecimal d) {
		if (MMNumberUtil.isNullOrZero(d)) {
			return d;
		}
		return new BigDecimal(Math.ceil(d.doubleValue()));
	}

	/**
	 * 数值向下取整
	 * 
	 * @param d
	 * @return
	 */
	public static BigDecimal toDownWardRoundNumber(BigDecimal d) {
		if (MMNumberUtil.isNullOrZero(d)) {
			return d;
		}
		return new BigDecimal(Math.floor(d.doubleValue()));
	}

}
