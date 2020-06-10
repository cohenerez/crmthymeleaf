package com.erez.thymeleaf.crmthymeleaf.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 250)
	private String name;
	
	@Column(name = "sortname", nullable = false, length = 10)
	private String sortname;
	
	@Column(name = "region", nullable = false, length = 250)
	private String region;
	
	@Column(name = "phonecode", nullable = false, length = 10)
	private int phonecode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private Set<State> states = new HashSet<State>(0);

	public Country() {
	}

	public Country(String name,String sortname,int phonecode) {
		this.name = name;
		this.sortname =sortname;
		this.phonecode =phonecode;
		
	}

	public Country(String name,String sortname ,int phonecode,Set<State> states) {
		this.name = name;
		this.sortname = sortname;
		this.states = states;
		this.phonecode = phonecode;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	
	
	
	public int getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}

	
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}
