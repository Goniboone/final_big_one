package edu.uh.tech.cis3368.finalproject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleChartRepository extends CrudRepository<SaleChartEntity,Integer> {
}
