package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSSPMetalCasing extends VariantBlockCasing<BlockSSPMetalCasing.SSPMetalCasingType> {

    public BlockSSPMetalCasing() {
        super(Material.IRON);
        setTranslationKey("ssp_metal_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
        setDefaultState(getState(SSPMetalCasingType.DATA));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    public enum SSPMetalCasingType implements IStringSerializable {

        DATA("data"),
        FIELD_GENERATOR("fieldgen"),
        EXTREME("extreme"),
        BACTERIAL_REFLECTIVE("bacterial_reflective"),
        CHEMICALLY_INERT("chemically_inert"),
        HEATER_BLOCK("heater_block"),
        SOLID_TEMPERED_HSS_E_CASING("solid_tempered_hss_e_casing"),
        SOLID_HSS_G_CASING("solid_hss_g_casing"),
        PLASMA_INJECTOR("plasma_injector"),
        FUSION_3("fusion_3");


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
