package com.naver.myhome4.task;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.naver.myhome4.domain.MailVO;
import com.naver.myhome4.service.BoardService;

import org.springframework.scheduling.annotation.EnableScheduling;

@Service
@EnableScheduling //아래의 클래스를 스케줄링 목적으로 사용하도록 하겠다는 명시합니다.
@Configuration //이 어노테이션을 사용하지 않으면 스케줄링이 동작하지 않습니다.
public class FileCheckTask {
	
	
	private static final Logger logger = LoggerFactory.getLogger(FileCheckTask.class);

	@Value("${savefoldername}")
	private String saveFolder;
	
	private BoardService boardService;

	@Autowired
	public FileCheckTask(BoardService boardService) {
		this.boardService = boardService;
	}

	
	//스케줄러를 이용해서 주기적으로 메서드를 실행하기 위해 설정합니다.
	//1000 : 밀리세컨드 단위입니다. (1초)
	//@Scheduled(fixedDelay = 1000)
	public void test() throws Exception { 
		logger.info("test");
	}
	
	//cron 사용법
	//seconds(초:0~59) minutes(분:0~59) hours(시:0~23) day(일:1~31)
	//months(달:1~12) day of week(요일:0~6) year(optional)
	//				초 분 시 일 달 요일
	@Scheduled(cron = "0 17 * * * *")
	public void checkFiles() throws Exception { 
		
		logger.info("checkFiles");

		List<String> deleteFileList = boardService.getDeleteFileList();

		// for(String filename : deleteFileList) {
		for (int i = 0; i < deleteFileList.size(); i++) {
			String filename = deleteFileList.get(i);
			File file = new File(saveFolder + filename);
			if (file.exists()) {
				if (file.delete()) {
					logger.info(file.getPath() + " 삭제되었습니다.");
					boardService.deleteFileList(filename);
				}
			} else {
				logger.info(file.getPath() + " 파일이 존재하지 않습니다.");
			}
		}

	}

}
	
