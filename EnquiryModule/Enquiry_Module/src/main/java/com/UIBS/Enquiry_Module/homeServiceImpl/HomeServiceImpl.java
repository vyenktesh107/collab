package com.UIBS.Enquiry_Module.homeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UIBS.Enquiry_Module.CustomeExceptionHandler.EnquiryNotSubmitException;
import com.UIBS.Enquiry_Module.homeRepositry.EnquiryRepositry;
import com.UIBS.Enquiry_Module.model.Enquiry;
import com.UIBS.Enquiry_Module.serviceI.HomeServiceI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HomeServiceImpl implements HomeServiceI{
	
	@Autowired
	EnquiryRepositry er;

	@Override
	public Enquiry saveEnquiry(Enquiry e) {
		log.info("Enquiry save executed");
		
		List<String> li = new ArrayList<String>();
		List<Enquiry> al = er.findAll();
		
		for(Enquiry a:al) {
			li.add(a.getPancardNo());
		}
		
//		if(li.contains(e.getPancardNo())) {
//			log.info("EnquiryNotSubmitException Started "+e.getPancardNo()+ "user already exist");
//			
//			throw new EnquiryNotSubmitException("Enquiry Already Exist");
//		}
//		else {
//			return er.save(e);
//		}
		
		return er.save(e);
		
	}

	@Override
	public Iterable<Enquiry> getEnquiry() {
		log.info("Enquiry get service executed");
		return er.findAll();
	}

	@Override
	public Enquiry updateEnquiry(Enquiry e) {
		log.info("Enquiry update service executed");
		return er.save(e);
	}

}
