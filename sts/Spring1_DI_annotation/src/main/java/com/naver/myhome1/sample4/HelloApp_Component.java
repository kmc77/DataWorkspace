/*
 	@Component ����� ���� 
 	- Spring �����̳ʰ� component-scan�� ���ؼ� �ڵ����� bean ����� ������� �����˴ϴ�.
 	- �̶� bean�� �̸��� ������ �� �ִµ� ����� @Component("���� �̸�") �ϸ� �˴ϴ�.
 	- �̸��� ������� ������ ������ Ŭ������ �̸����� ù���ڸ� �ҹ��ڷ� �ٲ� �̸����� bean �� �����˴ϴ�.
 	��)
 	@Component
 	public class MessageMultiple {} �� ����
 	
 	MessageMultiple bean = (MessageMultiple)ctx.getBean("messageMultiple");
 */


package com.naver.myhome1.sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp_Component {

	public static void main(String[] args) {
		/*
			Spring �����̳ʸ� �����մϴ�.
		 */
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("com/naver/myhome1/sample4/applicationContext4.xml");
		
		//2. Object getBean(String name) :
		// 			argument�� ������ �̸��� bean �ν��Ͻ��� ��ȯ�մϴ�.
		//	Spring �����̳ʷκ��� ���� ���̵� "m2" �� bean�� �����ɴϴ�.
		MessageMultiple bean = (MessageMultiple) ctx.getBean("messageMultiple");
		
		//3. �޼��� �����մϴ�.
		bean.print();
		
		//4. Spring �����̳ʸ� �����մϴ�.
		ctx.close();
		
	}

}