package com.jm.scbooking.model.booking.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jm.scbooking.model.booking.dto.BookingDTO;

@Repository
public class BookingDAOImpl implements BookingDAO {

	private static final Logger logger = 
			LoggerFactory.getLogger(BookingDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertBooking(BookingDTO dto) {
		sqlSession.insert("booking.insertBooking",dto);
	}

	@Override
	public List<BookingDTO> lookup(BookingDTO dto) {
		return sqlSession.selectList("booking.lookup",dto);
	}

}
