package net.portalblock.discordinated.rest.discord;

import lombok.Getter;

import java.security.Provider;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Channel {

    @Getter private String id, guild_id, name;

    @Getter private ChannelType type;

    @Getter private int position;

    @Getter private boolean is_private;

    //TODO Permission overwrites https://discordapp.com/developers/docs/resources/channel

    @Getter private String topic, last_message_id; //Text only

    @Getter private int bitrate, user_limit; //Voice only

    public static class DMChannel {

        @Getter private String id;

        @Getter private boolean is_private;

        @Getter private User recipient;

        @Getter private String last_message_id;

    }

    public static class CreateDM {

        @Getter private String recipient_id;

    }

    public static class Overwrite {

        @Getter private String id;

        @Getter private OverwriteType type;

        @Getter private int allow, deny;

    }

    public static class Embed {

        @Getter private String title, type, description, url;

        @Getter private EmbedThumbnail thumbnail;

        @Getter private Provider provider;

    }

    public static class EmbedThumbnail {

        @Getter private String url, proxy_url;

        @Getter private int height, width;

    }

    public static class EmbedProvider {

        @Getter private String name, url;

    }

    public static class Attachment {

        @Getter private String id, filename;

        @Getter private int size; //Size in bytes

        @Getter private String url, proxy_url;

        @Getter private int height, width; //height/width if image

    }

}
