package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
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
         * Double Health
         * 30% chance spawned powered
         * 30% chance explosion radius is 20 meters
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.CREEPER){
                final int chance = rand.nextInt(101) + 1; //random number between 1 and 100
                final double health = 40.0;
                Creeper creeper = (Creeper) event.getEntity();
                // TODO creeper.setHealth(health);
                if (chance >= 0 && chance <= 30){
                    creeper.setExplosionRadius(10);
                }
                if (chance >= 70 && chance <= 100){
                    creeper.setPowered(true);
                }
            }
        }
    }
    @EventHandler
    public void zombieSpawn(CreatureSpawnEvent event){
        /**
         * Zombie
         * Double Health
         * 15% chance spawn with IRON Armor and Iron Sword
         * 5% chance spawn with DIAMOND Armor and Diamond Axe
         * 1% chance spawn with enchanted Iron/Diamond Armor (Protection 4)
         * 50% chance spawn with increased-damage buff
         */

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
                int chance = rand.nextInt(101) + 1; //random number between 1 and 100
                final int armorLevel = 4;
                final double health = 40.0;
                Zombie zombie = (Zombie) event.getEntity();
                // TODO zombie.setHealth(health);
                if (chance >= 50){
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 240, 2));
                }
                if (chance >= 10 && chance <= 25){
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
                    if (chance == 15){
                        ih.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ic.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        il.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
                }
                if (chance <= 6){
                    if (chance == 1){
                        dh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        dc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        dl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        db.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
                    //Give Zombie Diamond Armor if 5% chance
                    zombie.getEquipment().setHelmet(new ItemStack(dh));
                    zombie.getEquipment().setChestplate(new ItemStack(dc));
                    zombie.getEquipment().setLeggings(new ItemStack(dl));
                    zombie.getEquipment().setBoots(new ItemStack(db));
                    //Dropped Armor Chance
                    zombie.getEquipment().setHelmetDropChance(0.05F);
                    zombie.getEquipment().setChestplateDropChance(0.05F);
                    zombie.getEquipment().setLeggingsDropChance(0.05F);
                    zombie.getEquipment().setBootsDropChance(0.05F);
                    //Give Zombie the axe
                    zombie.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
                }
            }
        }

    }
    @EventHandler
    public void skeletonSpawn(CreatureSpawnEvent event){
        /**
         * Skeleton
         * Double Health
         * 25% Chance Spawn with Enchanted Chain-mail armor (Protection 2)
         * 25% Chance Spawn with Punch 2 Bow
         * 10% Chance spawn with speed 2
         * 10% chance spawn with speed 2 and Chain-mail boots and leggings with thorns 2.
         * 5% chance spawn with BOTH Enchanted Chain-mail armor and punch two bow
         */
        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);

        ItemStack pB = new ItemStack(Material.BOW);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.SKELETON){
                int chance = rand.nextInt(101) + 1; //random number between 1 and 100
                final double health = 40.0;
                final float percentDropWeapon = 0.10F;
                final float percentDropChanceArmor = 0.15F;
                final int armorLevel = 2;
                final int bowLevel = 2;
                Skeleton skeleton = (Skeleton) event.getEntity();
                //TODO skeleton.setHealth(health); //Double Health
                /**
                 * 0 -> 25 Enchanted Chain-mail (Protection 2)
                 * 26 -> 51 Punch 2
                 * 52 -> 62 speed 2
                 * 63 -> 73 speed 2 with chain bottoms (Thorns)
                 * 74 -> 79 both enchanted chain-mail (Protection 2) and punch 2 bow, with speed buff
                 * 80 -> 100 normal skelly
                 */
                if (chance >= 0 && chance <= 25){
                    //enchant the armor
                    ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    //give skeleton the armor
                    skeleton.getEquipment().setHelmet(ch);
                    skeleton.getEquipment().setChestplate(cc);
                    skeleton.getEquipment().setLeggings(cl);
                    skeleton.getEquipment().setBoots(cb);
                    //set chances of armor drop
                    skeleton.getEquipment().setHelmetDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setChestplateDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setLeggingsDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setBootsDropChance(percentDropChanceArmor);
                }
                if (chance >= 26 && chance <= 51){
                    //Enchant the bow and give to the skeleton
                    pB.addEnchantment(Enchantment.ARROW_KNOCKBACK, bowLevel);
                    skeleton.getEquipment().setItemInMainHand(pB);
                    //set weapon drop chance
                    skeleton.getEquipment().setItemInMainHandDropChance(percentDropWeapon);
                }
                if (chance >= 52 && chance <= 62){
                    //give skeleton the buff
                    skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,240,2));
                }
                if (chance >= 63 && chance <= 73){
                    //enchant the armor and give it to the skeleton
                    cl.addEnchantment(Enchantment.THORNS, armorLevel);
                    cb.addEnchantment(Enchantment.THORNS, armorLevel);
                    skeleton.getEquipment().setLeggings(cl);
                    skeleton.getEquipment().setBoots(cb);
                    //give skeleton the buff
                    skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,240,2));
                    //set armor drop chance
                    skeleton.getEquipment().setLeggingsDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setBootsDropChance(percentDropChanceArmor);
                }
                if (chance >= 74 && chance <= 79){
                    //enchant the armor
                    ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    cb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    //give skeleton the armor
                    skeleton.getEquipment().setHelmet(ch);
                    skeleton.getEquipment().setChestplate(cc);
                    skeleton.getEquipment().setLeggings(cl);
                    skeleton.getEquipment().setBoots(cb);
                    //Enchant the bow and give to the skeleton
                    pB.addEnchantment(Enchantment.ARROW_KNOCKBACK, bowLevel);
                    skeleton.getEquipment().setItemInMainHand(pB);
                    //give skeleton the buff
                    skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,240,2));
                    //set armor drop chance percent
                    skeleton.getEquipment().setHelmetDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setChestplateDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setLeggingsDropChance(percentDropChanceArmor);
                    skeleton.getEquipment().setBootsDropChance(percentDropChanceArmor);
                    //set weapon drop chance
                    skeleton.getEquipment().setItemInMainHandDropChance(percentDropWeapon);
                }
            }
        }
    }

}
