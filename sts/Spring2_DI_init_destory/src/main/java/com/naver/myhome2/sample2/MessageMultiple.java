/*
  @Autowired 사용해 보기 
  - @Autowireddms 생성자나 메서드, 멤버변수 위에 모두 사용할 수 있습니다.
  - 자동 주입 기능을 사용하면 스프링 컨테이너는 알아서 의존 객체를 찾아서 주입해 줍니다.
  - 즉, 해당 타입에 할당할 수 있는 빈 객체를 찾아서 주입합니다.
  - @Autowired 애노테이션을 적용하면 반드시 주입할 의존 객체가 존재해야 합니다.
  - 만약 @Autowired가 붙은 객체가 메모리에 없다면 스프링 컨테이너가 NoSuchBeanDefinitionException을 발생시킵니다.
  
  자동 주입 기능을 위한 두 가지 사용
  1) 자동 주입 대상에 @Autowired 애노테이션 사용
  2) XML 설정에 <context:annotation-config/> 사용
  
  
  @Qualifier("m1") 생략한 경우 오류 발생
  
  MessageBean 타입의 변이 "m"과 "m1" 두 개가 존재해서 어떤 객체를 주입할지 모르기 때문에 발생하는 예외입니다.
  
  @Qualifier annotation을 이용해서 주입될 객체의 아이디나 이름을 지정할 수 있습니다.
  
  @Autowired와 @Qualifier을 한 번에 처리할 수 있는 것이 @Resource입니다.
 
 */

package com.naver.myhome2.sample2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("m2")
public class MessageMultiple {
	
	private MessageBean messagebean;
	@Autowired
	public void setBean(MessageBean messagebean) {
		this.messagebean = messagebean;
	}
	
	
	public MessageMultiple() {
		System.out.println("MessageMultiple 생성자입니다.");

	}
	
	public void print() {
		messagebean.sayHello("Spring");
	}
	
	
	//객체를 생성한 후에 init-method 속성으로 지정된 이 메서드를 호출합니다.
	@PostConstruct //init-method="initMethod"에 해당하는 annotation
	public void initMethod() {
		System.out.println("MessageMultiple의 init-Method()를 실행합니다.");
	}

}
