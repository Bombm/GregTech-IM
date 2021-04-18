package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSolarCasing extends VariantBlock<BlockSolarCasing.SolarCasingType> {

    public BlockSolarCasing() {
        super(Material.IRON);
        setUnlocalizedName("ssp_solar_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
        setDefaultState(getState(SolarCasingType.SOLAR_PANEL_CASING_LV));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    public enum SolarCasingType implements IStringSerializable {

        SOLAR_PANEL_CASING_LV("ssp_solar_panel_casing_lv"),
        SOLAR_PANEL_CASING_MV("ssp_solar_panel_casing_mv"),
        SOLAR_PANEL_CASING_HV("ssp_solar_panel_casing_hv"),
        SOLAR_PANEL_CASING_EV("ssp_solar_panel_casing_ev"),
        SOLAR_PANEL_CASING_IV("ssp_solar_panel_casing_iv"),
        SOLAR_PANEL_CASING_LUV("ssp_solar_panel_casing_luv"),
        SOLAR_PANEL_CASING_ZPM("ssp_solar_panel_casing_zpm"),
        SOLAR_PANEL_CASING_UV("ssp_solar_panel_casing_uv"),
        SOLAR_PANEL_CASING_UHV("ssp_solar_panel_casing_uhv"),
        SOLAR_PANEL_CASING_UEV("ssp_solar_panel_casing_uev"),
        SOLAR_PANEL_CASING_UIV("ssp_solar_panel_casing_uiv"),
        SOLAR_PANEL_CASING_UMV("ssp_solar_panel_casing_umv"),
        SOLAR_PANEL_CASING_UXV("ssp_solar_panel_casing_uxv"),
        SOLAR_PANEL_CASING_OpV("ssp_solar_panel_casing_opv"),
        SOLAR_PANEL_CASING_MAX("ssp_solar_panel_casing_max");

        private final String name;

        SolarCasingType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }
}
