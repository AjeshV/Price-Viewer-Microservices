package com.microservices.dbservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "quotes", catalog = "test")
public class Quote {

    private Integer id;
    private String userName;
    private String Quote;
}