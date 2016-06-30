package net.portalblock.discordinated.rest.discord.queries;

import lombok.Getter;

/**
 * Created by portalBlock on 6/30/2016.
 */
public class BulkDeleteMessagesParams {

    @Getter private String[] messages;

    public BulkDeleteMessagesParams(String... messages) {
        this.messages = messages;
    }

}
