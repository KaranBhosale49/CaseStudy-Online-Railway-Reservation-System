package com.CaseStudy.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CaseStudy.com.Controller.TrainController;
import com.CaseStudy.com.Model.Train;
import com.CaseStudy.com.Repository.TrainRepository;

@SpringBootTest
class AdminApplicationTests {
     
	@Autowired
	TrainController con;
	@MockBean
	TrainRepository repo;
	@Test
	public void addTest() {
		Train train = new Train(1,"express","pune","solapur",100,200);
		when(repo.save(train)).thenReturn(train);
		Train result = con.add(train);
		assertEquals(train.getTrain_id(),result.getTrain_id());
	}
	@Test
	public void getTrainsTest() {
		int s=13;
		con.getTrains(s);
		verify(repo).findById(s);
	}
//	@Test
//	public void deleteTrain() {
//		int train=Train(1);
//		con.deleteTrain(train);
//		verify(repo,times(1)).deleteById(booking);
//		
//	}
//	private String Train(int i, String string, String string2, int j, int k) {
//		return null;
//	}
	

}
