package com.jm.scbooking.service.booking;

import java.util.List;

import com.jm.scbooking.model.booking.dto.BookingDTO;

public interface BookingService {
	public void insertBooking(BookingDTO dto);
	public List<BookingDTO> lookup(BookingDTO dto);
}
