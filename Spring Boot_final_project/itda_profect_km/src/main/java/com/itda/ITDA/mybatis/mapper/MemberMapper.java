package com.itda.ITDA.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itda.ITDA.domain.Member;

@Mapper
public interface MemberMapper {

	Member isId(String userId);

	int insert(Member mem);
	
}
