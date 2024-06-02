package jda_helper.handle;

import jda_helper.command.handle.BaseCommandHandler;
import jda_helper.command.handle.CommandHandler;
import jda_helper.guild.GuildHandler;

public class Handler {

    private final GuildHandler guildHandler;
    private final CommandHandler commandHandler;

    public Handler(String prefix) {
        this.guildHandler = new GuildHandler();
        this.commandHandler = new BaseCommandHandler();
    }
}
