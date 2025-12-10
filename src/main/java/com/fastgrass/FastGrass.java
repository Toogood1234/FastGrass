package com.fastgrass;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FastGrass extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FastGrass plugin enabled! Grass will spread instantly around players.");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Block centerBlock = player.getLocation().getBlock().getRelative(0, -1, 0);
                    
                    for (int x = -5; x <= 5; x++) {
                        for (int z = -5; z <= 5; z++) {
                            Block block = centerBlock.getRelative(x, 0, z);
                            
                            if (block.getType() == Material.DIRT) {
                                block.setType(Material.GRASS_BLOCK);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    @Override
    public void onDisable() {
        getLogger().info("FastGrass plugin disabled!");
    }
}
