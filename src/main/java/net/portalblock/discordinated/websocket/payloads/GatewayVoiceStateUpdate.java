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
public class GatewayVoiceStateUpdate implements WSPayload {

    @Getter private String guild_id, channel_id;

    @Getter private boolean self_mute, self_deaf;

}
