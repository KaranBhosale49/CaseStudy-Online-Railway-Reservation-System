package com.CaseStudy.UserBooking.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaseStudy.UserBooking.Model.Booking;
import com.CaseStudy.UserBooking.Service.BookingService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	BookingService service;
	@PostMapping("/orders/addorder")
	public Booking saveBook(@RequestBody Booking book) {
		service.saveBook(book);
		return book;
	}

	@GetMapping("/orders")
	public List<Booking> getAllTrains(){
		return service.getAllTrains();
	}
	
	@GetMapping("/orders/{id}")
	public Optional<Booking> getBook(@PathVariable("id") String id){
		return service.getBook(id);
	}
	
	@PutMapping("/orders/update/{id}")
     public Booking updateBooking(@PathVariable("id")String id,@RequestBody Booking book) {
		return service.updateBooking(id,book);
	}
	
	@DeleteMapping("/orders/delete/{id}")
	public String deletebooking(@PathVariable("id")String id) {
		return service.deletebooking(id);
	}
}
