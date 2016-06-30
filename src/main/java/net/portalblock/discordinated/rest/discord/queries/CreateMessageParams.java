package net.portalblock.discordinated.rest.discord.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by portalBlock on 6/30/2016.
 */
@AllArgsConstructor
@NoArgsConstructor
public class CreateMessageParams {

    @Getter private String content, nonce;

    @Getter private boolean tts;

}
