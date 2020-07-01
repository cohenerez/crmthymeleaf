package com.erez.thymeleaf.crmthymeleaf.entity;


import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
@Table(name="customer")
public class Customer {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "sales_rep_employee_id")
	@SerializedName("id")
	@Expose
	private Integer id;
	
	
	@NotBlank(message= "pleace  insert company name ")
	@Size(min=3, max=32, message="First name must be between 3 and 32 characters")
	@Column(name="customerName")
	@SerializedName("customerName")
	@Expose
	private String customerName;
	
	@NotBlank(message= "pleace  insert last name ")
	@Size(min=3, max=32, message="First name must be between 3 and 32 characters")
	@Column(name="contact_last_name")
	@SerializedName("contactLastName")
	@Expose
	private String contactLastName;
	
	@NotBlank(message= "pleace  insert first name ")
	@Size(min=3, max=32, message="First name must be between 3 and 32 characters")
	@Column(name="contact_first_Name")
	@SerializedName("contactFirstName")
	@Expose
	private String contactFirstName;
	
	@NotNull
	@NotBlank(message= "pleace  insert phone number ")
	//@Pattern(regexp = "\\d{10}", message="Please enter valid phone number")
	@Column(name="phone")
	private String phone;
	
	@NotBlank(message= "pleace  insert email ")
	@NotNull
	@Email(message= "pleace  insert valid email ")
	@Column(name="email")
	private String email;
	
	
	@Digits(integer=6, fraction=2 ,message= "pleace  insert valit number ")
	@Column(name ="credit_limit")
	private BigDecimal creditLimit;
	
	
	@ManyToOne( cascade= { CascadeType.DETACH,CascadeType.MERGE, 
	                   CascadeType.PERSIST ,CascadeType.REFRESH} )
	@JoinColumn(name ="sales_rep_employee_id" )
	@NotNull
    @Valid
	private SalesRepresentative  salesRepresentative;

	
	 @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name = "address_id")
	 @NotNull
	 @Valid
	 private Address address;	
	
		
	public Customer() {
	
	}

	

	public Customer(Integer id, String customerName, String contactLastName, String contactFirstName, String phone,
			String email, BigDecimal creditLimit, SalesRepresentative salesRepresentative, Address address) {
	
		this.id = id;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.email = email;
		this.creditLimit = creditLimit;
		this.salesRepresentative = salesRepresentative;
		this.address = address;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

    

	public SalesRepresentative getSalesRepresentative() {
		return salesRepresentative;
	}



	public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

  

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
		
}





