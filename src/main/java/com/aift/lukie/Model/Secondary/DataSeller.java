package com.aift.lukie.Model.Secondary;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import static com.aift.lukie.utilities.Utils.*;
import lombok.Getter;

@Entity
@Table(name="data_seller")
@Getter
public class DataSeller implements Serializable {

    public DataSeller(){}

    public <K> DataSeller(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "address",columnDefinition = "longtext",nullable = true)
    private String address;
    @Column(name = "company_name",columnDefinition = "varchar",nullable = true)
    private String companyName;
    @Column(name = "company_name_abbreviation",columnDefinition = "varchar",nullable = true)
    private String companyNameAbbreviation;
    @Column(name = "company_name_chinese",columnDefinition = "varchar",nullable = true)
    private String companyNameChinese;
    @Column(name = "created_datetime",columnDefinition = "datetime",nullable = false)
    private Date createdDatetime;
    @Column(name = "description",columnDefinition = "longtext",nullable = true)
    private String description;
    @Id
    @Column(name = "id",columnDefinition = "varchar",nullable = false)
    private String id;
    @Column(name = "modified_datetime",columnDefinition = "datetime",nullable = false)
    private Date modifiedDatetime;
    @Override
    public String toString(){
        return String.format(
            "{"+
    " address: "+address+
    " company_name: "+companyName+
    " company_name_abbreviation: "+companyNameAbbreviation+
    " company_name_chinese: "+companyNameChinese+
    " created_datetime: "+createdDatetime+
    " description: "+description+
    " id: "+id+
    " modified_datetime: "+modifiedDatetime+
            " }"    );}
    public DataSeller setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
