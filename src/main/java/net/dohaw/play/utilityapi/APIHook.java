package net.dohaw.play.utilityapi;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class APIHook extends PluginWrapper{

    public UtilityAPI hook(PluginWrapper pluginWrapper){
        if(!Sponge.getPluginManager().isLoaded("utilityapi")){
            Sponge.getServer().getConsole().sendMessage(Text.of("Disabling this plugin. Could not find UtilityAPI dependency!"));
            shutDown(pluginWrapper);
            return null;
        }else{
            Optional<PluginContainer> optPluginContainer = Sponge.getPluginManager().getPlugin("utilityapi");
            if(optPluginContainer.isPresent()){
                return (UtilityAPI) optPluginContainer.get().getInstance().get();
            }else{
                return null;
            }
        }
    }

    private void shutDown(PluginWrapper pluginWrapper){
        Sponge.getEventManager().unregisterListeners(pluginWrapper.getPluginContainer().getInstance().get());
        Sponge.getCommandManager().getOwnedBy(pluginWrapper.getPluginContainer().getInstance().get());
        Sponge.getScheduler().getScheduledTasks(pluginWrapper.getPluginContainer().getInstance().get()).stream().forEach(t -> t.cancel());
    }

}
