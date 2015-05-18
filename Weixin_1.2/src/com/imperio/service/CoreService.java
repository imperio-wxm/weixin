package com.imperio.service;

import java.util.ArrayList;
import java.util.Date;  
import java.util.List;
import java.util.Map;  

import javax.servlet.http.HttpServletRequest;  
import javax.swing.plaf.multi.MultiButtonUI;

import com.imperio.message.resp.Article;
import com.imperio.message.resp.NewsMessage;
import com.imperio.message.resp.TextMessage;  
import com.imperio.util.MessageUtil;  
  
/**
 * ���ķ����� 
 * @author wxm-Imperio
 *
 */
public class CoreService {  
    /** 
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  	
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // Ĭ�Ϸ��ص��ı���Ϣ����  
            String respContent = "�������쳣�����Ժ��ԣ�";  
  
            // xml�������  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            
System.out.println("fromUserName:" + fromUserName);

            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName"); 
            
System.out.println("toUserName:" + toUserName);

            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
  
            
            // �ı���Ϣ  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            	//��ȡ�û��������������
                String content = requestMap.get("Content");  
      
                if("?".equals(content) || "��".equals(content) || "help".equals(content) || "HELP".equals(content)) {
                	respMessage = MessageService.initText(toUserName,fromUserName,MessageService.menuMessage()); 
                } else {
                	respMessage = MessageService.initText(toUserName,fromUserName,"������ı����������������!"); 
                }
            } 
            // ͼƬ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "�����͵���ͼƬ��Ϣ��";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 

            }  
            // ����λ����Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "�����͵��ǵ���λ����Ϣ��";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // ������Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "�����͵���������Ϣ��";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "�����͵�����Ƶ��Ϣ��";
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // �¼�����  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                	//������˵�
                	respMessage = NewsMessageService.createNewsMessage(fromUserName, toUserName); 
                }  
                // ȡ������  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	 // �¼�KEYֵ���봴���Զ���˵�ʱָ����KEYֵ��Ӧ  
                    String eventKey = requestMap.get("EventKey");  
  
                    if (eventKey.equals("btnHomePage")) {  
                        respContent = "�����������ҳ��Ϣ��";
                    	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnProducts")) {  
                    	respContent = "��������ǲ�Ʒ��Ϣ��";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnCase")) {  
                    	respContent = "��������ǰ�����Ϣ��";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnIntroductionDevelopment")) {  
                    	respContent = "��������ǹ�˾�����뷢չ��";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent);  
                    } else if (eventKey.equals("btnCultureHonor")) {  
                    	respContent = "�����������ҵ�Ļ���������";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnContactUs")) {  
                    	respContent = "�����������ϵ���ǣ�";
                    	respMessage = MessageService.initText(toUserName,fromUserName,respContent);
                    } 
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return respMessage;  
    }    
}
