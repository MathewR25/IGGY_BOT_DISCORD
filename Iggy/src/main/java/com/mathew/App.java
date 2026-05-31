package com.mathew;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App {
    public static void main(String[] args) throws Exception {
        
        String token = System.getenv("DISCORD_TOKEN");

        JDABuilder.createDefault(
                token,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES
        )
        .addEventListeners(new WelcomeListener())
        .addEventListeners(new ForumListener())
        .build();
        System.out.println("UN IGGY SALVAJE HA APARECIDO");
    }
}
