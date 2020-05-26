package com.erez.thymeleaf.crmthymeleaf.entity;

import java.io.Serializable;

public class StateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public StateDTO() {
	}

	public StateDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}