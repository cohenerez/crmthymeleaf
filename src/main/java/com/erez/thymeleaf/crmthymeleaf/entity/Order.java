package com.erez.thymeleaf.crmthymeleaf.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderNumber")
	Integer orderNumber;
	
	@Column(name="orderDate")
	Date orderDate;
	
	@Column(name="requiredDate")
	Date requiredDate;
	
	@Column(name="status")
	String status;
	
	@Column(name="comments")
	String comments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name ="id" )
	Customer customer;

}
