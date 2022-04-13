package com.CaseStudy.com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaseStudy.com.Model.Train;
import com.CaseStudy.com.Repository.TrainRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/admincontrols")
public class TrainController {

	@Autowired
	TrainRepository trainrepo;
	
	
	@GetMapping("/Trains")
	public List<Train> getAllTrains() {
		return trainrepo.findAll();
	}
	
	@GetMapping("/Trains/{id}")
	public Optional<Train> getTrains(@PathVariable("id") int id) {
		return trainrepo.findById(id);
	}
	
	@PostMapping("/Trains")
	public Train add(@RequestBody Train train) {
		 return trainrepo.save(train);
	}
	
	@PutMapping("/Trains/{id}")
	public ResponseEntity<Train> updateTrain(@PathVariable("id") int id, @RequestBody Train train) {
	  trainrepo.save(train);
	  return null;
	}
	
	@DeleteMapping("/Trains/{id}")
	public String deleteTrain(@PathVariable("id") int id) {
	trainrepo.deleteById(id);  
	return null;
  }
	
	
}
