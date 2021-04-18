package gregtech.common.metatileentities.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.render.Textures;
import gregtech.api.unification.material.Materials;
import gregtech.common.ConfigHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.fml.common.FMLLog;

/*public class MetaTileEntityChunkLoader extends TieredMetaTileEntity {
    private static final int PRODUCTION_CYCLE_LENGTH = 200;

    public MetaTileEntityChunkLoader(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new MetaTileEntityChunkLoader(metaTileEntityId, getTier());
    }

    @Override
    public void update() {
        super.update();

        if (!getWorld().isRemote) {
            long energyToConsume = 131072L;
            if (checkDimension() && checkOpenSides() && getTimer() % PRODUCTION_CYCLE_LENGTH == 0L && energyContainer.getEnergyStored() >= energyToConsume) {
                energyContainer.removeEnergy(energyToConsume);
                forceChunkLoading();
            }
        }

        private boolean checkDimension() {
            int dimensionId = getWorld().provider.getDimension();
            return IntStream.of(ConfigHolder.machineSpecific.chunkLoaderDimensionBlacklist).noneMatch(x -> x == dimensionId);
        }

        @Override
        public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
            if(!worldIn.isRemote)
            {
                MetaTileEntityChunkLoader MetaTileEntityChunkLoader = (MetaTileEntityChunkLoader)worldIn.getTileEntity(pos);
                if(MetaTileEntityChunkLoader != null)
                {
                    MetaTileEntityChunkLoader.unforceChunkLoading();
                }
            }
            super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
        }

        @Override
        public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
            if(!worldIn.isRemote)
            {
                MetaTileEntityChunkLoader MetaTileEntityChunkLoader = (MetaTileEntityChunkLoader)worldIn.getTileEntity(pos);
                if(MetaTileEntityChunkLoader != null)
                {
                    MetaTileEntityChunkLoader.unforceChunkLoading();
                }
            }
            super.onBlockDestroyedByPlayer(worldIn, pos, state);
        }

        @Override
        public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
            super.renderMetaTileEntity(renderState, translation, pipeline);
            EnumFacing frontFacing = getFrontFacing();
            Textures.SCREEN_OVERLAY.renderSided(frontFacing, renderState, translation, pipeline);
        }
    }
}*/

