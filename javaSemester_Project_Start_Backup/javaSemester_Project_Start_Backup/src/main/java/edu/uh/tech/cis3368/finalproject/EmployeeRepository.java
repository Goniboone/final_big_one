package edu.uh.tech.cis3368.finalproject;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {
}
