package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.CategoryCounts;
import java.util.*;

@Repository
public interface CategoryCountsRepository extends JpaRepository<CategoryCounts,Integer>{
    List<CategoryCounts> findAll();
}