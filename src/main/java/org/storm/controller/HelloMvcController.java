package org.storm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//����DispatcherServlet��ص������� ����һ��Controller�� ���������beanŶ
@Controller
//�༶���RequestMapping������DispatcherServlet������ฺ�����Ը�URL��
//HandlerMapping���������ǩ������
@RequestMapping("")
public class HelloMvcController {
	
	//���������RequestMapping�� ���Ʋ���С��URL·��ƥ�䣬ͬ�༶��ı�ǩЭͬ����������ȷ�����ص���URL���Ǹ���������
	@RequestMapping("/home")
	public String helloMvc() {
		
		//��ͼ��Ⱦ��/WEB-INF/jsps/home.jsp
		return "";
	}

}