package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UniqueProductsByMonthDmPb;

@Repository
public interface UniqueProductsByMonthDmPbRepository extends JpaRepository<UniqueProductsByMonthDmPb,Integer>{
}