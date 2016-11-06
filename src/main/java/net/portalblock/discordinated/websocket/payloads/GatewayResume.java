package net.portalblock.discordinated.websocket.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.portalblock.discordinated.websocket.WSPayload;

/**
 * Created by portalBlock on 7/18/2016.
 */
@AllArgsConstructor
@NoArgsConstructor
public class GatewayResume implements WSPayload {

    @Getter private String token, session_id;

    @Getter private int seq;

}
