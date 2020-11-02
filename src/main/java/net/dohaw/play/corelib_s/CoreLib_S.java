package net.dohaw.play.corelib_s;

import lombok.Getter;
import org.spongepowered.api.plugin.PluginContainer;

public class CoreLib_S {

    @Getter private static PluginContainer instance;

    public static void setInstance(PluginContainer i){
        instance = i;
        SPUtils.setConfigFolderName(instance.getId());
    }

}
