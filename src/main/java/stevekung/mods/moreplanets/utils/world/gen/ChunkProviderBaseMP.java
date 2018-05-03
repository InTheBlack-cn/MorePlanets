package stevekung.mods.moreplanets.utils.world.gen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public abstract class ChunkProviderBaseMP extends ChunkGeneratorOverworld
{
    protected NoiseModule noiseGen1;
    protected NoiseModule noiseGen2;
    protected NoiseModule noiseGen3;
    protected NoiseModule noiseGen4;
    protected World worldObj;
    protected Random rand;
    private int CHUNK_SIZE_X = 16;
    private int CHUNK_SIZE_Y = 128;
    private int CHUNK_SIZE_Z = 16;

    public ChunkProviderBaseMP(World world, long seed)
    {
        super(world, seed, true, "");
        this.worldObj = world;
        this.rand = new Random(seed);
        this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen3 = new Gradient(this.rand.nextLong(), 1, 0.25F);
        this.noiseGen4 = new Gradient(this.rand.nextLong(), 1, 0.25F);
    }

    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        this.noiseGen1.setFrequency(0.0125F);
        this.noiseGen2.setFrequency(0.015F);
        this.noiseGen3.setFrequency(0.01F);
        this.noiseGen4.setFrequency(0.02F);

        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double d = this.noiseGen1.getNoise(x + chunkX * 16, z + chunkZ * 16) * 8;
                double d2 = this.noiseGen2.getNoise(x + chunkX * 16, z + chunkZ * 16) * 24;
                double d3 = this.noiseGen3.getNoise(x + chunkX * 16, z + chunkZ * 16) - 0.1;
                d3 *= 4;

                double yDev = 0;

                if (d3 < 0.0D)
                {
                    yDev = d;
                }
                else if (d3 > 1.0D)
                {
                    yDev = d2;
                }
                else
                {
                    yDev = d + (d2 - d) * d3;
                }

                for (int y = 0; y < this.CHUNK_SIZE_Y; y++)
                {
                    if (y < this.getTerrainHeight() + yDev)
                    {
                        chunk.setBlockState(x, y, z, this.getStoneBlock());
                    }
                }
            }
        }
    }

    @Override
    public void replaceBiomeBlocks(int chunkX, int chunkZ, ChunkPrimer chunk, Biome[] biomeGen)
    {
        int seaLevel = 20;

        for (int x = 0; x < 16; ++x)
        {
            for (int z = 0; z < 16; ++z)
            {
                int noise = (int) (this.noiseGen4.getNoise(x + chunkX * 16, z * chunkZ * 16) / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int j = -1;
                IBlockState topBlock = this.getTopBlock();
                IBlockState fillBlock = this.getSubBlock();

                for (int y = 255; y >= 0; --y)
                {
                    if (y <= 0 + this.rand.nextInt(5))
                    {
                        chunk.setBlockState(x, y, z, Blocks.BEDROCK.getDefaultState());
                    }
                    else
                    {
                        IBlockState iblockstate2 = chunk.getBlockState(x, y, z);

                        if (iblockstate2.getMaterial() == Material.AIR)
                        {
                            j = -1;
                        }
                        else if (iblockstate2.getBlock() == this.getStoneBlock().getBlock())
                        {
                            if (j == -1)
                            {
                                if (noise <= 0)
                                {
                                    topBlock = Blocks.AIR.getDefaultState();
                                    fillBlock = this.getStoneBlock();
                                }
                                else if (y >= seaLevel - 4 && y <= seaLevel + 1)//-16
                                {
                                    topBlock = this.getTopBlock();
                                    fillBlock = this.getSubBlock();
                                }

                                j = noise;

                                if (y >= seaLevel - 1)
                                {
                                    chunk.setBlockState(x, y, z, topBlock);
                                }
                                else if (y < seaLevel - 1 && y >= seaLevel - 2)
                                {
                                    chunk.setBlockState(x, y, z, fillBlock);
                                }
                            }
                            else if (j > 0)
                            {
                                --j;
                                chunk.setBlockState(x, y, z, fillBlock);
                            }
                        }
                    }
                }
            }
        }
    }

    public void createCraters(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        for (int cx = chunkX - 2; cx <= chunkX + 2; cx++)
        {
            for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++)
            {
                for (int x = 0; x < this.CHUNK_SIZE_X; x++)
                {
                    for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
                    {
                        if (this.getCraterChance() > 0)
                        {
                            if (Math.abs(this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.noiseGen4.getNoise(x * this.CHUNK_SIZE_X + x, cz * this.CHUNK_SIZE_Z + z) / this.getCraterChance())
                            {
                                Random random = new Random(cx * 16 + x + (cz * 16 + z) * 5000);
                                EnumCraterSize cSize = EnumCraterSize.sizeArray[random.nextInt(EnumCraterSize.sizeArray.length)];
                                int size = random.nextInt(cSize.MAX_SIZE - cSize.MIN_SIZE) + cSize.MIN_SIZE;
                                this.makeCrater(cx * 16 + x, cz * 16 + z, chunkX * 16, chunkZ * 16, size, chunk);
                            }
                        }
                    }
                }
            }
        }
    }

    public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, ChunkPrimer chunk)
    {
        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double xDev = craterX - (chunkX + x);
                double zDev = craterZ - (chunkZ + z);

                if (xDev * xDev + zDev * zDev < size * size)
                {
                    xDev /= size;
                    zDev /= size;
                    double sqrtY = xDev * xDev + zDev * zDev;
                    double yDev = sqrtY * sqrtY * 6;
                    yDev = 5 - yDev;
                    int helper = 0;

                    for (int y = 127; y > 0; y--)
                    {
                        if (Blocks.AIR != chunk.getBlockState(x, y, z).getBlock() && helper <= yDev)
                        {
                            chunk.setBlockState(x, y, z, Blocks.AIR.getDefaultState());
                            helper++;
                        }
                        if (helper > yDev)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    private double randFromPoint(int x, int z)
    {
        int n;
        n = x + z * 57;
        n = n << 13 ^ n;
        return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType type, BlockPos pos)
    {
        return this.worldObj.getBiome(pos).getSpawnableList(type);
    }

    protected int getCraterChance()
    {
        return 300;
    }

    protected int getTerrainHeight()
    {
        return 64;
    }

    protected abstract IBlockState getTopBlock();
    protected abstract IBlockState getSubBlock();
    protected abstract IBlockState getStoneBlock();
}