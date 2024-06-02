package jda_helper.command.listener;

import jda_helper.guild.GuildHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CommandListener extends ListenerAdapter {

    private final String prefix;
    private final GuildHandler handler;

    public CommandListener(String prefix, GuildHandler handler) {
        this.prefix = prefix;
        this.handler = handler;
    }

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        String eventMessage = event.getMessage().getContentRaw();
        if (eventMessage.startsWith(prefix)) {
            ThreadPoolExecutor executor =
                    (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            executor.submit(() -> {
                handler.execute(event);
            });
        }
    }

}
