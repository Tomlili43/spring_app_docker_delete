package com.aift.lukie.Repository.Fifth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Fifth.DataMonth;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DataMonthRepositoryPb extends JpaRepository<DataMonth,Integer>{
    
    @Transactional
    List<DataMonth> findByProductId(String productId);

    @Transactional
    @Query("SELECT d FROM DataMonth d WHERE d.sellerId = ?1")
    List<DataMonth> findBySellerId(String sellerId);

    @Transactional
    @Query("SELECT d From DataMonth d WHERE d.productId= ?1 AND d.sellerId = ?2")
    List<DataMonth> findByProductIdAndSellerId(String productId,String sellerId);
}