package main.commands;


import com.sun.tools.javac.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberReactionAdd extends ListenerAdapter {
    /**
     * This needs work but trying to see when the user clicks reaction 1 it goes to the respective thing
     *
     * @param event aka the message
     */
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){

        if(event.getReactionEmote().getName().equals("1️⃣") &&
           !event.getMember().getUser().equals(event.getJDA().getSelfUser())){

            event.getClass().getName().equals(MainCommands.happy);

            Random rand = new Random();
            int number = rand.nextInt(MainCommands.happy.length);

            EmbedBuilder Hap = new EmbedBuilder();
            Hap.setTitle("Juniper");
            Hap.setDescription(MainCommands.happy[number].replace("[member]", event.getMember().getAsMention()));
            Hap.setColor(20512750);
            Hap.setFooter("Please remember to take care of yourself.");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Hap.build()).queue();


        }

        else if(event.getReactionEmote().getName().equals("2️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){

            event.getClass().getName().equals(MainCommands.sad);

            Random rand = new Random();
            int number = rand.nextInt(MainCommands.sad.length);

            EmbedBuilder Stressed = new EmbedBuilder();
            Stressed.setTitle("Juniper");
            Stressed.setDescription(MainCommands.sad[number].replace("[member]",event.getMember().getAsMention()));
            Stressed.setColor(20512750);
            Stressed.setFooter("Please remember to drink water.");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Stressed.build()).queue();

        }

        else if(event.getReactionEmote().getName().equals("3️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){

            event.getClass().getName().equals(MainCommands.angry);

            Random rand = new Random();
            int number = rand.nextInt(MainCommands.angry.length);

            EmbedBuilder Upset = new EmbedBuilder();
            Upset.setTitle("Juniper");
            Upset.setDescription(MainCommands.angry[number].replace("[member]", event.getMember().getAsMention()));
            Upset.setColor(20512750);
            Upset.setFooter("Take a chill pill for the day my guy");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Upset.build()).queue();

        }

        else if(event.getReactionEmote().getName().equals("4️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){

            event.getClass().getName().equals(MainCommands.scared);

            Random rand = new Random();
            int number = rand.nextInt(MainCommands.scared.length);

            EmbedBuilder Depressed = new EmbedBuilder();
            Depressed.setTitle("Juniper");
            Depressed.setDescription(MainCommands.scared[number].replace("[member]", event.getMember().getAsMention()));
            Depressed.setColor(20512750);
            Depressed.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Depressed.build()).queue();

        }

        else if(event.getReactionEmote().getName().equals("5️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){

            event.getClass().getName().equals(MainCommands.nervous);

            Random rand = new Random();
            int number = rand.nextInt(MainCommands.nervous.length);

            EmbedBuilder Worried = new EmbedBuilder();
            Worried.setTitle("Juniper");
            Worried.setDescription(MainCommands.nervous[number].replace("[member]", event.getMember().getAsMention()));
            Worried.setColor(20512750);
            Worried.setFooter("You got this don't give up!");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(Worried.build()).queue();

        }

    }
}
