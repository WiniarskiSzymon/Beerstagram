package com.projects.bigswierku.beerstagram.Api

import com.projects.bigswierku.beerstagram.model.untapped.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface  UntappedService{

    @GET("beer/info/{param}")
    fun getBeerInfo (
            @Path("param") beerID : String,
            @Query("client_id")clientID: String,
            @Query("client_secret")clientSecret : String
    ): Single<BeerInfoRequest>

    @GET("thepub/local")
    fun getPubLocal (
            @Query("client_id")clientID: String,
            @Query("client_secret")clientSecret : String,
            @Query("lat")lat : String,
            @Query("lng")lng : String,
            @Query("dist_pref") dist_pref : String,
            @Query("max_id")lastId : String
    ):Single<PubLocalRequest>

     @GET
     fun getAuthorizationToken(
         @Url url:String,
         @Query("client_id")clientID: String,
         @Query("client_secret")clientSecret : String,
         @Query("response_type")responseType :String,
         @Query("redirect_url")redirectURL : String,
         @Query("code")code:String
     ):Single<TokenResponse>

    @GET("checkin/recent")
    fun getUserFeed(
        @Query("access_token")token : String
    ) : Single<UserFeedResponse>

    @GET("search/beer")
    fun searchBeer(
        @Query("client_id")clientID: String,
        @Query("client_secret")clientSecret : String,
        @Query("q")query : String,
        @Query ("offset") offset : String
    ):Single<BeerSearchResponse>
}
