package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNonEbfCoil extends VariantBlockCasing<BlockNonEbfCoil.NonEbfCoilType> {

    public BlockNonEbfCoil() {
        super(Material.IRON);
        setTranslationKey("non_ebf_coil");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
        setDefaultState(getState(NonEbfCoilType.FUSION_MK1));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    public enum NonEbfCoilType implements IStringSerializable {

        FUSION_MK1("fusion_coil_mk1"),
        FUSION_MK2("fusion_coil_mk2"),
        FUSION_MK3("fusion_coil_mk3");

        private final String name;

        NonEbfCoilType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }

}
