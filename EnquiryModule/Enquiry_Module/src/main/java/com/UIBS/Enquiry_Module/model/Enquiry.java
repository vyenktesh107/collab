package com.UIBS.Enquiry_Module.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min = 4, message="Enter your full name and must be of min 4 characters" )
	private String enquiryName;
	
	
	@Min(23)
	private int age;
	
	@NotEmpty
	@Email(message = "Email address is not valid")
	private String email;
	
//	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number Should be of 10 digits.")
	private long mobileNo;
	
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Pan Card Must be like Ex. ABCDE1234Q")
	private String pancardNo;
	
	@NotEmpty
	private String remark;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CibilScore cibilScore;
}
