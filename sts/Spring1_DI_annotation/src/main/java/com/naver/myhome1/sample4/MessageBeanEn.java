package com.naver.myhome1.sample4;

import org.springframework.stereotype.Component;

@Component("m")
public class MessageBeanEn implements MessageBean {

	public MessageBeanEn() {
		System.out.println("�̰��� MessageBeanEn �������Դϴ�.");

	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}

}
