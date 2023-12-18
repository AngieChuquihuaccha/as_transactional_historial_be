package com.transactional.demo_soa.repository;

import com.transactional.demo_soa.domain.model.TransactionalSimple;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Optional;

public interface TransactionalSimpleRepository extends ReactiveCrudRepository<com.transactional.demo_soa.domain.model.TransactionalSimple, Integer> {

}
