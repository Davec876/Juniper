package main.commands;

import main.Juniper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.User;

import java.util.List;
import java.util.Random;

public class mainCommands extends ListenerAdapter {
    //We can fill this up with multiple responses and then randomize it like it's done in the Sad method.
    String[] Sad = {
            "It's going to be okay [member], just breathe.",
            "[member], I suggest taking your mind off things with watching something funny on YouTube.",
            "[member], I suggest taking a walk to talk your mind off things.",
            "There's always someone to talk to [member], please take care of yourself.",
            "[member], I hope you know we're here if you need someone to talk to."
    };

    String[] Happy = {
            "That's great [member]! Remember to take some breaks throughout the day.",
            "[member], spread your positivity with all of us 😆"

    };

    String[] Ok = {
            "Hang in there",
            "Make sure to take some time to yourself",
            "Consider taking a break and going for a walk",
            "keep going, you got this",
            "keep going [member], remember to drink some water"


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
            help.setDescription("How are you feeling?:\n\n 1. Happy\n 2. Sad\n 3. Ecstatic\n 4. Ok");
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
            Stressed.setFooter("Please remember to drink water.");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Stressed.build()).queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Happy")){
            Random rand = new Random();
            int number = rand.nextInt(Happy.length);

            EmbedBuilder Hap = new EmbedBuilder();
            Hap.setTitle("Juniper");
            Hap.setDescription(Happy[number].replace("[member]", event.getMember().getAsMention()));
            Hap.setColor(20512750);
            Hap.setFooter("Please remember to drink water.");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Hap.build()).queue();
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

        if (args[0].equalsIgnoreCase(Juniper.prefix + "getHelp")){
            User user = event.getAuthor();
            String message = "**Consider reaching out to the student health and wellness center.**\n" +
                    "They can be reached online here: https://www.dal.ca/campus_life/health-and-wellness/services-support/student-health-and-wellness/make-an-appointment.html\n" +
                    "They can be rached by phone at (902)497-2171";


            sendUserMessage(user,message);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("I've sent you a private message.").queue();
        }
    }

    public void sendUserMessage(User user, String content){
        user.openPrivateChannel().queue(channel -> {
            channel.sendMessage(content).queue();
        });
    }

}
