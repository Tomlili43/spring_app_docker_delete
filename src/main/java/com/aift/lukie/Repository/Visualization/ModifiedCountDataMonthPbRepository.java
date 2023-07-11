package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.ModifiedCountDataMonthPb;

@Repository
public interface ModifiedCountDataMonthPbRepository extends JpaRepository<ModifiedCountDataMonthPb,Integer>{
}