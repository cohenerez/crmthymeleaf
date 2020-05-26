package com.erez.thymeleaf.crmthymeleaf.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"name",
	"code",
	"states"
})
public class Country {

	@JsonProperty("name")
	private String name;
	@JsonProperty("code")
	private String code;
	@JsonProperty("states")
	private List<State> states = new ArrayList<State>();
	
	private int index;

		public Country() {
	}

	
	public Country(String name, String code, List<State> states,int index) {
		
		this.name = name;
		this.code = code;
		this.states = states;
		this.index= index;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("states")
	public List<State> getStates() {
	
		if(states != null)
		    return states;
		
		else return null;
	}

	@JsonProperty("states")
	public void setStates(List<State> states) {
		this.states = states;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	
	
}

	
	
