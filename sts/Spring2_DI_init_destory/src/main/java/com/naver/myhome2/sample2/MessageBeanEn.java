package com.naver.myhome2.sample2;

import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;

@Component("m")
public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}

	public MessageBeanEn() {
		System.out.println("�̰��� MessageBeanEn �������Դϴ�.");

	}

	@PreDestroy //destroy-method = "destroyMethod"�� �ش��ϴ� annotation
	public void destroyMethod() {
		System.out.println("MessageBeanEn�� destroyMethod()�Դϴ�.");
	}

}