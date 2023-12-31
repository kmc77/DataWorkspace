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
		System.out.println("이곳은 MessageBeanEn 생성자입니다.");

	}

	@PreDestroy //destroy-method = "destroyMethod"에 해당하는 annotation
	public void destroyMethod() {
		System.out.println("MessageBeanEn의 destroyMethod()입니다.");
	}

}
