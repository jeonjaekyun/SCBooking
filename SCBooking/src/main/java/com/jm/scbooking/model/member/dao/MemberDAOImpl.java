package com.jm.scbooking.model.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jm.scbooking.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void memberRegister(MemberDTO dto) {
		sqlSession.insert("member.memberRegister", dto);
	}

	@Override
	public int duplicateCheck(String userid) {
		return sqlSession.selectOne("member.duplicateCheck",userid);
	}

	@Override
	public String loginCheck(String userid, String passwd) {
		Map<String,Object> map = new HashMap<>();
		map.put("userid",userid);
		map.put("passwd", passwd);
		return sqlSession.selectOne("member.loginCheck", map);
	}

}
