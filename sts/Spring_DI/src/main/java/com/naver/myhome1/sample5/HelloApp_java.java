package com.naver.myhome1.sample5;

public class HelloApp_java {

	public static void main(String[] args) {
	
		MessageBeanImpl bean = new MessageBeanImpl("Spring");
		FileOutputter outputter = new FileOutputter();
		outputter.setFilePath("out.txt");
		
		bean.setGreeting("�ȳ��ϼ���!");
		bean.setOutputter(outputter);
		System.out.println("===========getBean() �� ===========");
		
		bean.sayHello();
		
		//�ڵ� ���� ��ħ
		//Window > Preferences > General
		//		 > Workspace  > Refresh using native hooks and polling
	}

}