package stevekung.mods.moreplanets.module.planets.nibiru.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.init.MPPotions;
import stevekung.mods.moreplanets.module.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.util.DamageSourceMP;
import stevekung.mods.moreplanets.util.entity.EntityArrowMP;

public class EntityInfectedArrow extends EntityArrowMP
{
    public EntityInfectedArrow(World world)
    {
        super(world);
    }

    public EntityInfectedArrow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public EntityInfectedArrow(World world, EntityLivingBase shooter, float velocity)
    {
        super(world, shooter, velocity);
    }

    public EntityInfectedArrow(World world, EntityLivingBase shooter, EntityLivingBase target, float velocity, float inaccuracy)
    {
        super(world, shooter, target, velocity, inaccuracy);
    }

    @Override
    public void addEffect(EntityLivingBase living)
    {
        if (!this.worldObj.isRemote)
        {
            living.addPotionEffect(new PotionEffect(MPPotions.INFECTED_SPORE.id, 80, 0));
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0)
        {
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(new ItemStack(NibiruItems.INFECTED_ARROW, 1)))
            {
                flag = false;
            }
            if (flag)
            {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    @Override
    public DamageSource[] getDamageSource()
    {
        return new DamageSource[] {DamageSourceMP.causeInfectedArrowDamage(this, this), DamageSourceMP.causeInfectedArrowDamage(this, this.shootingEntity)};
    }
}