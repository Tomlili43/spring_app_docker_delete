package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UniqueProductsByMonth;
import java.util.*;

@Repository
public interface UniqueProductsByMonthRepository extends JpaRepository<UniqueProductsByMonth,Integer>{
    List<UniqueProductsByMonth> findAll();
}