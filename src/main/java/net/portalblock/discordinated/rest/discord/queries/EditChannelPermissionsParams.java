package net.portalblock.discordinated.rest.discord.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by portalBlock on 6/30/2016.
 */
@AllArgsConstructor
public class EditChannelPermissionsParams {

    @Getter private int allow, deny;

}
