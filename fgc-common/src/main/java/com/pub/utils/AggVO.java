package com.pub.utils;

/**
 * 聚合VO
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 */
public class AggVO<H, B> {

	private H headVO;

	private B[] bodyVOs;

	/**
	 * @return the headVO
	 */
	public H getHeadVO() {
		return headVO;
	}

	/**
	 * @param headVO
	 *            the headVO to set
	 */
	public void setHeadVO(H headVO) {
		this.headVO = headVO;
	}

	/**
	 * @return the bodyVOs
	 */
	public B[] getBodyVOs() {
		return bodyVOs;
	}

	/**
	 * @param bodyVOs
	 *            the bodyVOs to set
	 */
	public void setBodyVOs(B[] bodyVOs) {
		this.bodyVOs = bodyVOs;
	}
}
