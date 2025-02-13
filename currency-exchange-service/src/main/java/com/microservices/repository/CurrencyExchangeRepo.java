package com.microservices.repository;

import com.microservices.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {
}
