package jda_helper.guild;

import jda_helper.command.Command;
import jda_helper.command.handle.BaseCommandHandler;
import jda_helper.permission.BasicPermissionController;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class GuildHandler {
    private final HashMap<Guild, DiscordGuild> guildMap;

    public GuildHandler() {
        this.guildMap = new HashMap<>();
    }

    public void addGuild(Guild guild) {
        DiscordGuild discordGuild = new DiscordGuild(new BasicPermissionController(), new BaseCommandHandler());
        guildMap.put(guild, discordGuild);
    }

    public void addCommand(Command command) {

    }

    public DiscordGuild getGuild(Guild guild) {
        return guildMap.get(guild);
    }

    public void execute(MessageReceivedEvent event) {
        if(guildMap.containsKey(event.getGuild())) {
            guildMap.get(event.getGuild()).execute(event);
        } else {
            addGuild(event.getGuild());
        }
    }
}
