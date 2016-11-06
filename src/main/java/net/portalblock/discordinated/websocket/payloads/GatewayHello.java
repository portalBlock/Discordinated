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
public class GatewayHello implements WSPayload {

    @Getter private int heartbeat_interval;

    @Getter private String[] _trace;

}
