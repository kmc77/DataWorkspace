package com.naver.myhome4.mybatis.mapper;
//<mybatis-spring:scan base-package="com.naver.myhome4.mapper"/>
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naver.myhome4.domain.Board;
import com.naver.myhome4.domain.Comment;

/*
 Mapper 인터페이스란 매퍼 파일에 기재된 SQL을 호출하기 위한 인터페이스입니다.
 MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
 */

public interface CommentMapper {
	
	public int getListCount(int board_num);
	
	public List<Comment> getCommentList(Map<String, Integer> map);
	
	public int commentInsert(Comment c);
	
	public int commentsDelete(int num);
	
	public int commentsUpdate(Comment co);
}
