

package com.naver.myhome1.sample5_2;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class ReadMain2 {

	public static void main(String[] args) {
		/*
			Spring �����̳ʸ� �����մϴ�.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample5_2/applicationContext2.xml");

		ReadTest2 rt = (ReadTest2)ctx.getBean("readTest2");
		
		//3. �޼��� �����մϴ�.
		rt.print();
		
		//4. Spring �����̳ʸ� �����մϴ�.
		ctx.close();
		
	}

}