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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	@Entity
	@Table(name="office")
	@JsonIgnoreProperties(value= {"salesRepresentatives"})
	public class Office  implements Serializable {

		
		private static final long serialVersionUID = -5011548524561982389L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="office_id")
		private int id;
		
		
		@Column(name="phone")
		private String phone;
		
		@OneToMany(mappedBy="office" ,fetch = FetchType.EAGER
		   ,cascade= { CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH})
		@JsonIgnore
		private List<SalesRepresentative> salesRepresentatives ;
		
	   @OneToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name = "address_id")
       private Address address;	
		
		
		public Office() {
			
		}

		public Office(String phone, List<SalesRepresentative> salesRepresentatives, Address address) {
			this.phone = phone;
			this.salesRepresentatives = salesRepresentatives;
			this.address = address;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public List<SalesRepresentative> getSalesRepresentatives() {
			return salesRepresentatives;
		}


		public void setSalesRepresentatives(List<SalesRepresentative> salesRepresentatives) {
			this.salesRepresentatives = salesRepresentatives;
		}


		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}
		
		public 	void addSalesRepresentative(SalesRepresentative tempSalesRepresentative) {
			if (salesRepresentatives == null) {
			
				@SuppressWarnings("unused")
				List<SalesRepresentative> salesRepresentatives = new ArrayList<SalesRepresentative>();
			}
			salesRepresentatives.add(tempSalesRepresentative);
		    tempSalesRepresentative.setOffice(this);    
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + id;
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((salesRepresentatives == null) ? 0 : salesRepresentatives.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Office other = (Office) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (id != other.id)
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (salesRepresentatives == null) {
				if (other.salesRepresentatives != null)
					return false;
			} else if (!salesRepresentatives.equals(other.salesRepresentatives))
				return false;
			return true;
		}
		
		
}
