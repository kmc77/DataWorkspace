/*
  1. MessageBeanImpl.java에서   @Component 사용해 보기
     - Spring 컨테이너가 component-scan에 의해서
              자동으로 bean 등록할 대상으로 지정됩니다.
     - 이때 bean의 이름을 지어줄 수 있는데 방법은  @Component("빈의 이름")하면 됩니다.
     - 이름을 사용하지 않으면 지정한 클래스의 이름에서 첫글자를 소문자로 바꾼 이름으로 
       bean이 생성됩니다.
*/
package com.naver.myhome1.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;
public class HelloApp_Component {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
                  new GenericXmlApplicationContext("com/naver/myhome1/sample6/applicationContext6.xml");
		MessageBeanImpl m3 = (MessageBeanImpl)ctx.getBean("m3"); 
		
		m3.sayHello();//메서드 호출합니다.
		ctx.close();
	}
}







