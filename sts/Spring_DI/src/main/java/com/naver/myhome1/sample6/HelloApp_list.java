package com.naver.myhome1.sample6;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_list {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("som/naver/myhome1/sample6/applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) ctx.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
	
		for(String address : addressList)
			System.out.println(address);
		
		ctx.close();
	}

}
