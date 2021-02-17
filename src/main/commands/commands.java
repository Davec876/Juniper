package main.commands;

import main.Juniper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;


public class commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        //this will clear messages from chat
        if(args[0].equalsIgnoreCase(Juniper.prefix + "clear")){
            if(args.length < 3){
                //how to delete
                EmbedBuilder Usage = new EmbedBuilder();
                Usage.setColor(0xff3923);
                Usage.setTitle("Specify amount to delete");
                Usage.setDescription("Usage: `" + Juniper.prefix + "clear [#amount of messages]`");
                event.getChannel().sendMessage(Usage.build()).queue();
            }
            else{
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();

                    //delete successfully
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(0x22ff2a);
                    success.setTitle("✔️ Successfully Deleted " +  args[1] + ".");
                    event.getChannel().sendMessage(success.build()).queue();

                }
                catch (IllegalArgumentException e){
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                        //too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("There's too many messages selected");
                        error.setDescription("Between 1-100 messages can be deleted at a time");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                    else{
                        //messages too old
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("Messages too old");
                        error.setDescription("Messages older than 2 weeks can not be deleted");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }

        if(args[0].equalsIgnoreCase(Juniper.prefix + "info")){

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Juniper");
            info.setDescription("I'm a bot that checks your mental health");
//            info.addField("Creators","Dave, Justin, and Liam",false);
            info.setColor(20512750);
            //we can choose between the field or the footer whichever looks more professional.
            info.setFooter("Created by: Dave, Justin, and Liam");

            //shows bot is typing
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "help")){

            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Juniper");
            // the "`" allows it to be displayed in a code block but not necessary
            help.setDescription("`How are you feeling?:\nStressed\nAnxious\nDepressed\n`");
            help.setColor(20512750);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(help.build()).queue();

        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Stressed")){

            EmbedBuilder Stressed = new EmbedBuilder();
            Stressed.setTitle("Juniper");
            Stressed.setDescription("You are Stressed");
            Stressed.setColor(20512750);
            Stressed.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Stressed.build()).queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Anxious")){
            EmbedBuilder Anxious = new EmbedBuilder();
            Anxious.setTitle("Juniper");
            Anxious.setDescription("You are Anxious");
            Anxious.setColor(20512750);
            Anxious.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Anxious.build()).queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Depressed")){

            EmbedBuilder Depressed = new EmbedBuilder();
            Depressed.setTitle("Juniper");
            Depressed.setDescription("You are Depressed");
            Depressed.setColor(20512750);
            Depressed.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Depressed.build()).queue();
        }

    }
}
