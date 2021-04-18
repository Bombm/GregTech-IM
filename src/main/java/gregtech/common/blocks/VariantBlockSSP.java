package gregtech.common.blocks;

import gregtech.api.GregTechAPI;
import gregtech.api.util.GTUtility;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class VariantBlockSSP<T extends Enum<T> & IStringSerializable> extends BlockHorizontal {

    protected PropertyEnum<T> VARIANT;
    protected T[] VALUES;

    public VariantBlockSSP(Material materialIn) {
        super(materialIn);
        setCreativeTab(GregTechAPI.TAB_GREGTECH);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (T variant : VALUES) {
            list.add(getItemVariant(variant));
        }
    }

    public IBlockState getState(T variant) {
        return getDefaultState().withProperty(VARIANT, variant).withProperty(FACING, EnumFacing.NORTH);
    }

    public T getState(IBlockState blockState) {
        return blockState.getValue(VARIANT);
    }

    public ItemStack getItemVariant(T variant) {
        return new ItemStack(this, 1, variant.ordinal());
    }

    public ItemStack getItemVariant(T variant, int amount) {
        return new ItemStack(this, amount, variant.ordinal());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        Class<T> enumClass = GTUtility.getActualTypeParameter(getClass(), VariantBlockSSP.class, 0);
        this.VARIANT = PropertyEnum.create("variant", enumClass);
        this.VALUES = enumClass.getEnumConstants();
        return new BlockStateContainer(this,FACING);
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }



    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        //tier less tooltip like: tile.turbine_casing.tooltip
        String unlocalizedVariantTooltip = getUnlocalizedName() + ".tooltip";
        if (I18n.hasKey(unlocalizedVariantTooltip))
            tooltip.addAll(Arrays.asList(I18n.format(unlocalizedVariantTooltip).split("/n")));
        //item specific tooltip: tile.turbine_casing.bronze_gearbox.tooltip
        String unlocalizedTooltip = stack.getUnlocalizedName() + ".tooltip";
        if (I18n.hasKey(unlocalizedTooltip))
            tooltip.addAll(Arrays.asList(I18n.format(unlocalizedTooltip).split("/n")));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

}
