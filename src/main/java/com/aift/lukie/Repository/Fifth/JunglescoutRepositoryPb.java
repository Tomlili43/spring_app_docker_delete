
package com.aift.lukie.Repository.Fifth;

import com.aift.lukie.Model.Fifth.Junglescout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunglescoutRepositoryPb extends JpaRepository<Junglescout, String>{

    Junglescout save(String Junglescout);
    // List<JpaRepository> findAll();
    Junglescout findByid(String _id);
    // JpaRepository<substantial entity,type of entity>
}
