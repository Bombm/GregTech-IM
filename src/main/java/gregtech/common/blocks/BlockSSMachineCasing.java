package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSSMachineCasing extends VariantBlock<BlockSSMachineCasing.SSMachineCasingType> {

    public BlockSSMachineCasing() {
        super(Material.IRON);
        setUnlocalizedName("ss_machine_casing");
        setHardness(4.0f);
        setResistance(8.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(SSMachineCasingType.UHV));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    public enum SSMachineCasingType implements IStringSerializable {

        //Voltage-tiered casings
        UHV("ultra_high_voltage"),
        UEV("ultra_extreme_voltage"),
        UIV("ultra_insane_voltage"),
        UMV("ultra_mad_voltage"),
        UXV("ultra_x_voltage"),
        OpV("overpowered_voltage");

        private final String name;

        SSMachineCasingType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }

}

