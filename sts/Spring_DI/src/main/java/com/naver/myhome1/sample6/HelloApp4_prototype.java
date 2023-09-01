package com.naver.myhome1.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp4_prototype {

	public static void main(String[] args) {
		/*
		 Spring �����̳� ���� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ���
		 GenericXmlApplicationContext ��ü�� �����Ǿ� ������ �����̳ʰ� �����մϴ�.
		 ������ �����̳ʴ� applicationContext.xml �� ������� ���� �����մϴ�.
		 
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample6/collectionBean.xml");

		MessageBean bean1 = (MessageBean) ctx.getBean("collectionBean");
		ctx.close();

	}

}