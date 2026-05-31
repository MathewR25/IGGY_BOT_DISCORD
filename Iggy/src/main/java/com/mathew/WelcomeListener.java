package com.mathew;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WelcomeListener extends ListenerAdapter {

    private static final String CANAL_BIENVENIDA = "1478859967284117607";
    private static final String CANAL_INSCRIPCIONES = "1479944259091304710";
    private static final String CANAL_BUSCAR_EQUIPO = "1478897427439161444";

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        TextChannel canal = event.getGuild()
                .getTextChannelById(CANAL_BIENVENIDA);

        if (canal != null) {
            // Construimos el mensaje con saltos de línea (\n) y menciones a canales (<#ID>)
            String mensaje = "✨ Hola " + event.getUser().getAsMention() + ", bienvenido a la Brawl Bizarre League\n\n" +
                             "* Si quieres crear un equipo, haz una publicación en <#" + CANAL_INSCRIPCIONES + "> siguiendo la plantilla\n" +
                             "* Si quieres unirte a un equipo, publica en <#" + CANAL_BUSCAR_EQUIPO + "> siguiendo la plantilla fijada en el canal";

            canal.sendMessage(mensaje).queue();
        }
    }
}