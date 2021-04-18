package gregtech.common.covers;

import gregtech.api.GTValues;
import gregtech.api.cover.CoverBehavior;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.cover.ICoverable;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.render.Textures;
import gregtech.api.util.GTLog;
import gregtech.common.covers.filter.OreDictionaryItemFilter;
import gregtech.common.covers.filter.SimpleFluidFilter;
import gregtech.common.covers.filter.SimpleItemFilter;
import gregtech.common.covers.filter.SmartItemFilter;
import gregtech.common.items.MetaItems;
import gregtech.common.items.behaviors.CoverPlaceBehavior;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiFunction;

public class CoverBehaviors {

    public static void init() {
        GTLog.logger.info("Registering cover behaviors...");
        registerBehavior(0, new ResourceLocation(GTValues.MODID, "conveyor.lv"), MetaItems.CONVEYOR_MODULE_LV, (tile, side) -> new CoverConveyor(tile, side, GTValues.LV, 8));
        registerBehavior(1, new ResourceLocation(GTValues.MODID, "conveyor.mv"), MetaItems.CONVEYOR_MODULE_MV, (tile, side) -> new CoverConveyor(tile, side, GTValues.MV, 32));
        registerBehavior(2, new ResourceLocation(GTValues.MODID, "conveyor.hv"), MetaItems.CONVEYOR_MODULE_HV, (tile, side) -> new CoverConveyor(tile, side, GTValues.HV, 64));
        registerBehavior(3, new ResourceLocation(GTValues.MODID, "conveyor.ev"), MetaItems.CONVEYOR_MODULE_EV, (tile, side) -> new CoverConveyor(tile, side, GTValues.EV, 3 * 64));
        registerBehavior(4, new ResourceLocation(GTValues.MODID, "conveyor.iv"), MetaItems.CONVEYOR_MODULE_IV, (tile, side) -> new CoverConveyor(tile, side, GTValues.IV, 8 * 64));
        registerBehavior(5, new ResourceLocation(GTValues.MODID, "conveyor.luv"), MetaItems.CONVEYOR_MODULE_LUV, (tile, side) -> new CoverConveyor(tile, side, GTValues.LuV, 16 * 64));
        registerBehavior(6, new ResourceLocation(GTValues.MODID, "conveyor.zpm"), MetaItems.CONVEYOR_MODULE_ZPM, (tile, side) -> new CoverConveyor(tile, side, GTValues.ZPM, 16 * 64));
        registerBehavior(7, new ResourceLocation(GTValues.MODID, "conveyor.uv"), MetaItems.CONVEYOR_MODULE_UV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UV, 16 * 64));

        registerBehavior(10, new ResourceLocation(GTValues.MODID, "robotic_arm.lv"), MetaItems.ROBOT_ARM_LV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.LV, 8));
        registerBehavior(11, new ResourceLocation(GTValues.MODID, "robotic_arm.mv"), MetaItems.ROBOT_ARM_MV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.MV, 32));
        registerBehavior(12, new ResourceLocation(GTValues.MODID, "robotic_arm.hv"), MetaItems.ROBOT_ARM_HV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.HV, 64));
        registerBehavior(13, new ResourceLocation(GTValues.MODID, "robotic_arm.ev"), MetaItems.ROBOT_ARM_EV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.EV, 3 * 64));
        registerBehavior(14, new ResourceLocation(GTValues.MODID, "robotic_arm.iv"), MetaItems.ROBOT_ARM_IV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.IV, 8 * 64));
        registerBehavior(15, new ResourceLocation(GTValues.MODID, "robotic_arm.luv"), MetaItems.ROBOT_ARM_LUV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.LuV, 16 * 64));
        registerBehavior(16, new ResourceLocation(GTValues.MODID, "robotic_arm.zpm"), MetaItems.ROBOT_ARM_ZPM, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.ZPM, 16 * 64));
        registerBehavior(17, new ResourceLocation(GTValues.MODID, "robotic_arm.uv"), MetaItems.ROBOT_ARM_UV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UV, 16 * 64));

        registerBehavior(20, new ResourceLocation(GTValues.MODID, "pump.lv"), MetaItems.ELECTRIC_PUMP_LV, (tile, side) -> new CoverPump(tile, side, GTValues.LV, 1280));
        registerBehavior(21, new ResourceLocation(GTValues.MODID, "pump.mv"), MetaItems.ELECTRIC_PUMP_MV, (tile, side) -> new CoverPump(tile, side, GTValues.MV, 5120));
        registerBehavior(22, new ResourceLocation(GTValues.MODID, "pump.hv"), MetaItems.ELECTRIC_PUMP_HV, (tile, side) -> new CoverPump(tile, side, GTValues.HV, 20480));
        registerBehavior(23, new ResourceLocation(GTValues.MODID, "pump.ev"), MetaItems.ELECTRIC_PUMP_EV, (tile, side) -> new CoverPump(tile, side, GTValues.EV, 81920));
        registerBehavior(24, new ResourceLocation(GTValues.MODID, "pump.iv"), MetaItems.ELECTRIC_PUMP_IV, (tile, side) -> new CoverPump(tile, side, GTValues.IV, 327680));
        registerBehavior(25, new ResourceLocation(GTValues.MODID, "pump.luv"), MetaItems.ELECTRIC_PUMP_LUV, (tile, side) -> new CoverPump(tile, side, GTValues.LuV, 1310720));
        registerBehavior(26, new ResourceLocation(GTValues.MODID, "pump.zpm"), MetaItems.ELECTRIC_PUMP_ZPM, (tile, side) -> new CoverPump(tile, side, GTValues.ZPM, 5242880));
        registerBehavior(27, new ResourceLocation(GTValues.MODID, "pump.uv"), MetaItems.ELECTRIC_PUMP_UV, (tile, side) -> new CoverPump(tile, side, GTValues.UV, 20971520));

        registerBehavior(30, new ResourceLocation(GTValues.MODID, "ore_dictionary_filter"), MetaItems.ORE_DICTIONARY_FILTER, (tile, side) -> new CoverItemFilter(tile, side, "cover.ore_dictionary_filter.title", Textures.ORE_DICTIONARY_FILTER_OVERLAY, new OreDictionaryItemFilter()));
        registerBehavior(31, new ResourceLocation(GTValues.MODID, "item_filter"), MetaItems.ITEM_FILTER, (tile, side) -> new CoverItemFilter(tile, side, "cover.item_filter.title", Textures.ITEM_FILTER_FILTER_OVERLAY, new SimpleItemFilter()));
        registerBehavior(32, new ResourceLocation(GTValues.MODID, "fluid_filter"), MetaItems.FLUID_FILTER, (tile, side) -> new CoverFluidFilter(tile, side, "cover.fluid_filter.title", Textures.FLUID_FILTER_OVERLAY, new SimpleFluidFilter()));
        registerBehavior(33, new ResourceLocation(GTValues.MODID, "shutter"), MetaItems.COVER_SHUTTER, CoverShutter::new);

        registerBehavior(34, new ResourceLocation(GTValues.MODID, "solar_panel.basic"), MetaItems.COVER_SOLAR_PANEL, (tile, side) -> new CoverSolarPanel(tile, side, 1));
        registerBehavior(35, new ResourceLocation(GTValues.MODID, "solar_panel.ulv"), MetaItems.COVER_SOLAR_PANEL_ULV, (tile, side) -> new CoverSolarPanel(tile, side, 8));
        registerBehavior(36, new ResourceLocation(GTValues.MODID, "solar_panel.lv"), MetaItems.COVER_SOLAR_PANEL_LV, (tile, side) -> new CoverSolarPanel(tile, side, 32));

        registerBehavior(37, new ResourceLocation(GTValues.MODID, "machine_controller"), MetaItems.COVER_MACHINE_CONTROLLER, CoverMachineController::new);
        registerBehavior(38, new ResourceLocation(GTValues.MODID, "smart_filter"), MetaItems.SMART_FILTER, (tile, side) -> new CoverItemFilter(tile, side, "cover.smart_item_filter.title", Textures.SMART_FILTER_FILTER_OVERLAY, new SmartItemFilter()));
        registerBehavior(39, new ResourceLocation(GTValues.MODID, "facade"), MetaItems.COVER_FACADE, CoverFacade::new);

        registerBehavior(100, new ResourceLocation(GTValues.MODID, "conveyor.uhv"), MetaItems.CONVEYOR_MODULE_UHV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UHV, 32 * 64));
        registerBehavior(101, new ResourceLocation(GTValues.MODID, "conveyor.uev"), MetaItems.CONVEYOR_MODULE_UEV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UEV, 32 * 64));
        registerBehavior(102, new ResourceLocation(GTValues.MODID, "conveyor.uiv"), MetaItems.CONVEYOR_MODULE_UIV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UIV, 32 * 64));
        registerBehavior(103, new ResourceLocation(GTValues.MODID, "conveyor.umv"), MetaItems.CONVEYOR_MODULE_UMV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UMV, 32 * 64));
        registerBehavior(104, new ResourceLocation(GTValues.MODID, "conveyor.uxv"), MetaItems.CONVEYOR_MODULE_UXV, (tile, side) -> new CoverConveyor(tile, side, GTValues.UXV, 64 * 64));
        registerBehavior(105, new ResourceLocation(GTValues.MODID, "conveyor.opv"), MetaItems.CONVEYOR_MODULE_OPV, (tile, side) -> new CoverConveyor(tile, side, GTValues.OpV, 64 * 64));


        registerBehavior(106, new ResourceLocation(GTValues.MODID, "robotic_arm.uhv"), MetaItems.ROBOT_ARM_UHV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UHV, 32 * 64));
        registerBehavior(107, new ResourceLocation(GTValues.MODID, "robotic_arm.uev"), MetaItems.ROBOT_ARM_UEV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UEV, 32 * 64));
        registerBehavior(108, new ResourceLocation(GTValues.MODID, "robotic_arm.uiv"), MetaItems.ROBOT_ARM_UIV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UIV, 32 * 64));
        registerBehavior(109, new ResourceLocation(GTValues.MODID, "robotic_arm.umv"), MetaItems.ROBOT_ARM_UMV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UMV, 32 * 64));
        registerBehavior(110, new ResourceLocation(GTValues.MODID, "robotic_arm.uxv"), MetaItems.ROBOT_ARM_UXV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.UXV, 64 * 64));
        registerBehavior(111, new ResourceLocation(GTValues.MODID, "robotic_arm.opv"), MetaItems.ROBOT_ARM_OPV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.OpV, 64 * 64));


        registerBehavior(112, new ResourceLocation(GTValues.MODID, "pump.uhv"), MetaItems.ELECTRIC_PUMP_UHV, (tile, side) -> new CoverPump(tile, side, GTValues.UHV,80000000));
        registerBehavior(113, new ResourceLocation(GTValues.MODID, "pump.uev"), MetaItems.ELECTRIC_PUMP_UEV, (tile, side) -> new CoverPump(tile, side, GTValues.UEV,32000000));
        registerBehavior(114, new ResourceLocation(GTValues.MODID, "pump.uiv"), MetaItems.ELECTRIC_PUMP_UIV, (tile, side) -> new CoverPump(tile, side, GTValues.UIV,128000000));
        registerBehavior(115, new ResourceLocation(GTValues.MODID, "pump.umv"), MetaItems.ELECTRIC_PUMP_UMV, (tile, side) -> new CoverPump(tile, side, GTValues.UMV,512000000));
        registerBehavior(116, new ResourceLocation(GTValues.MODID, "pump.uxv"), MetaItems.ELECTRIC_PUMP_UXV, (tile, side) -> new CoverPump(tile, side, GTValues.UXV, 1024000000));
        registerBehavior(117, new ResourceLocation(GTValues.MODID, "pump.opv"), MetaItems.ELECTRIC_PUMP_OPV, (tile, side) -> new CoverPump(tile, side, GTValues.OpV, Integer.MAX_VALUE));


    }

    public static void registerBehavior(int coverNetworkId, ResourceLocation coverId, MetaValueItem placerItem, BiFunction<ICoverable, EnumFacing, CoverBehavior> behaviorCreator) {
        CoverDefinition coverDefinition = new CoverDefinition(coverId, behaviorCreator, placerItem.getStackForm());
        CoverDefinition.registerCover(coverNetworkId, coverDefinition);
        placerItem.addComponents(new CoverPlaceBehavior(coverDefinition));
    }
}
