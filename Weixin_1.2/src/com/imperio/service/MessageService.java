package com.imperio.service;

import java.util.Date;

import com.imperio.message.resp.NewsMessage;
import com.imperio.message.resp.TextMessage;
import com.imperio.util.MessageUtil;

public class MessageService {
	
	/**
	 * 初始化纯文本信息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
    public static String initText(String toUserName,String fromUserName,String content) {
    	//创建文本消息对象进行回复
		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setContent(content);
		return MessageUtil.textMessageToXml(textMessage);
    }
    /**
     * 文字主菜单
     */
    public static String menuMessage() {
    	//拼接字符串
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("欢迎您的关注!\n请按照菜单提示进行操作：\n");
    	sbBuffer.append("1.产品中心 \n");
    	sbBuffer.append("2.关于我们 \n\n");
    	sbBuffer.append("回复help[?]调出菜单.");
    	return sbBuffer.toString();  	
    }
    
    /**
     * 产品主分类菜单
     */
    public static String projectMainMenu() {
    	//拼接字符串
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("回复序号进行产品查看：\n\n");
    	sbBuffer.append("01.：超低NOx燃烧器\n");
    	sbBuffer.append("02.：专用燃烧器\n");
    	sbBuffer.append("03.：线型管道燃烧器\n");
    	sbBuffer.append("04.：工艺燃烧产品\n");
    	sbBuffer.append("05.：电站锅炉低氮改造\n");
    	sbBuffer.append("06.：脱硝脱硫与除尘技术\n");
    	sbBuffer.append("07.：产品配件\n");
    	return sbBuffer.toString();  	
    }
    
    /**
     * 热点推送菜单
     */
    public static String secoundMenuMessage() {
    	//拼接字符串
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("这是热点推送菜单\n");
    	return sbBuffer.toString();  	
    }
}
