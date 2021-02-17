package main.commands;

import main.Juniper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        //this will clear messages from chat
        if (args[0].equalsIgnoreCase(Juniper.prefix + "clear")) {
            if (args.length < 3) {
                //how to delete messages
                EmbedBuilder Usage = new EmbedBuilder();
                Usage.setColor(20512750);
                Usage.setTitle("Specify amount to delete");
                Usage.setDescription("Usage: `" + Juniper.prefix + "clear [#amount of messages]`");
                event.getChannel().sendMessage(Usage.build()).queue();
            } else {
                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();

                    //delete successfully
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(20512750);
                    success.setTitle("✔️ Successfully Deleted " + args[1] + ".");
                    event.getChannel().sendMessage(success.build()).queue();

                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        //too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(20512750);
                        error.setTitle("There's too many messages selected");
                        error.setDescription("Between 1-100 messages can be deleted at a time");
                        event.getChannel().sendMessage(error.build()).queue();
                    } else {
                        //messages too old
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(20512750);
                        error.setTitle("Messages too old");
                        error.setDescription("Messages older than 2 weeks can not be deleted");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }

    }
}
