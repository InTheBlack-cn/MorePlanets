package stevekung.mods.moreplanets.init;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import stevekung.mods.moreplanets.core.MorePlanetsMod;
import stevekung.mods.moreplanets.entity.EntityAntiGravFallingBlock;
import stevekung.mods.moreplanets.entity.EntityBlackHole;
import stevekung.mods.moreplanets.entity.EntityBlackHoleStorage;
import stevekung.mods.moreplanets.entity.EntitySpaceMinecartChest;
import stevekung.mods.moreplanets.entity.projectile.EntityLaserBullet;
import stevekung.mods.moreplanets.entity.projectile.EntitySpaceFishHook;
import stevekung.mods.moreplanets.moons.koentus.entity.EntityFallingKoentusMeteor;
import stevekung.mods.moreplanets.moons.koentus.entity.EntityKoentusMeteor;
import stevekung.mods.moreplanets.planets.chalos.entity.EntityCheeseCow;
import stevekung.mods.moreplanets.planets.chalos.entity.EntityCheeseCubeEyeBoss;
import stevekung.mods.moreplanets.planets.chalos.entity.EntityCheeseFloater;
import stevekung.mods.moreplanets.planets.chalos.entity.EntityCheeseSlime;
import stevekung.mods.moreplanets.planets.chalos.entity.projectile.EntityCheeseSpore;
import stevekung.mods.moreplanets.planets.chalos.entity.projectile.EntitySmallCheeseSpore;
import stevekung.mods.moreplanets.planets.diona.entity.*;
import stevekung.mods.moreplanets.planets.diona.entity.projectile.EntityAntiGravityArrow;
import stevekung.mods.moreplanets.planets.diona.entity.projectile.EntityInfectedPurloniteArrow;
import stevekung.mods.moreplanets.planets.fronos.entity.EntityBearry;
import stevekung.mods.moreplanets.planets.fronos.entity.EntityGiantBlueberry;
import stevekung.mods.moreplanets.planets.fronos.entity.EntityJellySlime;
import stevekung.mods.moreplanets.planets.fronos.entity.EntityMarshmallow;
import stevekung.mods.moreplanets.planets.nibiru.entity.*;
import stevekung.mods.moreplanets.planets.nibiru.entity.projectile.*;
import stevekung.mods.moreplanets.planets.nibiru.entity.weather.EntityNibiruLightningBolt;
import stevekung.mods.stevekunglib.utils.ColorUtils;
import stevekung.mods.stevekunglib.utils.enums.EnumEntityTrackerType;

public class MPEntities
{
    public static void init()
    {
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityAlbetiusWorm.class, "albetius_worm", ColorUtils.rgbToDecimal(137, 115, 196), ColorUtils.rgbToDecimal(52, 38, 89));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedPurloniteSpider.class, "infected_purlonite_spider", ColorUtils.rgbToDecimal(51, 26, 63), ColorUtils.rgbToDecimal(188, 159, 242));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedPurloniteWorm.class, "infected_purlonite_worm", ColorUtils.rgbToDecimal(102, 80, 146), ColorUtils.rgbToDecimal(147, 111, 213));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedPurloniteSlimeBoss.class, "infected_purlonite_slime_boss", ColorUtils.rgbToDecimal(59, 50, 71), ColorUtils.rgbToDecimal(91, 19, 110));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityZeliusZombie.class, "zelius_zombie", ColorUtils.rgbToDecimal(23, 130, 130), ColorUtils.rgbToDecimal(108, 94, 118));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityZeliusCreeper.class, "zelius_creeper", ColorUtils.rgbToDecimal(87, 72, 124), ColorUtils.rgbToDecimal(44, 22, 69));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityCheeseCubeEyeBoss.class, "cheese_cube_eye_boss", ColorUtils.rgbToDecimal(255, 218, 131), ColorUtils.rgbToDecimal(194, 39, 36));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityCheeseFloater.class, "cheese_floater", ColorUtils.rgbToDecimal(255, 218, 131), ColorUtils.rgbToDecimal(19, 38, 201));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityCheeseSlime.class, "cheese_slime", ColorUtils.rgbToDecimal(255, 218, 131), ColorUtils.rgbToDecimal(255, 228, 162));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityCheeseCow.class, "cheese_cow", ColorUtils.rgbToDecimal(108, 84, 28), ColorUtils.rgbToDecimal(255, 227, 160));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityGiantWorm.class, "giant_worm", -2060769, -1413099);
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedZombie.class, "infected_zombie", ColorUtils.rgbToDecimal(74, 55, 50), ColorUtils.rgbToDecimal(66, 25, 15));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityAlienMiner.class, "alien_miner", ColorUtils.rgbToDecimal(75, 75, 75), ColorUtils.rgbToDecimal(176, 193, 227));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedPurloniteSlimeMinion.class, "infected_purlonite_slime_minion", ColorUtils.rgbToDecimal(59, 50, 71), ColorUtils.rgbToDecimal(91, 19, 110));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedWorm.class, "infected_worm", ColorUtils.rgbToDecimal(150, 52, 32), ColorUtils.rgbToDecimal(160, 70, 52));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedSnowman.class, "infected_snowman", ColorUtils.rgbToDecimal(164, 101, 84), ColorUtils.rgbToDecimal(145, 145, 145));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityZeliusSkeleton.class, "zelius_skeleton", ColorUtils.rgbToDecimal(100, 85, 106), ColorUtils.rgbToDecimal(120, 86, 188));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedGuardian.class, "infected_guardian", ColorUtils.rgbToDecimal(133, 79, 64), ColorUtils.rgbToDecimal(112, 97, 197));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedElderGuardian.class, "infected_elder_guardian", ColorUtils.rgbToDecimal(114, 118, 151), ColorUtils.rgbToDecimal(41, 42, 46));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedSquid.class, "infected_squid", ColorUtils.rgbToDecimal(70, 29, 20), ColorUtils.rgbToDecimal(143, 77, 54), 64, 3);
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedChicken.class, "infected_chicken", ColorUtils.rgbToDecimal(148, 119, 108), ColorUtils.rgbToDecimal(88, 35, 19));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedCow.class, "infected_cow", ColorUtils.rgbToDecimal(95, 59, 36), ColorUtils.rgbToDecimal(66, 66, 66));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedCaveSpider.class, "infected_cave_spider", ColorUtils.rgbToDecimal(120, 54, 7), ColorUtils.rgbToDecimal(0, 204, 0));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityZergius.class, "zergius", ColorUtils.rgbToDecimal(176, 176, 124), ColorUtils.rgbToDecimal(121, 239, 51));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityShlime.class, "shlime", 15198183, ColorUtils.rgbToDecimal(151, 69, 46));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityNibiruVillager.class, "nibiru_villager", ColorUtils.rgbToDecimal(106, 79, 72), ColorUtils.rgbToDecimal(169, 90, 67));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedCreeper.class, "infected_creeper", ColorUtils.rgbToDecimal(159, 74, 40), ColorUtils.rgbToDecimal(66, 26, 16));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityInfectedSkeleton.class, "infected_skeleton", ColorUtils.rgbToDecimal(129, 54, 15), ColorUtils.rgbToDecimal(57, 30, 19));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityVeinFloater.class, "vein_floater", ColorUtils.rgbToDecimal(132, 68, 28), ColorUtils.rgbToDecimal(79, 49, 28));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityVeinFloaterMinion.class, "vein_floater_minion", ColorUtils.rgbToDecimal(132, 68, 28), ColorUtils.rgbToDecimal(79, 49, 28));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityMiniVeinFloater.class, "mini_vein_floater", ColorUtils.rgbToDecimal(132, 68, 28), ColorUtils.rgbToDecimal(79, 49, 28));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityGiantBlueberry.class, "giant_blueberry", ColorUtils.rgbToDecimal(69, 88, 156), ColorUtils.rgbToDecimal(79, 100, 177));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityMarshmallow.class, "marshmallow", ColorUtils.rgbToDecimal(225, 215, 206), ColorUtils.rgbToDecimal(128, 128, 128));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityBearry.class, "bearry", ColorUtils.rgbToDecimal(179, 47, 47), ColorUtils.rgbToDecimal(0, 143, 0));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityJellySlime.class, "jelly_slime", ColorUtils.rgbToDecimal(244, 69, 109), ColorUtils.rgbToDecimal(199, 56, 89));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityTerrastoneGolem.class, "terrastone_golem", ColorUtils.rgbToDecimal(101, 78, 83), ColorUtils.rgbToDecimal(101, 130, 56));
        MorePlanetsMod.COMMON_REGISTRY.registerEntity(EntityTerrasquid.class, "terrasquid", ColorUtils.rgbToDecimal(106, 152, 187), ColorUtils.rgbToDecimal(109, 219, 210));

        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntitySpaceMinecartChest.class, "space_minecart_chest");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedPurloniteTentacle.class, "infected_purlonite_tentacle");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityCheeseSpore.class, "cheese_spore", 256, 1, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntitySmallCheeseSpore.class, "small_cheese_spore", 256, 1, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedPurloniteBomb.class, "infected_purlonite_bomb", EnumEntityTrackerType.THROWABLE_LARGE);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityNibiruLightningBolt.class, "nibiru_lightning_bolt");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityDarkLightningBolt.class, "dark_lightning_bolt");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedSnowball.class, "infected_snowball", EnumEntityTrackerType.THROWABLE_LARGE);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityPurifiedSnowball.class, "purified_snowball", EnumEntityTrackerType.THROWABLE_LARGE);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityBlackHole.class, "black_hole");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedEgg.class, "infected_egg", EnumEntityTrackerType.THROWABLE_LARGE);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedPurloniteArrow.class, "infected_purlonite_arrow", EnumEntityTrackerType.ARROW);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityInfectedArrow.class, "infected_arrow", EnumEntityTrackerType.ARROW);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntitySpaceFishHook.class, "space_fish_hook", EnumEntityTrackerType.FISHING_HOOK);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityAlienBeam.class, "alien_beam");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityVeinEye.class, "vein_eye", 64, 4, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityLaserBullet.class, "laser_bullet", 60, 10, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityVeinBall.class, "vein_ball", 256, 1, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityBlackHoleStorage.class, "black_hole_storage");
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityAntiGravityArrow.class, "anti_gravity_arrow", EnumEntityTrackerType.ARROW);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityFallingKoentusMeteor.class, "falling_koentus_meteor", 160, 20, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityAntiGravFallingBlock.class, "anti_gravity_falling_block", 80, 1, true);
        MorePlanetsMod.COMMON_REGISTRY.registerNonMobEntity(EntityKoentusMeteor.class, "koentus_meteor", 150, 5, true);

        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityAlienMiner.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityZeliusZombie.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityZeliusCreeper.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityCheeseFloater.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityCheeseSlime.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityCheeseCow.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityGiantWorm.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedZombie.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedSnowman.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityZeliusSkeleton.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedGuardian.class, SpawnPlacementType.IN_WATER);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedSquid.class, SpawnPlacementType.IN_WATER);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedChicken.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedCow.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityZergius.class, SpawnPlacementType.IN_AIR);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityShlime.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedCreeper.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityInfectedSkeleton.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityGiantBlueberry.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityMarshmallow.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityBearry.class, SpawnPlacementType.ON_GROUND);
        MorePlanetsMod.COMMON_REGISTRY.registerEntityPlacement(EntityJellySlime.class, SpawnPlacementType.ON_GROUND);
    }
}