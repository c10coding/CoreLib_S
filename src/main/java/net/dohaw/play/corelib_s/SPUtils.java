package net.dohaw.play.corelib_s;

import lombok.Setter;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;

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
                    CoreLib_S.getInstance().getLogger().info("Copying asset " + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                throw new NullPointerException("Asset " + fileName + " was not found!");
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

    public static void registerListeners(Object... obj){
        for(Object o : obj){
            Sponge.getEventManager().registerListeners(CoreLib_S.getInstance(), o);
        }
    }

}
