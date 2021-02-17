package main;

import main.commands.clear;
import main.commands.mainCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Juniper {
    public static JDA jda;
    public static String prefix = "*";

//    private static String discordToken = ("ODEwOTY2NDI1NzMxNzI3NDAw.YCrVVg.IuxO1WFLRl3pLd1cuIfvU2b2CpA");

    //referencing Bot linkage token.
    public static void main(String[] args) throws LoginException{
        jda = JDABuilder.createDefault("ODEwOTY2NDI1NzMxNzI3NDAw.YCrVVg.IuxO1WFLRl3pLd1cuIfvU2b2CpA").build();

        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.listening("How you're feeling"));

        jda.addEventListener(new mainCommands());
        jda.addEventListener(new clear());

    }

}
