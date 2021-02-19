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

    String[] Happy = {
            "That's great [member]! Remember to take some breaks throughout the day.",
            "[member], spread your positivity with all of us 😆",
            "That's great [member], now make the best of today 💯!",
            "[member], I think you should treat yourself to something nice today :)"
    };

    String[] Sad = {
            "It's going to be okay [member], just breathe.",
            "[member], I suggest taking your mind off things with watching something funny on YouTube.",
            "[member], I suggest taking a walk to talk your mind off things.",
            "There's always someone to talk to [member], please take care of yourself.",
            "[member], I hope you know we're here if you need someone to talk to."
    };

    String[] Angry = {
            "Remember [member], it's never good to hold a grudge. The past is the past.",
            "Hey [member], don't stress yourself over it better to ignore than to entertain.",
            "[member], Have you tried letting your anger out in a external way such as: screaming?",
            "[member], Would you like to talk about it?"

    };

    String[] Scared = {
            "Hang in there [member], try listening to some music.",
            "Hey [member], Make sure to take some time to yourself.",
            "[member], Consider taking a break and going for a walk.",
            "keep going [member], You got this don't let sadness bring you down!",
            "keep going [member], Remember to drink some water."

    };

    String[] Nervous = {
        "[member], Listen to me, breathe and count to ten.",
        "[member], Take your time and think it through slowly.",
        "[member], Visualize yourself being calm in your happy place.",
        "Don't be afraid of the feeling [member], embrace it and make it your bitch!",
        "Try shifting your focus [member], because it'll consume you if you don't. "
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
            help.setDescription("How are you feeling today?:\n\n 1. Happy\n 2. Sad\n 3. Angry\n 4. Scared\n 5. Nervous/Anxious");
            help.setColor(20512750);

            event.getChannel().sendTyping().queue();
            Message msg = event.getChannel().sendMessage(help.build()).complete();
            //adds  reactions to the embed builder
            msg.addReaction("1️⃣").queue();
            msg.addReaction("2️⃣").queue();
            msg.addReaction("3️⃣").queue();
            msg.addReaction("4️⃣").queue();
            msg.addReaction("5️⃣").queue();

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
            Hap.setFooter("Please remember to take care of yourself.");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Hap.build()).queue();
        }

        if(args[0].equalsIgnoreCase(Juniper.prefix + "Angry")){

            Random rand = new Random();
            int number = rand.nextInt(Angry.length);

            EmbedBuilder Upset = new EmbedBuilder();
            Upset.setTitle("Juniper");
            Upset.setDescription(Angry[number].replace("[member]", event.getMember().getAsMention()));
            Upset.setColor(20512750);
            Upset.setFooter("Take a chill pill for the day my guy");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Upset.build()).queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Scared")){

            Random rand = new Random();
            int number = rand.nextInt(Scared.length);

            EmbedBuilder Depressed = new EmbedBuilder();
            Depressed.setTitle("Juniper");
            Depressed.setDescription(Scared[number].replace("[member]", event.getMember().getAsMention()));
            Depressed.setColor(20512750);
            Depressed.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Depressed.build()).queue();
        }

        if(args[0].equalsIgnoreCase(Juniper.prefix + "Nervous")){
            Random rand = new Random();
            int number = rand.nextInt(Nervous.length);

            EmbedBuilder Worried = new EmbedBuilder();
            Worried.setTitle("Juniper");
            Worried.setDescription(Nervous[number].replace("[member]", event.getMember().getAsMention()));
            Worried.setColor(20512750);
            Worried.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Worried.build()).queue();
        }



        if (args[0].equalsIgnoreCase(Juniper.prefix + "realHelp")){
            User user = event.getAuthor();

            EmbedBuilder gethelp = new EmbedBuilder();
            gethelp.setTitle("Juniper");
            gethelp.setDescription("__**As a student of Dalhousie here is where you can get help:**__" +
                    "\n\n**The student health and wellness center can be reached online at: https://bit.ly/3drjon6**\n\n" +
                    "**or by phone at (902)497-2171**\n" + "**\nIf that doesn't help please seek external sources such as friends/family/therapist"
                    + " Juniper cares about you don't give up!**");
            gethelp.setFooter("\nHang in there, you can get through this");
            gethelp.setColor(20512750);
            //function to pm the user
            user.openPrivateChannel().queue(channel ->{
                channel.sendMessage(gethelp.build()).queue();
            });

            EmbedBuilder gethelpchat = new EmbedBuilder();
            gethelpchat.setTitle("Juniper");
            gethelpchat.setDescription(event.getMember().getAsMention() + " I've sent you a private message.");
            gethelpchat.setColor(20512750);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(gethelpchat.build()).queue();
        }
    }

}
