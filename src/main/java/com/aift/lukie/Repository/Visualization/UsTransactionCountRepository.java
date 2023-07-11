package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionCount;
import java.util.*;

@Repository
public interface UsTransactionCountRepository extends JpaRepository<UsTransactionCount,Integer>{
    List<UsTransactionCount> findAll();
}