package com.naver.myhome1.sample5;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("MessageBeanImpl�� setOutputter()���� �� ����");
	}
	
	//������ ȣ���� ���Ͽ� name="Sprion" �Ҵ��մϴ�.
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("MessageBeanImpl ������ �Դϴ�.");
	}
	
	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println("MessageBeanImpl�� sayHello() ȣ�� : " + message);
		try {
			outputter.output(message);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public String getGreetion() {
		return greeting;
	}
	
	//getGreetion �޼��� ȣ���� ���Ͽ� greetion="�ȳ��ϼ���!" �Ҵ��մϴ�.
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("MessageBeanImpl�� setGreetion()���� �� ����");
		
	}

}
