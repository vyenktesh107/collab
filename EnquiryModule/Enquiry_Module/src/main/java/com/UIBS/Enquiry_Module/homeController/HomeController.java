package com.UIBS.Enquiry_Module.homeController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.UIBS.Enquiry_Module.model.Enquiry;
import com.UIBS.Enquiry_Module.serviceI.HomeServiceI;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {
	
	@Autowired
	HomeServiceI hsi;
	
	@PostMapping(value="/saveEnquiry", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Enquiry> postEnquiry(@Valid @RequestBody Enquiry e){
		log.info("post method working");
		Enquiry eq=hsi.saveEnquiry(e);
		log.info("result" + e);
		return new ResponseEntity<Enquiry>(eq,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEnquiry")
	public ResponseEntity<Iterable<Enquiry>> getEnquiry(){
		log.info("get method executed");
		Iterable<Enquiry> eq = hsi.getEnquiry();
		log.info("enquiry get method execution complete");
		return new  ResponseEntity<Iterable<Enquiry>>(eq, HttpStatus.OK);
	}
	
	@PutMapping("/updateEnquiry/{id}")
	public ResponseEntity<Enquiry> updateEnquiry(@RequestBody Enquiry e, @PathVariable("id") Long id){
		
		List<String> li = new ArrayList<String>();
		Iterable<Enquiry> al = hsi.getEnquiry();
		
		for(Enquiry a: al) {
			li.add(a.getPancardNo());
		}
		
		if(e.getId()==id  && e.getPancardNo().equals(li.get(0))) {
			
			log.info("Update Enquiry put method execution started");
			Enquiry eq = hsi.updateEnquiry(e);
			log.info("Update Enquiry put method execution ended");
			
			return new ResponseEntity<Enquiry>(eq, HttpStatus.CREATED);
		}else {
			Enquiry eq = hsi.saveEnquiry(e);
			return new ResponseEntity<Enquiry>(eq,HttpStatus.CREATED);
		}
		
		
		
	}
	

}
