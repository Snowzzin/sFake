package me.snow.sfake.commands;

import me.snow.sfake.Main;
import me.snow.sfake.manager.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFake implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(!(sender instanceof Player)) {
            p.sendMessage("§cApenas para jogadores validos");
            return false;
        }

        if(p.hasPermission(Main.plugin.getConfig().getString("PermissaoFake"))) {
            if (cmd.getLabel().equalsIgnoreCase("fake")) {
                if (args.length == 0) {
                    p.openInventory(new InventoryManager().fakeInventory());
                    p.sendMessage("§aOpções de Fake aberta com sucesso");
                }
            }
        }else{
            p.sendMessage("§cVocê não possui permissão");
        }
        return false;
    }
}
