package com.naver.myhome1.sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp4_prototype {

	public static void main(String[] args) {
		/*
		 Spring �����̳� ���� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ���
		 GenericXmlApplicationContext ��ü�� �����Ǿ� ������ �����̳ʰ� �����մϴ�.
		 ������ �����̳ʴ� applicationContext.xml �� ������� ���� �����մϴ�.
		 
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample3/applicationContext2.xml");

		MessageBean bean1 = (MessageBean) ctx.getBean("m");
		MessageBean bean2 = (MessageBean) ctx.getBean("m");
		MessageBean bean3 = (MessageBean) ctx.getBean("m");
		MessageBean bean4 = (MessageBean) ctx.getBean("m");
		ctx.close();

	}

}