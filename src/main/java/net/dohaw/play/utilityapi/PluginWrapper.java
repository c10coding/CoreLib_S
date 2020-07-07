package net.dohaw.play.utilityapi;

import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class PluginWrapper {

    private PluginContainer plugin;
    protected Config baseConfig;
    protected String baseConfigName = "config.yml";
    protected String configFolderName;
    private boolean needBaseConfig = true;

    protected void wrap(PluginContainer container){
        this.plugin = container;
        this.configFolderName = plugin.getId();
        setupEssentials();
    }

    protected void validateFiles(String... files){
        for(String fileName : files){
            Path path = Paths.get("config/" + configFolderName + "/" + fileName);
            Optional<Asset> optAsset = ((PluginContainer)plugin).getAsset(fileName);
            if(optAsset.isPresent()){
                try {
                    optAsset.get().copyToFile(path, false, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setupEssentials(){
        if(needBaseConfig){
            this.baseConfig = new Config(baseConfigName, configFolderName);
        }
    }

    protected void setNeedBaseConfig(boolean b){
        this.needBaseConfig = b;
    }

    protected void setBaseConfigName(String baseConfigName){
        this.baseConfigName = baseConfigName;
    }

    protected void setConfigFolder(String folderName){
        this.configFolderName = folderName;
    }

    public String getConfigFolderName(){
        return configFolderName;
    }

    public PluginContainer getPluginContainer(){
        return plugin;
    }



}
