package com.imperio.main;

import com.imperio.menu.pojo.AccessToken;
import com.imperio.menu.pojo.Button;
import com.imperio.menu.pojo.ClickButton;
import com.imperio.menu.pojo.ComplexButton;
import com.imperio.menu.pojo.Menu;
import com.imperio.menu.pojo.ViewButton;
import com.imperio.util.WeixinUtil;  

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
/**
 *  菜单管理器类   
 * @author Administrator
 *
 */
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public static void main(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "wxf4ae77f836af1dea";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "9d4941961d64dc2e461db3beed3faa08";  
        System.out.println("这是主菜单调用函数");
  
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // 调用接口创建菜单  
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
  
            // 判断菜单创建结果  
            if (0 == result) {
                log.info("菜单创建成功！"); 
            	System.out.println("菜单创建成功");
            }
            else { 
                log.info("菜单创建失败，错误码：" + result);
                System.out.println("菜单创建失败");
            }
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
    	
    	/**
    	 * 子菜单
    	 */
        ClickButton btnProducts = new ClickButton();  
        btnProducts.setName("产品中心");  
        btnProducts.setType("click");  
        btnProducts.setKey("btnProducts");  
        
        ClickButton btnCase = new ClickButton();  
        btnCase.setName("工程案例");  
        btnCase.setType("click");  
        btnCase.setKey("btnCase");  
        
        ClickButton btnIntroductionDevelopment = new ClickButton();  
        btnIntroductionDevelopment.setName("公司介绍与发展");  
        btnIntroductionDevelopment.setType("click");  
        btnIntroductionDevelopment.setKey("btnIntroductionDevelopment");  
        
        ClickButton btnCultureHonor = new ClickButton();  
        btnCultureHonor.setName("企业文化与荣誉");  
        btnCultureHonor.setType("click");  
        btnCultureHonor.setKey("btnCultureHonor");  
        
        ViewButton btnContactUs = new ViewButton();  
        btnContactUs.setName("联系我们");  
        btnContactUs.setType("view");  
        btnContactUs.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205463973&idx=1&sn=d07db82a2b8639e43885319c4b6e4d80#rd");
  
        
        /**
         * 父级菜单
         */
        ViewButton btnHomePage = new ViewButton();  
        btnHomePage.setName("首页");  
        btnHomePage.setType("view");  
        btnHomePage.setUrl("http://www.wisebond.net/default.aspx");  
  
        ComplexButton btnProductsCase = new ComplexButton();  
        btnProductsCase.setName("产品与案例");  
        btnProductsCase.setSub_button(new Button[] { btnProducts,btnCase});  
  
        ComplexButton btnAboutUs = new ComplexButton();  
        btnAboutUs.setName("关于我们");  
        btnAboutUs.setSub_button(new Button[] { btnIntroductionDevelopment,btnCultureHonor,btnContactUs});  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { btnHomePage, btnProductsCase, btnAboutUs });  
  
        return menu;  
    }  
}  
