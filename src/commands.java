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
            help.setDescription("Are you feeling:\nStressed\nAnxious\nDepressed\n");
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
