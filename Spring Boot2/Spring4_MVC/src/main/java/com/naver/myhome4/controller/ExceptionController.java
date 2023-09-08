package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/*
 	@ControllerAdvice �ֳ����̼��� ���ؼ� �� Ŭ������ ��ü�� ��Ʈ�ѷ����� �߻��ϴ�
 	Exception�� ���������� ó���ϴ� Ŭ������� ���� ����մϴ�.
 	
 		����� ����� ������ �����ϴ�.
 	1. Ŭ������ @controllerAdvice ��� �ֳ����̼� ó��
 	2. �� �޼ҵ忡 @ExceptionHandler�� �̿��ؼ� ������ Ÿ���� Exception�� ó��
 */

@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	/* common�޼ҵ�� Exception Ÿ������ ó���ϴ� ��� ���ܸ� ó���ϵ��� ���� */
	// select count(*) form board; ó�� �����ݷ� �ְ� ���� �߻��ϵ��� �մϴ�.
	@ExceptionHandler(Exception.class)
	public ModelAndView commom(Exception e, HttpServletRequest request) {
		logger.info(e.toString());
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("error/common");
	    mav.addObject("exception",e);
	    mav.addObject("ulr", request.getRequestURL());
	    return mav;
	   }
	
	//web.xml ���� �����ؾ� �մϴ�.
	//���� start�� �� http://localhost:8088/myhome/list.bo�� ������ ������
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		logger.info(e.toString());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/404");
		mav.addObject("exception", "404 ���� �߻��߽��ϴ�.");
		mav.addObject("url", request.getRequestURL());
		return mav;
	}
	
}
