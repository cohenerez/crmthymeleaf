package com.erez.thymeleaf.crmthymeleaf.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name="productline")
class ProductLine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="productLine")
    private String productLine;

    @Column(name="textDescription")
     private String textDescription;

    @Column(name="htmlDescription")
    private String htmlDescription;

    @Column(name="image")
    private String image;
  


}
