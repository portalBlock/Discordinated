package net.portalblock.discordinated.websocket.events;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import net.portalblock.discordinated.rest.discord.Message;
import net.portalblock.discordinated.websocket.Event;

/**
 * Created by portalBlock on 11/6/2016.
 */
public class MessageCreateEvent implements Event {

    @Getter @SerializedName("d") private Message message;

}
