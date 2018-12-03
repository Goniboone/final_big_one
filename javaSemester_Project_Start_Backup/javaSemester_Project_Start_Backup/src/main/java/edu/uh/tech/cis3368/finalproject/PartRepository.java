package edu.uh.tech.cis3368.finalproject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends CrudRepository<PartEntity, Integer> {
    PartEntity findByPartId(int i);
}
