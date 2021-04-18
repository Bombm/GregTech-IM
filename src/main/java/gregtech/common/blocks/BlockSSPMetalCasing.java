package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSSPMetalCasing extends VariantBlock<BlockSSPMetalCasing.SSPMetalCasingType> {

    public BlockSSPMetalCasing() {
        super(Material.IRON);
        setUnlocalizedName("ssp_metal_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
        setDefaultState(getState(SSPMetalCasingType.Data));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    public enum SSPMetalCasingType implements IStringSerializable {

        Data("data"),
        FieldGen("fieldgen"),
        Extreme("extreme"),
        Bacterial_reflective("bacterial_reflective"),
        Chemically_inert("chemically_inert"),
        Heater_block("heater_block"),
        Solid_tempered_hss_e_casing("solid_tempered_hss_e_casing"),
        Solid_hss_g_casing("solid_hss_g_casing"),
        Plasma_injector("plasma_injector"),
        Fusion_3("fusion_3");


        private final String name;

        SSPMetalCasingType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }
}
