package me.snow.sfake.manager;

import me.snow.sfake.utils.ItemBuilder;
import me.snow.sfake.utils.SkullAPI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class itemManager {

    public ItemStack createItem(Material mat, String name, List<String> lore) {
        return new ItemBuilder(mat).setName(name).setLore(lore).build();
    }

    public ItemStack createSkull(String url, String name, List<String> lore) {
        return new ItemBuilder(SkullAPI.getSkull(url)).setName(name).setLore(lore).build();
    }
}
