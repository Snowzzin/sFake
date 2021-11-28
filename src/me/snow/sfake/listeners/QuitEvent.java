package me.snow.sfake.listeners;

import me.snow.sfake.Main;
import me.snow.sfake.method.fakeMethod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    void quit(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        if(Main.plugin.fake.contains(p.getUniqueId())) {

            fakeMethod.removeTag(p);

            Main.plugin.fake.remove(p.getUniqueId());

        }
    }
}
