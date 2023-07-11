package com.aift.lukie.Model.Visualization;
import javax.persistence.*;
import java.io.Serializable;
import java.math.*;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="us_transaction_value")
@Getter
public class UsTransactionValue implements Serializable {

    public UsTransactionValue(){}

    public <K> UsTransactionValue(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
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
    @Column(name = "valueofgoodsusd",columnDefinition = "bigint",nullable = false)
    private BigInteger valueofgoodsusd;
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
    " valueofgoodsusd: "+valueofgoodsusd+
    " week: "+week+
    " year: "+year+
            " }"    );}
    public UsTransactionValue setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
