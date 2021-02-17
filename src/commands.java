import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");

        //checking messages within the main channel to read out and type a response
        if(args[0].equalsIgnoreCase(Juniper.prefix + "info")){

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Juniper");
            info.setDescription("I'm a bot that Checks your mental health");
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
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Are you:\nStressed\nAnxious\nDepressed").queue();

        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Stressed")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("You are stressed").queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Anxious")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("You are Anxious").queue();
        }

        if (args[0].equalsIgnoreCase(Juniper.prefix + "Depressed")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("You are feeling Depressed").queue();
        }

    }
}
