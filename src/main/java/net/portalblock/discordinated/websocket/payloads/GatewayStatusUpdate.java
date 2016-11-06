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
public class GatewayStatusUpdate implements WSPayload {

    @Getter private Long idle_since;

    @Getter private Game game;

    @AllArgsConstructor
    public static class Game {

        @Getter private String name;

    }

}
