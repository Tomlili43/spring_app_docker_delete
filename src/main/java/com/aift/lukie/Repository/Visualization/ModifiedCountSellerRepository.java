package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.ModifiedCountSeller;

@Repository
public interface ModifiedCountSellerRepository extends JpaRepository<ModifiedCountSeller,Integer>{
}