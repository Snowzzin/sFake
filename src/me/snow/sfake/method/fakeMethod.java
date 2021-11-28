package me.snow.sfake.method;

import me.snow.sfake.Main;
import me.snow.sfake.listeners.ChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class fakeMethod {

    public static void applyTag(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        String prefix = Main.plugin.getConfig().getString("GruposTags." + ChatEvent.msg2 + ".prefix");
        String suffix = "";

        if (prefix.length() > 16)
            prefix = prefix.substring(0, 16);

        Team team = scoreboard.getTeam(player.getName());

        if (team == null)
            team = scoreboard.registerNewTeam(player.getName());

        if (suffix.length() > 16)
            suffix = suffix.substring(0, 16);

        team.setPrefix(prefix.replace("&","§"));
        team.setSuffix(suffix);

        if (!team.hasPlayer(player))
            team.addPlayer(player);
    }

    public static void removeTag(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Team team = scoreboard.getTeam(player.getName());

        if (team == null)
            team = scoreboard.registerNewTeam(player.getName());

        team.setPrefix("");
        team.setSuffix("");
    }

    public static void kickMethod(Player p) {

        Main.plugin.loadfake.remove(p.getUniqueId());
        p.kickPlayer(Main.plugin.getConfig().getString("MensagemFakeRetirado")
                .replace("&","§")
                .replace("{nw}", "\n"));
    }

    public static void setMethod(Player p) {

        Main.plugin.loadfake.add(p.getUniqueId());
        p.closeInventory();

        p.sendMessage("§ePara começar a usar o Fake temos 1 etapa");
        p.sendMessage("§7Digite no chat uma tag disponivel para o Fake");
    }

    public static void msgMethod(Player p) {

        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.hasPermission(Main.plugin.getConfig().getString("PermissaoFakeAdmin"))) {
                all.sendMessage(" ");
                all.sendMessage(Main.plugin.getConfig().getString("MensagemFakeSetadoAdmin")
                        .replace("&","§")
                        .replace("{nome}", p.getName())
                        .replace("{newNome}", Main.plugin.getConfig().getString("GruposTags." + ChatEvent.msg2 + ".prefix")
                                .replace("&","§") + " " + p.getName()));

                all.sendMessage(" ");
            }
        }
    }

    public static void setFakeMethod(Player p) {

        String prefix = Main.plugin.getConfig().getString("GruposTags." + ChatEvent.msg2 + ".prefix")
                .replace("&","§");

        Main.plugin.loadfake.remove(p.getUniqueId());

        p.sendMessage(Main.plugin.getConfig().getString("MensagemFakeSetado")
                .replace("&", "§")
                .replace("{prefix}", prefix));

        fakeMethod.msgMethod(p);
        p.setDisplayName(prefix + " " + p.getName());
        fakeMethod.applyTag(p);
        Main.plugin.fake.add(p.getUniqueId());
    }

    public static void listTagsMethods(Player p) {

        List<String> config = Main.plugin.getConfig().getStringList("GruposFakes");

        p.sendMessage("§eLista de tags do Fake \n \n");
        config.forEach(allatori -> p.sendMessage( "§7- §e" + allatori));

        p.closeInventory();


    }
}
