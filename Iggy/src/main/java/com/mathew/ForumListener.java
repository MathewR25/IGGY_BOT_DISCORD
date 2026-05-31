package com.mathew;

import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ForumListener extends ListenerAdapter {

    private static final String CANAL_FORO_BUSCAR_EQUIPO = "1478897427439161444";
    private static final String ROL_CAPITANES_ID = "1480384831790518394";

    private static final String CANAL_FORO_INSCRIPCIONES = "1479944259091304710";
    private static final String ROL_ADMIN_ID = "1478860052046807040";

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {
        if (event.getChannel() instanceof ThreadChannel) {
            ThreadChannel publicacion = (ThreadChannel) event.getChannel();

            if (publicacion.getParentChannel().getId().equals(CANAL_FORO_BUSCAR_EQUIPO)) {
                
                String mensaje = "📢 <@&" + ROL_CAPITANES_ID + "> NUEVO JUGADOR DISPONIBLE\n" +
                                 "🔥 Un nuevo jugador se ha registrado y está buscando equipo.\n" +
                                 "💬 Revisen su perfil y contacten si les interesa sumarlo a su equipo.";

                publicacion.sendMessage(mensaje).queue();
            }

            if (publicacion.getParentChannel().getId().equals(CANAL_FORO_INSCRIPCIONES)) {
                String mensajeEquipo = "━━━━━━━━━━━━━━━━━━━━━━\n" +
                                       "🚨 <@&" + ROL_ADMIN_ID + "> | NUEVO EQUIPO CREADO 🚨\n" +
                                       "━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                                       "⚡ Se ha registrado un nuevo equipo en la liga.\n\n" +
                                       "📌 Por favor revísenlo y acéptenlo para confirmar su participación.\n\n" +
                                       "━━━━━━━━━━━━━━━━━━━━━━\n" +
                                       "🔥 Brawl Bizarre League\n" +
                                       "━━━━━━━━━━━━━━━━━━━━━━";
                publicacion.sendMessage(mensajeEquipo).queue();
            }
        }
    }
}