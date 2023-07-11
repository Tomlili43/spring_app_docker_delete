package com.aift.lukie.Model.Primary;

import com.aift.lukie.Model.Primary.MonthAllJsId;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="month_all_js")
@IdClass(MonthAllJsId.class)
@Getter
public class MonthAllJs implements Serializable {

    public MonthAllJs(){}

    public <K> MonthAllJs(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "created_time",columnDefinition = "timestamp",nullable = true)
    private Timestamp createdTime;
    @Column(name = "end_price",columnDefinition = "decimal",nullable = true)
    private Double endPrice;
    @Column(name = "last_price",columnDefinition = "decimal",nullable = true)
    private Double lastPrice;
    @Id
    @Column(name = "month",columnDefinition = "tinyint",nullable = false)
    private Integer month;
    @Column(name = "price",columnDefinition = "decimal",nullable = true)
    private Double price;
    @Id
    @Column(name = "product_id",columnDefinition = "varchar",nullable = false)
    private String productId;
    @Column(name = "`rank`",columnDefinition = "int",nullable = true)
    private Integer rank;
    @Column(name = "rating",columnDefinition = "decimal",nullable = true)
    private Double rating;
    @Column(name = "revenue",columnDefinition = "decimal",nullable = true)
    private Double revenue;
    @Column(name = "review",columnDefinition = "int",nullable = true)
    private Integer review;
    @Column(name = "review_increase",columnDefinition = "int",nullable = true)
    private Integer reviewIncrease;
    @Column(name = "review_rate",columnDefinition = "decimal",nullable = true)
    private Double reviewRate;
    @Column(name = "sales",columnDefinition = "int",nullable = true)
    private Integer sales;
    @Column(name = "stock",columnDefinition = "int",nullable = true)
    private Integer stock;
    @Id
    @Column(name = "year",columnDefinition = "smallint",nullable = false)
    private Integer year;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " created_time: "+createdTime+
    " end_price: "+endPrice+
    " last_price: "+lastPrice+
    " month: "+month+
    " price: "+price+
    " product_id: "+productId+
    " rank: "+rank+
    " rating: "+rating+
    " revenue: "+revenue+
    " review: "+review+
    " review_increase: "+reviewIncrease+
    " review_rate: "+reviewRate+
    " sales: "+sales+
    " stock: "+stock+
    " year: "+year+
            " }"    );}
    public MonthAllJs setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
