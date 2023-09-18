package ITDA.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITDA.project.domain.Member;
import ITDA.project.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper dao;
	
	@Autowired
	public MemberServiceImpl(MemberMapper dao) {
		this.dao = dao;
	}
	
	@Override
	public int idCheck(String id) {
		Member rmember = dao.idCheck(id);
		return (rmember==null)? -1 : 1;
	}

	@Override
	public int insert(Member m) {
		return dao.insert(m);
	}

	@Override
	public int idCheck(String id, String password) {
		Member dbmember = dao.idCheck(id);
		int result = -1;
		if(dbmember != null) {
			if(password.equals(dbmember.getUserPw())) {
				result = 1;
			}else {
				result = 0;
			}
		}
		return result;
	}

}
