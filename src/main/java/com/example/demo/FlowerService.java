package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlowerService {
	
	private FlowerRepository repository;
	
//	to get all flower in the database
	public List<Flower> getAllFlowers(){		
		return (List<Flower>) repository.findAll();
	}
	
//	to delete flower by id
	public void deleteFlower(long id) {
		repository.deleteById(id);
	}
	
//	to save flower after add or edit
	public void save(Flower flower) {
		this.repository.save(flower);
	}
	
//	to find flower by id in database
	public Flower getFlowerById(long id) {
		Optional<Flower> res = repository.findById(id);
		if(res.isPresent()) {
			return res.get();
		}		
		return null;		
	}		
	
}
