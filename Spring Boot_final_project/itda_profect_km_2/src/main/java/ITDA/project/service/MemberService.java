package ITDA.project.service;

import ITDA.project.domain.Member;

public interface MemberService {

	public int idCheck(String id);
	
	public int insert(Member m);

	public int idCheck(String id, String password);
}
