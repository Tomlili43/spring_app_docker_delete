package com.aift.lukie.Repository.Fourth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Fourth.AsinBasicInfo;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AsinBasicInfoRepository extends JpaRepository<AsinBasicInfo,String>{

    @Query("SELECT a FROM AsinBasicInfo a WHERE a.productId = :productId")
    AsinBasicInfo findByProductId(@Param("productId") String productId);

    @Query("SELECT a FROM AsinBasicInfo a WHERE a.sellerId = :sellerId")
    List<AsinBasicInfo> findBySellerId(@Param("sellerId") String sellerId);

    @Query("SELECT a FROM AsinBasicInfo a WHERE a.productId = :productId AND a.sellerId = :sellerId")
    List<AsinBasicInfo> findByProductIdAndSellerId(@Param("productId") String productId, @Param("sellerId") String sellerId);
    
}