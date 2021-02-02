package me.doragoncraft.dcsuperpick;

import me.doragoncraft.dcsuperpick.DCSuperpick;
import org.bukkit.ChatColor;
import org.omg.CORBA.NO_PERMISSION;

import java.util.List;
import java.util.stream.Collectors;

public enum Lang {
    ReloadMessage("Config &aSuccessfully reloaded."),
    EnableMessage("&5Superpick Enabled"),
    DisableMessage("&dSuperpick Disabled"),
    NO_PERMISSION("&cSorry you do not have permission to do this!");


    private String type;
    private DCSuperpick plugin;

    Lang(String type) {
        this.type = type;
        plugin = DCSuperpick.getPlugin(DCSuperpick.class);
    }

    public String get() {
        String value = plugin.getLangFile().getString(name());
        if (value == null) {
            plugin.getLogger().warning("Missing Lang message data: " + name());
            value = "&4Missing Lang message data: - '" + name() + "']";
        }
        return ChatColor.translateAlternateColorCodes('&', value);
    }

    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }


    public List format(List<String> list) {
        return list.stream().map(Lang::format).collect(Collectors.toList());
    }
}

