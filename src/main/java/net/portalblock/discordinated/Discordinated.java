package net.portalblock.discordinated;

import lombok.Getter;
import net.portalblock.discordinated.rest.discord.DiscordService;
import net.portalblock.discordinated.rest.oauth2.AccessToken;
import net.portalblock.discordinated.rest.oauth2.OAuth2Service;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Discordinated {

    private OAuth2Service oAuthService;

    @Getter private DiscordService discordService;

    private String baseUrl, userAgent;

    public Discordinated setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public Discordinated setUserAgent(String userAgent) {
        if(!userAgent.matches("^DiscordBot \\((.)+, (.)+\\)"))
            throw new RuntimeException("Invalid User-Agent format. " + userAgent + " does not match 'DiscordBot ($url, $versionNumber)'");
        this.userAgent = userAgent;
        return this;
    }

    public OAuth2Service buildOAuth2Service() {
        if(oAuthService == null) {
            if(baseUrl == null)
                throw new NullPointerException("No base URL set.");
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            oAuthService = retrofit.create(OAuth2Service.class);
        }
        return oAuthService;
    }

    public DiscordService buildDiscordinatedService(final AccessToken accessToken, Interceptor... interceptors) {
        if(discordService == null) {
            if(accessToken == null)
                throw new NullPointerException("Authentication token is empty.");
            //Credit: https://futurestud.io/blog/oauth-2-on-android-with-retrofit
            Retrofit.Builder retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create());
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken())
                            .header("User-Agent", userAgent)
                            .method(original.method(), original.body());
                    return chain.proceed(requestBuilder.build());
            });
            for(Interceptor i : interceptors)
                httpClient.addInterceptor(i);
            discordService = (retrofit.client(httpClient.build()).build()).create(DiscordService.class);
            //End Credit: https://futurestud.io/blog/oauth-2-on-android-with-retrofit
        }
        return discordService;
    }

}
