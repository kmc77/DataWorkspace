package com.naver.myhome1.sample3;

/*
 	������ ���� �̿��ϱ�
 	Factory ������ �̿��ϴ� ������� Ŭ���̾�Ʈ���� ����� ��ü ������ ĸ��ȭ�Ͽ� �޼ҵ��� �Ű������� ���� ��ü�� �����մϴ�.
 	==> ���� �ʿ��� ��ü�� ���� �������� �ʰ� ���� � ��ü�� �ʿ�����
 	BeanFactory�� ��û�ϸ� BeanFactory�� �����Ͽ� �Ѱ��ݴϴ�.
 */
public class HellpApp_Factory {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		MessageBean bean = (MessageBean)factory.getBean("MessageBeanKo");
		bean.sayHello("spriong~");

	}

}