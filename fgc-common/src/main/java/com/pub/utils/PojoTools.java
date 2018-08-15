package com.pub.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * pojo保存工具类 名称: com.taotao.utils.PojoIsertTools<br>
 * by：javaboy<br>
 * e-mail:javaboyok@163.com<br>
 * 
 * @author 张佳宾
 * @date 2017年4月15日
 */
public class PojoTools {

	private PojoTools() {

	}

	/**
	 * 设置id,ts,dr
	 * <p>
	 * Title: info
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clazz
	 * @param obj
	 */
	public static void beforeInsert(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setId")) {
					method.invoke(obj, IDUtils.genId());
				} else if (method.getName().equals("setDr")) {
					method.invoke(obj, MMNCUtils.getDR(0));
				} else if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.FREE);
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置id,ts,dr
	 * <p>
	 * Title: info
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clazz
	 * @param obj
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void beforeInsert(Class<?> clazz, Object obj, IUParamVO paramVO) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setId")) {
					method.invoke(obj, IDUtils.genId());
				} else if (method.getName().equals("setDr")) {
					method.invoke(obj, MMNCUtils.getDR(0));
				} else if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.FREE);
				} else if (method.getName().equals("getVbillcode")) {
					String billcode = (String) method.invoke(obj);
					if (MMStringUtil.isEmpty(billcode)) {
						Method vbillcodeMethod = clazz.getMethod("setVbillcode", String.class);
						vbillcodeMethod.invoke(obj, paramVO.getVbillcode());
					}
				} else if (method.getName().equals("setBillmaker")) {
					method.invoke(obj, paramVO.getCuserid());
				} else if (method.getName().equals("setBillmaketime")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 校验ts
	 * <p>
	 * Title: info
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clazz
	 * @param obj
	 * @param objOld
	 *            数据库中pojo
	 */
	public static boolean canBeforeUpdate(String jspts, String dbts) {
		if (MMStringUtil.isEqual(jspts, dbts)) {
			return true;
		}
		TSException.error();
		return false;
	}

	public static void beforeUpdate(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeUpdate(Class<?> clazz, Object obj, IUParamVO paramVO) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setModifier")) {
					method.invoke(obj, paramVO.getCuserid());
				} else if (method.getName().equals("setModifiedtime")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeApprove(Class<?> clazz, Object obj, IUParamVO paramVO) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setApprover")) {
					method.invoke(obj, paramVO.getCuserid());
				} else if (method.getName().equals("setApprovetime")) {
					method.invoke(obj, paramVO.getYeDate());
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.APPROVED);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeSign(Class<?> clazz, Object obj, IUParamVO paramVO) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setApprover")) {
					method.invoke(obj, paramVO.getCuserid());
				} else if (method.getName().equals("setApprovetime")) {
					method.invoke(obj, paramVO.getYeDate());
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.SIGN);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeUnSign(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setApprover")) {
					method.invoke(obj, "");
				} else if (method.getName().equals("setApprovetime")) {
					method.invoke(obj, "");
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.FREE);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeUnApprove(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setApprover")) {
					method.invoke(obj, "");
				} else if (method.getName().equals("setApprovetime")) {
					method.invoke(obj, "");
				} else if (method.getName().equals("setVbillstatus")) {
					method.invoke(obj, BillStatus.FREE);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void beforeDelete(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setDr")) {
					method.invoke(obj, MMNCUtils.getDR(1));
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param class1
	 * @param hvo
	 * @param paramVO
	 */
	public static void beforeRevise(Class<?> clazz, Object obj, IUParamVO paramVO) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setReviser")) {
					method.invoke(obj, paramVO.getCuserid());
				} else if (method.getName().equals("setRevisetime")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param class1
	 * @param hvo
	 * @param paramVO
	 */
	public static void beforeRevise(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param class1
	 * @param hvo
	 * @param paramVO
	 */
	public static void beforeBodyRevise(Class<?> clazz, Object obj) {
		Method[] methods = clazz.getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().equals("setTs")) {
					method.invoke(obj, MMNCUtils.getNowTime());
				} else if (method.getName().equals("setIssync")) {
					method.invoke(obj, (short) 0);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
