package net.portalblock.discordinated.websocket;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import net.portalblock.discordinated.Discordinated;
import net.portalblock.discordinated.rest.discord.User;
import net.portalblock.discordinated.rest.oauth2.AccessToken;
import net.portalblock.discordinated.websocket.payloads.GatewayHello;
import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import java.net.URI;

/**
 * Created by portalBlock on 7/17/2016.
 */
public class DiscordWebsocket extends WebSocketClient {

    private static final Gson GSON = new GsonBuilder().serializeNulls().create();

    @Getter @Setter private AccessToken token;

    private Discordinated discordinated;

    @Getter private int lastSequence = -1, heartBeatInterval = -1;

    private Thread heartBeat;

    private boolean closed = false;

    private GatewayHello gatewayHello;

    private OpHandler opHandler;

    @Getter private EventBus eventBus = new EventBus();

    @Getter @Setter private User self;

    public DiscordWebsocket(Discordinated discordinated, URI gateway) {
        super(gateway);
        this.discordinated = discordinated;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, null);
            setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sslContext));
            this.opHandler = new OpHandler(discordinated, this, GSON);
            this.eventBus.register(new InternalEventHandler(discordinated, this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connectNow() throws InterruptedException {
        connectBlocking();
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected");
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
        handleData(new JSONObject(s));
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println(i + " " + s + " " + b);
        System.out.println("CLOSED");
        closed = true;
        if (heartBeat != null)
            heartBeat.interrupt();
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    private void handleData(JSONObject payload) {
        //TODO Make this more dynamic. This is just for testing right now.
        if(payload.optInt("s", -1) > -1)
            lastSequence = payload.getInt("s");
        //TODO Implement all
        switch (payload.getInt("op")) {
            case 0: opHandler.dispatch(payload); break;
            case 7: opHandler.reconnect(payload); break;
            case 10: opHandler.hello(payload); break;
        }
    }

    public void setHeartBeatInterval(int heartBeatInterval) {
        if(this.heartBeatInterval == -1)
            this.heartBeatInterval = heartBeatInterval;
    }

    public void startBeating() {
        if(heartBeat == null)
            (heartBeat = new Thread(() -> {
                System.out.println("Starting heartbeat!");
                while (!closed) {
                    if(lastSequence >= 0)
                        System.out.println(write(new PayloadWrapper(new PayloadWrapper.HeartbeatPayload(1, lastSequence))));
                    else
                        System.out.println(write(new PayloadWrapper(new PayloadWrapper.HeartbeatPayload(1, null))));
                    try {
                        Thread.sleep(getHeartBeatInterval());
                    } catch (InterruptedException ignored) { }
                }
                System.out.println("Stopped heartbeat!");
            })).start();
    }

    public String write(PayloadWrapper payloadWrapper) {
        String val;
        send(val = GSON.toJson(payloadWrapper));
        return val;
    }

}
