package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.CategoryTimeCoverage;
import java.util.*;

@Repository
public interface CategoryTimeCoverageRepository extends JpaRepository<CategoryTimeCoverage,Integer>{
    List<CategoryTimeCoverage> findAll();
}