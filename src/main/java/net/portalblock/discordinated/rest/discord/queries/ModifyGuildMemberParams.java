package net.portalblock.discordinated.rest.discord.queries;

import lombok.Getter;

/**
 * Created by portalBlock on 6/30/2016.
 */
public class ModifyGuildMemberParams {

    @Getter private String nick;

    //TODO @Getter private Role[] roles;

    @Getter private boolean mute, deaf;

    @Getter private String channel_id;

}
