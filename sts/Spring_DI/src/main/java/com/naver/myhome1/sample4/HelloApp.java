package com.naver.myhome1.sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		/*
		 Spring 컨테이너 구동 설정 파일인 applicationContext.xml을 로딩하여 스프링 컨테이너 중 하나인
		 GenericXmlApplicationContext 객체가 생성되어 스프링 컨테이너가 구동합니다.
		 스프링 컨테이너는 applicationContext.xml 에 설정대로 빈을 생성합니다.
		 
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample4/applicationContext.xml");
		MessageBean bean = (MessageBean) ctx.getBean("m2");
		bean.sayHello();
		ctx.close();
		
	}

}
