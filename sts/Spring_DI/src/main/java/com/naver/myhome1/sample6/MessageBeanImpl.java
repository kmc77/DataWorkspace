package com.naver.myhome1.sample6;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	
	
	//생성자 호출을 통하여 name="Sprion" 할당합니다.
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
	
	//getGreetion 메서드 호출을 통하여 greetion="안녕하세요!" 할당합니다.
	public void setGreetion(String greeting) {
		this.greeting = greeting;
	}

}
