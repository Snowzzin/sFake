package me.snow.sfake;

import me.snow.sfake.commands.CommandFake;
import me.snow.sfake.commands.CommandRetirarFake;
import me.snow.sfake.listeners.ChatEvent;
import me.snow.sfake.listeners.ClickEvent;
import me.snow.sfake.listeners.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static Main plugin;

    public List<UUID> loadfake = new ArrayList<>();
    public List<UUID> fake = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        registerCommands();
        registerEvents();
        Bukkit.getConsoleSender().sendMessage("§a[sFake] Plugin inicializado com sucesso");
    }

    public void registerCommands() {
        getCommand("fake").setExecutor(new CommandFake());
        getCommand("rfake").setExecutor(new CommandRetirarFake());
        Bukkit.getConsoleSender().sendMessage("§a[sFake] Carregando commandos...");
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getConsoleSender().sendMessage("§a[sFake] Carregando eventos...");
    }
}
