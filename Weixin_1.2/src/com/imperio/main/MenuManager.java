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
        ViewButton btnProducts = new ViewButton();  
        btnProducts.setName("��Ʒ����");  
        btnProducts.setType("view");  
        btnProducts.setUrl("http://weixin-for-web.coding.io/?p=241");  
        
        ViewButton btnCase = new ViewButton();  
        btnCase.setName("���̰���");  
        btnCase.setType("view");  
        btnCase.setUrl("http://weixin-for-web.coding.io/category/cases/engineeringservices/");
        
        ViewButton btnPatents = new ViewButton();  
        btnPatents.setName("���ר��");  
        btnPatents.setType("view");  
        btnPatents.setUrl("http://weixin-for-web.coding.io/?p=332"); 
        
        ViewButton btnAboutUs = new ViewButton();  
        btnAboutUs.setName("��������");  
        btnAboutUs.setType("view");  
        btnAboutUs.setUrl("http://weixin-for-web.coding.io/?p=189");
        
        ViewButton btnContactUs = new ViewButton();  
        btnContactUs.setName("��ϵ����");  
        btnContactUs.setType("view");  
        btnContactUs.setUrl("http://weixin-for-web.coding.io/?p=444");
  
        
        /**
         * �����˵�
         */
        ViewButton btnHomePage = new ViewButton();  
        btnHomePage.setName("��ҳ");  
        btnHomePage.setType("view");  
        btnHomePage.setUrl("http://weixin-for-web.coding.io/");  
  
        ComplexButton btnProductsCase = new ComplexButton();  
        btnProductsCase.setName("��Ʒ�밸��");  
        btnProductsCase.setSub_button(new Button[] { btnProducts,btnCase});  
  
        ComplexButton btnKnowUs = new ComplexButton();  
        btnKnowUs.setName("�˽�����");  
        btnKnowUs.setSub_button(new Button[] { btnPatents,btnAboutUs,btnContactUs});  
  
        /** 
         * ���ǹ��ں�xiaoqrobotĿǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br> 
         *  
         * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br> 
         * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { btnHomePage, btnProductsCase, btnKnowUs });  
  
        return menu;  
    }  
}  
