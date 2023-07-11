package com.aift.lukie.Model.Fifth;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;

@Entity
@Table(name="data_month", uniqueConstraints = {
    @UniqueConstraint(name ="data_month_product_id_seller_id_year_month_a72443a2_uniq", columnNames = {"product_id","seller_id","year","month"})
})
@Getter
public class DataMonth implements Serializable {

    public DataMonth(){}

    public <K> DataMonth(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "category",columnDefinition = "varchar",nullable = true)
    private String category;
    @Column(name = "created_datetime",columnDefinition = "datetime",nullable = false)
    private Date createdDatetime;
    @Column(name = "end_price",columnDefinition = "double",nullable = true)
    private Double endPrice;
    @Id
    @Column(name = "id",columnDefinition = "bigint",nullable = false)
    private Integer id;
    @Column(name = "last_price",columnDefinition = "double",nullable = true)
    private Double lastPrice;
    @Column(name = "modified_datetime",columnDefinition = "datetime",nullable = false)
    private Date modifiedDatetime;
    @Column(name = "month",columnDefinition = "int",nullable = true)
    private Integer month;
    @Column(name = "price",columnDefinition = "double",nullable = true)
    private Double price;
    @Column(name = "product_id",columnDefinition = "varchar",nullable = false)
    private String productId;
    @Column(name = "rank",columnDefinition = "int",nullable = true)
    private Integer rank;
    @Column(name = "rating",columnDefinition = "double",nullable = true)
    private Double rating;
    @Column(name = "revenue",columnDefinition = "double",nullable = true)
    private Double revenue;
    @Column(name = "review",columnDefinition = "int",nullable = true)
    private Integer review;
    @Column(name = "review_increase",columnDefinition = "int",nullable = true)
    private Integer reviewIncrease;
    @Column(name = "review_rate",columnDefinition = "double",nullable = true)
    private Double reviewRate;
    @Column(name = "sales",columnDefinition = "int",nullable = true)
    private Integer sales;
    @Column(name = "seller_id",columnDefinition = "varchar",nullable = true)
    private String sellerId;
    @Column(name = "stock",columnDefinition = "int",nullable = true)
    private Integer stock;
    @Column(name = "year",columnDefinition = "int",nullable = true)
    private Integer year;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " category: "+category+
    " created_datetime: "+createdDatetime+
    " end_price: "+endPrice+
    " id: "+id+
    " last_price: "+lastPrice+
    " modified_datetime: "+modifiedDatetime+
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
    " seller_id: "+sellerId+
    " stock: "+stock+
    " year: "+year+
            " }"    );}
    public DataMonth setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
