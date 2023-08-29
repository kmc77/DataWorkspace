package com.naver.myhome1.sample6;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("m3")

public class MessageBeanImpl implements MessageBean {
	
	/*
	 Spring 4.3 버전 이후부터 생성자가 한개인 경우 묵시적 자동 주입이 가능합니다.
	 즉, 단일 생성자(생성자가 한개)일 경우 @Autowired 어노테이션을 붙이지 않아도 자동으로 생성자 주입을 해주는 것입니다.
	 
	 */
	
	private Outputter outputter;
	
	@Autowired
	public MessageBeanImpl(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("MessageBeanImpl 생성자 입니다.");
	}
	
   @Value("${name}")
	private String name;
   
   @Value("${greeting}")
	private String greeting;

	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println("MessageBeanImpl의 sayHello() 호출 :  " + message);
		try {
			 outputter.output(message);			 
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	
}









