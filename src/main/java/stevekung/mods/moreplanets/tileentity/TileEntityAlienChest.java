package stevekung.mods.moreplanets.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import stevekung.mods.moreplanets.init.MPBlocks;
import stevekung.mods.moreplanets.utils.tileentity.TileEntityChestMP;

public class TileEntityAlienChest extends TileEntityChestMP
{
    public TileEntityAlienChest()
    {
        super(MPBlocks.ALIEN_CHEST);
    }

    @Override
    public void checkForAdjacentChests()
    {
        if (!this.adjacentChestChecked)
        {
            if (this.world == null || !this.world.isAreaLoaded(this.pos, 1))
            {
                return;
            }
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
            this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
            this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
            this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
        }
    }

    private TileEntityAlienChest getAdjacentChest(EnumFacing side)
    {
        BlockPos blockpos = this.pos.offset(side);

        if (this.isChestAt(blockpos))
        {
            TileEntity tileentity = this.world.getTileEntity(blockpos);

            if (tileentity instanceof TileEntityAlienChest)
            {
                TileEntityAlienChest tileentitychest = (TileEntityAlienChest)tileentity;
                tileentitychest.setNeighbor(this, side.getOpposite());
                return tileentitychest;
            }
        }
        return null;
    }
}