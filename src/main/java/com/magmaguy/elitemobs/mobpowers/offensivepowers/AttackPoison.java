/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.magmaguy.elitemobs.mobpowers.offensivepowers;

import com.magmaguy.elitemobs.mobpowers.PowerCooldown;
import com.magmaguy.elitemobs.mobpowers.minorpowers.EventValidator;
import com.magmaguy.elitemobs.mobpowers.minorpowers.MinorPowers;
import com.magmaguy.elitemobs.utils.EntityFinder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

/**
 * Created by MagmaGuy on 12/12/2016.
 */
public class AttackPoison extends MinorPowers implements Listener {

    private ArrayList<LivingEntity> cooldownList = new ArrayList<>();

    @Override
    public void applyPowers(Entity entity) {
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {

        if (!EventValidator.eventIsValid(this, event)) return;
        Player player = EntityFinder.findPlayer(event);
        LivingEntity eliteMob = EntityFinder.getRealDamager(event);
        if (PowerCooldown.cooldownChecker(eliteMob, cooldownList)) return;

        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 3));
        PowerCooldown.startCooldownTimer(eliteMob, cooldownList, 10 * 20);

    }

}
