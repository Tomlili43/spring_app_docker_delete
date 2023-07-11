package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionCountCn;
import java.util.*;

@Repository
public interface UsTransactionCountCnRepository extends JpaRepository<UsTransactionCountCn,Integer>{
    List<UsTransactionCountCn> findAll();
}