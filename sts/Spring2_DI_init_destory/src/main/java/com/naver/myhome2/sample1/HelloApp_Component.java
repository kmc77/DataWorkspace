/*
  1. MessageBeanImpl.java����   @Component ����� ����
     - Spring �����̳ʰ� component-scan�� ���ؼ�
              �ڵ����� bean ����� ������� �����˴ϴ�.
     - �̶� bean�� �̸��� ������ �� �ִµ� �����  @Component("���� �̸�")�ϸ� �˴ϴ�.
     - �̸��� ������� ������ ������ Ŭ������ �̸����� ù���ڸ� �ҹ��ڷ� �ٲ� �̸����� 
       bean�� �����˴ϴ�.
*/
package com.naver.myhome2.sample1;

import org.springframework.context.support.GenericXmlApplicationContext;
public class HelloApp_Component {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
                  new GenericXmlApplicationContext("com/naver/myhome2/sample1/applicationContext.xml");
		//2. Object getBean(String name) :
		//			argument�� ������ �̸��� bean �ν��Ͻ��� ��ȯ�մϴ�.
		//	Spring �����̳ʷκ��� ���� ���̵� "m2"�� bean�� �����ɴϴ�.
		MessageMultiple bean = (MessageMultiple)ctx.getBean("m2"); 
		
		//3. �޼��� �����մϴ�.
		bean.print();
		
		System.out.println("ctx.close() ȣ�� ���Դϴ�.");
		
		//4. Spring �����̳ʸ� �����մϴ�.
		ctx.close();
		
		System.out.println("ctx.close() ȣ�� ���Դϴ�.");
	}
}






