package com.jm.scbooking.service.member;

import com.jm.scbooking.model.member.dto.MemberDTO;

public interface MemberService {
	public void memberRegister(MemberDTO dto);
	public int duplicateCheck(String userid);
	public String loginCheck(String userid, String passwd);
}
