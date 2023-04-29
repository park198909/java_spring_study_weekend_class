package org.koreait.repositories;

import org.koreait.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>,
        QuerydslPredicateExecutor<Address> {

}
