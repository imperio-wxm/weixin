package com.imperio.service;

import java.util.Date;

import com.imperio.message.resp.NewsMessage;
import com.imperio.message.resp.TextMessage;
import com.imperio.util.MessageUtil;

public class MessageService {
	
	/**
	 * ��ʼ�����ı���Ϣ
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
    public static String initText(String toUserName,String fromUserName,String content) {
    	//�����ı���Ϣ������лظ�
		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setContent(content);
		return MessageUtil.textMessageToXml(textMessage);
    }
    /**
     * �������˵�
     */
    public static String menuMessage() {
    	//ƴ���ַ���
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("��ӭ���Ĺ�ע!\n�밴�ղ˵���ʾ���в�����\n");
    	sbBuffer.append("1.��Ʒ���� \n");
    	sbBuffer.append("2.�������� \n\n");
    	sbBuffer.append("�ظ�help[?]�����˵�.");
    	return sbBuffer.toString();  	
    }
    
    /**
     * ��Ʒ������˵�
     */
    public static String projectMainMenu() {
    	//ƴ���ַ���
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("�ظ���Ž��в�Ʒ�鿴��\n\n");
    	sbBuffer.append("01.������NOxȼ����\n");
    	sbBuffer.append("02.��ר��ȼ����\n");
    	sbBuffer.append("03.�����͹ܵ�ȼ����\n");
    	sbBuffer.append("04.������ȼ�ղ�Ʒ\n");
    	sbBuffer.append("05.����վ��¯�͵�����\n");
    	sbBuffer.append("06.�������������������\n");
    	sbBuffer.append("07.����Ʒ���\n");
    	return sbBuffer.toString();  	
    }
    
    /**
     * �ȵ����Ͳ˵�
     */
    public static String secoundMenuMessage() {
    	//ƴ���ַ���
    	StringBuffer sbBuffer = new StringBuffer();
    	sbBuffer.append("�����ȵ����Ͳ˵�\n");
    	return sbBuffer.toString();  	
    }
}
