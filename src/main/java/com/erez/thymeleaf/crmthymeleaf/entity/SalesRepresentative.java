package com.erez.thymeleaf.crmthymeleaf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="salesrepresentative")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "office_id")
public class SalesRepresentative implements Serializable {

	
	

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sales_rep_employee_id")
	private Integer id;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="extension")
	private String extension;
	
	@Column(name="email")
	private String email;
	
	
		
	@Column(name="job_title")
	private String jobTitle;

	
	
	@Column(name="reports_to")
	private int reportsTo;
	
	@ManyToOne( cascade= { CascadeType.DETACH,CascadeType.MERGE, 
            CascadeType.PERSIST ,CascadeType.REFRESH} )
    @JoinColumn(name ="office_id" )
	private Office office;

	
	@OneToMany(mappedBy="salesRepresentative",fetch = FetchType.LAZY
			,cascade= { CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH})
	@JsonIgnore
	private List<Customer> customers ;
	
		
	
	public SalesRepresentative() {
		
	}

	
	
	public SalesRepresentative(String lastName, String firstName, String extension, String email, Office office,
			String jobTitle, int reportsTo) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
	}

	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	public int getReportsTo() {
		return reportsTo;
	}


	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}


	
	
	public Office getOffice() {
		return office;
	}



	public void setOffice(Office office) {
		this.office = office;
	}



	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@SuppressWarnings("unused")
	public 	void addCustomer(Customer theCustomer) {
		if (customers== null) {
		
			List<Customer> customers = new ArrayList<Customer>();
		}
		customers.add(theCustomer);
		theCustomer.setSalesRepresentative(this);
	}




}





