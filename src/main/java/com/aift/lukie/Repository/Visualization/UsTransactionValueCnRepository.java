package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionValueCn;
import java.util.*;

@Repository
public interface UsTransactionValueCnRepository extends JpaRepository<UsTransactionValueCn,Integer>{
    List<UsTransactionValueCn> findAll();
}