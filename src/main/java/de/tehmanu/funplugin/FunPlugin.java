package de.tehmanu.funplugin;

import de.tehmanu.funplugin.listener.CowListener;
import de.tehmanu.funplugin.listener.StickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FunPlugin extends JavaPlugin {

    private static FunPlugin plugin;

    public static FunPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        registerListener();
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new CowListener(), this);
        Bukkit.getPluginManager().registerEvents(new StickListener(), this);
    }
}
