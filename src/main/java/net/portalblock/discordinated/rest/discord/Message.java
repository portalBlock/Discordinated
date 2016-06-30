package net.portalblock.discordinated.rest.discord;

import lombok.Getter;

/**
 * Created by portalBlock on 6/27/2016.
 */
public class Message {

    @Getter private String id, channel_id;

    @Getter private User author;

    @Getter private String content;

    //TODO @Getter private Timestamp timestamp, edited_timestamp;

    @Getter private boolean tts, mention_everyone;

    @Getter private User[] mentions;

    @Getter private Channel.Attachment[] attachments;

    @Getter private Channel.Embed[] embeds;

    @Getter private int nonce;

    @Getter private boolean pinned;

}
