package com.fgc.controller.bd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *   未来离线需求
 */
@Controller
@RequestMapping("/pub")
public class BDPageController {
	
	/**
	 * 弹出参照界面
	 * 
	 * @return String
	 */
	@RequestMapping("/refPage")
	public String showPubRefPage() {
		return "bd/pubRef";
	}
	
	/**
	 * 弹出树形参照界面
	 */
	@RequestMapping("/refTreePage")
	public String showRefTreePage(){
		return "bd/refTreePage";
	}
	/**
	 * 弹出树表参照界面
	 */
	@RequestMapping("/refTreeTablePage")
	public String showRefTreeTablePage(){
		return "bd/refTreeTablePage";
	}
	
	/**
	 * 弹出表体参照界面
	 */
	@RequestMapping("/bodyPubRefPage")
	public String showBodyPubRefPage(){
		return "bd/bodyPubRef";
	}
	
}
