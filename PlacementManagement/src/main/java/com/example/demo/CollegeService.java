package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CollegeService 
{
	@Autowired
	private CollegeRepository repo;
	
	//To retrieve all data of college class
	public List<College> listAll() {
		return repo.findAll();
	}
	//Insert/create/update a data
	public void create(College c)
	{
		repo.save(c);
	}
	//To retrieve a single Data
	public College retrieve(Integer collegeid)
	{
		return repo.findById(collegeid).get();
	}
	//To delete a data
	public void delete(Integer collegeid)
	{
		repo.deleteById(collegeid);
	}

}