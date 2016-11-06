package net.portalblock.discordinated.websocket;

import net.portalblock.discordinated.websocket.events.*;

import java.util.HashMap;

/**
 * Created by portalBlock on 11/6/2016.
 */
public class EventList {

    private static final HashMap<String, Class<? extends Event>> EVENTS = new HashMap<>();

    static {
        EVENTS.put("READY", ReadyEvent.class);
        EVENTS.put("CHANNEL_UPDATE", ChannelUpdateEvent.class);
        EVENTS.put("GUILD_CREATE", GuildCreateEvent.class);
        EVENTS.put("GUILD_DELETE", GuildDeleteEvent.class);
        EVENTS.put("GUILD_UPDATE", GuildUpdateEvent.class);
        EVENTS.put("PRESENCE_UPDATE", PresenceUpdateEvent.class);
        EVENTS.put("RESUMED", ResumedEvent.class);
        EVENTS.put("MESSAGE_CREATE", MessageCreateEvent.class);
    }

    public static Class<? extends Event> getEventClass(String eventName) {
        return EVENTS.get(eventName);
    }

}
