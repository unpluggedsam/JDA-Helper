package jda_helper.permission;

import jda_helper.command.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Map;

public class BasicPermissionController implements PermissionController {

    @Override
    public Map<Command, List<Permission>> getCommandsMappedToPermissions() {
        return null;
    }

    @Override
    public boolean isValid(MessageReceivedEvent event) {
        return false;
    }
}
