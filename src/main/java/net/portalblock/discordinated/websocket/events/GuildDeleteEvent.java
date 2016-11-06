package net.portalblock.discordinated.websocket.events;

import lombok.Getter;
import net.portalblock.discordinated.websocket.Event;

/**
 * Created by portalBlock on 11/5/2016.
 */
public class GuildDeleteEvent implements Event {

    @Getter private String id;

    @Getter private boolean unavailable;

}
