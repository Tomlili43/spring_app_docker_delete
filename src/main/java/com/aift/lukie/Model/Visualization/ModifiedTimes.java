package com.aift.lukie.Model.Visualization;
import javax.persistence.*;
import java.io.Serializable;
import java.math.*;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="modified_times")
@Getter
public class ModifiedTimes implements Serializable {

    public ModifiedTimes(){}

    public <K> ModifiedTimes(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "datetime",columnDefinition = "varchar",nullable = false)
    private String datetime;
    @Column(name = "gmt_created",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtCreated;
    @Column(name = "gmt_modified",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtModified;
    @Id
    @Column(name = "id",columnDefinition = "int",nullable = false)
    private Integer id;
    @Column(name = "name",columnDefinition = "varchar",nullable = false)
    private String name;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " datetime: "+datetime+
    " gmt_created: "+gmtCreated+
    " gmt_modified: "+gmtModified+
    " id: "+id+
    " name: "+name+
            " }"    );}
    public ModifiedTimes setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
