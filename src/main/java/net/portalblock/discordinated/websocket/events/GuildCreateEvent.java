package net.portalblock.discordinated.websocket.events;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import net.portalblock.discordinated.rest.discord.Guild;
import net.portalblock.discordinated.websocket.Event;

/**
 * Created by portalBlock on 11/5/2016.
 */
public class GuildCreateEvent implements Event {

    @Getter @SerializedName("d") private Guild guild;

}
