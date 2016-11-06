package net.portalblock.discordinated.websocket.payloads;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.portalblock.discordinated.websocket.WSPayload;
import org.json.JSONObject;

/**
 * Created by portalBlock on 7/18/2016.
 */
@AllArgsConstructor
@NoArgsConstructor
public class GatewayIdentify implements WSPayload {

    @Getter private String token;

    @Getter private Properties properties;

    @Getter private boolean compress;

    @Getter private int large_threshold;

    @Getter private int[] shard;

    @Getter private int v = 3;

    @AllArgsConstructor
    public static class Properties {

        @Getter @SerializedName("$os") private String os;
        @Getter @SerializedName("$browser") private String browser;
        @Getter @SerializedName("$device") private String device;
        @Getter @SerializedName("$referrer") private String referrer;
        @Getter @SerializedName("$referring_domain") private String referring_domain;

        public String toJson() {
            JSONObject data = new JSONObject();
            data.put("$os", os).put("$browser", browser).put("$device", device)
                    .put("$referrer", referrer).put("$referring_domain", referring_domain);
            return data.toString();
        }

        public static Properties fromJson(JSONObject data) {
            return new Properties(data.getString("$os"), data.getString("$browser"),
                    data.getString("$device"), data.getString("$referrer"), data.getString("$referring_domain"));
        }

    }

}
