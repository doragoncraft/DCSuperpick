package me.doragoncraft.dcsuperpick.commands;

import me.doragoncraft.dcsuperpick.DCSuperpick;
import me.doragoncraft.dcsuperpick.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleBreak implements CommandExecutor {
    private DCSuperpick plugin;


        public ToggleBreak(DCSuperpick pl) { this.plugin = pl; }

        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                boolean toggled = this.plugin.playerBoolean.contains(player.getName());
                if (!toggled) {
                    player.sendMessage(Lang.EnableMessage.get());
                    this.plugin.playerBoolean.add(player.getName());
                } else {

                    player.sendMessage(Lang.DisableMessage.get());
                    this.plugin.playerBoolean.remove(player.getName());
                }
            }
            return true;
        }
    }
