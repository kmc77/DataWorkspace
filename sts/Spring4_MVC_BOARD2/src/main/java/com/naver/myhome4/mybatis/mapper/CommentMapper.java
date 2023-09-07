package com.naver.myhome4.mybatis.mapper;
//<mybatis-spring:scan base-package="com.naver.myhome4.mapper"/>
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naver.myhome4.domain.Board;
import com.naver.myhome4.domain.Comment;

/*
 Mapper �������̽��� ���� ���Ͽ� ����� SQL�� ȣ���ϱ� ���� �������̽��Դϴ�.
 MyBatis-Spring�� Mapper �������̽��� �̿��ؼ� ���� SQL ó���� �Ǵ� Ŭ������ �ڵ����� �����մϴ�.
 */

public interface CommentMapper {
	
	public int getListCount(int board_num);
	
	public List<Comment> getCommentList(Map<String, Integer> map);
	
	public int commentInsert(Comment c);
	
	public int commentsDelete(int num);
	
	public int commentsUpdate(Comment co);
}
