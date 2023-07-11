package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionWeight;
import java.util.*;

@Repository
public interface UsTransactionWeightRepository extends JpaRepository<UsTransactionWeight,Integer>{
    List<UsTransactionWeight> findAll();
}