

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;

public class Juniper {

    private static String discordToken = ("ODEwOTY2NDI1NzMxNzI3NDAw.YCrVVg.99-TBzS9N-3RpD4S0x9Z-3cF3Xk");

    //referencing Bot linkage token.
    public static void main(String[] args) throws LoginException{
        JDABuilder builder = JDABuilder.createDefault(discordToken);

        builder.build();
    }

}
