package me.doragoncraft.dcsuperpick.commands;
import java.io.File;

import me.doragoncraft.dcsuperpick.DCSuperpick;
import me.doragoncraft.dcsuperpick.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.doragoncraft.dcsuperpick.Lang.*;

public class Reload implements CommandExecutor {
    private DCSuperpick plugin;

    public Reload(DCSuperpick pe) {
        this.plugin = pe;
    }


    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        this.plugin.reloadConfig();
        Player p = (Player) sender;
        if (p.hasPermission("dc.superpick.reload")) {
            p.sendMessage(ReloadMessage.get());
            this.plugin.reloadConfig();
        } else {
            p.sendMessage(NO_PERMISSION.get());
        }

        return true;
    }
}
