package com.aift.lukie.Model.Visualization;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="us_transaction_volume")
@Getter
public class UsTransactionVolume implements Serializable {

    public UsTransactionVolume(){}

    public <K> UsTransactionVolume(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "gmt_created",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtCreated;
    @Column(name = "gmt_modified",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtModified;
    @Id
    @Column(name = "id",columnDefinition = "int",nullable = false)
    private Integer id;
    @Column(name = "volumeteu",columnDefinition = "int",nullable = false)
    private Integer volumeteu;
    @Column(name = "week",columnDefinition = "varchar",nullable = false)
    private String week;
    @Column(name = "year",columnDefinition = "varchar",nullable = false)
    private String year;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " gmt_created: "+gmtCreated+
    " gmt_modified: "+gmtModified+
    " id: "+id+
    " volumeteu: "+volumeteu+
    " week: "+week+
    " year: "+year+
            " }"    );}
    public UsTransactionVolume setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
