package me.doragoncraft.dcsuperpick;

import me.doragoncraft.dcsuperpick.commands.Reload;
import me.doragoncraft.dcsuperpick.commands.ToggleBreak;
import me.doragoncraft.dcsuperpick.events.BlockDamage;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DCSuperpick
        extends JavaPlugin
{
    public Set<String> playerBoolean = new HashSet();
    private FileConfiguration Lang;



    public void onEnable() {
        getCommand("superpick").setExecutor(new ToggleBreak(this));
        getCommand("superpickreload").setExecutor(new Reload(this));

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockDamage(this), this);
        saveDefaultConfig();
        createLangFile();
    }
    public void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
    public FileConfiguration getLangFile() {
        return this.Lang;
    }

    private void createLangFile() {
        File langFile = new File(getDataFolder(), "Lang.yml");
        if (!langFile.exists()) {
            langFile.getParentFile().mkdirs();
            saveResource("Lang.yml", false);
        }

        Lang = new YamlConfiguration();
        try {
            Lang.load(langFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
