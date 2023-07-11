package com.aift.lukie.Repository.Teritary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aift.lukie.Model.Teritary.SellerToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

@Repository
public interface SellerTokenRepository extends JpaRepository<SellerToken,String>{

    @Transactional
    @Modifying
    @Query("update SellerToken s set s.redirectUri = :redirectUri, s.platform = :platform, s.expiresIn = :expiresIn, s.tokenType = :tokenType, s.accessToken = :accessToken, s.refreshToken = :refreshToken, s.createTokenTime = :createTokenTime where s.sellingPartnerId = :sellingPartnerId")
    Integer updateSellerTokenByPartnerId(@Param("redirectUri") String redirectUri, @Param("platform") String platform, @Param("expiresIn") Integer expiresIn, @Param("tokenType") String tokenType, @Param("accessToken") String accessToken, @Param("refreshToken") String refreshToken, @Param("createTokenTime") Date createTokenTime, @Param("sellingPartnerId") String sellingPartnerId);
    
    @Transactional
    Optional<SellerToken> findBySellingPartnerId (String sellingPartnerId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO seller_token (seller_id, selling_partner_id, spapi_oauth_code, redirect_uri, platform, expires_in, token_type, access_token, refresh_token, create_token_time) "
            + "VALUES (:sellerId, :sellingPartnerId, :spapiOauthCode, :redirectUri, :platform, :expiresIn, :tokenType, :accessToken, :refreshToken, CURRENT_TIMESTAMP())", nativeQuery = true)
    Integer insertSellerToken(@Param("sellerId") String sellerId, @Param("sellingPartnerId") String sellingPartnerId, @Param("spapiOauthCode") String spapiOauthCode, @Param("redirectUri") String redirectUri,
                          @Param("platform") String platform, @Param("expiresIn") Integer expiresIn, @Param("tokenType") String tokenType, @Param("accessToken") String accessToken, @Param("refreshToken") String refreshToken);
    
                          
    SellerToken findFirstBySellingPartnerIdOrderByCreateTokenTimeDesc(@Param("sellingPartnerId") String sellingPartnerId);

}
