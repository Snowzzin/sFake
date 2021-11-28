package me.snow.sfake.listeners;

import me.snow.sfake.Main;
import me.snow.sfake.method.fakeMethod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    public static String msg2;

    public static Player p2;

    @EventHandler
    void chat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        p2 = p;

        String msg = e.getMessage();
        msg2 = msg;

        if (Main.plugin.loadfake.contains(p.getUniqueId())) {

            for (String config : Main.plugin.getConfig().getStringList("GruposFakes")) {

                    if (msg.equals(config)) {

                        fakeMethod.setFakeMethod(p);

                    }

            }

        }
    }
}
