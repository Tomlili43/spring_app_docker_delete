package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UniqueProductsByMonthDm;
import java.util.*;

@Repository
public interface UniqueProductsByMonthDmRepository extends JpaRepository<UniqueProductsByMonthDm,Integer>{
    List<UniqueProductsByMonthDm> findAll();
}