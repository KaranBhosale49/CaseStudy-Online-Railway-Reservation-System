package com.CaseStudy.UserBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CaseStudy.UserBooking.Controller.BookingController;
import com.CaseStudy.UserBooking.Model.Booking;
import com.CaseStudy.UserBooking.Repository.BookingRepository;

@SpringBootTest
class UserBookingApplicationTests {
     
	@MockBean
	BookingRepository repo;
	
	@Autowired
	BookingController controller;
	@Test
	void savebook() {
		Booking booking=new Booking("123","express","pune","mumbai","karan","25","male","4","23feb","bhosalekaran@gmail.com");
	     when(repo.save(booking)).thenReturn(booking);
	     Booking res=controller.saveBook(booking);
	assertEquals(booking.getId(), res.getId());
	}
	
	@Test
	public void getbookingbyIdTest() {
		String string="22";
		controller.getBook(string);
		verify(repo).findById(string);
	}
	@Test
	public void deletebookingIdTest() {
		String booking= Booking("100","local","solapur","thane","pranav","20","male","cash","2","hdfc","4jan","pranav@gmail.com");
		controller.deletebooking(booking);
		verify(repo,times(1)).deleteById(booking);
	}

	private String Booking(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11,
			String string12) {
		return null;
	}


}
