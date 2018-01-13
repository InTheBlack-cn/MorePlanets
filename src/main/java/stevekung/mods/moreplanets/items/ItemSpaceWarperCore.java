package stevekung.mods.moreplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.util.JsonUtil;
import stevekung.mods.moreplanets.util.items.ItemBaseMP;

public class ItemSpaceWarperCore extends ItemBaseMP
{
    public ItemSpaceWarperCore(String name)
    {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
        JsonUtil json = new JsonUtil();

        if (!player.worldObj.isRemote)
        {
            if (player.isSneaking())
            {
                if (GCCoreUtil.getDimensionID(world) == 0 || world.provider instanceof IGalacticraftWorldProvider)
                {
                    if (!itemStack.hasTagCompound())
                    {
                        itemStack.setTagCompound(new NBTTagCompound());
                        itemStack.getTagCompound().setInteger("DimensionID", GCCoreUtil.getDimensionID(world));
                        itemStack.getTagCompound().setInteger("X", MathHelper.floor_double(player.posX));
                        itemStack.getTagCompound().setInteger("Y", MathHelper.floor_double(player.posY));
                        itemStack.getTagCompound().setInteger("Z", MathHelper.floor_double(player.posZ));
                        itemStack.getTagCompound().setFloat("Pitch", player.rotationPitch);
                        itemStack.getTagCompound().setFloat("Yaw", player.rotationYaw);
                        player.addChatMessage(json.text(GCCoreUtil.translate("gui.warp_core_data_add.message")));
                        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
                    }
                    else
                    {
                        player.addChatMessage(json.text(GCCoreUtil.translate("gui.warp_core_data_add_fail.message")));
                    }
                }
                else
                {
                    player.addChatMessage(json.text(GCCoreUtil.translate("gui.space_dimension_only.message")).setStyle(json.red()));
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean advanced)
    {
        if (!itemStack.hasTagCompound())
        {
            return;
        }
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("DimensionID") || itemStack.getTagCompound().hasKey("X") || itemStack.getTagCompound().hasKey("Y") || itemStack.getTagCompound().hasKey("Z"))
        {
            list.add("Destination: " + itemStack.getTagCompound().getInteger("X") + " " + itemStack.getTagCompound().getInteger("Y") + " " + itemStack.getTagCompound().getInteger("Z"));
            list.add("Dimension ID: " + itemStack.getTagCompound().getInteger("DimensionID"));
            list.add("Dimension Name: " + WorldUtil.getProviderForDimensionClient(itemStack.getTagCompound().getInteger("DimensionID")).getDimensionType().getName());
        }
    }

    @Override
    public String getName()
    {
        return "space_warper_core";
    }
}