package net.portalblock.discordinated.rest.discord;

import lombok.Getter;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class User {

    @Getter private String id, username, discriminator, avatar;

    @Getter private boolean mfa_enabled, verified;

    @Getter private String email;

    public static class UserGuild {

        @Getter private String id, name, icon;

        @Getter private boolean owner;

        @Getter private int permissions;

    }

}
