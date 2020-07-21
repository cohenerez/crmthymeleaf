package com.erez.thymeleaf.crmthymeleaf.utils;

import lombok.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {

	@SerializedName("customerId")
	@Expose
	private Integer customerId;

	@SerializedName("customerName")
	@Expose
	private String customerName;

	@SerializedName("status")
	@Expose
	private String status;


}
