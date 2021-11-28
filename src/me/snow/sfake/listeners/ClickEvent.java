package me.snow.sfake.listeners;

import me.snow.sfake.method.fakeMethod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    @EventHandler
    void click(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory().getName().equals("Opções do Fake")) {
            e.setCancelled(true);

            if(e.getSlot() == 29) {

                fakeMethod.setMethod(p);
            }

            if(e.getSlot() == 33) {
                fakeMethod.kickMethod(p);
            }

            if(e.getSlot() == 36) {

                fakeMethod.listTagsMethods(p);
            }
        }
    }
}
