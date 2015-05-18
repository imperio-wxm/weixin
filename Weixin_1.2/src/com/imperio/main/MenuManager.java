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
        ViewButton btnProducts = new ViewButton();  
        btnProducts.setName("产品中心");  
        btnProducts.setType("view");  
        btnProducts.setUrl("http://weixin-for-web.coding.io/?p=241");  
        
        ViewButton btnCase = new ViewButton();  
        btnCase.setName("工程案例");  
        btnCase.setType("view");  
        btnCase.setUrl("http://weixin-for-web.coding.io/category/cases/engineeringservices/");
        
        ViewButton btnPatents = new ViewButton();  
        btnPatents.setName("相关专利");  
        btnPatents.setType("view");  
        btnPatents.setUrl("http://weixin-for-web.coding.io/?p=332"); 
        
        ViewButton btnAboutUs = new ViewButton();  
        btnAboutUs.setName("关于我们");  
        btnAboutUs.setType("view");  
        btnAboutUs.setUrl("http://weixin-for-web.coding.io/?p=189");
        
        ViewButton btnContactUs = new ViewButton();  
        btnContactUs.setName("联系我们");  
        btnContactUs.setType("view");  
        btnContactUs.setUrl("http://weixin-for-web.coding.io/?p=444");
  
        
        /**
         * 父级菜单
         */
        ViewButton btnHomePage = new ViewButton();  
        btnHomePage.setName("首页");  
        btnHomePage.setType("view");  
        btnHomePage.setUrl("http://weixin-for-web.coding.io/");  
  
        ComplexButton btnProductsCase = new ComplexButton();  
        btnProductsCase.setName("产品与案例");  
        btnProductsCase.setSub_button(new Button[] { btnProducts,btnCase});  
  
        ComplexButton btnKnowUs = new ComplexButton();  
        btnKnowUs.setName("了解我们");  
        btnKnowUs.setSub_button(new Button[] { btnPatents,btnAboutUs,btnContactUs});  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { btnHomePage, btnProductsCase, btnKnowUs });  
  
        return menu;  
    }  
}  
