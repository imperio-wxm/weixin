package com.imperio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imperio.message.resp.Article;
import com.imperio.message.resp.NewsMessage;
import com.imperio.util.MessageUtil;

public class NewsMessageService {

    /**
	 * 初始化图文信息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
    public static String initNewsMessage(String toUserName,String fromUserName) {
    	// 创建图文消息  
        NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setToUserName(fromUserName);  
        newsMessage.setFromUserName(toUserName);  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0); 
        
        //生成多图文文章列表
        List<Article> articleList = multiNewsMessage();
        newsMessage.setArticleCount(articleList.size());  
        newsMessage.setArticles(articleList); 
        return MessageUtil.newsMessageToXml(newsMessage);
    }
    
    /**
     * 多图文文章列表
     * @return
     */ 
    public static List<Article> multiNewsMessage() {
    	
    	List<Article> articleList = new ArrayList<Article>();  
        
        Article article1 = new Article();  
        article1.setTitle("超低NOx燃烧器");  
        article1.setDescription("");  
        article1.setPicUrl("http://www.wisebond.net/userfiles/images/chanpinzhongxin/f28bc70dd5874df98f26d59f21cf0145.jpg");  
        article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205594622&idx=1&sn=887be85eee3d1a49861628da4cf7bba5#rd");  

        Article article2 = new Article();  
        article2.setTitle("专用燃烧器");  
        article2.setDescription("");  
        article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/AF4uW8In2NP4jXztsecBiaUGsuBtqRyqtf6pvCpoVK19IwCLric6K5pMXZj3om6SyYTnWsFaCNY2B6oRHhTHL4YQ/0?wx_fmt=jpeg&tp=webp&wxfrom=5");  
        article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205594622&idx=2&sn=1c9fce87c00abf8b0efd7a5f7f9e6b39#rd");  

        Article article3 = new Article();  
        article3.setTitle("线性管道燃烧器");  
        article3.setDescription("");  
        article3.setPicUrl("http://mmbiz.qpic.cn/mmbiz/AF4uW8In2NP4jXztsecBiaUGsuBtqRyqts3Q2aFjwT1J4xc8UPl5PPmP0gUk9QEvqZeZGkLvyR5Cq26yQ7uTFlg/0?wx_fmt=jpeg&tp=webp&wxfrom=5");  
        article3.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205594622&idx=3&sn=0fdbc2f31e68be1a7359296e144ab99e#rd");  
        
        Article article4 = new Article();  
        article4.setTitle("工艺燃烧产品");  
        article4.setDescription("");  
        article4.setPicUrl("http://mmbiz.qpic.cn/mmbiz/AF4uW8In2NP4jXztsecBiaUGsuBtqRyqtTMKHh3xrZ8xuUG5z1V5a6gmticqNG9BibdCicfTkY3YYoatYaZM9nJ85A/0?wx_fmt=jpeg&tp=webp&wxfrom=5");  
        article4.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205594622&idx=4&sn=89c40d106b2f6a8caa74744a0c17972c#rd"); 
        
        Article article5 = new Article();  
        article5.setTitle("电站锅炉低氮改造");  
        article5.setDescription("");  
        article5.setPicUrl("http://mmbiz.qpic.cn/mmbiz/AF4uW8In2NP4jXztsecBiaUGsuBtqRyqtQDco0x0gjaWx8v9RYnSAiboofE1SvMMKLSxetJE5qjEr43qFmaeryKw/0?wx_fmt=jpeg&tp=webp&wxfrom=5");  
        article5.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205594622&idx=5&sn=6071c7195fc3928c2a6f79d5d989463e#rd"); 
        

        articleList.add(article1);  
        articleList.add(article2);  
        articleList.add(article3);  
        articleList.add(article4); 
        articleList.add(article5);  
        return articleList;
    }
    
    /**
     * 创建图文消息
     * @param fromUserName
     * @param toUserName
     * @return
     */
    public static String createNewsMessage(String fromUserName, String toUserName) {
    	// 创建图文消息    	        
    	return NewsMessageService.initNewsMessage(toUserName, fromUserName);
    }
}
