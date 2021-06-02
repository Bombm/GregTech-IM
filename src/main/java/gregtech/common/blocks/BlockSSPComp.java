package gregtech.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSSPComp extends VariantBlockCasing<BlockSSPComp.SSPCompBlock> {

    public BlockSSPComp() {
        super(Material.ROCK);
        setTranslationKey("mainframe_block");
        setHardness(3.0f);
        setResistance(3.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(getState(SSPCompBlock.wetware));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    public enum SSPCompBlock implements IStringSerializable {

        wetware("wetware"),
        bioware("bioware"),
        micro("micro"),
        high_energy("high_energy"),
        quantum_mk_2("quantum_mk_2");

        private final String name;

        SSPCompBlock(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }

}
