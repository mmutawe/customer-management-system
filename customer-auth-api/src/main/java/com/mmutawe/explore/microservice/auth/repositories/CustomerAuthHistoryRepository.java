package com.mmutawe.explore.microservice.auth.repositories;

import com.mmutawe.explore.microservice.auth.entities.CustomerAuthHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAuthHistoryRepository extends JpaRepository<CustomerAuthHistory, Long> {
}
