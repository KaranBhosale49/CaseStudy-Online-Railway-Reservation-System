package com.CaseStudy.UserBooking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.CaseStudy.UserBooking.Model.Booking;
@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {

}
