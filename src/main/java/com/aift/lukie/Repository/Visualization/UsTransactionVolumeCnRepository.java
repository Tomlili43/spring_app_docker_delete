package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionVolumeCn;
import java.util.*;

@Repository
public interface UsTransactionVolumeCnRepository extends JpaRepository<UsTransactionVolumeCn,Integer>{
    List<UsTransactionVolumeCn> findAll();
}