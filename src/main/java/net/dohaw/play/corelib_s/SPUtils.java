package net.dohaw.play.corelib_s;

import lombok.Setter;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.event.Listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class SPUtils {

    @Setter public static String configFolderName;

    public static void validatePluginFolder(){
        File folder = new File("config/" + CoreLib_S.getInstance().getId());
        if(!folder.exists()){
            folder.mkdirs();
        }
    }

    public static void validateFiles(String configFolderName, String... files){
        for(String fileName : files){
            Path path = Paths.get("config/" + configFolderName + "/" + fileName);
            Optional<Asset> optAsset = CoreLib_S.getInstance().getAsset(fileName);
            if(optAsset.isPresent()){
                try {
                    optAsset.get().copyToFile(path, false, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void validateFolders(String configFolderName, String... folderNames){
        for(String folderName : folderNames){
            File folder = new File("config/" + configFolderName + "/" + folderName);
            if(!folder.exists()){
                folder.mkdirs();
            }
        }
    }

    public static void registerListeners(Listener... listeners){
        for(Listener l : listeners){
            Sponge.getEventManager().registerListeners(CoreLib_S.getInstance(), l);
        }
    }

}
