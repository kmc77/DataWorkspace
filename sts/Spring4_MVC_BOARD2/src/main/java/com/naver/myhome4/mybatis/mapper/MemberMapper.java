package com.naver.myhome4.mybatis.mapper;
import java.util.List;
import java.util.Map;

import com.naver.myhome4.domain.Member;

/*
 Mapper �������̽��� ���� ���Ͽ� ����� SQL�� ȣ���ϱ� ���� �������̽��Դϴ�.
 MyBatis-Spring�� Mapper �������̽��� �̿��ؼ� ���� SQL ó���� �Ǵ� Ŭ������ �ڵ����� �����մϴ�.
 */

public interface MemberMapper {
	
	public Member isId(String id);
	
	public int insert(Member m);
	
	public int update(Member m);
	
	public void delete(String id);
	
	public int getSearchListCount(Map<String, String> map);
	
	public List<Member> getSearchList(Map<String, Object> map);

}
