package com.aift.lukie.Repository.Fourth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aift.lukie.Model.Fourth.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,String>{

    @Query("SELECT s FROM Seller s WHERE s.sellerId = :sellerId")
    Seller findBySellerId(@Param("sellerId") String sellerId);
    
}