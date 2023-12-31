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
   //SqlSessionFactoryBean에서 만든 SqlSessionFactory를 주입합니다. 
   
  // @Test // 현재 메서드를 테스트 대상으로 지정하는 애노테이션입니다.(org.junit.Test)
    public void testSqlSessionFactory() {
	   logger.info("~~~~~~~sqlSessionFactory : " + sqlSessionFactory);
	   //sqlSessionFactory : org.apache.ibatis.session.defaluts.DefalutSqlSessionFactory@2c5d601e
	   //만약에 root-context.xml 파일에 설정한 SqlSessionFactory Bean의 설정에 문제가 있다면
	   //이 코드에서 문제가 발생할 것입니다. 
	   
   }
   
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate; 
    //SqlSessionFactoryBean에서 만든 SqlSessionFactory를 주입합니다. 
    
    @Test // 현재 메서드를 테스트 대상으로 지정하는 애노테이션입니다.(org.junit.Test)
     public void testSqlSessionTemplate() {
 	   logger.info("~~~~~~~sqlSessionTemplate : " + sqlSessionTemplate);
 	  
    } 
    
    
    
    
}