package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class OverworldMonsterListeners implements Listener {
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
                final int chance = rand.nextInt(10) + 1; //random number between 1 and 100
                final float health = 40.0F;
                Creeper creeper = (Creeper) event.getEntity();
                creeper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                creeper.setHealth(health);
                if (chance <= 3){
                    creeper.setExplosionRadius(10);
                }
                if (chance >= 7){
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
                int chance = rand.nextInt(100) + 1; //random number between 1 and 100
                final int armorLevel = 4;
                final float health = 40.0F;
                Zombie zombie = (Zombie) event.getEntity();
                zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                zombie.setHealth(health);
                if (chance >= 50){
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 240, 2));
                }
                if (chance >= 10 && chance <= 25){
                    if (chance == 15){
                        ih.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ic.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        il.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ib.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
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
                }
                if (chance <= 5){
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
                skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                skeleton.setHealth(health); //Double Health
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
                if (chance >= 26 && chance < 51){
                    //Enchant the bow and give to the skeleton
                    pB.addEnchantment(Enchantment.ARROW_KNOCKBACK, bowLevel);
                    skeleton.getEquipment().setItemInMainHand(pB);
                    //set weapon drop chance
                    skeleton.getEquipment().setItemInMainHandDropChance(percentDropWeapon);
                }
                if (chance >= 52 && chance < 62){
                    //give skeleton the buff
                    skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,240,2));
                }
                if (chance >= 63 && chance < 73){
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
                if (chance >= 74 && chance < 79){
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
    @EventHandler
    public void endermanSpawn(CreatureSpawnEvent event){
        /**
         * Enderman
         * All endermen have 1.5x health
         * All endermen do more damage per hit
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.ENDERMAN){
                final float health = 60.0F;
                final float damage = 7.0F;
                Enderman enderman = (Enderman) event.getEntity();
                enderman.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                enderman.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(damage);
                enderman.setHealth(health);
            }
        }
    }
    @EventHandler
    public void drownedSpawn(CreatureSpawnEvent event){
        /**
         * Drowned
         * double health
         * 50% of drowns spawn with trident
         * 25% of that 50% of the tridents will be enchanted with channeling
         * 15% will have full gold armor
         */

        ItemStack gh = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack gc = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack gl = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemStack gb = new ItemStack(Material.GOLDEN_LEGGINGS);

        ItemStack trident = new ItemStack(Material.TRIDENT);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.DROWNED){
                int chance = rand.nextInt(100) + 1;
                final int health = 45;
                final float dropChance = 0.15F; //armor and weapon
                Drowned drowned = (Drowned) event.getEntity();
                drowned.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                drowned.setHealth(health);
                if (chance >= 50){
                    if (chance > 75){
                        trident.addEnchantment(Enchantment.CHANNELING, 1);
                        drowned.getEquipment().setItemInMainHand(trident);
                    }
                    drowned.getEquipment().setItemInMainHand(trident);
                    drowned.getEquipment().setItemInMainHandDropChance(dropChance);
                }
                if (chance <= 15){
                    drowned.getEquipment().setHelmet(gh);
                    drowned.getEquipment().setChestplate(gc);
                    drowned.getEquipment().setLeggings(gl);
                    drowned.getEquipment().setBoots(gb);
                    drowned.getEquipment().setHelmetDropChance(dropChance);
                    drowned.getEquipment().setChestplateDropChance(dropChance);
                    drowned.getEquipment().setLeggingsDropChance(dropChance);
                    drowned.getEquipment().setBootsDropChance(dropChance);
                }
            }
        }
    }
    @EventHandler
    public void huskSpawn(CreatureSpawnEvent event){
        /**
         * Husk
         * Double Health
         * 50% Iron Axe
         * 25% of that 50% Leather Armor as well
         * 10% knock back 2 fire aspect 1 sword golden sword
         */

        ItemStack lh = new ItemStack(Material.LEATHER_HELMET);
        ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack lb = new ItemStack(Material.LEATHER_BOOTS);

        ItemStack ironAxe = new ItemStack(Material.IRON_AXE);
        ItemStack goldSword = new ItemStack(Material.IRON_SWORD);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.HUSK){
                int chance = rand.nextInt(100) + 1;
                final int health = 40;
                final float armorDropChance = 0.15F;
                final float weaponDropChanceAxe = 0.20F;
                final float weaponDropChanceSword = 0.08F;
                Husk husk = (Husk) event.getEntity();
                husk.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                husk.setHealth(health);
                if (chance >= 50){
                    if (chance > 75){
                        husk.getEquipment().setHelmet(lh);
                        husk.getEquipment().setChestplate(lc);
                        husk.getEquipment().setLeggings(ll);
                        husk.getEquipment().setBoots(lb);
                        husk.getEquipment().setHelmetDropChance(armorDropChance);
                        husk.getEquipment().setChestplateDropChance(armorDropChance);
                        husk.getEquipment().setLeggingsDropChance(armorDropChance);
                        husk.getEquipment().setBootsDropChance(armorDropChance);
                    }
                    husk.getEquipment().setItemInMainHand(ironAxe);
                    husk.getEquipment().setItemInMainHandDropChance(weaponDropChanceAxe);
                }
                if (chance <= 10){
                    goldSword.addEnchantment(Enchantment.FIRE_ASPECT , 1);
                    goldSword.addEnchantment(Enchantment.KNOCKBACK, 2);
                    husk.getEquipment().setItemInMainHand(goldSword);
                    husk.getEquipment().setItemInMainHandDropChance(weaponDropChanceSword);
                }
            }

        }
    }
    @EventHandler
    public void straySpawn(CreatureSpawnEvent event){
        /**
         * Stray
         * Double Health
         * 25% Chance Power 2 Punch 2 bow
         * 15% Speed 3 Chain chest-plate with protection 3, power 1 bow
         */

        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack bow = new ItemStack(Material.BOW);

        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.STRAY){
                int chance = rand.nextInt(100 ) + 1;
                final float health = 40.0F;
                final float bowDropChance = 0.9F;
                final float armorDropChance = 0.15F;
                Stray stray = (Stray) event.getEntity();
                stray.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                stray.setHealth(health);
                if (chance >= 75){
                    bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                    bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
                    stray.getEquipment().setItemInMainHand(bow);
                    stray.getEquipment().setItemInMainHandDropChance(bowDropChance);
                }
                if (chance <= 15){
                    stray.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 3));
                    cc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                    bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                    stray.getEquipment().setChestplate(cc);
                    stray.getEquipment().setItemInMainHand(bow);
                    stray.getEquipment().setItemInMainHandDropChance(bowDropChance);
                    stray.getEquipment().setChestplateDropChance(armorDropChance);
                }
            }
        }

    }
    @EventHandler
    public void spiderAndCaveSpiderSpawn(CreatureSpawnEvent event){
        /**
         * Spider's Health is doubled
         * There's not too much you can do with them
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.SPIDER || event.getEntityType() == EntityType.CAVE_SPIDER){
                final int health = 40;
                Spider spider = (Spider) event.getEntity();
                CaveSpider caveSpider = (CaveSpider) event.getEntity();
                spider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                caveSpider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                spider.setHealth(health);
                caveSpider.setHealth(health);
            }
        }
    }
    @EventHandler
    public void phantomSpawn(CreatureSpawnEvent event){
        /**
         * Not much we can do with phantoms
         *  3x health
         *  speed 2
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.PHANTOM){
                final float health = 60.0F;
                Phantom phantom = (Phantom) event.getEntity();
                phantom.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 3));
                phantom.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                phantom.setHealth(health);
            }
        }
    }
    @EventHandler
    public void meanVillagerTypesSpawn(CreatureSpawnEvent event){
        /**
         * This method will include
         * witches, pillagers, ravangers, vex, zombie villager
         * Mobs will have more health (Not all Double)
         * Increased Attack damage
         * Speed 2
         */

        ItemStack lh = new ItemStack(Material.LEATHER_HELMET);
        ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack lb = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack is = new ItemStack(Material.IRON_SWORD);

        ItemStack cb = new ItemStack(Material.CROSSBOW);

        if (event.getEntity() instanceof LivingEntity){
            int chance = rand.nextInt(100) + 1;
            final float doubleHealth = 40.0F;

            if (event.getEntityType() == EntityType.ZOMBIE_VILLAGER){
                /**
                 * Zombie Villager has double health
                 * 35% chance of leather gear and 20% of that 35% chance will be enchanted protection 4
                 * will have a sword too
                 */
                final float armorDropChance = 0.20F;
                final float swordDropChance = 0.25F;
                final int armorLevel = 4;
                ZombieVillager zombieVillager = (ZombieVillager) event.getEntity();
                zombieVillager.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
                zombieVillager.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240 , 2));
                zombieVillager.setHealth(doubleHealth);
                if (chance >= 65){
                    if (chance >= 80){
                        lh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        lc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        ll.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                        lb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, armorLevel);
                    }
                    zombieVillager.getEquipment().setHelmet(lh);
                    zombieVillager.getEquipment().setChestplate(lc);
                    zombieVillager.getEquipment().setLeggings(ll);
                    zombieVillager.getEquipment().setBoots(lb);
                    zombieVillager.getEquipment().setItemInMainHand(is);
                    zombieVillager.getEquipment().setHelmetDropChance(armorDropChance);
                    zombieVillager.getEquipment().setChestplateDropChance(armorDropChance);
                    zombieVillager.getEquipment().setLeggingsDropChance(armorDropChance);
                    zombieVillager.getEquipment().setBootsDropChance(armorDropChance);
                    //sword
                    zombieVillager.getEquipment().setItemInMainHand(is);
                    zombieVillager.getEquipment().setItemInMainHandDropChance(swordDropChance);
                }
            }
            if (event.getEntityType() == EntityType.WITCH){
                /**
                 * Witch has double health
                 * and speed 1.
                 */
                Witch witch = (Witch) event.getEntity();
                witch.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 1));
                witch.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
            }
            if (event.getEntityType() == EntityType.RAVAGER){
                //these guys are already beefy enough
                Ravager ravager = (Ravager) event.getEntity();
                ravager.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 1));
            }
            if (event.getEntityType() == EntityType.VEX){
                Vex vex = (Vex) event.getEntity();
                vex.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
                vex.setHealth(doubleHealth);
                is.addEnchantment(Enchantment.DAMAGE_ALL, 2);
                vex.getEquipment().setItemInMainHand(is);
                vex.getEquipment().setItemInMainHandDropChance(0.10F);
            }
            if (event.getEntityType() == EntityType.PILLAGER){
                final float isDropChance = 0.20F;
                final float cbDropChance = 0.15F;
                Pillager pillager = (Pillager) event.getEntity();
                if (chance <= 40){
                    pillager.getEquipment().setItemInMainHand(is);
                    pillager.getEquipment().setItemInMainHandDropChance(isDropChance);
                }
                if (chance >= 75){
                    cb.addEnchantment(Enchantment.QUICK_CHARGE, 2);
                    pillager.getEquipment().setItemInMainHand(cb);
                    pillager.getEquipment().setItemInMainHandDropChance(cbDropChance);
                }
            }

        }
    }
    @EventHandler
    public void guardianSpawn(CreatureSpawnEvent event){
        /**
         * Guardians have increased health
         * as well as speed 2
         */
        if (event.getEntity() instanceof LivingEntity){
            if (event.getEntityType() == EntityType.GUARDIAN){
                final float doubleHealth = 60.0F;
                Guardian guardian = (Guardian) event.getEntity();
                guardian.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(doubleHealth);
                guardian.setHealth(doubleHealth);
                guardian.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240 , 2));
            }
        }

    }
}
