package com.imperio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imperio.message.resp.TextMessage;
import com.imperio.service.CoreService;
import com.imperio.util.CheckUtil;
import com.imperio.util.MessageUtil;

/**
 * ������������
 * @author wxm-Imperio
 *
 */
public class WeixinServlet extends HttpServlet {
	//private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * ȷ����������΢�ŷ�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * ����΢�ŷ�������������Ϣ
	 */
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        // ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
	        request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
	  
	        // ���ú���ҵ���������Ϣ��������Ϣ  
	        String respMessage = CoreService.processRequest(request);  
	          
	        // ��Ӧ��Ϣ  
	        PrintWriter out = response.getWriter();  
	        out.print(respMessage);  
	        out.close();  
	 }  
}
