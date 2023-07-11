package com.aift.lukie.Model.Fourth;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;
import java.sql.Timestamp;

@Entity
@Table(name="seller")
@Getter
public class Seller implements Serializable {

    public Seller(){}

    public <K> Seller(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "amazon_name",columnDefinition = "varchar",nullable = true)
    private String amazonName;
    @Column(name = "company_address",columnDefinition = "varchar",nullable = true)
    private String companyAddress;
    @Column(name = "company_name",columnDefinition = "varchar",nullable = true)
    private String companyName;
    @Column(name = "country_code",columnDefinition = "char",nullable = true)
    private String countryCode;
    @Column(name = "created_time",columnDefinition = "timestamp",nullable = true)
    private Timestamp createdTime;
    @Column(name = "modified_time",columnDefinition = "timestamp",nullable = true)
    private Timestamp modifiedTime;
    @Column(name = "rating_num_12months",columnDefinition = "int",nullable = true)
    private Integer ratingNumOnetwomonths;
    @Column(name = "rating_num_1month",columnDefinition = "int",nullable = true)
    private Integer ratingNumOnemonth;
    @Column(name = "rating_num_3months",columnDefinition = "int",nullable = true)
    private Integer ratingNumThreemonths;
    @Column(name = "rating_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer ratingNumLifetime;
    @Id
    @Column(name = "seller_id",columnDefinition = "varchar",nullable = false)
    private String sellerId;
    @Column(name = "shop_description",columnDefinition = "text",nullable = true)
    private String shopDescription;
    @Column(name = "star1_num_12months",columnDefinition = "int",nullable = true)
    private Integer staroneNumOnetwomonths;
    @Column(name = "star1_num_1month",columnDefinition = "int",nullable = true)
    private Integer staroneNumOnemonth;
    @Column(name = "star1_num_3months",columnDefinition = "int",nullable = true)
    private Integer staroneNumThreemonths;
    @Column(name = "star1_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer staroneNumLifetime;
    @Column(name = "star1_percentage_12months",columnDefinition = "tinyint",nullable = true)
    private Integer staronePercentageOnetwomonths;
    @Column(name = "star1_percentage_1month",columnDefinition = "tinyint",nullable = true)
    private Integer staronePercentageOnemonth;
    @Column(name = "star1_percentage_3months",columnDefinition = "tinyint",nullable = true)
    private Integer staronePercentageThreemonths;
    @Column(name = "star1_percentage_lifetime",columnDefinition = "tinyint",nullable = true)
    private Integer staronePercentageLifetime;
    @Column(name = "star2_num_12months",columnDefinition = "int",nullable = true)
    private Integer startwoNumOnetwomonths;
    @Column(name = "star2_num_1month",columnDefinition = "int",nullable = true)
    private Integer startwoNumOnemonth;
    @Column(name = "star2_num_3months",columnDefinition = "int",nullable = true)
    private Integer startwoNumThreemonths;
    @Column(name = "star2_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer startwoNumLifetime;
    @Column(name = "star2_percentage_12months",columnDefinition = "tinyint",nullable = true)
    private Integer startwoPercentageOnetwomonths;
    @Column(name = "star2_percentage_1month",columnDefinition = "tinyint",nullable = true)
    private Integer startwoPercentageOnemonth;
    @Column(name = "star2_percentage_3months",columnDefinition = "tinyint",nullable = true)
    private Integer startwoPercentageThreemonths;
    @Column(name = "star2_percentage_lifetime",columnDefinition = "tinyint",nullable = true)
    private Integer startwoPercentageLifetime;
    @Column(name = "star3_num_12months",columnDefinition = "int",nullable = true)
    private Integer starthreeNumOnetwomonths;
    @Column(name = "star3_num_1month",columnDefinition = "int",nullable = true)
    private Integer starthreeNumOnemonth;
    @Column(name = "star3_num_3months",columnDefinition = "int",nullable = true)
    private Integer starthreeNumThreemonths;
    @Column(name = "star3_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer starthreeNumLifetime;
    @Column(name = "star3_percentage_12months",columnDefinition = "tinyint",nullable = true)
    private Integer starthreePercentageOnetwomonths;
    @Column(name = "star3_percentage_1month",columnDefinition = "tinyint",nullable = true)
    private Integer starthreePercentageOnemonth;
    @Column(name = "star3_percentage_3months",columnDefinition = "tinyint",nullable = true)
    private Integer starthreePercentageThreemonths;
    @Column(name = "star3_percentage_lifetime",columnDefinition = "tinyint",nullable = true)
    private Integer starthreePercentageLifetime;
    @Column(name = "star4_num_12months",columnDefinition = "int",nullable = true)
    private Integer starfourNumOnetwomonths;
    @Column(name = "star4_num_1month",columnDefinition = "int",nullable = true)
    private Integer starfourNumOnemonth;
    @Column(name = "star4_num_3months",columnDefinition = "int",nullable = true)
    private Integer starfourNumThreemonths;
    @Column(name = "star4_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer starfourNumLifetime;
    @Column(name = "star4_percentage_12months",columnDefinition = "tinyint",nullable = true)
    private Integer starfourPercentageOnetwomonths;
    @Column(name = "star4_percentage_1month",columnDefinition = "tinyint",nullable = true)
    private Integer starfourPercentageOnemonth;
    @Column(name = "star4_percentage_3months",columnDefinition = "tinyint",nullable = true)
    private Integer starfourPercentageThreemonths;
    @Column(name = "star4_percentage_lifetime",columnDefinition = "tinyint",nullable = true)
    private Integer starfourPercentageLifetime;
    @Column(name = "star5_num_12months",columnDefinition = "int",nullable = true)
    private Integer starfiveNumOnetwomonths;
    @Column(name = "star5_num_1month",columnDefinition = "int",nullable = true)
    private Integer starfiveNumOnemonth;
    @Column(name = "star5_num_3months",columnDefinition = "int",nullable = true)
    private Integer starfiveNumThreemonths;
    @Column(name = "star5_num_lifetime",columnDefinition = "int",nullable = true)
    private Integer starfiveNumLifetime;
    @Column(name = "star5_percentage_12months",columnDefinition = "tinyint",nullable = true)
    private Integer starfivePercentageOnetwomonths;
    @Column(name = "star5_percentage_1month",columnDefinition = "tinyint",nullable = true)
    private Integer starfivePercentageOnemonth;
    @Column(name = "star5_percentage_3months",columnDefinition = "tinyint",nullable = true)
    private Integer starfivePercentageThreemonths;
    @Column(name = "star5_percentage_lifetime",columnDefinition = "tinyint",nullable = true)
    private Integer starfivePercentageLifetime;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " amazon_name: "+amazonName+
    " company_address: "+companyAddress+
    " company_name: "+companyName+
    " country_code: "+countryCode+
    " created_time: "+createdTime+
    " modified_time: "+modifiedTime+
    " rating_num_12months: "+ratingNumOnetwomonths+
    " rating_num_1month: "+ratingNumOnemonth+
    " rating_num_3months: "+ratingNumThreemonths+
    " rating_num_lifetime: "+ratingNumLifetime+
    " seller_id: "+sellerId+
    " shop_description: "+shopDescription+
    " star1_num_12months: "+staroneNumOnetwomonths+
    " star1_num_1month: "+staroneNumOnemonth+
    " star1_num_3months: "+staroneNumThreemonths+
    " star1_num_lifetime: "+staroneNumLifetime+
    " star1_percentage_12months: "+staronePercentageOnetwomonths+
    " star1_percentage_1month: "+staronePercentageOnemonth+
    " star1_percentage_3months: "+staronePercentageThreemonths+
    " star1_percentage_lifetime: "+staronePercentageLifetime+
    " star2_num_12months: "+startwoNumOnetwomonths+
    " star2_num_1month: "+startwoNumOnemonth+
    " star2_num_3months: "+startwoNumThreemonths+
    " star2_num_lifetime: "+startwoNumLifetime+
    " star2_percentage_12months: "+startwoPercentageOnetwomonths+
    " star2_percentage_1month: "+startwoPercentageOnemonth+
    " star2_percentage_3months: "+startwoPercentageThreemonths+
    " star2_percentage_lifetime: "+startwoPercentageLifetime+
    " star3_num_12months: "+starthreeNumOnetwomonths+
    " star3_num_1month: "+starthreeNumOnemonth+
    " star3_num_3months: "+starthreeNumThreemonths+
    " star3_num_lifetime: "+starthreeNumLifetime+
    " star3_percentage_12months: "+starthreePercentageOnetwomonths+
    " star3_percentage_1month: "+starthreePercentageOnemonth+
    " star3_percentage_3months: "+starthreePercentageThreemonths+
    " star3_percentage_lifetime: "+starthreePercentageLifetime+
    " star4_num_12months: "+starfourNumOnetwomonths+
    " star4_num_1month: "+starfourNumOnemonth+
    " star4_num_3months: "+starfourNumThreemonths+
    " star4_num_lifetime: "+starfourNumLifetime+
    " star4_percentage_12months: "+starfourPercentageOnetwomonths+
    " star4_percentage_1month: "+starfourPercentageOnemonth+
    " star4_percentage_3months: "+starfourPercentageThreemonths+
    " star4_percentage_lifetime: "+starfourPercentageLifetime+
    " star5_num_12months: "+starfiveNumOnetwomonths+
    " star5_num_1month: "+starfiveNumOnemonth+
    " star5_num_3months: "+starfiveNumThreemonths+
    " star5_num_lifetime: "+starfiveNumLifetime+
    " star5_percentage_12months: "+starfivePercentageOnetwomonths+
    " star5_percentage_1month: "+starfivePercentageOnemonth+
    " star5_percentage_3months: "+starfivePercentageThreemonths+
    " star5_percentage_lifetime: "+starfivePercentageLifetime+
            " }"    );}
    public Seller setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
