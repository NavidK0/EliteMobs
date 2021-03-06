package com.magmaguy.elitemobs.mobpowers.miscellaneouspowers;

import com.magmaguy.elitemobs.MetadataHandler;
import com.magmaguy.elitemobs.mobpowers.minorpowers.MinorPower;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class MoonWalk extends MinorPower {

    @Override
    public void applyPowers(Entity entity) {
        new BukkitRunnable() {
            @Override
            public void run() {
                ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
            }
        }.runTaskLater(MetadataHandler.PLUGIN, 1);

    }

}
