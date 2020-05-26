package com.erez.thymeleaf.crmthymeleaf.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"code",
	"name"
})
public class State {

	@JsonProperty("code")
	private String code;
	@JsonProperty("name")
	private String name;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public State() {
	}

	
	public State(String code, String name) {
		
		this.code = code;
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

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
		
	}

}