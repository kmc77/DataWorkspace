package com.naver.myhome1.sample6;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	
	
	//������ ȣ���� ���Ͽ� name="Sprion" �Ҵ��մϴ�.
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		System.out.println(greeting + name + "!");
	}
	
	public String getGreetion() {
		return greeting;
	}
	
	//getGreetion �޼��� ȣ���� ���Ͽ� greetion="�ȳ��ϼ���!" �Ҵ��մϴ�.
	public void setGreetion(String greeting) {
		this.greeting = greeting;
	}

}
