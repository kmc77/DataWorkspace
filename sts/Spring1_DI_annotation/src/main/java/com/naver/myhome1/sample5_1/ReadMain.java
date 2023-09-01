

package com.naver.myhome1.sample5_1;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class ReadMain {

	public static void main(String[] args) {
		/*
			Spring �����̳ʸ� �����մϴ�.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample5_1/applicationContext1.xml");

		ReadTest1 rt = (ReadTest1)ctx.getBean("readTest1");
		
		//3. �޼��� �����մϴ�.
		rt.print();
		
		//4. Spring �����̳ʸ� �����մϴ�.
		ctx.close();
		
	}

}