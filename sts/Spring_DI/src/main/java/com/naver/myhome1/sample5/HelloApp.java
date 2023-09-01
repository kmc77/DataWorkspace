package com.naver.myhome1.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp {

	public static void main(String[] args) {
		/*
		 Spring �����̳� ���� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ���
		 GenericXmlApplicationContext ��ü�� �����Ǿ� ������ �����̳ʰ� �����մϴ�.
		 ������ �����̳ʴ� applicationContext.xml �� ������� ���� �����մϴ�.
		 
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample5/applicationContext.xml");
		//Object getBean(String name) :
		//argument �� ������ �̸��� bean �ν��Ͻ��� ��ȯ�մϴ�.
		//applicationContext.xml ���� id�� "m3"�� bean�� �����ɴϴ�.
		
		System.out.println("==================gitBean() �� ===================");
		
		MessageBean bean = (MessageBean) ctx.getBean("m3");
		
		bean.sayHello();
		
		ctx.close();
		
	}

}