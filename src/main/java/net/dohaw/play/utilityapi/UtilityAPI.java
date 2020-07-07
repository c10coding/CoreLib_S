package net.dohaw.play.utilityapi;

import com.google.inject.Inject;
import net.dohaw.play.utilityapi.helpers.NumbersHelper;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "utilityapi",
        name = "UtilityAPI",
        version = "1.0-SNAPSHOT"
)
public class UtilityAPI{

    @Inject
    private Logger logger;

    private NumbersHelper numbersHelper;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        this.numbersHelper = new NumbersHelper();
    }

    public NumbersHelper getNumbersHelper(){
        return numbersHelper;
    }
}
