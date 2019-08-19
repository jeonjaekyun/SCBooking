package com.jm.scbooking.model.qa.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jm.scbooking.model.qa.dto.QaDTO;

@Repository
public class QaDAOImpl implements QaDAO {

	private	static final Logger logger = LoggerFactory.getLogger(QaDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<QaDTO> list() {
		logger.info("QADAO list : "+sqlSession.selectList("qa.list").toString());
		return sqlSession.selectList("qa.list");
	}

	@Override
	public void newBoard(QaDTO dto) {
		sqlSession.insert("qa.newBoard",dto);
	}

	@Override
	public QaDTO readBoard(int bno) {
		return sqlSession.selectOne("qa.readBoard",bno);
	}

}
