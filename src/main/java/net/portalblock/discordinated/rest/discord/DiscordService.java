package net.portalblock.discordinated.rest.discord;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by portalBlock on 6/27/2016.
 */
public interface DiscordService {

    /*
    INVITE SECTION
     */

    @GET("/invites/{invite_id}")
    Call<Invite> getInvite(@Path("invite_id") String inviteId);

    @DELETE("/invites/{invite_id}")
    Call<Invite> deleteInvite(@Path("invite_id") String inviteId);

    @Deprecated
    @POST("/invites/{invite_id}")
    Call<Invite> acceptInvite(@Path("invite_id") String inviteId);

    /*
    USER SECTION
     */

    @GET("/users")
    Call<User[]> getUsers(@Query("q") String username, @Query("limit") int max);

    @GET("/users/{@me}")
    Call<User> getCurrentUser();

    @GET("/users/{user_id}")
    Call<Invite> getUser(@Path("user_id") String userId);

    @PATCH("/users/{@me}")
    Call<User> modifyCurrentUser(@Body User modifiedUser);

    @GET("/users/{@me}/guilds")
    Call<User.UserGuild[]> getCurrentGuilds();

    @DELETE("/users/{@me}/guilds/{guild_id}")
    Call leaveGuild(@Path("guild_id") String guildId);

    @GET("/users/{@me}/channels")
    Call<Channel.DMChannel[]> getUserDMs();

    @POST("/users/{@me}/channels")
    Call<Channel.DMChannel> createDM(@Body Channel.CreateDM createDM);

    @GET("/users/{@me}/connections")
    Call getUsersConnections(); //TODO

    /*
    GUILD SECTION
     */

    @POST("/guilds")
    Call<Guild> createGuild(@Body Guild guild);

    @GET("/guilds/{guild_id}")
    Call<Guild> getGuild(@Path("guild_id") String guildId);

    @PATCH("/guilds/{guild_id")
    Call<Guild> modifyGuild(@Path("guild_id") String guildId, @Body Guild modifiedGuild);

    @DELETE("/guilds/{guild_id}")
    Call<Guild> deleteGuild(@Path("guild_id") String guildId);

    @GET("/guilds/{guild_id}/channels")
    Call<Channel[]> getGuildChannels(@Path("guild_id") String guildId);

    @POST("/guilds/{guild_id}/channels")
    Call<Channel> createGuildChannels(@Path("guild_id") String guildId);

    @PATCH("/guilds/{guild_id}/channels")
    Call<Channel> modifyGuildChannels(@Path("guild_id") String guildId, @Body Channel modifiedChannel);

    @GET("/guilds/{guild_id}/members/{user_id}")
    Call<Guild.GuildMember> getGuildMember(@Path("guild_id") String guildId, @Path("user_id") String userId);

    @GET("/guilds/{guild_id}/members")
    Call<Guild.GuildMember[]> getGuildMembers(@Path("guild_id") String guildId);

    @GET("/guilds/{guild_id}/members")
    Call<Guild.GuildMember[]> getGuildMembers(@Path("guild_id") String guildId, @Query("limit") int limit);

    @GET("/guilds/{guild_id}/members")
    Call<Guild.GuildMember[]> getGuildMembers(@Path("guild_id") String guildId, @Query("limit") int limit, @Query("offset") int offset);

    @PATCH("/guilds/{guild_id}/members/{user_id}")
    Call modifyGuildMember(@Path("guild_id") String guildId, @Path("user_id") String userId, @Body Guild.GuildMember modifiedGuildMember);

    //TODO From here on https://discordapp.com/developers/docs/resources/guild#remove-guild-member

    /*
    CHANNEL SECTION
     */

    //TODO From here on https://discordapp.com/developers/docs/resources/channel#get-channel
}
