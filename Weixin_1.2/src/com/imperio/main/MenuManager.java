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
 *  �˵���������   
 * @author Administrator
 *
 */
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public static void main(String[] args) {  
        // �������û�Ψһƾ֤  
        String appId = "wxf4ae77f836af1dea";  
        // �������û�Ψһƾ֤��Կ  
        String appSecret = "9d4941961d64dc2e461db3beed3faa08";  
        System.out.println("�������˵����ú���");
  
        // ���ýӿڻ�ȡaccess_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // ���ýӿڴ����˵�  
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
  
            // �жϲ˵��������  
            if (0 == result) {
                log.info("�˵������ɹ���"); 
            	System.out.println("�˵������ɹ�");
            }
            else { 
                log.info("�˵�����ʧ�ܣ������룺" + result);
                System.out.println("�˵�����ʧ��");
            }
        }  
    }  
  
    /** 
     * ��װ�˵����� 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
    	
    	/**
    	 * �Ӳ˵�
    	 */
        ClickButton btnProducts = new ClickButton();  
        btnProducts.setName("��Ʒ����");  
        btnProducts.setType("click");  
        btnProducts.setKey("btnProducts");  
        
        ClickButton btnCase = new ClickButton();  
        btnCase.setName("���̰���");  
        btnCase.setType("click");  
        btnCase.setKey("btnCase");  
        
        ClickButton btnIntroductionDevelopment = new ClickButton();  
        btnIntroductionDevelopment.setName("��˾�����뷢չ");  
        btnIntroductionDevelopment.setType("click");  
        btnIntroductionDevelopment.setKey("btnIntroductionDevelopment");  
        
        ClickButton btnCultureHonor = new ClickButton();  
        btnCultureHonor.setName("��ҵ�Ļ�������");  
        btnCultureHonor.setType("click");  
        btnCultureHonor.setKey("btnCultureHonor");  
        
        ViewButton btnContactUs = new ViewButton();  
        btnContactUs.setName("��ϵ����");  
        btnContactUs.setType("view");  
        btnContactUs.setUrl("http://mp.weixin.qq.com/s?__biz=MzAwNzUxNzM3Nw==&mid=205463973&idx=1&sn=d07db82a2b8639e43885319c4b6e4d80#rd");
  
        
        /**
         * �����˵�
         */
        ViewButton btnHomePage = new ViewButton();  
        btnHomePage.setName("��ҳ");  
        btnHomePage.setType("view");  
        btnHomePage.setUrl("http://www.wisebond.net/default.aspx");  
  
        ComplexButton btnProductsCase = new ComplexButton();  
        btnProductsCase.setName("��Ʒ�밸��");  
        btnProductsCase.setSub_button(new Button[] { btnProducts,btnCase});  
  
        ComplexButton btnAboutUs = new ComplexButton();  
        btnAboutUs.setName("��������");  
        btnAboutUs.setSub_button(new Button[] { btnIntroductionDevelopment,btnCultureHonor,btnContactUs});  
  
        /** 
         * ���ǹ��ں�xiaoqrobotĿǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br> 
         *  
         * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br> 
         * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { btnHomePage, btnProductsCase, btnAboutUs });  
  
        return menu;  
    }  
}  
