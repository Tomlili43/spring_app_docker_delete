package com.aift.lukie.Repository.Fifth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Fifth.DataProduct;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DataProductRepositoryPb extends JpaRepository<DataProduct,Integer>{
    @Transactional
    List<DataProduct> findByProductId(String productId);

    @Transactional
    @Query("SELECT d FROM DataProduct d WHERE d.sellerId = ?1")
    List<DataProduct> findBySellerId(String sellerId);

    @Transactional
    @Query("SELECT d From DataProduct d WHERE d.productId= ?1 AND d.sellerId = ?2")
    List<DataProduct> findByProductIdAndSellerId(String productId,String sellerId);
}