package gregtech.common.metatileentities.electric;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.ModularUI.Builder;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.SimpleTextWidget;
import gregtech.api.gui.GuiTextures;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.render.Textures;
import gregtech.api.util.PipelineUtil;
import gregtech.common.ConfigHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityDiode extends TieredMetaTileEntity {

    private int minAmps;
    private boolean isChanged = false;
    private int energyIn = 1;
    private int energyOut = 1;
    private final Long energyInLong = (long) energyIn;
    private final Long energyOutLong = (long) energyOut;

    public MetaTileEntityDiode(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
    }

    @Override
    public gregtech.api.metatileentity.MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new MetaTileEntityDiode(metaTileEntityId, getTier());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("Changed", isChanged);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isChanged = data.getBoolean("Changed");
        reinitializeEnergyContainer();
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(isChanged);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.isChanged = buf.readBoolean();
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == 100) {
            this.isChanged = buf.readBoolean();
        }
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        Textures.ENERGY_OUT.renderSided(getFrontFacing(), renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[getTier()]));
        Textures.SCREEN.renderSided(EnumFacing.UP, renderState, translation, PipelineUtil.color(pipeline, 0xffffff));
    }

    @Override
    public boolean isValidFrontFacing(EnumFacing facing) {
        return true;
    }

    private void setEnergyIn(int energyIn) {
        this.energyIn = energyIn;
        markDirty();
    }

    private void adjustEnergyIn(int amount) {
        setEnergyIn(MathHelper.clamp(energyIn + amount, minAmps = ConfigHolder.machineSpecific.ioZeroAmps ? 1 : 0, ConfigHolder.machineSpecific.maxSmartDiodeOutput));
        markDirty();
    }

    private void setEnergyOut(int energyOut) {
        this.energyOut = energyOut;
        markDirty();
    }

    private void adjustEnergyOut(int amount) {
        setEnergyOut(MathHelper.clamp(energyOut + amount, minAmps = ConfigHolder.machineSpecific.ioZeroAmps ? 1 : 0, ConfigHolder.machineSpecific.maxSmartDiodeInput));
        markDirty();
    }

    private void apply() {
        isChanged = true;
        if (!getWorld().isRemote) {
            reinitializeEnergyContainer();
            writeCustomData(100, b -> b.writeBoolean(isChanged));
            getHolder().notifyBlockUpdate();
            markDirty();
        }
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        Builder builder = ModularUI.defaultBuilder();
        builder.widget(new ClickButtonWidget(30, 20, 20, 20, "-1", data -> adjustEnergyIn(-1)));
        builder.widget(new ClickButtonWidget(10, 20, 20, 20, "-10", data -> adjustEnergyIn(-10)));
        builder.widget(new ClickButtonWidget(126, 20, 20, 20, "+1", data -> adjustEnergyIn(+1)));
        builder.widget(new ClickButtonWidget(146, 20, 20, 20, "+10", data -> adjustEnergyIn(+10)));
        builder.widget(new ClickButtonWidget(30, 40, 20, 20, "-1", data -> adjustEnergyOut(-1)));
        builder.widget(new ClickButtonWidget(10, 40, 20, 20, "-10", data -> adjustEnergyOut(-10)));
        builder.widget(new ClickButtonWidget(126, 40, 20, 20, "+1", data -> adjustEnergyOut(+1)));
        builder.widget(new ClickButtonWidget(146, 40, 20, 20, "+10", data -> adjustEnergyOut(+10)));
        builder.widget(new ClickButtonWidget(10, 60, 116, 20, "Apply", data -> apply()));
        builder.widget(new ImageWidget(50, 20, 76, 20, GuiTextures.DISPLAY));
        builder.widget(new ImageWidget(50, 40, 76, 20, GuiTextures.DISPLAY));
        builder.widget(new SimpleTextWidget(88, 30, "gregtech.machine.diode.gui.energyin", 0xFFFFFF, () -> Integer.toString(energyIn)));
        builder.widget(new SimpleTextWidget(88, 50, "gregtech.machine.diode.gui.energyout", 0xFFFFFF, () -> Integer.toString(energyOut)));
        return builder.label(6, 6, getMetaFullName())
            .build(getHolder(), entityPlayer);
    }

    /*@Override
    protected void reinitializeEnergyContainer() {
        long tierVoltage = GTValues.V[getTier()];

        this.energyContainer = new EnergyContainerHandler(this, tierVoltage * 1024L, tierVoltage, energyInLong, tierVoltage, energyOutLong);

        ((EnergyContainerHandler) this.energyContainer).setSideOutputCondition(s -> s == getFrontFacing());

        isChanged = false;

        System.out.println("Successfully reinitialized energy container for diode");

        if (!isChanged) {
            this.energyContainer = new EnergyContainerHandler(this, tierVoltage * 1024L, tierVoltage, 1, tierVoltage, 1);
        }
    }*/

    @Override
    protected void reinitializeEnergyContainer() {
        long tierVoltage = GTValues.V[getTier()];
        this.energyContainer = new EnergyContainerHandler(this, tierVoltage * 1024L, tierVoltage, 1, tierVoltage, 1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        String tierName = GTValues.VN[getTier()];

        tooltip.add(I18n.format("gregtech.machine.diode.tooltip.voltage_in", tierName));
        tooltip.add(I18n.format("gregtech.machine.diode.tooltip.voltage_out", tierName));
        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", energyContainer.getEnergyCapacity()));
    }
}
