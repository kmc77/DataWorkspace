package com.naver.myhome4.domain;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int		BOARD_NUM;		//�۹�ȣ
	private String	BOARD_NAME;		//�� �ۼ���
	private String	BOARD_PASS;		//�� ��й�ȣ
	private String	BOARD_SUBJECT;	//�� ����
	private String	BOARD_CONTENT;	//�� ����
	private String	BOARD_FILE;		//���� ����� ������ �̸�
	private int		BOARD_RE_REF;	//�亯 �� �ۼ��� �����Ǵ� ���� ��ȣ
	private int		BOARD_RE_LEV;	//�亯 ���� ����
	private int		BOARD_RE_SEQ;	//�亯 ���� ����
	private int		BOARD_READCOUNT;//���� ��ȸ��
	
	//board_write.jsp ���� name �Ӽ� Ȯ���ϼ���.
	//<input type="file" id="upfile" name="uploadfile">Ȯ��
	private MultipartFile uploadfile;
	
	private String BOARD_ORIGINAL;	//÷�ε� ������ �̸�
	private String BOARD_DATE;
	private int		CNT;
	
	public int getCNT() {
		return CNT;
	}
	public void setCNT(int cNT) {
		CNT = cNT;
	}
	
	public int getBOARD_NUM() {
		return BOARD_NUM;
	}
	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	public String getBOARD_NAME() {
		return BOARD_NAME;
	}
	public void setBOARD_NAME(String bOARD_NAME) {
		BOARD_NAME = bOARD_NAME;
	}
	public String getBOARD_PASS() {
		return BOARD_PASS;
	}
	public void setBOARD_PASS(String bOARD_PASS) {
		BOARD_PASS = bOARD_PASS;
	}
	public String getBOARD_SUBJECT() {
		return BOARD_SUBJECT;
	}
	public void setBOARD_SUBJECT(String bOARD_SUBJECT) {
		BOARD_SUBJECT = bOARD_SUBJECT;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public String getBOARD_FILE() {
		return BOARD_FILE;
	}
	public void setBOARD_FILE(String bOARD_FILE) {
		BOARD_FILE = bOARD_FILE;
	}
	public int getBOARD_RE_REF() {
		return BOARD_RE_REF;
	}
	public void setBOARD_RE_REF(int bOARD_RE_REF) {
		BOARD_RE_REF = bOARD_RE_REF;
	}
	public int getBOARD_RE_LEV() {
		return BOARD_RE_LEV;
	}
	public void setBOARD_RE_LEV(int bOARD_RE_LEV) {
		BOARD_RE_LEV = bOARD_RE_LEV;
	}
	public int getBOARD_RE_SEQ() {
		return BOARD_RE_SEQ;
	}
	public void setBOARD_RE_SEQ(int bOARD_RE_SEQ) {
		BOARD_RE_SEQ = bOARD_RE_SEQ;
	}
	public int getBOARD_READCOUNT() {
		return BOARD_READCOUNT;
	}
	public void setBOARD_READCOUNT(int bOARD_READCOUNT) {
		BOARD_READCOUNT = bOARD_READCOUNT;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getBOARD_ORIGINAL() {
		return BOARD_ORIGINAL;
	}
	public void setBOARD_ORIGINAL(String bOARD_ORIGINAL) {
		BOARD_ORIGINAL = bOARD_ORIGINAL;
	}
	public String getBOARD_DATE() {
		return BOARD_DATE;
	}
	public void setBOARD_DATE(String bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}
	@Override
	public String toString() {
		return "Board [BOARD_NUM=" + BOARD_NUM + ", BOARD_NAME=" + BOARD_NAME + ", BOARD_PASS=" + BOARD_PASS
				+ ", BOARD_SUBJECT=" + BOARD_SUBJECT + ", BOARD_CONTENT=" + BOARD_CONTENT + ", BOARD_FILE=" + BOARD_FILE
				+ ", BOARD_RE_REF=" + BOARD_RE_REF + ", BOARD_RE_LEV=" + BOARD_RE_LEV + ", BOARD_RE_SEQ=" + BOARD_RE_SEQ
				+ ", BOARD_READCOUNT=" + BOARD_READCOUNT + ", uploadfile=" + uploadfile + ", BOARD_ORIGINAL="
				+ BOARD_ORIGINAL + ", BOARD_DATE=" + BOARD_DATE + "]";
	}
	
	
	
}
