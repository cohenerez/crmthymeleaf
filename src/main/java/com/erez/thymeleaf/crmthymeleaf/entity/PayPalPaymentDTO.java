
package com.erez.thymeleaf.crmthymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayPalPaymentDTO {

	private double price;
	private String currency;
	private String method;
	private String intent;
	private String description;

}
