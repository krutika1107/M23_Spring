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
public class CertificateController 
{
	@Autowired                   
	private CertificateService service;

	//creation
	@PostMapping("/certificate")
	public void add(@RequestBody Certificate c)
	{
		service.create(c);
	}
	
	//to Delete the data
	@DeleteMapping("/admin/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	//Retrieve with all  the records
	@GetMapping("/certificate")
	public List<Certificate>list()
	{
		return service.listAll();
		
	}
	
	//Retrieve with specific ID
	@GetMapping("/certificate/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Integer id)
	{
		try 
		{
			Certificate c=service.retrieve(id);
			return new ResponseEntity<Certificate>(c,HttpStatus.OK);
		}	
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}
	   //to update 
		@PutMapping("/certificate/{id}")
		public ResponseEntity<Certificate> update(@RequestBody Certificate c, @PathVariable Integer id)
		{
			try 
			{
				Certificate c1=service.retrieve(id);
				service.create(c);
				return new ResponseEntity<Certificate>(c1, HttpStatus.OK);
			}	
		    catch(NoSuchElementException e)
			{
				return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
			}
	 
		}

}