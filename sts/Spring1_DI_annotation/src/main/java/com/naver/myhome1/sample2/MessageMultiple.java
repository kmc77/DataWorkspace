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

package com.naver.myhome1.sample2;

import javax.annotation.Resource;

public class MessageMultiple {
	
	private MessageBean messagebean;
	
	
	//�ش� Ÿ�Կ� �Ҵ��� �� �ִ� �� ��ü�� ã�Ƽ� �ڵ� ���Ե˴ϴ�.
	//�ݵ�� ������ ���� ��ü�� �����ؾ� �մϴ�.
	@Resource(name="m1")
	public void setBean (MessageBean messagebean) {
		this.messagebean = messagebean;
	}
	
	public MessageMultiple() {
		System.out.println("MessageMultiple �������Դϴ�.");

	}
	
	public void print() {
		messagebean.sayHello("Spring");
	}

}