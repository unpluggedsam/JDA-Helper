package jda_helper.permission;

import jda_helper.command.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface PermissionController {

    Map<Command, List<Permission>> getCommandsMappedToPermissions();
    boolean isValid(MessageReceivedEvent event);

    default void addPermissionRequiredForCommand(Command command, Permission... permissions) {
         getCommandsMappedToPermissions().put(command, Arrays.stream(permissions).toList());
    }
}
