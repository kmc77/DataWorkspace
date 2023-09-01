/*
  @Autowired ����� ���� 
  - @Autowireddms �����ڳ� �޼���, ������� ���� ��� ����� �� �ֽ��ϴ�.
  - �ڵ� ���� ����� ����ϸ� ������ �����̳ʴ� �˾Ƽ� ���� ��ü�� ã�Ƽ� ������ �ݴϴ�.
  - ��, �ش� Ÿ�Կ� �Ҵ��� �� �ִ� �� ��ü�� ã�Ƽ� �����մϴ�.
  - @Autowired �ֳ����̼��� �����ϸ� �ݵ�� ������ ���� ��ü�� �����ؾ� �մϴ�.
  - ���� @Autowired�� ���� ��ü�� �޸𸮿� ���ٸ� ������ �����̳ʰ� NoSuchBeanDefinitionException�� �߻���ŵ�ϴ�.
  
  �ڵ� ���� ����� ���� �� ���� ���
  1) �ڵ� ���� ��� @Autowired �ֳ����̼� ���
  2) XML ������ <context:annotation-config/> ���
  
  
  @Qualifier("m1") ������ ��� ���� �߻�
  
  MessageBean Ÿ���� ���� "m"�� "m1" �� ���� �����ؼ� � ��ü�� �������� �𸣱� ������ �߻��ϴ� �����Դϴ�.
  
  @Qualifier annotation�� �̿��ؼ� ���Ե� ��ü�� ���̵� �̸��� ������ �� �ֽ��ϴ�.
  
  @Autowired�� @Qualifier�� �� ���� ó���� �� �ִ� ���� @Resource�Դϴ�.
 
 */

package com.naver.myhome2.sample1;

import org.springframework.stereotype.Component;

@Component
public class MessageMultiple {
	
	private MessageBean messagebean;
	public void setBean(MessageBean messagebean) {
		this.messagebean = messagebean;
	}
	
	
	public MessageMultiple() {
		System.out.println("MessageMultiple �������Դϴ�.");

	}
	
	public void print() {
		messagebean.sayHello("Spring");
	}
	
	//��ü�� ������ �Ŀ� init-method �Ӽ����� ������ �� �޼��带 ȣ���մϴ�.
	public void initMethod() {
		System.out.println("MessageMultiple�� initMethod()�� �����մϴ�.");
	}

}