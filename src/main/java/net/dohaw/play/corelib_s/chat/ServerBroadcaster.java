package net.dohaw.play.corelib_s.chat;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;

public class ServerBroadcaster {

    public static void broadcast(String msg){
        Sponge.getServer().getBroadcastChannel().send(Text.of(msg));
    }

}
