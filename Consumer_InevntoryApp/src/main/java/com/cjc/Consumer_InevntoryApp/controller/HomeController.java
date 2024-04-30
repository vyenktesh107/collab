package com.cjc.Consumer_InevntoryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.Consumer_InevntoryApp.model.ApiResponce;
import com.cjc.Consumer_InevntoryApp.model.Product;
import com.cjc.Consumer_InevntoryApp.model.Supplier;
@CrossOrigin
@RestController
public class HomeController {
	
	@Autowired
	RestTemplate rs;
	@PostMapping("/postPro")
	public ResponseEntity<Product> postProduct(@RequestBody Product p) {
		String url="http://zuul/saveInven/savePro";
		Product msg=rs.postForObject(url, p, Product.class);
		return new ResponseEntity<Product>(msg,HttpStatus.CREATED);
	}
	
	@PostMapping("/postSup")
	public String postSupplier(@RequestBody Supplier s) {
		String url="http://zuul/saveInven/saveSup";
		String msg=rs.postForObject(url, s, String.class);
		return "supplier send";
	}
	
	@GetMapping("/getAllPro")
	public List getPro() {
		//String url="http://laptop-8alu92ns.mshome.net:1111/getPro";
		String url="http://zuul/saveInven/getPro";
		List msg=rs.getForObject(url, List.class);
		return msg;
	}
	
	@GetMapping("/getAllSup")
	public List getSup() {
		String url="http://zuul/saveInven/getSup";
		List msg=rs.getForObject(url, List.class);
		return msg;
	}
	
	@GetMapping("/getsingleCPRO/{id}")
	public Product getSingelPro(@PathVariable int id) {
		String url="http://zuul/saveInven/getSingelPro/"+id;
		Product msg=rs.getForObject(url, Product.class, ApiResponce.class);
		return msg;
	}
	
	@GetMapping("/getSingelCSUP/{id}")
	public Supplier getSingelSup(@PathVariable int id) {
		String url= "http://zuul/saveInven/getSingleSup/"+id;
		Supplier msg=rs.getForObject(url, Supplier.class);
		return msg;
	}

}
