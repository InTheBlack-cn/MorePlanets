package stevekung.mods.moreplanets.planets.nibiru.world.gen.biome;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.init.MPBlocks;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.BiomeDecoratorNibiru;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.feature.WorldGenInfectedBigTree;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.feature.WorldGenInfectedTrees;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.feature.WorldGenInfectedVinesDirt;
import stevekung.mods.moreplanets.planets.nibiru.world.gen.feature.WorldGenNibiruFossils;
import stevekung.mods.moreplanets.utils.world.gen.biome.BiomeMP;

public class BiomeNibiru extends BiomeMP
{
    protected IBlockState stoneBlock;
    protected IBlockState liquidBlock;
    protected BiomeDecoratorNibiru decorator = new BiomeDecoratorNibiru();
    protected static final WorldGenInfectedBigTree BIG_TREE = new WorldGenInfectedBigTree(true, MPBlocks.INFECTED_OAK_LOG.getDefaultState(), MPBlocks.INFECTED_OAK_LEAVES.getDefaultState());
    protected static final WorldGenInfectedBigTree BIG_TREE_NO_LEAVES = new WorldGenInfectedBigTree(false, MPBlocks.INFECTED_OAK_LOG.getDefaultState(), MPBlocks.INFECTED_OAK_LEAVES.getDefaultState());
    protected static final WorldGenInfectedTrees TREE = new WorldGenInfectedTrees(true, MPBlocks.INFECTED_OAK_LOG.getDefaultState(), MPBlocks.INFECTED_OAK_LEAVES.getDefaultState());
    protected static final WorldGenInfectedTrees TREE_NO_LEAVES = new WorldGenInfectedTrees(false, MPBlocks.INFECTED_OAK_LOG.getDefaultState(), MPBlocks.INFECTED_OAK_LEAVES.getDefaultState());
    protected static final WorldGenInfectedVinesDirt SCATTERED_DIRT = new WorldGenInfectedVinesDirt();
    protected static final WorldGenNibiruFossils FOSSILS = new WorldGenNibiruFossils();

    public BiomeNibiru(BiomeProperties prop)
    {
        super(prop);
        this.topBlock = MPBlocks.INFECTED_GRASS_BLOCK.getDefaultState();
        this.fillerBlock = MPBlocks.INFECTED_DIRT.getDefaultState();
        this.stoneBlock = MPBlocks.NIBIRU_ROCK.getDefaultState();
        this.liquidBlock = MPBlocks.INFECTED_WATER_FLUID_BLOCK.getDefaultState();
        this.decorator.clayPerChunk = 1;
        this.decorator.gravelPatchesPerChunk = 1;
        this.decorator.sandPatchesPerChunk = 3;
        this.decorator.pureHurbPerChunk = 4;
        this.decorator.treesPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = -999;
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos)
    {
        this.decorator.decorate(world, rand, this, pos);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return rand.nextInt(10) == 0 ? BiomeNibiru.BIG_TREE : BiomeNibiru.TREE;
    }

    @Override
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int chunkX, int chunkZ, double noiseVal)
    {
        int seaLevel = world.getSeaLevel();
        IBlockState topState = this.topBlock;
        IBlockState fillerState = this.fillerBlock;
        int j = -1;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int x = chunkZ & 15;// WTF??
        int z = chunkX & 15;// WTF??
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 255; y >= 0; --y)
        {
            if (y <= rand.nextInt(5))
            {
                primer.setBlockState(x, y, z, Blocks.BEDROCK.getDefaultState());
            }
            else
            {
                IBlockState stoneState = primer.getBlockState(x, y, z);

                if (stoneState.getMaterial() == Material.AIR)
                {
                    j = -1;
                }
                else if (stoneState.getBlock() == MPBlocks.NIBIRU_ROCK)
                {
                    primer.setBlockState(x, y, z, this.stoneBlock);

                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            topState = null;
                            fillerState = MPBlocks.NIBIRU_ROCK.getDefaultState();
                        }
                        else if (y >= seaLevel - 4 && y <= seaLevel + 1)
                        {
                            topState = this.topBlock;
                            fillerState = this.fillerBlock;
                        }

                        if (y < seaLevel && (topState == null || topState.getMaterial() == Material.AIR))
                        {
                            if (this.getTemperature(mutablePos.setPos(chunkX, y, chunkZ)) < 0.15F)
                            {
                                topState = MPBlocks.INFECTED_ICE.getDefaultState();
                            }
                            else
                            {
                                topState = this.liquidBlock;
                            }
                        }

                        j = k;

                        if (y >= seaLevel - 1)
                        {
                            primer.setBlockState(x, y, z, topState);
                        }
                        else if (y < seaLevel - 7 - k)
                        {
                            topState = null;
                            fillerState = MPBlocks.NIBIRU_ROCK.getDefaultState();
                            primer.setBlockState(x, y, z, MPBlocks.INFECTED_GRAVEL.getDefaultState());
                        }
                        else
                        {
                            primer.setBlockState(x, y, z, fillerState);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        primer.setBlockState(x, y, z, fillerState);

                        if (j == 0 && fillerState.getBlock() == MPBlocks.INFECTED_SAND)
                        {
                            j = rand.nextInt(4) + Math.max(0, y - 63);
                            fillerState = MPBlocks.INFECTED_SANDSTONE.getDefaultState();
                        }
                    }
                }
            }
        }
    }
}