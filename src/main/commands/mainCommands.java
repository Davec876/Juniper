package main.commands;

import main.Juniper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;


public class mainCommands extends ListenerAdapter {
    //We can fill this up with multiple responses and then randomize it like it's done in the Sad method.
    String[] Sad = {
            "It's going to be okay [member], don't worry",



    };

    String[] Happy = {
            "That's great! Remember to drink water",


    };

    String[] Ok = {
            "Hang in there",


    };


    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

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
            help.setDescription("`How are you feeling?:\nSad\nAnxious\nDepressed\n`");
            help.setColor(20512750);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(help.build()).queue();

        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Sad")){
            Random rand = new Random();
            int number = rand.nextInt(Sad.length);


            EmbedBuilder Stressed = new EmbedBuilder();
            Stressed.setTitle("Juniper");
            Stressed.setDescription(Sad[number].replace("[member]",event.getMember().getAsMention()));
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
