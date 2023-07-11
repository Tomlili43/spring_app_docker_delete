package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.ModifiedCountSellerPb;

@Repository
public interface ModifiedCountSellerPbRepository extends JpaRepository<ModifiedCountSellerPb,Integer>{
}