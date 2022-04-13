package com.CaseStudy.UserBooking.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="book")
public class Booking {

	@Id
	private String _id;
	private String train;
	private String startStation;
	private String destination;
	private String name;
	private String age;
	private String gender;
	private String seats;
	private String date;
	private String email;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Booking(String id, String train, String startStation, String destination, String name, String age,
			String gender, String seats, String date, String email) {
		super();
		this._id = id;
		this.train = train;
		this.startStation = startStation;
		this.destination = destination;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.seats = seats;
		this.date = date;
		this.email = email;
	}

	public Booking() {
		super();
	}
	

}
