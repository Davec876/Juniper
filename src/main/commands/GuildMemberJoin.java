package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getUser();

        EmbedBuilder onJoin = new EmbedBuilder();
        onJoin.setTitle("Hi, I'm Jupiter");
        onJoin.setColor(20512750);
        onJoin.setDescription("I'm the mental health bot from the CS Dal server. Check out my commands in the ________ channel");
        onJoin.setFooter("I'm here if you need me\nCreated by Dave, Justin and Liam");

        user.openPrivateChannel().queue(channel ->{
            channel.sendMessage(onJoin.build());
        });

    }


}
