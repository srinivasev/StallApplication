package com.learning.stall.repository;

import com.learning.stall.model.Stall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface StallRepository extends CrudRepository<Stall, Integer> {

    @Query("select s from Stall s where s.category = :category")
    Stall findByCategory(@Param("category") String category);
}


