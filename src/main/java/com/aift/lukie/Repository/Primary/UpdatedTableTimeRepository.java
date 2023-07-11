package com.aift.lukie.Repository.Primary;

import com.aift.lukie.Model.Primary.UpdatedTableTimeMonitor;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UpdatedTableTimeRepository extends JpaRepository<UpdatedTableTimeMonitor, String>{

    UpdatedTableTimeMonitor save(String updatedTableTimeMonitor);
    // List<JpaRepository> findAll();
    
    @Query("SELECT t FROM UpdatedTableTimeMonitor t WHERE t.tableName = :tableName")
    UpdatedTableTimeMonitor findByTableName(@Param("tableName") String tableName);
    // JpaRepository<substantial entity,type of entity>

    List<UpdatedTableTimeMonitor> findAll();

    Page<UpdatedTableTimeMonitor> findAll(Pageable pageable);

}

