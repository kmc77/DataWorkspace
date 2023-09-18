package ITDA.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import ITDA.project.domain.Member;

@Mapper
public interface MemberMapper {

	Member idCheck(String id);

	int insert(Member m);

}
