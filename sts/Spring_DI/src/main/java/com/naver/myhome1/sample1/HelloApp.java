package com.naver.myhome1.sample1;
/*
 	�� ���α׷��� �ڹٿ��� �Ϲ������� �� �� �ִ� �ڵ��Դϴ�.
 	HelloAppŬ�������� MessageBeanEnŬ������ ���� �ν��Ͻ��� �����Ͽ� say�޼��带 ȣ���ϰ� �ֽ��ϴ�.
 	���� MessageBeanEn Ŭ������ ����Ǹ� HelloAppŬ������ ������ �޽��ϴ�.
 	�̷� ��츦 HelloAppŬ������ MessageBeanEn Ŭ������ ���ϰ� �����ϰ� �ִٰ� �մϴ�.
 	==>��, Ŭ�������� ��������, ���ջ��°� ���ϴٰ� �� �� �ֽ��ϴ�.
 	
 	
 	���� HelloApp Ŭ�������� MessageBeanEnŬ���� ��� �ٸ� Ŭ����(MessageBeanKo)�� ����� ��쿡
 	(MessageBeanKoŬ������ MessageBeanEnŬ������ ���� ����� �����ϴ� �޼��尡 �����մϴ�.)
 	�� Ŭ������ �޼���� MessageBeanEnŬ������ �޼���� �ٸ� �̸����� ���ǰ� �ֽ��ϴ�.
 	�׷��� MessageBeanKo Ŭ������ �����ϱ� ���ؼ��� �Ʒ��� 23-24���� ó�� �ڵ带 �����ؾ� �մϴ�.
 	�̸� �ذ��ϱ� ���� �켱 �̸��� ���� �޼��带 ����ϴ� ���(������ �̿�) ���� ����� ���ڽ��ϴ�.
 */

public class HelloApp {

	public static void main(String[] args) {
		MessageBeanEn bean = new MessageBeanEn();
		bean.say("Spring");
		
		
		MessageBeanKo bean2 = new MessageBeanKo();
		bean2.sayHello("Spring");
		
		

	}

}
