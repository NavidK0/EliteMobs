package com.magmaguy.elitemobs.items.itemconstructor;

import com.magmaguy.elitemobs.config.ConfigValues;
import com.magmaguy.elitemobs.config.ItemsProceduralSettingsConfig;
import com.magmaguy.elitemobs.mobconstructor.CombatSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.Material.*;

public class MaterialGenerator {

    public static Material generateMaterial(Material material){

        return material;

    }

    public static Material generateMaterial(double itemTier){

        List<Material> localValidMaterials = intializeValidProceduralMaterials();

        if (localValidMaterials.isEmpty()) intializeValidProceduralMaterials();

        if (itemTier < CombatSystem.DIAMOND_TIER_LEVEL) {

            localValidMaterials.remove(DIAMOND);
            localValidMaterials.remove(DIAMOND_AXE);
            localValidMaterials.remove(DIAMOND_BARDING);
            localValidMaterials.remove(DIAMOND_BLOCK);
            localValidMaterials.remove(DIAMOND_CHESTPLATE);
            localValidMaterials.remove(DIAMOND_HELMET);
            localValidMaterials.remove(DIAMOND_HOE);
            localValidMaterials.remove(DIAMOND_LEGGINGS);
            localValidMaterials.remove(DIAMOND_ORE);
            localValidMaterials.remove(DIAMOND_PICKAXE);
            localValidMaterials.remove(DIAMOND_SPADE);
            localValidMaterials.remove(DIAMOND_SWORD);
            localValidMaterials.remove(DIAMOND_BOOTS);

        }

        if (itemTier < CombatSystem.IRON_TIER_LEVEL) {

            localValidMaterials.remove(IRON_AXE);
            localValidMaterials.remove(IRON_BARDING);
            localValidMaterials.remove(IRON_BLOCK);
            localValidMaterials.remove(IRON_BOOTS);
            localValidMaterials.remove(IRON_CHESTPLATE);
            localValidMaterials.remove(IRON_HELMET);
            localValidMaterials.remove(IRON_HOE);
            localValidMaterials.remove(IRON_INGOT);
            localValidMaterials.remove(IRON_LEGGINGS);
            localValidMaterials.remove(IRON_NUGGET);
            localValidMaterials.remove(IRON_ORE);
            localValidMaterials.remove(IRON_PICKAXE);
            localValidMaterials.remove(IRON_SPADE);
            localValidMaterials.remove(IRON_SWORD);

        }

        if (itemTier < CombatSystem.STONE_CHAIN_TIER_LEVEL) {

            localValidMaterials.remove(CHAINMAIL_BOOTS);
            localValidMaterials.remove(CHAINMAIL_CHESTPLATE);
            localValidMaterials.remove(CHAINMAIL_HELMET);
            localValidMaterials.remove(CHAINMAIL_LEGGINGS);
            localValidMaterials.remove(STONE_SWORD);
            localValidMaterials.remove(STONE_HOE);
            localValidMaterials.remove(STONE_SPADE);
            localValidMaterials.remove(STONE_PICKAXE);
            localValidMaterials.remove(STONE_AXE);

        }

        int index = ThreadLocalRandom.current().nextInt(localValidMaterials.size());

        Material material = localValidMaterials.get(index);

        return material;

    }

    private static List<Material> intializeValidProceduralMaterials(){

        List<Material> validMaterials = new ArrayList<>();

        for (Object object : ConfigValues.itemsProceduralSettingsConfig.getList(ItemsProceduralSettingsConfig.PROCEDURAL_ITEM_VALID_MATERIALS)) {

            try {

                Material parsedMaterial = getMaterial(object.toString());
                validMaterials.add(parsedMaterial);

            } catch (Exception e) {

                Bukkit.getLogger().info("Invalid material type detected: " + object.toString());

            }


        }

        return validMaterials;

    }

}
