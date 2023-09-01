package com.naver.myhome1.sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp_Qualifier {

	public static void main(String[] args) {
		/*
			Spring �����̳ʸ� �����մϴ�.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample2/applicationContext2.xml");
		
		//2. Object getBean(String name) :
		// 			argument�� ������ �̸��� bean �ν��Ͻ��� ��ȯ�մϴ�.
		//	Spring �����̳ʷκ��� ���� ���̵� "m2" �� bean�� �����ɴϴ�.
		MessageMultiple bean = (MessageMultiple) ctx.getBean("m2");
		
		//3. �޼��� �����մϴ�.
		bean.print();
		
		//4. Spring �����̳ʸ� �����մϴ�.
		ctx.close();
		
	}

}