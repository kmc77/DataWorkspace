package com.naver.myhome2.sample1;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}
	
	public MessageBeanEn() {
		System.out.println("�̰��� MessageBeanEn �������Դϴ�.");

	}

	@Override
	public void destroyMethod() {
		System.out.println("MessageBeanEn�� destroyMethod()�Դϴ�.");
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}