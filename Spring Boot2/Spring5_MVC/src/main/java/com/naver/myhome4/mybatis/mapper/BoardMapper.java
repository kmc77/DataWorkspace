package com.naver.myhome4.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.naver.myhome4.domain.Board;

//	<mybatis-spring:scan base-package="com.naver.myhome4.mapper"/>
@Mapper
public interface BoardMapper {
/*
 * Mapper �������̽��� ���� ���Ͽ� ����� SQL�� ȣ���ϱ� ���� �������̽��Դϴ�.
 * MyBatis-Spring�� Mapper �������̽��� �̿��ؼ� ���� SQL ó���� �Ǵ� Ŭ������ �ڵ����� �����մϴ�.
 */
	public int getListCount();
	
	public List<Board> getBoardList(HashMap<String, Integer> map);

	// �� ���� ����
	public Board getDetail(int num);
	
	// �� �亯
	public int boardReply(Board board);
	
	// �� ����
	public int boardModify(Board modifyboard);
	
	// �� ����
	public int boardDelete(Board board);
	
	// ��ȸ�� ������Ʈ
	public int setReadCountUpdate(int num);
	
	// �۾������� Ȯ��
	public Board isBoardWriter(Map<String, Object> map);
	
	// �� ����ϱ�
	public void insertBoard(Board board);
	
	// BOARD_RE_SEQ�� ����
	public int boardReplyUpdate(Board board);

	public List<String> getDeleteFileNames();

	public void deleteFileName(String filename);
	
}