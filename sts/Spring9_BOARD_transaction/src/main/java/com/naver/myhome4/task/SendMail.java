package com.naver.myhome4.task;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.naver.myhome4.domain.MailVO;
/*
 * 
 *  @Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만
 *  모든 클래스에  @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기
 *  어렵습니다. 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서
 *   @Component를 상속하여 다음과 같은 세개의 애노테이션을 제공합니다.
 *   
 *   1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
 *   2. @Respositiry - 데이터 베이스 연동을 처리하는 DAO 클래스
 *   3. @Service - 비지니스 로직을 처리하는 Service 클래스
 */

@Component // localhost/myhome4/member로 시작하는~
public class SendMail {
	// import org.slf4j.Logger;
	// import org.slf4j.LoggerFacntory;
	private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

	@Value("#{savefolder['sendfile']}")
	
	private String sendfile;
	private JavaMailSenderImpl mailSender;

	@Autowired
	public SendMail(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	//프로젝트 우클릭 -> Properties -> Profect Facets -> 자바 버전 11로 맞추세요
	public void sendMail(MailVO vo) {
		MimeMessagePreparator mp = new MimeMessagePreparator() {

			
			/*
			 MimeMessage : 이 클래스는 MIME 스타일 이메일 메시지를 나타냅니다.
			 MIMF (영어: Multipurpose Internet Mail Extensions)는
			 	전자 우편을 위한 인터넷 표준 포맷입니다.
			 */
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				/*
				 MimeMessageHelper를 이용하면 첨부 파일이나 특수 문자 인코딩으로 작업할 때 전달된 MimeMessage를 채우는 데
				 편리합니다.
				 
				 두 번째 인자 true는 멀티 파트 메시지를 사용하겠다는 의미입니다.
				 */
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setFrom(vo.getFrom());
				helper.setTo(vo.getTo());
				helper.setSubject(vo.getSubject());
				
				//1. 문자로만 전송하는 경우
				//trye는 html을 사용하겠다는 뜻입니다.
				//helper.setText(vo.getContent(), true);
				
				//2. 이미지를 내장해서 보내는 경우
				//cid(content id)
				String content = "<img src='cid:Home'>" + vo.getContent();
				helper.setText(content, true);
				
				
				FileSystemResource file = new FileSystemResource(new File(sendfile));
				//addInline메서드의 첫번째 매개변수에는 cid(content id) 를 지정합니다.
				helper.addInline("Home", file);
				
				//3. 파일을 첨부해서 보내는 경우
				//첫번째 인자 : 첨부될 파일의 이름입니다.
				//두번째 인자 : 첨부파일
				helper.addAttachment("딸기.jsp", file);
				
			}
		};//new MimeMessagePreparator() end

		mailSender.send(mp); //메일 전송합니다.
		logger.info("메일 전송했습니다.");

	}//sendMail(MailVO vo)
}//class SendMail
