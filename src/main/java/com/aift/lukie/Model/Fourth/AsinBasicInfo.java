package com.aift.lukie.Model.Fourth;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="asin_basic_info")
@Getter
public class AsinBasicInfo implements Serializable {

    public AsinBasicInfo(){}

    public <K> AsinBasicInfo(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "1starpercentage",columnDefinition = "tinyint",nullable = true)
    private Integer onestarpercentage;
    @Column(name = "2starpercentage",columnDefinition = "tinyint",nullable = true)
    private Integer twostarpercentage;
    @Column(name = "3starpercentage",columnDefinition = "tinyint",nullable = true)
    private Integer threestarpercentage;
    @Column(name = "4starpercentage",columnDefinition = "tinyint",nullable = true)
    private Integer fourstarpercentage;
    @Column(name = "5starpercentage",columnDefinition = "tinyint",nullable = true)
    private Integer fivestarpercentage;
    @Column(name = "best_sellers_rank",columnDefinition = "varchar",nullable = true)
    private String bestSellersRank;
    @Column(name = "brand_name",columnDefinition = "varchar",nullable = true)
    private String brandName;
    @Column(name = "category",columnDefinition = "varchar",nullable = true)
    private String category;
    @Column(name = "category_1",columnDefinition = "varchar",nullable = true)
    private String categoryOne;
    @Column(name = "category_10",columnDefinition = "varchar",nullable = true)
    private String categoryOnezero;
    @Column(name = "category_2",columnDefinition = "varchar",nullable = true)
    private String categoryTwo;
    @Column(name = "category_3",columnDefinition = "varchar",nullable = true)
    private String categoryThree;
    @Column(name = "category_4",columnDefinition = "varchar",nullable = true)
    private String categoryFour;
    @Column(name = "category_5",columnDefinition = "varchar",nullable = true)
    private String categoryFive;
    @Column(name = "category_6",columnDefinition = "varchar",nullable = true)
    private String categorySix;
    @Column(name = "category_7",columnDefinition = "varchar",nullable = true)
    private String categorySeven;
    @Column(name = "category_8",columnDefinition = "varchar",nullable = true)
    private String categoryEight;
    @Column(name = "category_9",columnDefinition = "varchar",nullable = true)
    private String categoryNine;
    @Column(name = "color",columnDefinition = "varchar",nullable = true)
    private String color;
    @Column(name = "country_of_origin",columnDefinition = "varchar",nullable = true)
    private String countryOfOrigin;
    @Column(name = "created_time",columnDefinition = "timestamp",nullable = true)
    private Timestamp createdTime;
    @Column(name = "date_first_available",columnDefinition = "varchar",nullable = true)
    private String dateFirstAvailable;
    @Column(name = "description",columnDefinition = "longtext",nullable = true)
    private String description;
    @Column(name = "discount",columnDefinition = "float",nullable = true)
    private Float discount;
    @Column(name = "features_bullet",columnDefinition = "text",nullable = true)
    private String featuresBullet;
    @Column(name = "is_discontinued_by_manufacturer",columnDefinition = "varchar",nullable = true)
    private String isDiscontinuedByManufacturer;
    @Column(name = "item_weight",columnDefinition = "float",nullable = true)
    private Float itemWeight;
    @Column(name = "item_weight_unit",columnDefinition = "varchar",nullable = true)
    private String itemWeightUnit;
    @Column(name = "manufacturer",columnDefinition = "varchar",nullable = true)
    private String manufacturer;
    @Column(name = "material",columnDefinition = "varchar",nullable = true)
    private String material;
    @Column(name = "modified_time",columnDefinition = "timestamp",nullable = true)
    private Timestamp modifiedTime;
    @Column(name = "package_weight",columnDefinition = "float",nullable = true)
    private Float packageWeight;
    @Column(name = "package_weight_unit",columnDefinition = "varchar",nullable = true)
    private String packageWeightUnit;
    @Column(name = "price",columnDefinition = "float",nullable = true)
    private Float price;
    @Id
    @Column(name = "product_id",columnDefinition = "varchar",nullable = false)
    private String productId;
    @Column(name = "rank_1",columnDefinition = "int",nullable = true)
    private Integer rankOne;
    @Column(name = "rank_2",columnDefinition = "int",nullable = true)
    private Integer rankTwo;
    @Column(name = "rank_3",columnDefinition = "int",nullable = true)
    private Integer rankThree;
    @Column(name = "rank_4",columnDefinition = "int",nullable = true)
    private Integer rankFour;
    @Column(name = "rating",columnDefinition = "float",nullable = true)
    private Float rating;
    @Column(name = "rating_count",columnDefinition = "int",nullable = true)
    private Integer ratingCount;
    @Column(name = "seller",columnDefinition = "varchar",nullable = true)
    private String seller;
    @Column(name = "seller_id",columnDefinition = "varchar",nullable = true)
    private String sellerId;
    @Column(name = "sellerhref",columnDefinition = "varchar",nullable = true)
    private String sellerhref;
    @Column(name = "shipper",columnDefinition = "varchar",nullable = true)
    private String shipper;
    @Column(name = "subcategory_1",columnDefinition = "varchar",nullable = true)
    private String subcategoryOne;
    @Column(name = "subcategory_2",columnDefinition = "varchar",nullable = true)
    private String subcategoryTwo;
    @Column(name = "subcategory_3",columnDefinition = "varchar",nullable = true)
    private String subcategoryThree;
    @Column(name = "subcategory_4",columnDefinition = "varchar",nullable = true)
    private String subcategoryFour;
    @Column(name = "title",columnDefinition = "text",nullable = true)
    private String title;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " 1starpercentage: "+onestarpercentage+
    " 2starpercentage: "+twostarpercentage+
    " 3starpercentage: "+threestarpercentage+
    " 4starpercentage: "+fourstarpercentage+
    " 5starpercentage: "+fivestarpercentage+
    " best_sellers_rank: "+bestSellersRank+
    " brand_name: "+brandName+
    " category: "+category+
    " category_1: "+categoryOne+
    " category_10: "+categoryOnezero+
    " category_2: "+categoryTwo+
    " category_3: "+categoryThree+
    " category_4: "+categoryFour+
    " category_5: "+categoryFive+
    " category_6: "+categorySix+
    " category_7: "+categorySeven+
    " category_8: "+categoryEight+
    " category_9: "+categoryNine+
    " color: "+color+
    " country_of_origin: "+countryOfOrigin+
    " created_time: "+createdTime+
    " date_first_available: "+dateFirstAvailable+
    " description: "+description+
    " discount: "+discount+
    " features_bullet: "+featuresBullet+
    " is_discontinued_by_manufacturer: "+isDiscontinuedByManufacturer+
    " item_weight: "+itemWeight+
    " item_weight_unit: "+itemWeightUnit+
    " manufacturer: "+manufacturer+
    " material: "+material+
    " modified_time: "+modifiedTime+
    " package_weight: "+packageWeight+
    " package_weight_unit: "+packageWeightUnit+
    " price: "+price+
    " product_id: "+productId+
    " rank_1: "+rankOne+
    " rank_2: "+rankTwo+
    " rank_3: "+rankThree+
    " rank_4: "+rankFour+
    " rating: "+rating+
    " rating_count: "+ratingCount+
    " seller: "+seller+
    " seller_id: "+sellerId+
    " sellerhref: "+sellerhref+
    " shipper: "+shipper+
    " subcategory_1: "+subcategoryOne+
    " subcategory_2: "+subcategoryTwo+
    " subcategory_3: "+subcategoryThree+
    " subcategory_4: "+subcategoryFour+
    " title: "+title+
            " }"    );}
    public AsinBasicInfo setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
