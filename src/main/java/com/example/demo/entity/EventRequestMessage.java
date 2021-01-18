package com.example.demo.entity;

import java.io.Serializable;

/**
 * @ClassName: EventRequestMessage   
 * @Description: TODO 事件消息模板入侵类
 * @author 杨文
 * @version 1.0 
 * @date 2020年3月16日 下午12:41:31
 */
public  final class EventRequestMessage implements Serializable{

	/**
	 * @Description: TODO(描述funcion功能)
	 * author 杨文
	 * @date 2020年3月16日 下午12:35:35 
	 * @version 1.0   
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 事件,appointment:预约，scheduling：排班
	 */
	private String event;
	/**
	 * 内容 JSON
	 */
	private String content;
	/**
	 * 时间
	 */
	private int createTime;

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
