package com.jm.scbooking.model.member.dao;

import com.jm.scbooking.model.member.dto.MemberDTO;

public interface MemberDAO {
	public void memberRegister(MemberDTO dto);
	public int duplicateCheck(String userid);
	public String loginCheck(String userid, String passwd);
}
