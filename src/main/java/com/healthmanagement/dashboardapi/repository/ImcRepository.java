package com.healthmanagement.dashboardapi.repository;

import com.healthmanagement.dashboardapi.model.Imc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImcRepository extends MongoRepository<Imc, String> {

}
