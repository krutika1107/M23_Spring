package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollageController
{
	@Autowired
	private CollegeService service;
	
	//creation
		@PostMapping("/college")
		public void add(@RequestBody College c)
		{
			service.create(c);
		}
		//deletion
		@DeleteMapping("/college/{collegeid}")
		public void remove(@PathVariable Integer collegeid)
		{
			service.delete(collegeid);
			
		}
		//Retrieve  with all the records
		@GetMapping("/college")
		public List<College>list()
		{
			return service.listAll();
		}
		//Retrieve with specific id
		@GetMapping("/college/{collegeid}")
		public ResponseEntity<College> get(@PathVariable Integer collegeid)
		{
			try {
				College c=service.retrieve(collegeid);
				return new ResponseEntity<College>(c,HttpStatus.OK);
			
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
			}
		}
		
		//updating
		@PutMapping("/college/{collegeid}")
		public ResponseEntity<College> update(@RequestBody College c, @PathVariable Integer collegeid)
		{
			try {
				@SuppressWarnings("unused")
				College c1=service.retrieve(collegeid);
				service.create(c);
				return new ResponseEntity<College>(c,HttpStatus.OK);
			
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
			}
			
			
		}
}