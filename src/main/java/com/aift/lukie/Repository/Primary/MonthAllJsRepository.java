package com.aift.lukie.Repository.Primary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.aift.lukie.Model.Primary.MonthAllJs;
import com.aift.lukie.Model.Primary.MonthAllJsId;


@Repository
public interface MonthAllJsRepository extends JpaRepository<MonthAllJs,MonthAllJsId>{
    @SuppressWarnings("unchecked")
    MonthAllJs save(MonthAllJs monthAllJs);

    @Query("SELECT m FROM MonthAllJs m WHERE m.productId = :productId")
    List<MonthAllJs> findByProductId(@Param("productId") String productId);

    @Query("SELECT m FROM MonthAllJs m WHERE m.productId = :productId")
    List<MonthAllJs> findByProductId(@Param("productId") String productId, Pageable pageable);

    @Query("SELECT m FROM MonthAllJs m WHERE m.productId = :productId AND m.month = :month AND m.year = :year")
    MonthAllJs findByProductIdAndMonthAndYear(@Param("productId") String productId, 
                                                   @Param("month") int month, 
                                                   @Param("year") int year);
    Page<MonthAllJs> findAll(Pageable pageable);

    @Query("SELECT DISTINCT m.productId FROM MonthAllJs m")
    List<String> findAllDistinctProductIds();
}