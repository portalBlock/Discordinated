package net.portalblock.discordinated.rest.oauth2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by portalBlock on 6/27/2016.
 *
 * Credit: https://futurestud.io/blog/oauth-2-on-android-with-retrofit
 */
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {

    private String accessToken;
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        // OAuth requires uppercase Authorization HTTP header value for token type
        if ( ! Character.isUpperCase(tokenType.charAt(0))) {
            tokenType =
                    Character
                            .toString(tokenType.charAt(0))
                            .toUpperCase() + tokenType.substring(1);
        }

        return tokenType;
    }

}
