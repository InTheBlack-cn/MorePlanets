package stevekung.mods.moreplanets.planets.nibiru.world.gen.biome;

public class BiomeInfectedRiver extends BiomeNibiru
{
    public BiomeInfectedRiver(BiomeProperties prop)
    {
        super(prop);
        this.decorator.infectedTallGrassPerChunk = 2;
        this.decorator.reedsPerChunk = 10;
    }
}