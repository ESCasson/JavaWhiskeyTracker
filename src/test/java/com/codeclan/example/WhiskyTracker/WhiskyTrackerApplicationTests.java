package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {
@Autowired
private WhiskyRepository whiskyRepository;

@Autowired
private DistilleryRepository distilleryRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetWhiskyByDistilleryIDByAge(){
		List<Whisky> found = whiskyRepository.findByDistilleryIdAndAge( 1, 12);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetWhiskiesByDistilleryRegion(){
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals(1, found.size());
	}

	@Test
	public void getDistilleriesByWhiskyAge(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(2, found.size());
	}

}
