package com.naver.myhome1.sample1_1;

import org.springframework.context.support.GenericXmlApplicationContext;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		/*
			Spring 컨테이너를 구동합니다.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample1_1/applicationContext.xml");
		
		//2. Object getBean(String name) :
		// 			argument로 지정된 이름의 bean 인스턴스를 반환합니다.
		//	Spring 컨테이너로부터 빈의 아이디가 "m2" 인 bean을 가져옵니다.
		MessageBean bean = (MessageBean) ctx.getBean("m2");
		
		//3. 메서드 실행합니다.
		bean.print();
		
		//4. Spring 컨테이너를 종료합니다.
		ctx.close();
		
	}

}
