package com.aift.lukie.Model.Secondary;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;

@Entity
@Table(name="data_product", uniqueConstraints = {
    @UniqueConstraint(name ="data_product_product_id_seller_id_26833922_uniq", columnNames = {"product_id","seller_id"})
})
@Getter
public class DataProduct implements Serializable {

    public DataProduct(){}

    public <K> DataProduct(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "actag",columnDefinition = "varchar",nullable = true)
    private String actag;
    @Column(name = "avg_rev",columnDefinition = "double",nullable = true)
    private Double avgRev;
    @Column(name = "avg_sales",columnDefinition = "int",nullable = true)
    private Integer avgSales;
    @Column(name = "bbSeller",columnDefinition = "varchar",nullable = true)
    private String bbseller;
    @Column(name = "brand",columnDefinition = "varchar",nullable = true)
    private String brand;
    @Column(name = "bstag",columnDefinition = "bigint",nullable = true)
    private Integer bstag;
    @Column(name = "cat_id0",columnDefinition = "bigint",nullable = true)
    private Integer catIdzero;
    @Column(name = "cat_id1",columnDefinition = "bigint",nullable = true)
    private Integer catIdone;
    @Column(name = "cat_id2",columnDefinition = "bigint",nullable = true)
    private Integer catIdtwo;
    @Column(name = "cat_id3",columnDefinition = "bigint",nullable = true)
    private Integer catIdthree;
    @Column(name = "cat_id4",columnDefinition = "bigint",nullable = true)
    private Integer catIdfour;
    @Column(name = "cat_id5",columnDefinition = "bigint",nullable = true)
    private Integer catIdfive;
    @Column(name = "cat_id6",columnDefinition = "bigint",nullable = true)
    private Integer catIdsix;
    @Column(name = "category",columnDefinition = "varchar",nullable = true)
    private String category;
    @Column(name = "categoryPath",columnDefinition = "varchar",nullable = true)
    private String categorypath;
    @Column(name = "countryCode",columnDefinition = "varchar",nullable = true)
    private String countrycode;
    @Column(name = "created_datetime",columnDefinition = "datetime",nullable = false)
    private Date createdDatetime;
    @Column(name = "description",columnDefinition = "longtext",nullable = true)
    private String description;
    @Column(name = "est_sales",columnDefinition = "double",nullable = true)
    private Double estSales;
    @Column(name = "FBA_Fee",columnDefinition = "double",nullable = true)
    private Double fbaFee;
    @Column(name = "fund_rate",columnDefinition = "double",nullable = true)
    private Double fundRate;
    @Id
    @Column(name = "id",columnDefinition = "bigint",nullable = false)
    private Integer id;
    @Column(name = "image_url",columnDefinition = "varchar",nullable = true)
    private String imageUrl;
    @Column(name = "modified_datetime",columnDefinition = "datetime",nullable = false)
    private Date modifiedDatetime;
    @Column(name = "price",columnDefinition = "double",nullable = true)
    private Double price;
    @Column(name = "product_id",columnDefinition = "varchar",nullable = false)
    private String productId;
    @Column(name = "publish_date",columnDefinition = "int",nullable = true)
    private Integer publishDate;
    @Column(name = "publish_date_2",columnDefinition = "date",nullable = true)
    private Date publishDateTwo;
    @Column(name = "rank",columnDefinition = "int",nullable = true)
    private Integer rank;
    @Column(name = "reviews_30d",columnDefinition = "int",nullable = true)
    private Integer reviewsThreezerod;
    @Column(name = "sales2",columnDefinition = "double",nullable = true)
    private Double salestwo;
    @Column(name = "sales_rate",columnDefinition = "double",nullable = true)
    private Double salesRate;
    @Column(name = "seller_id",columnDefinition = "varchar",nullable = true)
    private String sellerId;
    @Column(name = "seller_num",columnDefinition = "int",nullable = true)
    private Integer sellerNum;
    @Column(name = "title",columnDefinition = "varchar",nullable = true)
    private String title;
    @Column(name = "varient_num",columnDefinition = "int",nullable = true)
    private Integer varientNum;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " actag: "+actag+
    " avg_rev: "+avgRev+
    " avg_sales: "+avgSales+
    " bbSeller: "+bbseller+
    " brand: "+brand+
    " bstag: "+bstag+
    " cat_id0: "+catIdzero+
    " cat_id1: "+catIdone+
    " cat_id2: "+catIdtwo+
    " cat_id3: "+catIdthree+
    " cat_id4: "+catIdfour+
    " cat_id5: "+catIdfive+
    " cat_id6: "+catIdsix+
    " category: "+category+
    " categoryPath: "+categorypath+
    " countryCode: "+countrycode+
    " created_datetime: "+createdDatetime+
    " description: "+description+
    " est_sales: "+estSales+
    " FBA_Fee: "+fbaFee+
    " fund_rate: "+fundRate+
    " id: "+id+
    " image_url: "+imageUrl+
    " modified_datetime: "+modifiedDatetime+
    " price: "+price+
    " product_id: "+productId+
    " publish_date: "+publishDate+
    " publish_date_2: "+publishDateTwo+
    " rank: "+rank+
    " reviews_30d: "+reviewsThreezerod+
    " sales2: "+salestwo+
    " sales_rate: "+salesRate+
    " seller_id: "+sellerId+
    " seller_num: "+sellerNum+
    " title: "+title+
    " varient_num: "+varientNum+
            " }"    );}
    public DataProduct setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
