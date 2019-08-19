package com.jm.scbooking.service.member;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jm.scbooking.model.member.dao.MemberDAO;
import com.jm.scbooking.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	MemberDAO memberDao;
	
	@Override
	public void memberRegister(MemberDTO dto) {
		logger.info("sertvice dto : "+dto);
		memberDao.memberRegister(dto);
	}

	@Override
	public int duplicateCheck(String userid) {
		return memberDao.duplicateCheck(userid);
	}

	@Override
	public String loginCheck(String userid, String passwd) {
		return memberDao.loginCheck(userid, passwd);
	}

}
