package net.portalblock.discordinated.websocket;

import com.google.gson.Gson;
import net.portalblock.discordinated.Discordinated;
import net.portalblock.discordinated.websocket.payloads.GatewayHello;
import net.portalblock.discordinated.websocket.payloads.GatewayIdentify;
import org.json.JSONObject;

/**
 * Created by portalBlock on 11/5/2016.
 */
public class OpHandler {

    private Discordinated discordinated;

    private DiscordWebsocket discordWebsocket;

    private final Gson GSON;

    public OpHandler(Discordinated discordinated, DiscordWebsocket discordWebsocket, Gson gson) {
        this.discordinated = discordinated;
        this.discordWebsocket = discordWebsocket;
        this.GSON = gson;
    }

    public void dispatch(JSONObject payload) {
        System.out.println("EVENT: " + payload.getString("t"));
        System.out.println(payload.getJSONObject("d"));
        String eventName = payload.getString("t");
        if(eventName.equalsIgnoreCase("READY"))
            discordWebsocket.startBeating();
        Class<? extends Event> eventClass = EventList.getEventClass(eventName);
        if(eventClass != null) {
            Event event = GSON.fromJson(payload.toString(), eventClass);
            discordWebsocket.getEventBus().post(event);
        } else {
            System.err.println("Event not implemented: " + eventName);
        }
    }

    public void reconnect(JSONObject payload) {
        System.out.println("Reconnect requested!");
    }

    public void hello(JSONObject payload) {
        GatewayHello gatewayHello = GSON.fromJson(payload.getJSONObject("d").toString(), GatewayHello.class);
        discordWebsocket.setHeartBeatInterval(gatewayHello.getHeartbeat_interval());
        GatewayIdentify gid = new GatewayIdentify(discordWebsocket.getToken().getAccessToken(),
                new GatewayIdentify.Properties("linux", "Discordinated", "Discordinated", "", ""), false, 250, new int[]{0, 1}, 3);
        System.out.println(discordWebsocket.write(new PayloadWrapper(2, gid)));
    }

}
