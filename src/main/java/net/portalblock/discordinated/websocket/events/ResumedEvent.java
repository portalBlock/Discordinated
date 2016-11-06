package net.portalblock.discordinated.websocket.events;

import lombok.Getter;
import net.portalblock.discordinated.websocket.Event;

/**
 * Created by portalBlock on 11/5/2016.
 */
public class ResumedEvent implements Event {

    @Getter private String[] _trace;

}
