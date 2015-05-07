package com.imperio.menu.pojo;

/**
 * 菜单 
 * 最后是整个菜单对象的封装，菜单对象包含多个菜单项（最多只能有3个）
 * 这些菜单项即可以是子菜单项（不含二级菜单的一级菜单），也可以是父菜单项（包含二级菜单的菜单项）  
 * @author wxm-Imperio
 *
 */
public class Menu {
	//对于菜单的封装，最多可以封装3个
	//类型分为两类
	//1.不含子菜单的父菜单；2.含子菜单的父菜单
    private Button[] button;  
  
    public Button[] getButton() {  
        return button;  
    }  
  
    public void setButton(Button[] button) {  
        this.button = button;  
    }  
}  
