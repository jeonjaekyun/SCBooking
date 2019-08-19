package com.jm.scbooking.model.booking.dao;

import java.util.List;

import com.jm.scbooking.model.booking.dto.BookingDTO;

public interface BookingDAO {
	public void insertBooking(BookingDTO dto);
	public List<BookingDTO> lookup(BookingDTO dto);
}
