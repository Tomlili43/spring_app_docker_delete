package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.ModifiedCountAggProductAverageandsumPb;

@Repository
public interface ModifiedCountAggProductAverageandsumPbRepository extends JpaRepository<ModifiedCountAggProductAverageandsumPb,Integer>{
}