package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UsTransactionVolume;
import java.util.*;

@Repository
public interface UsTransactionVolumeRepository extends JpaRepository<UsTransactionVolume,Integer>{
    List<UsTransactionVolume> findAll();
}