package jda_helper.command.handle;

import jda_helper.command.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;


public class BaseCommandHandler implements CommandHandler {

    private final List<Command> commandList = new ArrayList<>();

    public void executeCommand(MessageReceivedEvent event) {
        getCommandByName(event.getMessage().getContentRaw().split(" ")[0]).ifPresent(Command::execute);
    }

    public Optional<Command> getCommandByName(String name) {
        return commandList.stream().filter(command -> command.getCommandName().equals(name)).findAny();
    }

    @Override
    public List<Command> getCommandList() {
        return commandList;
    }

    public boolean isUserPermissionValid(List<Role> userRoles, List<Role> requiredRoles) {
        if (userRoles.isEmpty()) return false;
        return !Collections.disjoint(userRoles, requiredRoles);
    }
}
