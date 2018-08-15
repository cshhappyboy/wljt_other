package com.pub.model;

import java.util.List;
import java.util.Map;
/**
 * 资源树
 * <br>名称: com.javaboy.model.JsonTreeData<br>
 * by：javaboy<br>
 * e-mail:javaboyok@163.com<br>
 * @author 张佳宾
 * @date 2017年5月22日
 */
public class JsonTreeData {
 
    public String id;       //json id
    public String pid;      //
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public List<JsonTreeData> children;       //
    public Map<String, String> attributes;
     
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public List<JsonTreeData> getChildren() {
        return children;
    }
    public void setChildren(List<JsonTreeData> children) {
        this.children = children;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
    
}