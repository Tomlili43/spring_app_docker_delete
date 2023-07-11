package com.aift.lukie.Model.Teritary;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import lombok.Getter;

import static com.aift.lukie.utilities.Utils.*;


@Entity
@Table(name="seller_token")
@Getter
public class SellerToken implements Serializable {

    public SellerToken(){}

    public <K> SellerToken(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String,K> entry:other.entrySet()){
            setElements(this,entry.getKey(),entry.getValue());
        }
    }
    @Column(name = "seller_id",columnDefinition = "varchar",nullable = false)
    private String sellerId;
    @Column(name = "selling_partner_id",columnDefinition = "varchar",nullable = true)
    private String sellingPartnerId;
    @Column(name = "spapi_oauth_code",columnDefinition = "varchar",nullable = true)
    private String spapiOauthCode;
    @Column(name = "redirect_uri",columnDefinition = "longtext",nullable = true)
    private String redirectUri;
    @Column(name = "platform",columnDefinition = "varchar",nullable = true)
    private String platform;
    @Column(name = "expires_in",columnDefinition = "bigint",nullable = true)
    private Integer expiresIn;
    @Column(name = "token_type",columnDefinition = "text",nullable = true)
    private String tokenType;
    @Column(name = "access_token",columnDefinition = "longtext",nullable = true)
    private String accessToken;
    @Column(name = "refresh_token",columnDefinition = "longtext",nullable = true)
    private String refreshToken;
    @Id
    @Column(name = "create_token_time",columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTokenTime;

    @Override
    public String toString(){
        return String.format(
            "{"+
    " seller_id: "+sellerId+
    " seller_partner_id: "+sellingPartnerId+
    " spapi_oauth_code: "+spapiOauthCode+
    " redirect_uri"+redirectUri+
    " platform: "+platform+
    " expires_in: "+expiresIn+
    " token_types: "+tokenType+
    " access_token: "+accessToken+
    " refresh_token: "+refreshToken+
    " create_token_time: "+createTokenTime+
            " }"    );}
    public SellerToken setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){
            setElements(this, entry.getKey(),entry.getValue());
        }
        return this;
    }
}
