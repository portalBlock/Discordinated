package net.portalblock.discordinated.rest.discord;

import lombok.Getter;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Guild {

    @Getter private String id, name, icon, splash, owner_id, region, afk_channel_id;

    @Getter private int afk_timeout;

    @Getter private boolean embed_enabled;

    @Getter private String embed_channel_id;

    @Getter private int verification_level;

    //TODO @Getter private VoiceState[] voice_states;

    //TODO @Getter private Role[] roles

    @Getter private Emoji[] emojis;

    //TODO @Getter private GuildFeature[] features;

    public static class UnavailableGuild {

        @Getter private String id;

        @Getter private boolean unavailable;

    }

    public static class GuildEmbed {

        @Getter private boolean enabled;

        @Getter private String channel_id;

    }

    public static class GuildMember {

        @Getter private User user;

        @Getter private String nick;

        //TODO @Getter private Role[] roles;

        //TODO @Getter private datetime joined_at;

        @Getter private boolean deaf, mute;

    }

    public static class Integration {

        @Getter private String id, name;

        @Getter private IntegrationType type;

        @Getter private boolean enabled, syncing;

        @Getter private String role_id;

        @Getter private int expire_behavior, expire_grace_period;

        @Getter private User user;

        //TODO @Getter private Account account;

        //TODO @Getter private Timestamp synced_at;

    }

    public static class IntegrationAccount {

        @Getter private String id, name;

    }

    public static class Emoji {

        @Getter private String id, name;

        //TODO @Getter private Role[] roles;

        @Getter private boolean require_colons, managed;

    }

}
