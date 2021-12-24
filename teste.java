@Override
//Um comando basico de /vanish q eu fiz para um plugin meu
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("zey.pvp.vanish")) {
            if (cmd.getLabel().equalsIgnoreCase("vanish")) {
                if (args.length == 0) {
                    if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.showPlayer(p);
                            p.removePotionEffect(PotionEffectType.INVISIBILITY);

                        }

                        p.sendMessage("§cModo vanish desativado !");

                    } else {

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.hidePlayer(p);
                            p.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(Integer.MAX_VALUE, 1));

                        }

                        p.sendMessage("§aModo vanish ativado !");

                    }
                }
            }
        }else{
            p.sendMessage("§cVocê não possui permissão !");
        }
        return false;
    }
