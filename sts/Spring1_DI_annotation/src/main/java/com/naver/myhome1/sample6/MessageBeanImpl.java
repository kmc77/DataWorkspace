package com.naver.myhome1.sample6;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("m3")

public class MessageBeanImpl implements MessageBean {
	
	/*
	 Spring 4.3 ���� ���ĺ��� �����ڰ� �Ѱ��� ��� ������ �ڵ� ������ �����մϴ�.
	 ��, ���� ������(�����ڰ� �Ѱ�)�� ��� @Autowired ������̼��� ������ �ʾƵ� �ڵ����� ������ ������ ���ִ� ���Դϴ�.
	 
	 */
	
	private Outputter outputter;
	
	@Autowired
	public MessageBeanImpl(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("MessageBeanImpl ������ �Դϴ�.");
	}
	
   @Value("${name}")
	private String name;
   
   @Value("${greeting}")
	private String greeting;

	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println("MessageBeanImpl�� sayHello() ȣ�� :  " + message);
		try {
			 outputter.output(message);			 
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	
}








