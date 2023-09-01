package com.naver.myhome1.sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp2 {

	public static void main(String[] args) {
		/*
		 Spring �����̳� ���� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ���
		 GenericXmlApplicationContext ��ü�� �����Ǿ� ������ �����̳ʰ� �����մϴ�.
		 ������ �����̳ʴ� applicationContext.xml �� ������� ���� �����մϴ�.
		 
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample3/applicationContext.xml");

		System.out.println("getBean() ȣ�� ��");
		
		//�����̳ʰ� ������ ��ü(��)�� �˻�(Lookup)�Ͽ� ����ϴ� ����� Dependency Lookup�̶�� �մϴ�.
		MessageBean bean = (MessageBean) ctx.getBean("m");
		
		MessageBean bean2 = (MessageBean) ctx.getBean("m1");
		
		System.out.println("getBean() ȣ�� ��");
		
		bean.sayHello("Sprion");
		bean2.sayHello("�����ӿ�ũ");
		
		
		//Sprion �����̳� ����
		ctx.close();

	}

}