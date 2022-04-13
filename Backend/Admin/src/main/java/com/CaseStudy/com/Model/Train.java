package com.CaseStudy.com.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="train")
public class Train {

	@Id
	public int train_id;
	public String train_name;
	public String from;
	public String to;
	public int cost;
	public int seats;
	
	 public Train() {	
		}

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Train(int train_id, String train_name, String from, String to, int cost, int seats) {
		super();
		this.train_id = train_id;
		this.train_name = train_name;
		this.from = from;
		this.to = to;
		this.cost = cost;
		this.seats = seats;
	}
	 
}