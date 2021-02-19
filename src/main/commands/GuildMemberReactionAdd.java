package main.commands;


import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberReactionAdd extends ListenerAdapter {
    /**
     * This needs work but trying to see when the user clicks reaction 1 it goes to the respective thing
     *
     * @param event aka the message
     */
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){

        if(event.getReactionEmote().getName().equals("1️⃣") &&
           !event.getMember().getUser().equals(event.getJDA().getSelfUser())){




        }

        else if(event.getReactionEmote().getName().equals("2️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){


        }

        else if(event.getReactionEmote().getName().equals("3️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){


        }

        else if(event.getReactionEmote().getName().equals("4️⃣") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser())){


        }
    }
}
