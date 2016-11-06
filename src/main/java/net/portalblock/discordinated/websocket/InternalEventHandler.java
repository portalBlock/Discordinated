package net.portalblock.discordinated.websocket;

import com.google.common.eventbus.Subscribe;
import net.portalblock.discordinated.Discordinated;
import net.portalblock.discordinated.websocket.events.ReadyEvent;

/**
 * Created by portalBlock on 11/6/2016.
 */
public class InternalEventHandler {

    private Discordinated discordinated;

    private DiscordWebsocket discordWebsocket;

    public InternalEventHandler(Discordinated discordinated, DiscordWebsocket discordWebsocket) {
        this.discordinated = discordinated;
        this.discordWebsocket = discordWebsocket;
    }

    @Subscribe
    public void onReady(ReadyEvent e) {
        discordWebsocket.setSelf(e.getUser());
    }

}
