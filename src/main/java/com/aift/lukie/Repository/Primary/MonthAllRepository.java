package com.aift.lukie.Repository.Primary;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aift.lukie.Model.Primary.MonthAll;
import com.aift.lukie.Model.Primary.MonthAllId;
/**
 *  how to use pagination and define the the variable paginable? 
 *  /// Pageable pageable = PageRequest.of(0,10);
 *  /// of(int page, int size, Sort sort);
 *  /// Pageable pageable = PageRequest.of(0, 10, Sort.by("lastName").ascending());
 *  /// Pageable pageable = PageRequest.ofSize(10);
 *  /// Pageable pageable = PageRequest.first();
 */
@Repository
public interface MonthAllRepository extends JpaRepository<MonthAll, MonthAllId>{

    @SuppressWarnings("unchecked")
    MonthAll save(MonthAll monthAll);

    @Query("SELECT m FROM MonthAll m WHERE m.productId = :productId")
    List<MonthAll> findByProductId(@Param("productId") String productId);

    @Query("SELECT m FROM MonthAll m WHERE m.productId = :productId")
    List<MonthAll> findByProductId(@Param("productId") String productId, Pageable pageable);

    @Query("SELECT m FROM MonthAll m WHERE m.productId = :productId AND m.month = :month AND m.year = :year")
    MonthAll findByProductIdAndMonthAndYear(@Param("productId") String productId, 
                                                   @Param("month") int month, 
                                                   @Param("year") int year);
    Page<MonthAll> findAll(Pageable pageable);

    @Query("SELECT DISTINCT m.productId FROM MonthAll m")
    List<String> findAllDistinctProductIds();
}
