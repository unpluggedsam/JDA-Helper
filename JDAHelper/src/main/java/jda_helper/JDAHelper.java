package jda_helper;


import jda_helper.command.Command;
import jda_helper.command.listener.CommandListener;
import jda_helper.guild.GuildHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class JDAHelper {
    GuildHandler guildHandler = new GuildHandler();

    public JDA build(JDABuilder builder) {
        builder.addEventListeners(new CommandListener());
        return null;
    }

    public void addCommand(Command command) {
        guildHandler
    }
}
