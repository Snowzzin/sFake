package me.snow.sfake.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class InventoryManager {

    public Inventory fakeInventory() {

        String url = "http://textures.minecraft.net/texture/badc048a7ce78f7dad72a07da27d85c0916881e5522eeed1e3daf217a38c1a";

        String url2 = "http://textures.minecraft.net/texture/a10c80b9a128df130b11818f49133c18df982b01cf4d8b31d4a0db8a2f1fac00";

        String url3 = "http://textures.minecraft.net/texture/e9cdb9af38cf41daa53bc8cda7665c509632d14e678f0f19f263f46e541d8a30";

        Inventory inv = Bukkit.createInventory(null, 5*9, "Opções do Fake");

        inv.setItem(13, new itemManager().createSkull(url, "§ePrecisa de ajuda?", Arrays.asList("",
                "§7Seleciona uma das opções abaixo",
                "§7Apos disso digite um nick e uma tag",
                "§7que estam disponiveis e divirta-se")));

        inv.setItem(29, new itemManager().createSkull(url2, "§eColocar o Fake", Arrays.asList("",
                "§7Clique para utilizar o Fake")));

        inv.setItem(33, new itemManager().createSkull(url3, "§eRetirar o Fake", Arrays.asList("",
                "§7Clique para retirar o Fake")));

        inv.setItem(36, new itemManager().createItem(Material.BOOK_AND_QUILL, "§eLista de Tags", Arrays.asList("",
                "§7Clique para a lista de tags",
                "§7do fake aparecer")));

        return inv;
    }
}
