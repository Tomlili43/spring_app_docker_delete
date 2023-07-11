package com.aift.lukie.Repository.Visualization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Visualization.UniqueProductsByMonthJs;
import java.util.*;

@Repository
public interface UniqueProductsByMonthJsRepository extends JpaRepository<UniqueProductsByMonthJs,Integer>{
    List<UniqueProductsByMonthJs> findAll();
}