package edu.uh.tech.cis3368.finalproject;

import org.springframework.data.repository.CrudRepository;

public interface DesignRepository extends CrudRepository<DesignEntity,Integer> {
    DesignEntity findDesignEntityByDesignId(int i);
}
