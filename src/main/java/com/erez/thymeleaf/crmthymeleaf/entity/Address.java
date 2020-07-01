package com.erez.thymeleaf.crmthymeleaf.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




	@Entity
	@Table(name="address")
	
	public class Address  implements Serializable {

		
		private static final long serialVersionUID = -5011548524561982389L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="address_id")
		private Integer id;
		
		
		@Column(name="city")
		@NotNull
		@NotBlank(message= "pleace  insert city name ")
		@Size(min=3, max=32, message="city name must be between 3 and 32 characters")
		private String city;
		
		
		@Column(name="street")
		@NotNull
		@NotBlank(message= "pleace  insert street name ")
		@Size(min=3, max=32, message="street name must be between 3 and 32 characters")
		private String street;
		
		
		@Column(name="state")
		@NotNull
		@NotBlank(message= "pleace  insert state name ")
		@Size(min=3, max=32, message="state name must be between 3 and 32 characters")
		private String state;
		
		@Column(name="zip")
		@NotNull
		@NotBlank(message= "pleace  insert zip number ")
		@Size(min=3, max=32, message="zip must be between 5 and 10 characters")
		private String zip;
		
		@Column(name ="country")
		@NotNull
		@NotBlank(message= "pleace  insert country name ")
		private String country;
				
		@Column(name ="territory")
		private String territory;

		
		public Address() {
			
		}





		public Address(Integer id ,String city, String street, String state, String zip, String country, String territory) {
			this.id = id;
			this.city = city;
			this.street = street;
			this.state = state;
			this.zip = zip;
			this.country = country;
			this.territory = territory;
		}





		public Integer getId() {
			return id;
		}





		public void setId(Integer id) {
			this.id = id;
		}





		public String getCity() {
			return city;
		}





		public void setCity(String city) {
			this.city = city;
		}





		public String getStreet() {
			return street;
		}





		public void setStreet(String street) {
			this.street = street;
		}





		public String getState() {
			return state;
		}





		public void setState(String state) {
			this.state = state;
		}





		public String getZip() {
			return zip;
		}





		public void setZip(String zip) {
			this.zip = zip;
		}





		public String getCountry() {
			return country;
		}





		public void setCountry(String country) {
			this.country = country;
		}





		public String getTerritory() {
			return territory;
		}





		public void setTerritory(String territory) {
			this.territory = territory;
		}
		
		
		
		
}
