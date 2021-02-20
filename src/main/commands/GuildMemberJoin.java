package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        User user = event.getUser();

        EmbedBuilder join = new EmbedBuilder();
        join.setTitle("Welcome to the CS Dal Server");
        join.setDescription("I'm Jupiter, the server's mental health bot");
        join.setFooter("Made by Dave, Justin and Liam");
        join.setColor(20512750);

        user.openPrivateChannel().queue(channel -> {
            channel.sendMessage("Welcome to the server").queue();
        });




    }

}

