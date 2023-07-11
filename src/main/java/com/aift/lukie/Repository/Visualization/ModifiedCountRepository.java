package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.ModifiedCount;
import java.util.*;

@Repository
public interface ModifiedCountRepository extends JpaRepository<ModifiedCount,Integer>{
    List<ModifiedCount> findAll();
}