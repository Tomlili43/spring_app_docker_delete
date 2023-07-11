package com.aift.lukie.Model.Visualization;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="unique_products_by_month_js")
@Getter
public class UniqueProductsByMonthJs implements Serializable {

    public UniqueProductsByMonthJs(){}

    public <K> UniqueProductsByMonthJs(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "category",columnDefinition = "varchar",nullable = false)
    private String category;
    @Column(name = "Count",columnDefinition = "int",nullable = false)
    private Integer count;
    @Column(name = "date",columnDefinition = "varchar",nullable = false)
    private String date;
    @Column(name = "gmt_created",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtCreated;
    @Column(name = "gmt_modified",columnDefinition = "timestamp",nullable = false)
    private Timestamp gmtModified;
    @Id
    @Column(name = "id",columnDefinition = "int",nullable = false)
    private Integer id;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " category: "+category+
    " Count: "+count+
    " date: "+date+
    " gmt_created: "+gmtCreated+
    " gmt_modified: "+gmtModified+
    " id: "+id+
            " }"    );}
    public UniqueProductsByMonthJs setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
