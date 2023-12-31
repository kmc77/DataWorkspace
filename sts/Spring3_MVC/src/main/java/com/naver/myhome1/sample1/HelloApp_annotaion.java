/*
  1. MessageBeanImpl.java에서   @Component 사용해 보기
     - Spring 컨테이너가 component-scan에 의해서
              자동으로 bean 등록할 대상으로 지정됩니다.
     - 이때 bean의 이름을 지어줄 수 있는데 방법은  @Component("빈의 이름")하면 됩니다.
     - 이름을 사용하지 않으면 지정한 클래스의 이름에서 첫글자를 소문자로 바꾼 이름으로 
       bean이 생성됩니다.
*/
package com.naver.myhome1.sample1;

import org.springframework.context.support.GenericXmlApplicationContext;
public class HelloApp_annotaion {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
                  new GenericXmlApplicationContext("com/naver/myhome2/sample2/applicationContext.xml");
		//2. Object getBean(String name) :
		//			argument로 지정된 이름의 bean 인스턴스를 반환합니다.
		//	Spring 컨테이너로부터 빈의 아이디가 "m2"인 bean을 가져옵니다.
		MessageMultiple bean = (MessageMultiple)ctx.getBean("m2"); 
		
		//3. 메서드 실행합니다.
		bean.print();
		
		System.out.println("ctx.close() 호출 전입니다.");
		
		//4. Spring 컨테이너를 종료합니다.
		ctx.close();
		
		System.out.println("ctx.close() 호출 후입니다.");
	}
}







