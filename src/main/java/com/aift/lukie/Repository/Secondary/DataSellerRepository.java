package com.aift.lukie.Repository.Secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Secondary.DataSeller;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DataSellerRepository extends JpaRepository<DataSeller,String>{
    @Transactional
    Optional<DataSeller> findById(String id);
}
