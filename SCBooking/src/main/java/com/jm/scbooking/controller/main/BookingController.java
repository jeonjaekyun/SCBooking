package com.jm.scbooking.controller.main;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jm.scbooking.model.booking.dto.BookingDTO;
import com.jm.scbooking.service.booking.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private static final Logger logger = 
			LoggerFactory.getLogger(BookingController.class);
	
	@Inject
	BookingService bookingService;
	
	@RequestMapping(value="/{roomNum}/{byear}/{bmonth}/{bday}", method=RequestMethod.GET)
	public ResponseEntity<List<BookingDTO>> lookup(
			@PathVariable("roomNum") String roomNum,@PathVariable("byear") int byear, 
			@PathVariable("bmonth") int bmonth, @PathVariable("bday") int bday){
		
		BookingDTO dto = new BookingDTO();
		dto.setRoomNum(roomNum); dto.setByear(byear); dto.setBmonth(bmonth); dto.setBday(bday);
		ResponseEntity<List<BookingDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(bookingService.lookup(dto),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> booking(@RequestBody BookingDTO dto){
		logger.info("booking called...");
		ResponseEntity<String> entity = null;
		try {
			if(timeCheck(dto)) {
				entity = new ResponseEntity<>("FAIL",HttpStatus.OK);
			}else {
				bookingService.insertBooking(dto);
				logger.info("booking SUCCESS");
				entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	private boolean timeCheck(BookingDTO dto) {
		List<BookingDTO> list = bookingService.lookup(dto);
		int s = dto.getBstart(); int e = dto.getBend();
		logger.info("list:"+list.toString());
		if(list.size()==0)
			return false;
		
		for(int i=0;i<list.size();i++) {
			int a = list.get(i).getBstart();
			int b = list.get(i).getBend();
			for(int j=s;j<e;j++) {
				if(j==a||j==b-1) {
					return true;
				}else {
					continue;
				}
			}
		}
		
		return false;
	}
}
