package net.portalblock.discordinated;

import com.google.gson.Gson;
import lombok.Getter;
import net.portalblock.discordinated.rest.discord.DiscordService;
import net.portalblock.discordinated.rest.oauth2.AccessToken;
import net.portalblock.discordinated.rest.oauth2.OAuth2Service;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Discordinated {

    private OAuth2Service oAuthService;

    private DiscordService discordService;

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

    public DiscordService buildDiscordinatedService(final AccessToken accessToken) {
        if(discordService == null) {
            if(accessToken == null)
                throw new NullPointerException("Authentication token is empty.");
            //Credit: https://futurestud.io/blog/oauth-2-on-android-with-retrofit
            Retrofit.Builder retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create());
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    System.out.println("Authorization: " + accessToken.getTokenType() + " " + accessToken.getAccessToken());
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken())
                            .header("User-Agent", userAgent)
                            .method(original.method(), original.body());
                    return chain.proceed(requestBuilder.build());
                }
            });
            discordService = (retrofit.client(httpClient.build()).build()).create(DiscordService.class);
            //End Credit: https://futurestud.io/blog/oauth-2-on-android-with-retrofit
        }
        return discordService;
    }

}
