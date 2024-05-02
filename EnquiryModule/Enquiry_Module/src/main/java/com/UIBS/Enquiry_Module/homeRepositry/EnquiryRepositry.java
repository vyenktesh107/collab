package com.UIBS.Enquiry_Module.homeRepositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UIBS.Enquiry_Module.model.Enquiry;

@Repository
public interface EnquiryRepositry extends JpaRepository<Enquiry, Integer>{

}
