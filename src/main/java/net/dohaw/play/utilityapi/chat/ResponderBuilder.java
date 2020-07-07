package net.dohaw.play.utilityapi.chat;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class ResponderBuilder {

    private boolean hasPrefix;
    private String msg;
    private String prefix;
    private Player player;

    private ResponderBuilder(Player player){
        this.hasPrefix = false;
        this.msg = "";
        this.prefix = "";
        this.player = player;
    }

    public static ResponderBuilder create(Player player){
        return new ResponderBuilder(player);
    }

    public ResponderBuilder message(String msg){
        this.msg = msg;
        return this;
    }

    public ResponderBuilder hasPrefix(boolean hasPrefix){
        this.prefix = prefix;
        return this;
    }

    public ResponderBuilder prefix(String prefix){
        this.prefix = prefix;
        return this;
    }

    public void send(){
        player.sendMessage(Text.of(msg));
    }

}
