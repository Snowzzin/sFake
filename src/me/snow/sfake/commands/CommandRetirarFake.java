package me.snow.sfake.commands;

import me.snow.sfake.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRetirarFake implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(cmd.getLabel().equalsIgnoreCase("rfake")) {
            if(args.length == 0) {

                Main.plugin.loadfake.remove(p.getUniqueId());
                p.kickPlayer(Main.plugin.getConfig().getString("MensagemFakeRetirado")
                        .replace("&","§")
                        .replace("{nw}", "\n"));
            }
        }
        return false;
    }
}
