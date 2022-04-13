package com.CaseStudy.UserBooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CaseStudy.UserBooking.Model.Booking;
import com.CaseStudy.UserBooking.Repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository repo;

	public void saveBook(Booking book) {
		repo.save(book);
	}

	public List<Booking> getAllTrains() {
		return repo.findAll();
	}

	public Optional<Booking> getBook(String id) {
		return repo.findById(id);
	}

	public Booking updateBooking(String id, Booking book) {
		return repo.save(book);
	}

	public String deletebooking(String id) {
		repo.deleteById(id);
		return null;
	}

}
