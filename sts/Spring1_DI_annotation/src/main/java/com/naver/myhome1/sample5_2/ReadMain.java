

package com.naver.myhome1.sample5_2;

import org.springframework.context.support.GenericXmlApplicationContext;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class ReadMain {

	public static void main(String[] args) {
		/*
			Spring 컨테이너를 구동합니다.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample5_2/applicationContext2.xml");

		ReadTest1 rt = (ReadTest1)ctx.getBean("readTest1");
		
		//3. 메서드 실행합니다.
		rt.print();
		
		//4. Spring 컨테이너를 종료합니다.
		ctx.close();
		
	}

}
