package com.aift.lukie.Model.Secondary;
import com.aift.lukie.utilities.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


// import lombok.Data;

// @Data
@Entity // Hibernate to make a table out of this class
@Table(name = "junglescout")
public class Junglescout implements Serializable{

        ///constructor
        public Junglescout(){}

        /// duplicated constructor 
        public <K> Junglescout(HashMap<String,K> other) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
            for (Map.Entry<String, K> entry : other.entrySet()){
                Utils.setElements(this, entry.getKey(),entry.getValue());
            }
        }

        /**
        * @Description --  primary key
        */
        @Id 
        @Column(name = "_id", columnDefinition = "varchar(200)", nullable = false)
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @NotEmpty(message="cannot be empty")
        private String _id;

        @Column(name = "nReviews", columnDefinition =  "double", nullable = true)
        private Double nReviews;
        
        @Column(name = "estimatedSales", columnDefinition =  "int", nullable = true)
        private Integer estimatedSales;

        @Column(name = "country", columnDefinition =  "varchar(50)", nullable = true)
        private String country;

        @Column(name = "state", columnDefinition =  "varchar(50)", nullable = true)
        private String state;

        @Lob
        @Column(name = "imageUrl", columnDefinition =  "longtext", nullable = true)
        private String imageUrl;

        @Lob
        @Column(name = "subCategories", columnDefinition =  "longtext", nullable = true)
        private List<Map<String,Object>> subCategories;

        @Column(name = "estRevenue", columnDefinition =  "double", nullable = true)
        private Double estRevenue;

        @Column(name = "rating", columnDefinition =  "double", nullable = true)
        private Boolean rating;
        
        @Column(name = "hasVariants", columnDefinition =  "varchar(50)", nullable = true)
        private Integer hasVariants;
        
        @Column(name = "rawCategory", columnDefinition =  "varchar(200)", nullable = true)
        private String rawCategory;
        
        @Column(name = "sellerName", columnDefinition =  "varchar(500)", nullable = true)
        private String sellerName;
        
        @Column(name = "nSellers", columnDefinition =  "int", nullable = true)
        private Integer nSellers;

        @Lob
        @Column(name = "VariantAsins", columnDefinition =  "longtext", nullable = true)
        private List<String> VariantAsins;
        
        @Column(name = "category", columnDefinition =  "varchar(200)", nullable = true)
        private String category;
        
        @Column(name = "isUnavailable", columnDefinition =  "varchar(50)", nullable = true)
        private Boolean isUnavailable;

        @Lob
        @Column(name = "name", columnDefinition =  "longtext", nullable = true)
        private String name;
        
        @Column(name = "listingQualityScore", columnDefinition =  "int", nullable = true)
        private Integer listingQualityScore;
        
        @Column(name = "sellerType", columnDefinition =  "varchar(200)", nullable = true)
        private String sellerType;
        
        @Column(name = "noParentCategory", columnDefinition =  "varchar(50)", nullable = true)
        private Boolean noParentCategory;
        
        @Column(name = "isSharedBSR", columnDefinition =  "varchar(50)", nullable = true)
        private Boolean isSharedBSR;

        @Column(name = "id", columnDefinition =  "varchar(200)", nullable = true)
        private String id;
        
        @Column(name = "calculatedCategory", columnDefinition =  "varchar(200)", nullable = true)
        private String calculatedCategory;
        
        @Column(name = "asin", columnDefinition =  "varchar(200)", nullable = true)
        private String asin;
        
        @Lob
        @Column(name = "brand", columnDefinition =  "longtext", nullable = true)
        private String brand;
        
        @Column(name = "scrapedParentAsin", columnDefinition =  "varchar(200)", nullable = true)
        private String scrapedParentAsin;
        
        @Column(name = "multipleSellers", columnDefinition =  "varchar(50)", nullable = true)
        private Boolean multipleSellers;
        
        @Column(name = "`rank`", columnDefinition =  "int", nullable = true)
        private Integer rank;
        
        @Column(name = "categoryCode", columnDefinition =  "varchar(200)", nullable = true)
        private String categoryCode;
        
        @Column(name = "pageAsin", columnDefinition =  "varchar(200)", nullable = true)
        private String pageAsin;
        
        @Column(name = "price", columnDefinition =  "double", nullable = true)
        private Double price;
        
        @Column(name = "variantAsinsCount", columnDefinition =  "int", nullable = true)
        private Integer variantAsinsCount;

        @Lob
        @Column(name = "sampleVariants", columnDefinition =  "longtext", nullable = true)
        private String sampleVariants;
        
        @Lob
        @Column(name = "product_url", columnDefinition =  "longtext", nullable = true)
        private String product_url;
        
        @Column(name = "bsr_product", columnDefinition =  "varchar(50)", nullable = true)
        private boolean bsr_product;

        @Lob
        @Column(name = "currency_code", columnDefinition =  "longtext", nullable = true)
        private String currency_code;
        
        @Column(name = "net", columnDefinition =  "double", nullable = true)
        private Double net;

        @Column(name = "fbaFee_feeBreakdown", columnDefinition =  "double", nullable = true)
        private Double fbaFee_feeBreakdown;
        
        @Column(name = "referralFee_feeBreakdown", columnDefinition =  "double", nullable = true)
        private Double referralFee_feeBreakdown;
        
        @Column(name = "variableClosingFee_feeBreakdown", columnDefinition =  "int", nullable = true)
        private Integer variableClosingFee_feeBreakdown;
        
        @Column(name = "totalFees_feeBreakdown", columnDefinition =  "double", nullable = true)
        private Double totalFees_feeBreakdown;
        
        @Lob
        @Column(name = "breadcrumbTree", columnDefinition =  "longtext", nullable = true)
        private String breadcrumbTree;
        
        @Column(name = "_timestamp", nullable = false, columnDefinition = "datetime")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Timestamp _timestamp;
        
        @Column(name = "estimatedListedAt", columnDefinition =  "datetime", nullable = true)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Timestamp estimatedListedAt;
        
        @Column(name = "fees", columnDefinition =  "float", nullable = true)
        private Float fees;

}       

