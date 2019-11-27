package com.microservices.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepository extends JpaRepository<Quote, Integer>