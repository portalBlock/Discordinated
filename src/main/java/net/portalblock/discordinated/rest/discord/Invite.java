package net.portalblock.discordinated.rest.discord;

import lombok.Getter;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Invite {

    private String code;

    private InviteGuild guild;

    private InviteChannel channel;

    private String xkcdpass;

    public static class InviteMetadata {

        @Getter private User inviter;

        @Getter private int uses, maxUses, maxAge;

        @Getter private boolean temporary;

        //TODO @Getter private datetime

        @Getter private boolean revoked;

    }

    public static class InviteGuild {

        @Getter private String id, name, splash_hash;

    }

    public static class InviteChannel {

        @Getter private String id, name;

        @Getter private ChannelType type;

    }

}
