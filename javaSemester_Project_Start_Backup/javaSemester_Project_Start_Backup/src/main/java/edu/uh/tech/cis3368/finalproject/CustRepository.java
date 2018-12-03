package edu.uh.tech.cis3368.finalproject;

import org.springframework.data.repository.CrudRepository;

public interface CustRepository extends CrudRepository<CustomerEntity,Integer> {
}
