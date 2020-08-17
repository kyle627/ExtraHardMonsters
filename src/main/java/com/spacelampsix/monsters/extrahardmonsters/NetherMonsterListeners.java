package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class NetherMonsterListeners implements Listener {
    Random rand = new Random();
    @EventHandler
    public void ghastSpawn(EntitySpawnEvent event){
        /**
         * Double ghast health
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.GHAST){
                final float doubleHealth = 25.0F;
                Ghast ghast = (Ghast) event.getEntity();
                ghast.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
                ghast.setHealth(doubleHealth);
            }
        }

    }
    @EventHandler
    public void zombiePigmanSpawn(EntitySpawnEvent event){

        ItemStack gh = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack gb = new ItemStack(Material.GOLDEN_BOOTS);
        ItemStack gs = new ItemStack(Material.GOLDEN_SWORD);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.ZOMBIFIED_PIGLIN){
                final int swordLevel = 2;
                final float swordDropChance = 0.12F;
                final float armorDropChance = 0.20F;
                int chance = rand.nextInt(10) + 1;
                PigZombie pigZombie = (PigZombie) event.getEntity();
                if (chance <= 3){
                    gs.addEnchantment(Enchantment.DAMAGE_ALL, swordLevel);
                    pigZombie.getEquipment().setItemInMainHand(gs);
                    pigZombie.getEquipment().setItemInMainHandDropChance(swordDropChance);
                }
                if (chance >= 6){
                    pigZombie.getEquipment().setHelmet(gh);
                    pigZombie.getEquipment().setBoots(gb);
                    pigZombie.getEquipment().setHelmetDropChance(armorDropChance);
                    pigZombie.getEquipment().setBootsDropChance(armorDropChance);
                }

            }
        }
    }
    @EventHandler
    public void blazeSpawn(EntitySpawnEvent event){
        /**
         * Double health
         * double damage see onDamage
         *
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.BLAZE){
                final float doubleHealth = 30.0F;
                Blaze blaze = (Blaze) event.getEntity();
                blaze.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
                blaze.setHealth(doubleHealth);
            }
        }
    }
    @EventHandler
    public void witherSkeletonSpawn(EntitySpawnEvent event){
        /**
         * Wither SKeletons
         * 1.5 x health 100%
         * Speed 100%
         * Chain gear with thorns 40%
         * stone swords with knock-back 20% on own and 10% of 40%
         */

        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);

        ItemStack ss = new ItemStack(Material.STONE_SWORD);

        if (event.getEntity() instanceof LivingEntity){
            int chance = rand.nextInt(10) + 1;
            final float dropChanceSword = 0.13F;
            final float armorDropChance = 0.15F;
            final float moreHealth = 30.0F;
            final int speedAmplifier = 1;
            final int swordLevel = 2;
            final int armorLevel = 1;
            final int duration = 240;
            if (event.getEntityType() == EntityType.WITHER_SKELETON){
                WitherSkeleton witherSkeleton = (WitherSkeleton) event.getEntity();
                witherSkeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(moreHealth);
                witherSkeleton.setHealth(moreHealth);
                witherSkeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, speedAmplifier));
                if (chance <= 4){
                    ch.addEnchantment(Enchantment.THORNS, armorLevel);
                    cc.addEnchantment(Enchantment.THORNS, armorLevel);
                    cl.addEnchantment(Enchantment.THORNS, armorLevel);
                    cb.addEnchantment(Enchantment.THORNS, armorLevel);
                    witherSkeleton.getEquipment().setHelmet(ch);
                    witherSkeleton.getEquipment().setChestplate(cc);
                    witherSkeleton.getEquipment().setLeggings(cl);
                    witherSkeleton.getEquipment().setBoots(cb);
                    witherSkeleton.getEquipment().setHelmetDropChance(armorDropChance);
                    witherSkeleton.getEquipment().setChestplateDropChance(armorDropChance);
                    witherSkeleton.getEquipment().setLeggingsDropChance(armorDropChance);
                    witherSkeleton.getEquipment().setBootsDropChance(armorDropChance);
                    if (chance == 1){
                        ss.addEnchantment(Enchantment.KNOCKBACK, swordLevel);
                        witherSkeleton.getEquipment().setItemInMainHand(ss);
                        witherSkeleton.getEquipment().setItemInMainHandDropChance(dropChanceSword);
                    }
                }
                if (chance >= 8){
                    ss.addEnchantment(Enchantment.KNOCKBACK, swordLevel);
                    witherSkeleton.getEquipment().setItemInMainHand(ss);
                    witherSkeleton.getEquipment().setItemInMainHandDropChance(dropChanceSword);
                }
            }
        }
    }
    @EventHandler
    public void piglinSpawn(EntitySpawnEvent event){
        ItemStack gh = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack gc = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack gl = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemStack gb = new ItemStack(Material.GOLDEN_BOOTS);

        ItemStack cb = new ItemStack(Material.CROSSBOW);
        ItemStack gs = new ItemStack(Material.GOLDEN_SWORD);
        /**
         * 50% chance FULL gold || 10% Knock back 1 gold sword
         * 10% multi-shot crossbow
         * 20% speed 2 and sharp 1 golden sword
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.PIGLIN){
                final float swordDropChance = 0.20F;
                final float crossbowDropChance = 0.20F;
                final float armorDropChance = 0.20F;
                final int duration = 240;
                final int speedLevel = 2;
                final int multiShotLevel = 1;
                final int swordKnockBackLevel = 1;
                final int swordSharpnessLevel = 1;

                int chance = rand.nextInt(10) + 1;
                Piglin piglin = (Piglin) event.getEntity();
                if (chance >= 5){
                    piglin.getEquipment().setHelmet(gh);
                    piglin.getEquipment().setChestplate(gc);
                    piglin.getEquipment().setLeggings(gl);
                    piglin.getEquipment().setBoots(gb);
                    piglin.getEquipment().setHelmetDropChance(armorDropChance);
                    piglin.getEquipment().setChestplateDropChance(armorDropChance);
                    piglin.getEquipment().setLeggingsDropChance(armorDropChance);
                    piglin.getEquipment().setBootsDropChance(armorDropChance);
                    if (chance == 1){
                        gs.addEnchantment(Enchantment.KNOCKBACK, swordKnockBackLevel);
                        piglin.getEquipment().setItemInMainHand(gs);
                        piglin.getEquipment().setItemInMainHandDropChance(swordDropChance);
                    }
                }
                if (chance >= 8){
                    piglin.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, speedLevel));
                    gs.addEnchantment(Enchantment.DAMAGE_ALL, swordSharpnessLevel);
                    piglin.getEquipment().setItemInMainHand(gs);
                    piglin.getEquipment().setItemInMainHandDropChance(swordDropChance);
                }
                if (chance == 6){
                    cb.addEnchantment(Enchantment.MULTISHOT, multiShotLevel);
                    piglin.getEquipment().setItemInMainHand(cb);
                    piglin.getEquipment().setItemInMainHandDropChance(crossbowDropChance);
                }
            }
        }

    }
    @EventHandler
    public void magmaCubeSpawn(EntitySpawnEvent event){
        //magma cubes are lame.
    }
    @EventHandler
    public void hoglinSpawn(EntitySpawnEvent event){
        /**
         * 1.5x damage
         * 2x health
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.HOGLIN){
                final float health = 40.0F;
                Hoglin hoglin = (Hoglin) event.getEntity();
                hoglin.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                hoglin.setHealth(health);
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Monster) {
            if (event.getEntityType() == EntityType.GHAST ||
                    event.getEntityType() == EntityType.BLAZE){
                event.setDamage(event.getDamage() * 2);
            }
            if (event.getEntityType() == EntityType.HOGLIN){
                event.setDamage(event.getDamage() * 1.5);
            }
        }
    }

}
