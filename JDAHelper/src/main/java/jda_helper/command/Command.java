package jda_helper.command;

/**
 * Represents a discord command. When a user
 * sends a message to a channel with the command prefix
 * then the command will be triggered with the {@link #execute} method.
 */
public interface Command {

    void execute();

    String getCommandName();

    String getDescription();

    boolean isEnabled();
}
