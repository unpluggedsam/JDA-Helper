package jda_helper.guild;

import jda_helper.command.handle.CommandHandler;
import jda_helper.permission.PermissionController;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DiscordGuild {
    private final PermissionController permissionController;
    private final CommandHandler commandHandler;

    public DiscordGuild(PermissionController permissionController, CommandHandler commandHandler) {
        this.permissionController = permissionController;
        this.commandHandler = commandHandler;
    }

    public void execute(MessageReceivedEvent event) {
        if(permissionController.isValid(event)) {
            commandHandler.executeCommand(event);
        } else {
            event.getChannel().sendMessage("Invalid Permissions!").queue();
        }
    }
}
