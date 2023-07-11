
package com.aift.lukie.Model.Primary;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import static com.aift.lukie.utilities.Utils.*;

@Entity // Hibernate to make a table out of this class
@Table(name = "updatedTableTimeMonitor")
public class UpdatedTableTimeMonitor implements Serializable {

    ///constructor
    public UpdatedTableTimeMonitor(){}
    
    // /// duplicated constructor 
    // public <T,K> UpdatedTableTimeMonitor(HashMap<T,K> other){
    //     this.tableName=(String) other.get("tableName");
    //     this.modifiedTime=Timestamp.valueOf((String) other.get("modifiedTime"));
    //     this.modifiedTimeNineThree=Timestamp.valueOf((String) other.get("modifiedTimeNineThree"));
    // }

    /// duplicated constructor 
    public <K> UpdatedTableTimeMonitor(HashMap<String,K> other) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String, K> entry : other.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
    }


    /**
     * @Description :  primary key
     */
    @Id 
    @Column(name = "tableName", columnDefinition = "varchar(200)", nullable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message="cannot be empty")
    private String tableName;

    @Column(name = "modifiedTime", nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedTime;
    // private String modifiedTime;

    @Column(name = "modifiedTime93",nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedTimeNineThree;
    // private String modifiedTimeNineThree;

    public String getTableName(){
        return tableName;
    }

    public Timestamp getModifiedTime(){
        return modifiedTime;
    }

    public Timestamp getModifiedTimeNineThree(){
        return modifiedTimeNineThree;
    }

    public void setTableName(String tableName){
        this.tableName = tableName;
    }

    public void setmodifiedTime(Timestamp modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    public void setmodifiedTimeNineThree(Timestamp modifiedTimeNineThree){
        this.modifiedTimeNineThree = modifiedTimeNineThree;
    }

    @Override
    public String toString(){
        return String.format("{tableName: %s %n modifiedTime: %s %n modifiedTimeNineThree: %s %n}",tableName, modifiedTime,modifiedTimeNineThree);
    }
}
