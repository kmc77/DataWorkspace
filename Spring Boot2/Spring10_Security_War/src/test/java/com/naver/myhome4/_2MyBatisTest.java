package com.naver.myhome4;
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
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class _2MyBatisTest {
 
   private static final Logger logger = LoggerFactory.getLogger(_2MyBatisTest.class);

   @Autowired
   private SqlSessionFactory sqlSessionFactory; 
   //SqlSessionFactoryBean���� ���� SqlSessionFactory�� �����մϴ�. 
   
  // @Test // ���� �޼��带 �׽�Ʈ ������� �����ϴ� �ֳ����̼��Դϴ�.(org.junit.Test)
    public void testSqlSessionFactory() {
	   logger.info("~~~~~~~sqlSessionFactory : " + sqlSessionFactory);
	   //sqlSessionFactory : org.apache.ibatis.session.defaluts.DefalutSqlSessionFactory@2c5d601e
	   //���࿡ root-context.xml ���Ͽ� ������ SqlSessionFactory Bean�� ������ ������ �ִٸ�
	   //�� �ڵ忡�� ������ �߻��� ���Դϴ�. 
	   
   }
   
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate; 
    //SqlSessionFactoryBean���� ���� SqlSessionFactory�� �����մϴ�. 
    
    @Test // ���� �޼��带 �׽�Ʈ ������� �����ϴ� �ֳ����̼��Դϴ�.(org.junit.Test)
     public void testSqlSessionTemplate() {
 	   logger.info("~~~~~~~sqlSessionTemplate : " + sqlSessionTemplate);
 	  
    } 
    
    
    
    
}