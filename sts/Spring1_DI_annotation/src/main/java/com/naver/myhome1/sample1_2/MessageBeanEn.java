package com.naver.myhome1.sample1_2;

public class MessageBeanEn implements MessageBean {
	
	public MessageBeanEn() {
		System.out.println("�̰��� MessageBeanEn �������Դϴ�.");

	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}