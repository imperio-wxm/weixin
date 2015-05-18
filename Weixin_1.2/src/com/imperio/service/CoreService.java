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
 * 核心服务类 
 * @author wxm-Imperio
 *
 */
public class CoreService {  
    /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  	
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            
System.out.println("fromUserName:" + fromUserName);

            // 公众帐号  
            String toUserName = requestMap.get("ToUserName"); 
            
System.out.println("toUserName:" + toUserName);

            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            	//获取用户输入的文字内容
                String content = requestMap.get("Content");  
      
                if("?".equals(content) || "？".equals(content) || "help".equals(content) || "HELP".equals(content)) {
                	respMessage = MessageService.initText(toUserName,fromUserName,MessageService.menuMessage()); 
                } else {
                	respMessage = MessageService.initText(toUserName,fromUserName,"您输入的编号有误，请重新输入!"); 
                }
            } 
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 

            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";
            	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                	//输出主菜单
                	respMessage = NewsMessageService.createNewsMessage(fromUserName, toUserName); 
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	 // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");  
  
                    if (eventKey.equals("btnHomePage")) {  
                        respContent = "您点击的是首页信息！";
                    	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnProducts")) {  
                    	respContent = "您点击的是产品信息！";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnCase")) {  
                    	respContent = "您点击的是案例信息！";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnIntroductionDevelopment")) {  
                    	respContent = "您点击的是公司介绍与发展！";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent);  
                    } else if (eventKey.equals("btnCultureHonor")) {  
                    	respContent = "您点击的是企业文化与荣誉！";
                      	respMessage = MessageService.initText(toUserName,fromUserName,respContent); 
                    } else if (eventKey.equals("btnContactUs")) {  
                    	respContent = "您点击的是联系我们！";
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
