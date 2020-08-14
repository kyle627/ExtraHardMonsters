package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Listeners implements Listener {

    //random number is generated that will be used to determine if we want the specific added challenge to
    //be added to the mob when it is spawned
    Random rand = new Random();
    @EventHandler
    public void creeperSpawn(CreatureSpawnEvent event){
        /**
         * Creeper
         * 30% chance spawned powered
         * 30% chance explosion radius is 20 meters
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.CREEPER){
                int chance = rand.nextInt(100) + 1; //random number between 1 and 100
                if (chance >= 0 && chance <= 30){
                    Creeper creeper = (Creeper) event.getEntity();
                    creeper.setExplosionRadius(10);
                }
                if (chance >= 70 && chance <= 100){
                    Creeper creeper = (Creeper) event.getEntity();
                    creeper.setPowered(true);
                }
            }
        }
    }
    @EventHandler
    public void zombieSpawn(CreatureSpawnEvent event){
        /**
         * Zombie
         * 20% chance spawn with IRON Armor and Iron Sword
         * 10% chance spawn with DIAMOND Armor and Diamond Axe
         * 1% chance spawn with enchanted Iron/Diamond Armor (Protection 4)
         * 50% chance spawn with strength buff
         */
        final int armorLevel = 4;

        ItemStack ih = new ItemStack(Material.IRON_HELMET);
        ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack il = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack ib = new ItemStack(Material.IRON_BOOTS);

        ItemStack dh = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.ZOMBIE){
                int chance = rand.nextInt(100) + 1; //random number between 1 and 100
                Zombie zombie = (Zombie) event.getEntity();
                if (chance >= 50 && chance <= 100){
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 240, 2));
                }
                if (chance >= 10 && chance <= 20){
                    //Give Zombie Iron Armor if 20% chance
                    zombie.getEquipment().setHelmet(ih);
                    zombie.getEquipment().setChestplate(ic);
                    zombie.getEquipment().setLeggings(il);
                    zombie.getEquipment().setBoots(ib);
                    //Dropped Armor Chance
                    zombie.getEquipment().setHelmetDropChance(0.15F);
                    zombie.getEquipment().setChestplateDropChance(0.10F);
                    zombie.getEquipment().setLeggingsDropChance(0.10F);
                    zombie.getEquipment().setBootsDropChance(0.15F);
                    //Give Zombie the Sword
                    zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                    if (chance == 69){
                        ih.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ic.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        il.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
                }
                if (chance <= 10 &&  chance >= 0){
                    //Give Zombie Iron Armor if 20% chance
                    zombie.getEquipment().setHelmet(new ItemStack(dh));
                    zombie.getEquipment().setChestplate(new ItemStack(dc));
                    zombie.getEquipment().setLeggings(new ItemStack(dl));
                    zombie.getEquipment().setBoots(new ItemStack(db));
                    //Dropped Armor Chance
                    zombie.getEquipment().setHelmetDropChance(0.05F);
                    zombie.getEquipment().setChestplateDropChance(0.05F);
                    zombie.getEquipment().setLeggingsDropChance(0.05F);
                    zombie.getEquipment().setBootsDropChance(0.05F);
                    //Give Zombie the Sword
                    zombie.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
                    if (chance == 42){
                        dh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        dc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        dl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        db.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
                }
            }
        }

    }
}
