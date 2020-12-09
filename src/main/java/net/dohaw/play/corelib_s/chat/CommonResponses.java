package net.dohaw.play.corelib_s.chat;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class CommonResponses {

    public static void playerOnlyCommand(Player player){
        player.sendMessage(Text.of("Only players can run this command!"));
    }

    public static void playerOnlyCommand(CommandSource src){
        src.sendMessage(Text.of("Only players can run this command!"));
    }

}
