package com.jm.scbooking.service.booking;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jm.scbooking.model.booking.dao.BookingDAO;
import com.jm.scbooking.model.booking.dto.BookingDTO;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger logger = 
			LoggerFactory.getLogger(BookingServiceImpl.class);
	
	@Inject
	BookingDAO bookingDao;
	
	@Override
	public void insertBooking(BookingDTO dto) {
		bookingDao.insertBooking(dto);
	}

	@Override
	public List<BookingDTO> lookup(BookingDTO dto) {
		return bookingDao.lookup(dto);
	}

}
