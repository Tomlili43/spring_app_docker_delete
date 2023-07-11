package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionWeightCn;
import java.util.*;

@Repository
public interface UsTransactionWeightCnRepository extends JpaRepository<UsTransactionWeightCn,Integer>{
    List<UsTransactionWeightCn> findAll();
}