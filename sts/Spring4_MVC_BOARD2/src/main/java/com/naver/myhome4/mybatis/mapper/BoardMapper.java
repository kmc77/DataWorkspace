package com.naver.myhome4.mybatis.mapper;
//<mybatis-spring:scan base-package="com.naver.myhome4.mapper"/>
import java.util.HashMap;
import java.util.List;

import com.naver.myhome4.domain.Board;

/*
 Mapper 인터페이스란 매퍼 파일에 기재된 SQL을 호출하기 위한 인터페이스입니다.
 MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
 */

public interface BoardMapper {
	
	//글의 갯수 구하기
	public int getListCount();
	
	public List<Board> getBoardList(HashMap<String, Integer> map);
	
	//글 내용 보기
	public Board getDetail(int num);
	
	//글 답변
	public int boardReply(Board board);

}
