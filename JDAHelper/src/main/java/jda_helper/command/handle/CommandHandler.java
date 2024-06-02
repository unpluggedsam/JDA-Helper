package jda_helper.command.handle;

import jda_helper.command.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;


public interface CommandHandler {
    void executeCommand(MessageReceivedEvent event);

    List<Command> getCommandList();

    default void addCommand(Command command) {
        getCommandList().add(command);
    }

    default void removeCommand(Command command) {
        getCommandList().remove(command);
    }
}
