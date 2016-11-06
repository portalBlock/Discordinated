package net.portalblock.discordinated.websocket.events;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import net.portalblock.discordinated.rest.discord.Channel;
import net.portalblock.discordinated.rest.discord.Guild;
import net.portalblock.discordinated.rest.discord.User;
import net.portalblock.discordinated.websocket.Event;

/**
 * Created by portalBlock on 11/5/2016.
 */
public class ReadyEvent implements Event {

    @SerializedName("d") private ReadyEventData readyEventData;

    public int getV() {
        return readyEventData.getV();
    }

    public Guild[] getGuilds() {
        return readyEventData.getGuilds();
    }

    public User getUser() {
        return readyEventData.getUser();
    }

    public String getSession_id() {
        return readyEventData.getSession_id();
    }

    public String[] get_trace() {
        return readyEventData.get_trace();
    }

    public Channel.DMChannel[] getPrivate_channels() {
        return readyEventData.getPrivate_channels();
    }

    public static class ReadyEventData {

        @Getter private int v;

        @Getter private User user;

        @Getter private Channel.DMChannel[] private_channels;

        @Getter private Guild[] guilds;

        @Getter private String session_id;

        @Getter private String[] _trace;

        //Presence and relationship functionality is not applicable to bots, and not implemented.

    }
}
