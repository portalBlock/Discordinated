package net.portalblock.discordinated.websocket;

import net.portalblock.discordinated.websocket.payloads.*;

/**
 * Created by portalBlock on 11/5/2016.
 */
public abstract class PayloadHandler {

    public void handle(GatewayHello gatewayHello) { }

    public void handle(GatewayIdentify gatewayIdentify) { }

    public void handle(GatewayRequestGuildMembers gatewayRequestGuildMembers) { }

    public void handle(GatewayResume gatewayResume) { }

    public void handle(GatewayStatusUpdate gatewayStatusUpdate) { }

    public void handle(GatewayVoiceStateUpdate gatewayVoiceStateUpdate) { }

}
