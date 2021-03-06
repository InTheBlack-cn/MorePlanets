package stevekung.mods.moreplanets.planets.nibiru.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.init.MPBlocks;

public class WorldGenInfectedIcePath extends WorldGenerator
{
    private final int basePathWidth;

    public WorldGenInfectedIcePath(int basePathWidth)
    {
        this.basePathWidth = basePathWidth;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        while (world.isAirBlock(pos) && pos.getY() > 2)
        {
            pos = pos.down();
        }
        if (world.getBlockState(pos).getBlock() != MPBlocks.INFECTED_SNOW)
        {
            return false;
        }
        else
        {
            int i = rand.nextInt(this.basePathWidth - 2) + 2;
            for (int k = pos.getX() - i; k <= pos.getX() + i; ++k)
            {
                for (int l = pos.getZ() - i; l <= pos.getZ() + i; ++l)
                {
                    int i1 = k - pos.getX();
                    int j1 = l - pos.getZ();

                    if (i1 * i1 + j1 * j1 <= i * i)
                    {
                        for (int k1 = pos.getY() - 1; k1 <= pos.getY() + 1; ++k1)
                        {
                            BlockPos blockpos = new BlockPos(k, k1, l);
                            Block block = world.getBlockState(blockpos).getBlock();

                            if (block == MPBlocks.INFECTED_DIRT || block == MPBlocks.INFECTED_SNOW || block == MPBlocks.INFECTED_ICE)
                            {
                                world.setBlockState(blockpos, MPBlocks.INFECTED_PACKED_ICE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}