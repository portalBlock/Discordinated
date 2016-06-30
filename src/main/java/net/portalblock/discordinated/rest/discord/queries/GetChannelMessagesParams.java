package net.portalblock.discordinated.rest.discord.queries;

import lombok.Getter;

/**
 * Created by portalBlock on 6/30/2016.
 */
public class GetChannelMessagesParams {

    @Getter private String around, before, after;

    @Getter private int limit;

    public GetChannelMessagesParams() {

    }

    public GetChannelMessagesParams(int limit) {
        this.limit = limit;
    }

    public GetChannelMessagesParams around(String messageId) {
        this.around = messageId;
        return this;
    }

    public GetChannelMessagesParams before(String messageId) {
        this.before = messageId;
        return this;
    }

    public GetChannelMessagesParams after(String messageId) {
        this.after = messageId;
        return this;
    }

}
