package com.naver.myhome1.sample2;

public class MessageBeanKo implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}

	public MessageBeanKo() {
		System.out.println("이곳은 MessageBeanKo 생성자입니다.");

	}

}
