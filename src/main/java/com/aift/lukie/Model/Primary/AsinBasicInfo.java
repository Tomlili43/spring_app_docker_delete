package com.aift.lukie.Model.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;

@Entity // Hibernate to make a table out of this class
@Table(name = "asin_basic_info")
@IdClass(AsinBasicInfoId.class)
@Getter
public class AsinBasicInfo implements Serializable{
    
    //constructor
    public AsinBasicInfo(){}

    // duplicated constructor 
    public <K> AsinBasicInfo(HashMap<String,K> other) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String, K> entry : other.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
    }
    /**
     *  @Description -- primary key
     */
    @Id
    @Column(name = "_id", columnDefinition = "varchar(200)",nullable = false)
    @NotEmpty(message = "cannot be empty")
    private String id;

    @Id
    @Column(name = "_timestamp", columnDefinition = "timestamp default current_timestamp", nullable = false) 
    private Timestamp timestamp;
    
}
