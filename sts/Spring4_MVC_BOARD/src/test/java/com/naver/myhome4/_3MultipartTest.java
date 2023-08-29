package com.naver.myhome4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class _3MultipartTest {
	
	private static final Logger logger = LoggerFactory.getLogger(_3MultipartTest.class);

	@Autowired
	org.springframework.web.multipart.commons.CommonsMultipartResolver multipart;

	@Test // ���� �޼��带 �׽�Ʈ ������� �����ϴ� �ֳ����̼��Դϴ�.(org.junit.Test)
	public void isMultipart() {
		logger.info("CommonsMultipartResolver �� ���� : " + multipart);
	}

}
