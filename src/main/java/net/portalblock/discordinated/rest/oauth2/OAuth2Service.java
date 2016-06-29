package net.portalblock.discordinated.rest.oauth2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * Created by portalBlock on 6/27/2016.
 */
public interface OAuth2Service {

    //@GET("oauth2/authorize")
    //Call<AccessToken> authorize(@Field("client_id") String clientId, @Field("scope") String scope, @Field("permissions") int perms);

    @GET("oauth2/token")
    Call<AccessToken> getAccessToken(@Field("code") String code, @Field("grant_type") String grantType);

}
