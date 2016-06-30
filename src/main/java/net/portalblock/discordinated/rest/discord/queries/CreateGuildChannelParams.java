package net.portalblock.discordinated.rest.discord.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.portalblock.discordinated.rest.discord.ChannelType;

/**
 * Created by portalBlock on 6/30/2016.
 */
@AllArgsConstructor
public class CreateGuildChannelParams {

    @Getter private String name;

    @Getter private ChannelType type;

    @Getter private int bitrate, user_limit;

}
