package com.imperio.menu.pojo;

/**
 * ���Ӱ�ť������ť��
 * �Ը��˵���Ķ��壺�����ж����˵����һ���˵���
 * ����˵�������ж������ԣ�name��sub_button����sub_button����һ���Ӳ˵������� 
 * @author wxm-Imperio
 *
 */
public class ComplexButton extends Button {  
	//���˵����Ӳ˵������飬������װ�Ӳ˵�
    private Button[] sub_button;  
  
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}  
