package com.imperio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imperio.message.resp.Article;
import com.imperio.message.resp.NewsMessage;
import com.imperio.util.MessageUtil;

public class NewsMessageService {

    /**
	 * ��ʼ��ͼ����Ϣ
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
    public static String initNewsMessage(String toUserName,String fromUserName) {
    	// ����ͼ����Ϣ  
        NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setToUserName(fromUserName);  
        newsMessage.setFromUserName(toUserName);  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0); 
        
        //���ɶ�ͼ�������б�
        List<Article> articleList = singleNewsMessage();
        newsMessage.setArticleCount(articleList.size());  
        newsMessage.setArticles(articleList); 
        return MessageUtil.newsMessageToXml(newsMessage);
    }
    
    /**
     * ��ͼ�������б�
     * @return
     */ 
    public static List<Article> multiNewsMessage() {
    	
    	List<Article> articleList = new ArrayList<Article>();  
        
        Article article1 = new Article();  
        article1.setTitle("W-NGϵ�г���NOXȼ��ȼ����");  
        article1.setDescription("");  
        article1.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/f28bc70dd5874df98f26d59f21cf0145.jpg");  
        article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205404259&idx=1&sn=c7121d71e3568426e0181aa4cc4f6777#rd");  

        Article article2 = new Article();  
        article2.setTitle("W-HOMϵ�н���������ȼ����");  
        article2.setDescription("");  
        article2.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/3cbdc3707aba41c2b3862c884d9102ce.jpg");  
        article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205404259&idx=2&sn=6c893a3153ca0a7fd31a985425e77812#rd");  

        Article article3 = new Article();  
        article3.setTitle("W-HOPϵ��ѹ��������ȼ����");  
        article3.setDescription("");  
        article3.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/3f9c36b4f86040329e080a9aef85f4c0.jpg");  
        article3.setUrl("http://www.wisebond.net/product-154.aspx");  
        
        Article article4 = new Article();  
        article4.setTitle("W-LOMϵ�н���������ȼ����");  
        article4.setDescription("");  
        article4.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/3bb2a618cfd44811baf3dc8260b73dec.jpg");  
        article4.setUrl("http://www.wisebond.net/product-153.aspx"); 
        
        Article article5 = new Article();  
        article5.setTitle("W-LOPϵ��ѹ��������ȼ����");  
        article5.setDescription("");  
        article5.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/6e2491359827464e824885de7580ee22.jpg");  
        article5.setUrl("http://www.wisebond.net/product-152.aspx"); 
        
        Article article6 = new Article();  
        article6.setTitle("��ϵ����");  
        article6.setDescription("");  
        article6.setPicUrl("http://mmbiz.qpic.cn/mmbiz/AF4uW8In2NOkQrN061W4k3vhSBUibNlN163hPDXmEHfibjk05jYPNeoLt2ETYQvx68W5OxNGbLOhmwiaVNwZVBNqw/640?wx_fmt=jpeg&tp=webp&wxfrom=5");  
        article6.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205463973&idx=1&sn=d07db82a2b8639e43885319c4b6e4d80#rd");

        articleList.add(article1);  
        articleList.add(article2);  
        articleList.add(article3);  
        articleList.add(article4); 
        articleList.add(article5); 
        articleList.add(article6); 
        return articleList;
    }
    
    /**
     * ����ͼ����Ϣ
     * @param fromUserName
     * @param toUserName
     * @return
     */
    public static String createNewsMessage(String fromUserName, String toUserName) {
    	// ����ͼ����Ϣ    	        
    	return NewsMessageService.initNewsMessage(toUserName, fromUserName);
    }
    
    /**
     * ��ͼ����Ϣ
     */
    public static List<Article> singleNewsMessage() {
    	 List<Article> articleList = new ArrayList<Article>(); 
    	 Article article = new Article();  
         article.setTitle("��ӭ����'��֮��'΢�Ź��ں�");  
         article.setDescription("��'��֮��'���塿��ֲ���� ����δ��\n����ҵ�Ļ��������޽� ����Ϊ��\n����Ӫģʽ�����ȼ�ա����ܼ��ż����������ܽ������\n����˾��ּ�������ŷ� ���Զ��� ������Ӧ\n����˾�����ȼ���豸Ϊ֧�� �Լ���ҵ��Ϊǣ�� ��ϵͳ����Ϊ����"
        		 			+ "\n\n����ܰ��ʾ��\n��ҳ���Ͻǡ�����ͼ�꡿���ڵ���" 
        		 			+ "\n�ظ�?����Help���������˵�");  
         article.setPicUrl("http://i1.tietuku.com/3ff910c3901ffc1f.png");  
         article.setUrl("http://weixin-for-web.coding.io/");  
         articleList.add(article);  
         return articleList;
    }
}
