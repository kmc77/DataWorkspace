package com.naver.myhome2.sample1;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}
	
	public MessageBeanEn() {
		System.out.println("이곳은 MessageBeanEn 생성자입니다.");

	}

	@Override
	public void destroyMethod() {
		System.out.println("MessageBeanEn의 destroyMethod()입니다.");
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}
