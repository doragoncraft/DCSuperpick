package me.doragoncraft.dcsuperpick.events;

import me.doragoncraft.dcsuperpick.DCSuperpick;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockDamage implements Listener {
    private DCSuperpick plugin;

    public BlockDamage(DCSuperpick pl) { this.plugin = pl; }
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        boolean toggled = this.plugin.playerBoolean.contains(player.getName());
        if (toggled)
            block.breakNaturally();
    }
}
