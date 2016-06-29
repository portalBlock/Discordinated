Discordinated
=============
Discordinated is a Java version of the [Discord API](https://discordapp.com/developers/docs/intro). There is no guaranteed functionality
of this library as it is my first time working with [Retrofit](http://square.github.io/retrofit/) and (eventually) websockets.
I welcome any pull requests and feedback.


Planned:

* Message formatting
* GET /users/{@me}/connections - No structure for the returned object found
* VoiceState (Guild)
* Roles (Guild, Guild.Emoji, Guild.GuildMember)
* GuildFeatures (Guild)
* Account (Guild.Integration)
* Timestamp (Guild.Integration)
* DateTime (same as timestamp?) (Guild.GuildMember, Invite.InviteMetadata)
* Permission overwrites (Channel)
* Finish guild endpoints
* Channel endpoints
* Create message objects and related
* Complete OAuth2 implementation

Lacks support for:

* Guild splashes