package net.dohaw.play.utilityapi;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.IOException;
import java.nio.file.Paths;

public class Config {

    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
    protected CommentedConfigurationNode config;

    public Config(String fileName, String folderName){
        this.configLoader = HoconConfigurationLoader.builder().setPath(Paths.get("config/" + folderName + "/" + fileName)).build();
        loadConfig();
    }

    public CommentedConfigurationNode getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            configLoader.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig() {
        try {
            config = configLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
