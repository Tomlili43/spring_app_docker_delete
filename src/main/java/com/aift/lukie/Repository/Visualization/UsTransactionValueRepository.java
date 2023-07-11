package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionValue;
import java.util.*;

@Repository
public interface UsTransactionValueRepository extends JpaRepository<UsTransactionValue,Integer>{
    List<UsTransactionValue> findAll();
}