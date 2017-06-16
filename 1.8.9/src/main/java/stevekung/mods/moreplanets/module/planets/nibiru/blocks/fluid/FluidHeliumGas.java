package stevekung.mods.moreplanets.module.planets.nibiru.blocks.fluid;

import stevekung.mods.moreplanets.util.blocks.fluid.FluidMP;

public class FluidHeliumGas extends FluidMP
{
    public FluidHeliumGas(String name, String still, String flowing)
    {
        super(name, still, flowing);
        this.setDensity(-2000);
        this.setGaseous(true);
    }
}