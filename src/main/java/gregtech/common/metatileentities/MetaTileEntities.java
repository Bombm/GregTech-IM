package gregtech.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.Miner;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.Textures;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTLog;
import gregtech.common.metatileentities.electric.*;
import gregtech.common.metatileentities.electric.multiblockpart.*;
import gregtech.common.metatileentities.multi.MetaTileEntityCokeOven;
import gregtech.common.metatileentities.multi.MetaTileEntityCokeOvenHatch;
import gregtech.common.metatileentities.multi.MetaTileEntityLargeBoiler;
import gregtech.common.metatileentities.multi.MetaTileEntityLargeBoiler.BoilerType;
import gregtech.common.metatileentities.multi.MetaTileEntityPrimitiveBlastFurnace;
import gregtech.common.metatileentities.multi.electric.*;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityDieselEngine;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeTurbine;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeTurbine.TurbineType;
import gregtech.common.metatileentities.steam.*;
import gregtech.common.metatileentities.steam.boiler.SteamCoalBoiler;
import gregtech.common.metatileentities.steam.boiler.SteamLavaBoiler;
import gregtech.common.metatileentities.steam.boiler.SteamSolarBoiler;
import gregtech.common.metatileentities.storage.*;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("WeakerAccess")
public class MetaTileEntities {

    //HULLS
    public static MetaTileEntityHull[] HULL = new MetaTileEntityHull[GTValues.V.length];

    public static MetaTileEntityDiode[] DIODE = new MetaTileEntityDiode[GTValues.V.length];

    public static MetaTileEntityTransformer[] TRANSFORMER = new MetaTileEntityTransformer[GTValues.V.length - 2];
    public static MetaTileEntityBatteryBuffer[][] BATTERY_BUFFER = new MetaTileEntityBatteryBuffer[GTValues.V.length][];
    public static MetaTileEntityCharger[] CHARGER = new MetaTileEntityCharger[GTValues.V.length];

    //BRONZE MACHINES SECTION
    public static SteamCoalBoiler STEAM_BOILER_COAL_BRONZE;
    public static SteamCoalBoiler STEAM_BOILER_COAL_STEEL;
    public static SteamSolarBoiler STEAM_BOILER_SOLAR_BRONZE;
    public static SteamSolarBoiler STEAM_BOILER_SOLAR_STEEL;
    public static SteamLavaBoiler STEAM_BOILER_LAVA_BRONZE;
    public static SteamLavaBoiler STEAM_BOILER_LAVA_STEEL;
    public static SteamExtractor STEAM_EXTRACTOR_BRONZE;
    public static SteamExtractor STEAM_EXTRACTOR_STEEL;
    public static SteamMacerator STEAM_MACERATOR_BRONZE;
    public static SteamMacerator STEAM_MACERATOR_STEEL;
    public static SteamCompressor STEAM_COMPRESSOR_BRONZE;
    public static SteamCompressor STEAM_COMPRESSOR_STEEL;
    public static SteamHammer STEAM_HAMMER_BRONZE;
    public static SteamHammer STEAM_HAMMER_STEEL;
    public static SteamFurnace STEAM_FURNACE_BRONZE;
    public static SteamFurnace STEAM_FURNACE_STEEL;
    public static SteamAlloySmelter STEAM_ALLOY_SMELTER_BRONZE;
    public static SteamAlloySmelter STEAM_ALLOY_SMELTER_STEEL;

    //SIMPLE MACHINES SECTION
    public static SimpleMachineMetaTileEntity[] ELECTRIC_FURNACE = new SimpleMachineMetaTileEntity[4];
    public static MetaTileEntityMacerator[] MACERATOR = new MetaTileEntityMacerator[4];
    public static SimpleMachineMetaTileEntity[] ALLOY_SMELTER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] AMPLIFABRICATOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] ARC_FURNACE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] ASSEMBLER = new SimpleMachineMetaTileEntity[5];
    public static SimpleMachineMetaTileEntity[] AUTOCLAVE = new SimpleMachineMetaTileEntity[5];
    public static SimpleMachineMetaTileEntity[] BENDER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] BREWERY = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CANNER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CENTRIFUGE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_BATH = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_REACTOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] COMPRESSOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CUTTER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] DISTILLERY = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] ELECTROLYZER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] EXTRACTOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] EXTRUDER = new SimpleMachineMetaTileEntity[3];
    public static SimpleMachineMetaTileEntity[] FERMENTER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FLUID_CANNER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FLUID_EXTRACTOR = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FLUID_HEATER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FLUID_SOLIDIFIER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FORGE_HAMMER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] FORMING_PRESS = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] LATHE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] MICROWAVE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] MIXER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] ORE_WASHER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] PACKER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] UNPACKER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] PLASMA_ARC_FURNACE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] POLARIZER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] LASER_ENGRAVER = new SimpleMachineMetaTileEntity[5];
    public static SimpleMachineMetaTileEntity[] SIFTER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] THERMAL_CENTRIFUGE = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] WIREMILL = new SimpleMachineMetaTileEntity[4];

    //ADD LUV+
    public static SimpleMachineMetaTileEntity[] ELECTRIC_FURNACE_SSP = new SimpleMachineMetaTileEntity[6];
    public static MetaTileEntityMacerator[] MACERATOR_SSP = new MetaTileEntityMacerator[6];
    public static SimpleMachineMetaTileEntity[] ALLOY_SMELTER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] AMPLIFABRICATOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] ARC_FURNACE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] ASSEMBLER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] AUTOCLAVE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] BENDER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] BREWERY_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] CANNER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] CENTRIFUGE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_BATH_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_REACTOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] COMPRESSOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] CUTTER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] DISTILLERY_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] ELECTROLYZER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] EXTRACTOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] EXTRUDER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FERMENTER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FLUID_CANNER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FLUID_EXTRACTOR_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FLUID_HEATER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FLUID_SOLIDIFIER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FORGE_HAMMER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] FORMING_PRESS_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] LATHE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] MICROWAVE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] MIXER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] ORE_WASHER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] PACKER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] UNPACKER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] PLASMA_ARC_FURNACE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] POLARIZER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] LASER_ENGRAVER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] SIFTER_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] THERMAL_CENTRIFUGE_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] WIREMILL_SSP = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] BIO_LAB = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] GEM_CUTTER = new SimpleMachineMetaTileEntity[12];

    //GENERATORS SECTION
    public static SimpleGeneratorMetaTileEntity[] DIESEL_GENERATOR = new SimpleGeneratorMetaTileEntity[4];
    public static SimpleGeneratorMetaTileEntity[] STEAM_TURBINE = new SimpleGeneratorMetaTileEntity[4];
    public static SimpleGeneratorMetaTileEntity[] GAS_TURBINE = new SimpleGeneratorMetaTileEntity[4];
    public static MetaTileEntityMagicEnergyAbsorber MAGIC_ENERGY_ABSORBER;

    //MULTIBLOCK PARTS SECTION
    public static MetaTileEntityItemBus[] ITEM_IMPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length];
    public static MetaTileEntityItemBus[] ITEM_EXPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length];
    public static MetaTileEntityFluidHatch[] FLUID_IMPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length];
    public static MetaTileEntityFluidHatch[] FLUID_EXPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length];
    public static MetaTileEntityEnergyHatch[] ENERGY_INPUT_HATCH = new MetaTileEntityEnergyHatch[GTValues.V.length];
    public static MetaTileEntityEnergyHatch[] ENERGY_OUTPUT_HATCH = new MetaTileEntityEnergyHatch[GTValues.V.length];
    public static MetaTileEntityRotorHolder[] ROTOR_HOLDER = new MetaTileEntityRotorHolder[12]; //from HV to MAX
    public static MetaTileEntityCokeOvenHatch COKE_OVEN_HATCH;
    public static MetaTileEntityMaintenanceHatch MAINTENANCE_HATCH;

    //MULTIBLOCKS SECTION
    public static MetaTileEntityPrimitiveBlastFurnace PRIMITIVE_BLAST_FURNACE;
    public static MetaTileEntityCokeOven COKE_OVEN;
    public static MetaTileEntityElectricBlastFurnace ELECTRIC_BLAST_FURNACE;
    public static MetaTileEntityVacuumFreezer VACUUM_FREEZER;
    public static MetaTileEntityImplosionCompressor IMPLOSION_COMPRESSOR;
    public static MetaTileEntityPyrolyseOven PYROLYSE_OVEN;
    public static MetaTileEntityDistillationTower DISTILLATION_TOWER;
    public static MetaTileEntityCrackingUnit CRACKER;
    public static MetaTileEntityMultiFurnace MULTI_FURNACE;
    public static MetaTileEntityDieselEngine DIESEL_ENGINE;

    public static MetaTileEntityLargeTurbine LARGE_STEAM_TURBINE;
    public static MetaTileEntityLargeTurbine LARGE_GAS_TURBINE;
    public static MetaTileEntityLargeTurbine LARGE_PLASMA_TURBINE;

    public static MetaTileEntityLargeBoiler LARGE_BRONZE_BOILER;
    public static MetaTileEntityLargeBoiler LARGE_STEEL_BOILER;
    public static MetaTileEntityLargeBoiler LARGE_TITANIUM_BOILER;
    public static MetaTileEntityLargeBoiler LARGE_TUNGSTENSTEEL_BOILER;

    //STORAGE SECTION
    public static MetaTileEntityChest SMALL_WOODEN_CHEST;
    public static MetaTileEntityChest WOODEN_CHEST;
    public static MetaTileEntityChest BRONZE_CHEST;
    public static MetaTileEntityChest STEEL_CHEST;
    public static MetaTileEntityChest STAINLESS_STEEL_CHEST;
    public static MetaTileEntityChest TITANIUM_CHEST;
    public static MetaTileEntityChest TUNGSTENSTEEL_CHEST;
    public static MetaTileEntityLockedSafe LOCKED_SAFE;
    public static MetaTileEntityLockedSafeMV LOCKED_SAFE_MV;
    public static MetaTileEntityLockedSafeHV LOCKED_SAFE_HV;
    public static MetaTileEntityLockedSafeEV LOCKED_SAFE_EV;
    public static MetaTileEntityArmorTable ARMOR_TABLE;

    public static MetaTileEntityTank WOODEN_TANK;
    public static MetaTileEntityTank BRONZE_TANK;
    public static MetaTileEntityTank STEEL_TANK;
    public static MetaTileEntityTank STAINLESS_STEEL_TANK;
    public static MetaTileEntityTank TITANIUM_TANK;
    public static MetaTileEntityTank TUNGSTENSTEEL_TANK;


    //MISC MACHINES SECTION
    public static MetaTileEntityWorkbench WORKBENCH;
    public static MetaTileEntityPump[] PUMP = new MetaTileEntityPump[4];
    public static MetaTileEntityBlockBreaker[] BLOCK_BREAKER = new MetaTileEntityBlockBreaker[4];
    public static MetaTileEntityAirCollector[] AIR_COLLECTOR = new MetaTileEntityAirCollector[4];
    public static MetaTileEntityItemCollector[] ITEM_COLLECTOR = new MetaTileEntityItemCollector[4];
    public static MetaTileEntityTeslaCoil TESLA_COIL;
    public static MetaTileEntityQuantumChest[] QUANTUM_CHEST = new MetaTileEntityQuantumChest[4];
    public static MetaTileEntityQuantumTank[] QUANTUM_TANK = new MetaTileEntityQuantumTank[4];
    public static MetaTileEntityFisher[] FISHER = new MetaTileEntityFisher[14];
    public static MetaTileEntityChunkMiner[] MINER = new MetaTileEntityChunkMiner[13];
    //public static MetaTileEntityChunkLoader CHUNKLOADER;

    public static void init() {
        GTLog.logger.info("Registering MetaTileEntities");

        STEAM_BOILER_COAL_BRONZE = GregTechAPI.registerMetaTileEntity(1, new SteamCoalBoiler(gregtechId("steam_boiler_coal_bronze"), false));
        STEAM_BOILER_COAL_STEEL = GregTechAPI.registerMetaTileEntity(2, new SteamCoalBoiler(gregtechId("steam_boiler_coal_steel"), true));

        STEAM_BOILER_SOLAR_BRONZE = GregTechAPI.registerMetaTileEntity(3, new SteamSolarBoiler(gregtechId("steam_boiler_solar_bronze"), false));
        STEAM_BOILER_SOLAR_STEEL = GregTechAPI.registerMetaTileEntity(4, new SteamSolarBoiler(gregtechId("steam_boiler_solar_steel"), true));

        STEAM_BOILER_LAVA_BRONZE = GregTechAPI.registerMetaTileEntity(5, new SteamLavaBoiler(gregtechId("steam_boiler_lava_bronze"), false));
        STEAM_BOILER_LAVA_STEEL = GregTechAPI.registerMetaTileEntity(6, new SteamLavaBoiler(gregtechId("steam_boiler_lava_steel"), true));

        STEAM_EXTRACTOR_BRONZE = GregTechAPI.registerMetaTileEntity(7, new SteamExtractor(gregtechId("steam_extractor_bronze"), false));
        STEAM_EXTRACTOR_STEEL = GregTechAPI.registerMetaTileEntity(8, new SteamExtractor(gregtechId("steam_extractor_steel"), true));

        STEAM_MACERATOR_BRONZE = GregTechAPI.registerMetaTileEntity(9, new SteamMacerator(gregtechId("steam_macerator_bronze"), false));
        STEAM_MACERATOR_STEEL = GregTechAPI.registerMetaTileEntity(10, new SteamMacerator(gregtechId("steam_macerator_steel"), true));

        STEAM_COMPRESSOR_BRONZE = GregTechAPI.registerMetaTileEntity(11, new SteamCompressor(gregtechId("steam_compressor_bronze"), false));
        STEAM_COMPRESSOR_STEEL = GregTechAPI.registerMetaTileEntity(12, new SteamCompressor(gregtechId("steam_compressor_steel"), true));

        STEAM_HAMMER_BRONZE = GregTechAPI.registerMetaTileEntity(13, new SteamHammer(gregtechId("steam_hammer_bronze"), false));
        STEAM_HAMMER_STEEL = GregTechAPI.registerMetaTileEntity(14, new SteamHammer(gregtechId("steam_hammer_steel"), true));

        STEAM_FURNACE_BRONZE = GregTechAPI.registerMetaTileEntity(15, new SteamFurnace(gregtechId("steam_furnace_bronze"), false));
        STEAM_FURNACE_STEEL = GregTechAPI.registerMetaTileEntity(16, new SteamFurnace(gregtechId("steam_furnace_steel"), true));

        STEAM_ALLOY_SMELTER_BRONZE = GregTechAPI.registerMetaTileEntity(17, new SteamAlloySmelter(gregtechId("steam_alloy_smelter_bronze"), false));
        STEAM_ALLOY_SMELTER_STEEL = GregTechAPI.registerMetaTileEntity(18, new SteamAlloySmelter(gregtechId("steam_alloy_smelter_steel"), true));

        ELECTRIC_FURNACE[0] = GregTechAPI.registerMetaTileEntity(50, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.lv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 1));
        ELECTRIC_FURNACE[1] = GregTechAPI.registerMetaTileEntity(51, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.mv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 2));
        ELECTRIC_FURNACE[2] = GregTechAPI.registerMetaTileEntity(52, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.hv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 3));
        ELECTRIC_FURNACE[3] = GregTechAPI.registerMetaTileEntity(53, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.ev"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 4));

        MACERATOR[0] = GregTechAPI.registerMetaTileEntity(60, new MetaTileEntityMacerator(gregtechId("macerator.lv"), RecipeMaps.MACERATOR_RECIPES, 1, Textures.MACERATOR_OVERLAY, 1));
        MACERATOR[1] = GregTechAPI.registerMetaTileEntity(61, new MetaTileEntityMacerator(gregtechId("macerator.mv"), RecipeMaps.MACERATOR_RECIPES, 1, Textures.MACERATOR_OVERLAY, 2));
        MACERATOR[2] = GregTechAPI.registerMetaTileEntity(62, new MetaTileEntityMacerator(gregtechId("macerator.hv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 3));
        MACERATOR[3] = GregTechAPI.registerMetaTileEntity(63, new MetaTileEntityMacerator(gregtechId("macerator.ev"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 4));

        ALLOY_SMELTER[0] = GregTechAPI.registerMetaTileEntity(70, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.lv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 1));
        ALLOY_SMELTER[1] = GregTechAPI.registerMetaTileEntity(71, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.mv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 2));
        ALLOY_SMELTER[2] = GregTechAPI.registerMetaTileEntity(72, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.hv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 3));
        ALLOY_SMELTER[3] = GregTechAPI.registerMetaTileEntity(73, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.ev"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 4));

        //AMPLIFABRICATOR[0] = GregTechAPI.registerMetaTileEntity(80, new SimpleMachineMetaTileEntity(gregtechId("amplifab.lv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 1));
        //AMPLIFABRICATOR[1] = GregTechAPI.registerMetaTileEntity(81, new SimpleMachineMetaTileEntity(gregtechId("amplifab.mv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 2));
        //AMPLIFABRICATOR[2] = GregTechAPI.registerMetaTileEntity(82, new SimpleMachineMetaTileEntity(gregtechId("amplifab.hv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 3));
        //AMPLIFABRICATOR[3] = GregTechAPI.registerMetaTileEntity(83, new SimpleMachineMetaTileEntity(gregtechId("amplifab.ev"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 4));

        ARC_FURNACE[0] = GregTechAPI.registerMetaTileEntity(90, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.lv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 1, false));
        ARC_FURNACE[1] = GregTechAPI.registerMetaTileEntity(91, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.mv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 2, false));
        ARC_FURNACE[2] = GregTechAPI.registerMetaTileEntity(92, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.hv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 3, false));
        ARC_FURNACE[3] = GregTechAPI.registerMetaTileEntity(93, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.ev"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 4, false));

        ASSEMBLER[0] = GregTechAPI.registerMetaTileEntity(100, new SimpleMachineMetaTileEntity(gregtechId("assembler.lv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 1));
        ASSEMBLER[1] = GregTechAPI.registerMetaTileEntity(101, new SimpleMachineMetaTileEntity(gregtechId("assembler.mv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 2));
        ASSEMBLER[2] = GregTechAPI.registerMetaTileEntity(102, new SimpleMachineMetaTileEntity(gregtechId("assembler.hv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 3));
        ASSEMBLER[3] = GregTechAPI.registerMetaTileEntity(103, new SimpleMachineMetaTileEntity(gregtechId("assembler.ev"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 4));
        ASSEMBLER[4] = GregTechAPI.registerMetaTileEntity(104, new SimpleMachineMetaTileEntity(gregtechId("assembler.iv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 5));

        AUTOCLAVE[0] = GregTechAPI.registerMetaTileEntity(110, new SimpleMachineMetaTileEntity(gregtechId("autoclave.lv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 1, false));
        AUTOCLAVE[1] = GregTechAPI.registerMetaTileEntity(111, new SimpleMachineMetaTileEntity(gregtechId("autoclave.mv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 2, false));
        AUTOCLAVE[2] = GregTechAPI.registerMetaTileEntity(112, new SimpleMachineMetaTileEntity(gregtechId("autoclave.hv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 3, false));
        AUTOCLAVE[3] = GregTechAPI.registerMetaTileEntity(113, new SimpleMachineMetaTileEntity(gregtechId("autoclave.ev"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 4, false));
        AUTOCLAVE[4] = GregTechAPI.registerMetaTileEntity(114, new SimpleMachineMetaTileEntity(gregtechId("autoclave.iv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 5, false));

        BENDER[0] = GregTechAPI.registerMetaTileEntity(120, new SimpleMachineMetaTileEntity(gregtechId("bender.lv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 1));
        BENDER[1] = GregTechAPI.registerMetaTileEntity(121, new SimpleMachineMetaTileEntity(gregtechId("bender.mv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 2));
        BENDER[2] = GregTechAPI.registerMetaTileEntity(122, new SimpleMachineMetaTileEntity(gregtechId("bender.hv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 3));
        BENDER[3] = GregTechAPI.registerMetaTileEntity(123, new SimpleMachineMetaTileEntity(gregtechId("bender.ev"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 4));

        BREWERY[0] = GregTechAPI.registerMetaTileEntity(130, new SimpleMachineMetaTileEntity(gregtechId("brewery.lv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 1));
        BREWERY[1] = GregTechAPI.registerMetaTileEntity(131, new SimpleMachineMetaTileEntity(gregtechId("brewery.mv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 2));
        BREWERY[2] = GregTechAPI.registerMetaTileEntity(132, new SimpleMachineMetaTileEntity(gregtechId("brewery.hv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 3));
        BREWERY[3] = GregTechAPI.registerMetaTileEntity(133, new SimpleMachineMetaTileEntity(gregtechId("brewery.ev"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 4));

        CANNER[0] = GregTechAPI.registerMetaTileEntity(140, new SimpleMachineMetaTileEntity(gregtechId("canner.lv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 1));
        CANNER[1] = GregTechAPI.registerMetaTileEntity(141, new SimpleMachineMetaTileEntity(gregtechId("canner.mv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 2));
        CANNER[2] = GregTechAPI.registerMetaTileEntity(142, new SimpleMachineMetaTileEntity(gregtechId("canner.hv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 3));
        CANNER[3] = GregTechAPI.registerMetaTileEntity(143, new SimpleMachineMetaTileEntity(gregtechId("canner.ev"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 4));

        CENTRIFUGE[0] = GregTechAPI.registerMetaTileEntity(150, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.lv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 1, false));
        CENTRIFUGE[1] = GregTechAPI.registerMetaTileEntity(151, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.mv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 2, false));
        CENTRIFUGE[2] = GregTechAPI.registerMetaTileEntity(152, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.hv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 3, false));
        CENTRIFUGE[3] = GregTechAPI.registerMetaTileEntity(153, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.ev"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 4, false));

        CHEMICAL_BATH[0] = GregTechAPI.registerMetaTileEntity(180, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.lv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 1));
        CHEMICAL_BATH[1] = GregTechAPI.registerMetaTileEntity(181, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.mv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 2));
        CHEMICAL_BATH[2] = GregTechAPI.registerMetaTileEntity(182, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.hv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 3));
        CHEMICAL_BATH[3] = GregTechAPI.registerMetaTileEntity(183, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.ev"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 4));

        CHEMICAL_REACTOR[0] = GregTechAPI.registerMetaTileEntity(190, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.lv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 1));
        CHEMICAL_REACTOR[1] = GregTechAPI.registerMetaTileEntity(191, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.mv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 2));
        CHEMICAL_REACTOR[2] = GregTechAPI.registerMetaTileEntity(192, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.hv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 3));
        CHEMICAL_REACTOR[3] = GregTechAPI.registerMetaTileEntity(193, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.ev"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 4));

        COMPRESSOR[0] = GregTechAPI.registerMetaTileEntity(210, new SimpleMachineMetaTileEntity(gregtechId("compressor.lv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 1));
        COMPRESSOR[1] = GregTechAPI.registerMetaTileEntity(211, new SimpleMachineMetaTileEntity(gregtechId("compressor.mv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 2));
        COMPRESSOR[2] = GregTechAPI.registerMetaTileEntity(212, new SimpleMachineMetaTileEntity(gregtechId("compressor.hv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 3));
        COMPRESSOR[3] = GregTechAPI.registerMetaTileEntity(213, new SimpleMachineMetaTileEntity(gregtechId("compressor.ev"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 4));

        CUTTER[0] = GregTechAPI.registerMetaTileEntity(220, new SimpleMachineMetaTileEntity(gregtechId("cutter.lv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 1));
        CUTTER[1] = GregTechAPI.registerMetaTileEntity(221, new SimpleMachineMetaTileEntity(gregtechId("cutter.mv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 2));
        CUTTER[2] = GregTechAPI.registerMetaTileEntity(222, new SimpleMachineMetaTileEntity(gregtechId("cutter.hv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 3));
        CUTTER[3] = GregTechAPI.registerMetaTileEntity(223, new SimpleMachineMetaTileEntity(gregtechId("cutter.ev"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 4));

        DISTILLERY[0] = GregTechAPI.registerMetaTileEntity(230, new SimpleMachineMetaTileEntity(gregtechId("distillery.lv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 1));
        DISTILLERY[1] = GregTechAPI.registerMetaTileEntity(231, new SimpleMachineMetaTileEntity(gregtechId("distillery.mv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 2));
        DISTILLERY[2] = GregTechAPI.registerMetaTileEntity(232, new SimpleMachineMetaTileEntity(gregtechId("distillery.hv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 3));
        DISTILLERY[3] = GregTechAPI.registerMetaTileEntity(233, new SimpleMachineMetaTileEntity(gregtechId("distillery.ev"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 4));

        ELECTROLYZER[0] = GregTechAPI.registerMetaTileEntity(240, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.lv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 1, false));
        ELECTROLYZER[1] = GregTechAPI.registerMetaTileEntity(241, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.mv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 2, false));
        ELECTROLYZER[2] = GregTechAPI.registerMetaTileEntity(242, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.hv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 3, false));
        ELECTROLYZER[3] = GregTechAPI.registerMetaTileEntity(243, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.ev"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 4, false));

        ELECTROMAGNETIC_SEPARATOR[0] = GregTechAPI.registerMetaTileEntity(250, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.lv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 1));
        ELECTROMAGNETIC_SEPARATOR[1] = GregTechAPI.registerMetaTileEntity(251, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.mv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 2));
        ELECTROMAGNETIC_SEPARATOR[2] = GregTechAPI.registerMetaTileEntity(252, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.hv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 3));
        ELECTROMAGNETIC_SEPARATOR[3] = GregTechAPI.registerMetaTileEntity(253, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.ev"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 4));

        EXTRACTOR[0] = GregTechAPI.registerMetaTileEntity(260, new SimpleMachineMetaTileEntity(gregtechId("extractor.lv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 1));
        EXTRACTOR[1] = GregTechAPI.registerMetaTileEntity(261, new SimpleMachineMetaTileEntity(gregtechId("extractor.mv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 2));
        EXTRACTOR[2] = GregTechAPI.registerMetaTileEntity(262, new SimpleMachineMetaTileEntity(gregtechId("extractor.hv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 3));
        EXTRACTOR[3] = GregTechAPI.registerMetaTileEntity(263, new SimpleMachineMetaTileEntity(gregtechId("extractor.ev"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 4));

        EXTRUDER[0] = GregTechAPI.registerMetaTileEntity(271, new SimpleMachineMetaTileEntity(gregtechId("extruder.mv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 2));
        EXTRUDER[1] = GregTechAPI.registerMetaTileEntity(272, new SimpleMachineMetaTileEntity(gregtechId("extruder.hv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 3));
        EXTRUDER[2] = GregTechAPI.registerMetaTileEntity(273, new SimpleMachineMetaTileEntity(gregtechId("extruder.ev"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 4));

        FERMENTER[0] = GregTechAPI.registerMetaTileEntity(280, new SimpleMachineMetaTileEntity(gregtechId("fermenter.lv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 1));
        FERMENTER[1] = GregTechAPI.registerMetaTileEntity(281, new SimpleMachineMetaTileEntity(gregtechId("fermenter.mv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 2));
        FERMENTER[2] = GregTechAPI.registerMetaTileEntity(282, new SimpleMachineMetaTileEntity(gregtechId("fermenter.hv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 3));
        FERMENTER[3] = GregTechAPI.registerMetaTileEntity(283, new SimpleMachineMetaTileEntity(gregtechId("fermenter.ev"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 4));

        FLUID_CANNER[0] = GregTechAPI.registerMetaTileEntity(290, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.lv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 1));
        FLUID_CANNER[1] = GregTechAPI.registerMetaTileEntity(291, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.mv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 2));
        FLUID_CANNER[2] = GregTechAPI.registerMetaTileEntity(292, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.hv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 3));
        FLUID_CANNER[3] = GregTechAPI.registerMetaTileEntity(293, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.ev"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 4));

        FLUID_EXTRACTOR[0] = GregTechAPI.registerMetaTileEntity(300, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.lv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 1));
        FLUID_EXTRACTOR[1] = GregTechAPI.registerMetaTileEntity(301, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.mv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 2));
        FLUID_EXTRACTOR[2] = GregTechAPI.registerMetaTileEntity(302, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.hv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 3));
        FLUID_EXTRACTOR[3] = GregTechAPI.registerMetaTileEntity(303, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.ev"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 4));

        FLUID_HEATER[0] = GregTechAPI.registerMetaTileEntity(310, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.lv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 1));
        FLUID_HEATER[1] = GregTechAPI.registerMetaTileEntity(311, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.mv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 2));
        FLUID_HEATER[2] = GregTechAPI.registerMetaTileEntity(312, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.hv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 3));
        FLUID_HEATER[3] = GregTechAPI.registerMetaTileEntity(313, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.ev"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 4));

        FLUID_SOLIDIFIER[0] = GregTechAPI.registerMetaTileEntity(320, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.lv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 1));
        FLUID_SOLIDIFIER[1] = GregTechAPI.registerMetaTileEntity(321, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.mv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 2));
        FLUID_SOLIDIFIER[2] = GregTechAPI.registerMetaTileEntity(322, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.hv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 3));
        FLUID_SOLIDIFIER[3] = GregTechAPI.registerMetaTileEntity(323, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.ev"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 4));

        FORGE_HAMMER[0] = GregTechAPI.registerMetaTileEntity(330, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.lv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 1));
        FORGE_HAMMER[1] = GregTechAPI.registerMetaTileEntity(331, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.mv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 2));
        FORGE_HAMMER[2] = GregTechAPI.registerMetaTileEntity(332, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.hv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 3));
        FORGE_HAMMER[3] = GregTechAPI.registerMetaTileEntity(333, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.ev"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 4));

        FORMING_PRESS[0] = GregTechAPI.registerMetaTileEntity(340, new SimpleMachineMetaTileEntity(gregtechId("forming_press.lv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 1));
        FORMING_PRESS[1] = GregTechAPI.registerMetaTileEntity(341, new SimpleMachineMetaTileEntity(gregtechId("forming_press.mv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 2));
        FORMING_PRESS[2] = GregTechAPI.registerMetaTileEntity(342, new SimpleMachineMetaTileEntity(gregtechId("forming_press.hv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 3));
        FORMING_PRESS[3] = GregTechAPI.registerMetaTileEntity(343, new SimpleMachineMetaTileEntity(gregtechId("forming_press.ev"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 4));

        LATHE[0] = GregTechAPI.registerMetaTileEntity(350, new SimpleMachineMetaTileEntity(gregtechId("lathe.lv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 1));
        LATHE[1] = GregTechAPI.registerMetaTileEntity(351, new SimpleMachineMetaTileEntity(gregtechId("lathe.mv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 2));
        LATHE[2] = GregTechAPI.registerMetaTileEntity(352, new SimpleMachineMetaTileEntity(gregtechId("lathe.hv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 3));
        LATHE[3] = GregTechAPI.registerMetaTileEntity(353, new SimpleMachineMetaTileEntity(gregtechId("lathe.ev"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 4));

        MICROWAVE[0] = GregTechAPI.registerMetaTileEntity(360, new SimpleMachineMetaTileEntity(gregtechId("microwave.lv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 1));
        MICROWAVE[1] = GregTechAPI.registerMetaTileEntity(361, new SimpleMachineMetaTileEntity(gregtechId("microwave.mv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 2));
        MICROWAVE[2] = GregTechAPI.registerMetaTileEntity(362, new SimpleMachineMetaTileEntity(gregtechId("microwave.hv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 3));
        MICROWAVE[3] = GregTechAPI.registerMetaTileEntity(363, new SimpleMachineMetaTileEntity(gregtechId("microwave.ev"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 4));

        MIXER[0] = GregTechAPI.registerMetaTileEntity(370, new SimpleMachineMetaTileEntity(gregtechId("mixer.lv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 1, false));
        MIXER[1] = GregTechAPI.registerMetaTileEntity(371, new SimpleMachineMetaTileEntity(gregtechId("mixer.mv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 2, false));
        MIXER[2] = GregTechAPI.registerMetaTileEntity(372, new SimpleMachineMetaTileEntity(gregtechId("mixer.hv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 3, false));
        MIXER[3] = GregTechAPI.registerMetaTileEntity(373, new SimpleMachineMetaTileEntity(gregtechId("mixer.ev"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 4, false));

        ORE_WASHER[0] = GregTechAPI.registerMetaTileEntity(380, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.lv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 1));
        ORE_WASHER[1] = GregTechAPI.registerMetaTileEntity(381, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.mv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 2));
        ORE_WASHER[2] = GregTechAPI.registerMetaTileEntity(382, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.hv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 3));
        ORE_WASHER[3] = GregTechAPI.registerMetaTileEntity(383, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.ev"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 4));

        PACKER[0] = GregTechAPI.registerMetaTileEntity(390, new SimpleMachineMetaTileEntity(gregtechId("packer.lv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 1));
        PACKER[1] = GregTechAPI.registerMetaTileEntity(391, new SimpleMachineMetaTileEntity(gregtechId("packer.mv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 2));
        PACKER[2] = GregTechAPI.registerMetaTileEntity(392, new SimpleMachineMetaTileEntity(gregtechId("packer.hv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 3));
        PACKER[3] = GregTechAPI.registerMetaTileEntity(393, new SimpleMachineMetaTileEntity(gregtechId("packer.ev"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 4));

        UNPACKER[0] = GregTechAPI.registerMetaTileEntity(400, new SimpleMachineMetaTileEntity(gregtechId("unpacker.lv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 1));
        UNPACKER[1] = GregTechAPI.registerMetaTileEntity(401, new SimpleMachineMetaTileEntity(gregtechId("unpacker.mv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 2));
        UNPACKER[2] = GregTechAPI.registerMetaTileEntity(402, new SimpleMachineMetaTileEntity(gregtechId("unpacker.hv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 3));
        UNPACKER[3] = GregTechAPI.registerMetaTileEntity(403, new SimpleMachineMetaTileEntity(gregtechId("unpacker.ev"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 4));

        PLASMA_ARC_FURNACE[0] = GregTechAPI.registerMetaTileEntity(410, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.lv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 1, false));
        PLASMA_ARC_FURNACE[1] = GregTechAPI.registerMetaTileEntity(411, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.mv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 2, false));
        PLASMA_ARC_FURNACE[2] = GregTechAPI.registerMetaTileEntity(412, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.hv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 3, false));
        PLASMA_ARC_FURNACE[3] = GregTechAPI.registerMetaTileEntity(413, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.ev"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 4, false));

        POLARIZER[0] = GregTechAPI.registerMetaTileEntity(420, new SimpleMachineMetaTileEntity(gregtechId("polarizer.lv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 1));
        POLARIZER[1] = GregTechAPI.registerMetaTileEntity(421, new SimpleMachineMetaTileEntity(gregtechId("polarizer.mv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 2));
        POLARIZER[2] = GregTechAPI.registerMetaTileEntity(422, new SimpleMachineMetaTileEntity(gregtechId("polarizer.hv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 3));
        POLARIZER[3] = GregTechAPI.registerMetaTileEntity(423, new SimpleMachineMetaTileEntity(gregtechId("polarizer.ev"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 4));

        LASER_ENGRAVER[0] = GregTechAPI.registerMetaTileEntity(430, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.lv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 1));
        LASER_ENGRAVER[1] = GregTechAPI.registerMetaTileEntity(431, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.mv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 2));
        LASER_ENGRAVER[2] = GregTechAPI.registerMetaTileEntity(432, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.hv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 3));
        LASER_ENGRAVER[3] = GregTechAPI.registerMetaTileEntity(433, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.ev"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 4));
        LASER_ENGRAVER[4] = GregTechAPI.registerMetaTileEntity(434, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.iv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 5));

        SIFTER[0] = GregTechAPI.registerMetaTileEntity(450, new SimpleMachineMetaTileEntity(gregtechId("sifter.lv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 1));
        SIFTER[1] = GregTechAPI.registerMetaTileEntity(451, new SimpleMachineMetaTileEntity(gregtechId("sifter.mv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 2));
        SIFTER[2] = GregTechAPI.registerMetaTileEntity(452, new SimpleMachineMetaTileEntity(gregtechId("sifter.hv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 3));
        SIFTER[3] = GregTechAPI.registerMetaTileEntity(453, new SimpleMachineMetaTileEntity(gregtechId("sifter.ev"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 4));

        THERMAL_CENTRIFUGE[0] = GregTechAPI.registerMetaTileEntity(460, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.lv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 1));
        THERMAL_CENTRIFUGE[1] = GregTechAPI.registerMetaTileEntity(461, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.mv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 2));
        THERMAL_CENTRIFUGE[2] = GregTechAPI.registerMetaTileEntity(462, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.hv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 3));
        THERMAL_CENTRIFUGE[3] = GregTechAPI.registerMetaTileEntity(463, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.ev"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 4));

        WIREMILL[0] = GregTechAPI.registerMetaTileEntity(470, new SimpleMachineMetaTileEntity(gregtechId("wiremill.lv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 1));
        WIREMILL[1] = GregTechAPI.registerMetaTileEntity(471, new SimpleMachineMetaTileEntity(gregtechId("wiremill.mv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 2));
        WIREMILL[2] = GregTechAPI.registerMetaTileEntity(472, new SimpleMachineMetaTileEntity(gregtechId("wiremill.hv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 3));
        WIREMILL[3] = GregTechAPI.registerMetaTileEntity(473, new SimpleMachineMetaTileEntity(gregtechId("wiremill.ev"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 4));

        DIESEL_GENERATOR[0] = GregTechAPI.registerMetaTileEntity(480, new SimpleGeneratorMetaTileEntity(gregtechId("diesel_generator.lv"), RecipeMaps.DIESEL_GENERATOR_FUELS, Textures.DIESEL_GENERATOR_OVERLAY, 1));
        DIESEL_GENERATOR[1] = GregTechAPI.registerMetaTileEntity(481, new SimpleGeneratorMetaTileEntity(gregtechId("diesel_generator.mv"), RecipeMaps.DIESEL_GENERATOR_FUELS, Textures.DIESEL_GENERATOR_OVERLAY, 2));
        DIESEL_GENERATOR[2] = GregTechAPI.registerMetaTileEntity(482, new SimpleGeneratorMetaTileEntity(gregtechId("diesel_generator.hv"), RecipeMaps.DIESEL_GENERATOR_FUELS, Textures.DIESEL_GENERATOR_OVERLAY, 3));

        STEAM_TURBINE[0] = GregTechAPI.registerMetaTileEntity(485, new SimpleGeneratorMetaTileEntity(gregtechId("steam_turbine.lv"), RecipeMaps.STEAM_TURBINE_FUELS, Textures.STEAM_TURBINE_OVERLAY, 1));
        STEAM_TURBINE[1] = GregTechAPI.registerMetaTileEntity(486, new SimpleGeneratorMetaTileEntity(gregtechId("steam_turbine.mv"), RecipeMaps.STEAM_TURBINE_FUELS, Textures.STEAM_TURBINE_OVERLAY, 2));
        STEAM_TURBINE[2] = GregTechAPI.registerMetaTileEntity(487, new SimpleGeneratorMetaTileEntity(gregtechId("steam_turbine.hv"), RecipeMaps.STEAM_TURBINE_FUELS, Textures.STEAM_TURBINE_OVERLAY, 3));

        GAS_TURBINE[0] = GregTechAPI.registerMetaTileEntity(490, new SimpleGeneratorMetaTileEntity(gregtechId("gas_turbine.lv"), RecipeMaps.GAS_TURBINE_FUELS, Textures.GAS_TURBINE_OVERLAY, 1));
        GAS_TURBINE[1] = GregTechAPI.registerMetaTileEntity(491, new SimpleGeneratorMetaTileEntity(gregtechId("gas_turbine.mv"), RecipeMaps.GAS_TURBINE_FUELS, Textures.GAS_TURBINE_OVERLAY, 2));
        GAS_TURBINE[2] = GregTechAPI.registerMetaTileEntity(492, new SimpleGeneratorMetaTileEntity(gregtechId("gas_turbine.hv"), RecipeMaps.GAS_TURBINE_FUELS, Textures.GAS_TURBINE_OVERLAY, 3));

        MAGIC_ENERGY_ABSORBER = GregTechAPI.registerMetaTileEntity(493, new MetaTileEntityMagicEnergyAbsorber(gregtechId("magic_energy_absorber")));

        ITEM_COLLECTOR[0] = GregTechAPI.registerMetaTileEntity(494, new MetaTileEntityItemCollector(gregtechId("item_collector.lv"), 1, 8));
        ITEM_COLLECTOR[1] = GregTechAPI.registerMetaTileEntity(495, new MetaTileEntityItemCollector(gregtechId("item_collector.mv"), 2, 16));
        ITEM_COLLECTOR[2] = GregTechAPI.registerMetaTileEntity(496, new MetaTileEntityItemCollector(gregtechId("item_collector.hv"), 3, 32));
        ITEM_COLLECTOR[3] = GregTechAPI.registerMetaTileEntity(497, new MetaTileEntityItemCollector(gregtechId("item_collector.ev"), 4, 64));

        MINER[0] = GregTechAPI.registerMetaTileEntity(498, new MetaTileEntityChunkMiner(gregtechId("miner.lv"), Miner.Type.LV, 1));
        MINER[1] = GregTechAPI.registerMetaTileEntity(499, new MetaTileEntityChunkMiner(gregtechId("miner.mv"), Miner.Type.MV, 2));
        MINER[2] = GregTechAPI.registerMetaTileEntity(500, new MetaTileEntityChunkMiner(gregtechId("miner.hv"), Miner.Type.HV, 3));
        MINER[3] = GregTechAPI.registerMetaTileEntity(501, new MetaTileEntityChunkMiner(gregtechId("miner.ev"), Miner.Type.EV, 4));
        MINER[4] = GregTechAPI.registerMetaTileEntity(502, new MetaTileEntityChunkMiner(gregtechId("miner.iv"), Miner.Type.IV, 5));
        MINER[5] = GregTechAPI.registerMetaTileEntity(503, new MetaTileEntityChunkMiner(gregtechId("miner.luv"), Miner.Type.LuV, 6));
        MINER[6] = GregTechAPI.registerMetaTileEntity(504, new MetaTileEntityChunkMiner(gregtechId("miner.zpm"), Miner.Type.ZPM, 7));
        MINER[7] = GregTechAPI.registerMetaTileEntity(505, new MetaTileEntityChunkMiner(gregtechId("miner.uv"), Miner.Type.UV, 8));
        MINER[8] = GregTechAPI.registerMetaTileEntity(506, new MetaTileEntityChunkMiner(gregtechId("miner.uhv"), Miner.Type.UHV, 9));
        MINER[9] = GregTechAPI.registerMetaTileEntity(507, new MetaTileEntityChunkMiner(gregtechId("miner.uev"), Miner.Type.UEV, 10));
        MINER[10] = GregTechAPI.registerMetaTileEntity(508, new MetaTileEntityChunkMiner(gregtechId("miner.uiv"), Miner.Type.UIV, 11));
        MINER[11] = GregTechAPI.registerMetaTileEntity(509, new MetaTileEntityChunkMiner(gregtechId("miner.umv"), Miner.Type.UMV, 12));
        MINER[12] = GregTechAPI.registerMetaTileEntity(528, new MetaTileEntityChunkMiner(gregtechId("miner.uxv"), Miner.Type.UXV, 13));

        //HULLS
        for (int i = 0; i < HULL.length; i++) {
            MetaTileEntityHull metaTileEntity = new MetaTileEntityHull(gregtechId("hull." + GTValues.VN[i].toLowerCase()), i);
            GregTechAPI.registerMetaTileEntity(2600 + i, metaTileEntity);
            HULL[i] = metaTileEntity;
        }

        //DIODES
        for (int i = 0; i < DIODE.length; i++) {
            MetaTileEntityDiode metaTileEntity = new MetaTileEntityDiode(gregtechId("diode." + GTValues.VN[i].toLowerCase()), i);
            GregTechAPI.registerMetaTileEntity(5000 + i, metaTileEntity);
            DIODE[i] = metaTileEntity;
        }

        PRIMITIVE_BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(510, new MetaTileEntityPrimitiveBlastFurnace(gregtechId("primitive_blast_furnace.bronze")));
        ELECTRIC_BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(511, new MetaTileEntityElectricBlastFurnace(gregtechId("electric_blast_furnace")));
        VACUUM_FREEZER = GregTechAPI.registerMetaTileEntity(512, new MetaTileEntityVacuumFreezer(gregtechId("vacuum_freezer")));
        IMPLOSION_COMPRESSOR = GregTechAPI.registerMetaTileEntity(513, new MetaTileEntityImplosionCompressor(gregtechId("implosion_compressor")));
        PYROLYSE_OVEN = GregTechAPI.registerMetaTileEntity(514, new MetaTileEntityPyrolyseOven(gregtechId("pyrolyse_oven")));
        DISTILLATION_TOWER = GregTechAPI.registerMetaTileEntity(515, new MetaTileEntityDistillationTower(gregtechId("distillation_tower")));
        MULTI_FURNACE = GregTechAPI.registerMetaTileEntity(516, new MetaTileEntityMultiFurnace(gregtechId("multi_furnace")));
        DIESEL_ENGINE = GregTechAPI.registerMetaTileEntity(517, new MetaTileEntityDieselEngine(gregtechId("diesel_engine")));
        CRACKER = GregTechAPI.registerMetaTileEntity(525, new MetaTileEntityCrackingUnit(gregtechId("cracker")));

        LARGE_STEAM_TURBINE = GregTechAPI.registerMetaTileEntity(518, new MetaTileEntityLargeTurbine(gregtechId("large_turbine.steam"), TurbineType.STEAM));
        LARGE_GAS_TURBINE = GregTechAPI.registerMetaTileEntity(519, new MetaTileEntityLargeTurbine(gregtechId("large_turbine.gas"), TurbineType.GAS));
        LARGE_PLASMA_TURBINE = GregTechAPI.registerMetaTileEntity(520, new MetaTileEntityLargeTurbine(gregtechId("large_turbine.plasma"), TurbineType.PLASMA));

        LARGE_BRONZE_BOILER = GregTechAPI.registerMetaTileEntity(521, new MetaTileEntityLargeBoiler(gregtechId("large_boiler.bronze"), BoilerType.BRONZE));
        LARGE_STEEL_BOILER = GregTechAPI.registerMetaTileEntity(522, new MetaTileEntityLargeBoiler(gregtechId("large_boiler.steel"), BoilerType.STEEL));
        LARGE_TITANIUM_BOILER = GregTechAPI.registerMetaTileEntity(523, new MetaTileEntityLargeBoiler(gregtechId("large_boiler.titanium"), BoilerType.TITANIUM));
        LARGE_TUNGSTENSTEEL_BOILER = GregTechAPI.registerMetaTileEntity(524, new MetaTileEntityLargeBoiler(gregtechId("large_boiler.tungstensteel"), BoilerType.TUNGSTENSTEEL));

        COKE_OVEN = GregTechAPI.registerMetaTileEntity(526, new MetaTileEntityCokeOven(gregtechId("coke_oven")));
        COKE_OVEN_HATCH = GregTechAPI.registerMetaTileEntity(527, new MetaTileEntityCokeOvenHatch(gregtechId("coke_oven_hatch")));

        int[] batteryBufferSlots = new int[]{1, 4, 9, 16};
        for (int i = 0; i < GTValues.V.length; i++) {
            if (i > 0 && i <= TRANSFORMER.length) {
                MetaTileEntityTransformer transformer = new MetaTileEntityTransformer(gregtechId("transformer." + GTValues.VN[i].toLowerCase()), i);
                TRANSFORMER[i - 1] = GregTechAPI.registerMetaTileEntity(2700 + (i - 1), transformer);
            }
            BATTERY_BUFFER[i] = new MetaTileEntityBatteryBuffer[batteryBufferSlots.length];
            for (int slot = 0; slot < batteryBufferSlots.length; slot++) {
                String transformerId = "battery_buffer." + GTValues.VN[i].toLowerCase() + "." + batteryBufferSlots[slot];
                MetaTileEntityBatteryBuffer batteryBuffer = new MetaTileEntityBatteryBuffer(gregtechId(transformerId), i, batteryBufferSlots[slot]);
                BATTERY_BUFFER[i][slot] = GregTechAPI.registerMetaTileEntity(2980 + batteryBufferSlots.length * i + slot, batteryBuffer);
            }
            String chargerId = "charger." + GTValues.VN[i].toLowerCase();
            MetaTileEntityCharger charger = new MetaTileEntityCharger(gregtechId(chargerId), i, 4);
            CHARGER[i] = GregTechAPI.registerMetaTileEntity(3100 + i, charger);
        }

        for (int i = 0; i < GTValues.V.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            ITEM_IMPORT_BUS[i] = new MetaTileEntityItemBus(gregtechId("item_bus.import." + voltageName), i, false);
            ITEM_EXPORT_BUS[i] = new MetaTileEntityItemBus(gregtechId("item_bus.export." + voltageName), i, true);
            FLUID_IMPORT_HATCH[i] = new MetaTileEntityFluidHatch(gregtechId("fluid_hatch.import." + voltageName), i, false);
            FLUID_EXPORT_HATCH[i] = new MetaTileEntityFluidHatch(gregtechId("fluid_hatch.export." + voltageName), i, true);
            ENERGY_INPUT_HATCH[i] = new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.input." + voltageName), i, false);
            ENERGY_OUTPUT_HATCH[i] = new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.output." + voltageName), i, true);

            GregTechAPI.registerMetaTileEntity(3700 + i, ITEM_IMPORT_BUS[i]);
            GregTechAPI.registerMetaTileEntity(3716 + i, ITEM_EXPORT_BUS[i]);
            GregTechAPI.registerMetaTileEntity(3732 + i, FLUID_IMPORT_HATCH[i]);
            GregTechAPI.registerMetaTileEntity(3748 + i, FLUID_EXPORT_HATCH[i]);
            GregTechAPI.registerMetaTileEntity(3764 + i, ENERGY_INPUT_HATCH[i]);
            GregTechAPI.registerMetaTileEntity(3780 + i, ENERGY_OUTPUT_HATCH[i]);
        }

        ROTOR_HOLDER[0] = GregTechAPI.registerMetaTileEntity(817, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.hv"), GTValues.HV, 1.06f));
        ROTOR_HOLDER[1] = GregTechAPI.registerMetaTileEntity(818, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.luv"), GTValues.LuV, 4f));
        ROTOR_HOLDER[2] = GregTechAPI.registerMetaTileEntity(819, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.max"), GTValues.MAX, 59049f));
        ROTOR_HOLDER[3] = GregTechAPI.registerMetaTileEntity(4000, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.iv"), GTValues.IV, 2f));
        ROTOR_HOLDER[4] = GregTechAPI.registerMetaTileEntity(4001, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.zpm"), GTValues.ZPM, 10f));
        ROTOR_HOLDER[5] = GregTechAPI.registerMetaTileEntity(4002, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.uv"), GTValues.UV, 28f));
        ROTOR_HOLDER[6] = GregTechAPI.registerMetaTileEntity(4003, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.uhv"), GTValues.UHV, 82f));
        ROTOR_HOLDER[7] = GregTechAPI.registerMetaTileEntity(4004, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.uev"), GTValues.UEV, 244f));
        ROTOR_HOLDER[8] = GregTechAPI.registerMetaTileEntity(4005, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.uiv"), GTValues.UIV, 730f));
        ROTOR_HOLDER[9] = GregTechAPI.registerMetaTileEntity(4006, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.umv"), GTValues.UMV, 2188f));
        ROTOR_HOLDER[10] = GregTechAPI.registerMetaTileEntity(4007, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.uxv"), GTValues.UXV, 6562f));
        ROTOR_HOLDER[11] = GregTechAPI.registerMetaTileEntity(4008, new MetaTileEntityRotorHolder(gregtechId("rotor_holder.opv"), GTValues.OpV, 19583f));

        MAINTENANCE_HATCH = GregTechAPI.registerMetaTileEntity(4009, new MetaTileEntityMaintenanceHatch(gregtechId("maintenance_hatch"), GTValues.LuV));

        SMALL_WOODEN_CHEST = GregTechAPI.registerMetaTileEntity(808, new MetaTileEntityChest(gregtechId("small_wooden_chest"), Materials.Wood, 1, 1));
        WOODEN_CHEST = GregTechAPI.registerMetaTileEntity(807, new MetaTileEntityChest(gregtechId("wooden_chest"), Materials.Wood, 9, 3));
        BRONZE_CHEST = GregTechAPI.registerMetaTileEntity(802, new MetaTileEntityChest(gregtechId("bronze_chest"), Materials.Bronze, 9, 6));
        STEEL_CHEST = GregTechAPI.registerMetaTileEntity(803, new MetaTileEntityChest(gregtechId("steel_chest"), Materials.Steel, 9, 8));
        STAINLESS_STEEL_CHEST = GregTechAPI.registerMetaTileEntity(804, new MetaTileEntityChest(gregtechId("stainless_steel_chest"), Materials.StainlessSteel, 9, 10));
        TITANIUM_CHEST = GregTechAPI.registerMetaTileEntity(805, new MetaTileEntityChest(gregtechId("titanium_chest"), Materials.Titanium, 12, 10));
        TUNGSTENSTEEL_CHEST = GregTechAPI.registerMetaTileEntity(806, new MetaTileEntityChest(gregtechId("tungstensteel_chest"), Materials.TungstenSteel, 12, 14));

        WOODEN_TANK = GregTechAPI.registerMetaTileEntity(811, new MetaTileEntityTank(gregtechId("wooden_tank"), Materials.Wood, 4000, 1, 3));
        BRONZE_TANK = GregTechAPI.registerMetaTileEntity(812, new MetaTileEntityTank(gregtechId("bronze_tank"), Materials.Bronze, 8000, 4, 3));
        STEEL_TANK = GregTechAPI.registerMetaTileEntity(813, new MetaTileEntityTank(gregtechId("steel_tank"), Materials.Steel, 16000, 7, 5));
        STAINLESS_STEEL_TANK = GregTechAPI.registerMetaTileEntity(814, new MetaTileEntityTank(gregtechId("stainless_steel_tank"), Materials.StainlessSteel, 32000, 9, 7));
        TITANIUM_TANK = GregTechAPI.registerMetaTileEntity(815, new MetaTileEntityTank(gregtechId("titanium_tank"), Materials.Titanium, 48000, 12, 9));
        TUNGSTENSTEEL_TANK = GregTechAPI.registerMetaTileEntity(816, new MetaTileEntityTank(gregtechId("tungstensteel_tank"), Materials.TungstenSteel, 64000, 16, 9));

        FISHER[0] = GregTechAPI.registerMetaTileEntity(820, new MetaTileEntityFisher(gregtechId("fisher.lv"), 1));
        FISHER[1] = GregTechAPI.registerMetaTileEntity(821, new MetaTileEntityFisher(gregtechId("fisher.mv"), 2));
        FISHER[2] = GregTechAPI.registerMetaTileEntity(822, new MetaTileEntityFisher(gregtechId("fisher.hv"), 3));
        FISHER[3] = GregTechAPI.registerMetaTileEntity(823, new MetaTileEntityFisher(gregtechId("fisher.ev"), 4));
        FISHER[4] = GregTechAPI.registerMetaTileEntity(1200, new MetaTileEntityFisher(gregtechId("fisher.iv"), 5));
        FISHER[5] = GregTechAPI.registerMetaTileEntity(1201, new MetaTileEntityFisher(gregtechId("fisher.luv"), 6));
        FISHER[6] = GregTechAPI.registerMetaTileEntity(1202, new MetaTileEntityFisher(gregtechId("fisher.zpm"), 7));
        FISHER[7] = GregTechAPI.registerMetaTileEntity(1203, new MetaTileEntityFisher(gregtechId("fisher.uv"), 8));
        FISHER[8] = GregTechAPI.registerMetaTileEntity(1204, new MetaTileEntityFisher(gregtechId("fisher.uhv"), 9));
        FISHER[9] = GregTechAPI.registerMetaTileEntity(1205, new MetaTileEntityFisher(gregtechId("fisher.uev"), 10));
        FISHER[10] = GregTechAPI.registerMetaTileEntity(1206, new MetaTileEntityFisher(gregtechId("fisher.uiv"), 11));
        FISHER[11] = GregTechAPI.registerMetaTileEntity(1207, new MetaTileEntityFisher(gregtechId("fisher.umv"), 12));
        FISHER[12] = GregTechAPI.registerMetaTileEntity(1208, new MetaTileEntityFisher(gregtechId("fisher.uxv"), 13));
        FISHER[13] = GregTechAPI.registerMetaTileEntity(1209, new MetaTileEntityFisher(gregtechId("fisher.opv"), 14));

        LOCKED_SAFE = GregTechAPI.registerMetaTileEntity(824, new MetaTileEntityLockedSafe(gregtechId("locked_safe")));
        WORKBENCH = GregTechAPI.registerMetaTileEntity(825, new MetaTileEntityWorkbench(gregtechId("workbench")));
        ARMOR_TABLE = GregTechAPI.registerMetaTileEntity(826, new MetaTileEntityArmorTable(gregtechId("armor_table")));
        LOCKED_SAFE_MV = GregTechAPI.registerMetaTileEntity(827, new MetaTileEntityLockedSafeMV(gregtechId("locked_safe_mv")));
        LOCKED_SAFE_HV = GregTechAPI.registerMetaTileEntity(828, new MetaTileEntityLockedSafeHV(gregtechId("locked_safe_hv")));
        LOCKED_SAFE_EV = GregTechAPI.registerMetaTileEntity(829, new MetaTileEntityLockedSafeEV(gregtechId("locked_safe_ev")));

        for (int i = 1; i < 5; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            PUMP[i - 1] = new MetaTileEntityPump(gregtechId("pump." + voltageName), i);
            AIR_COLLECTOR[i - 1] = new MetaTileEntityAirCollector(gregtechId("air_collector." + voltageName), i);
            GregTechAPI.registerMetaTileEntity(900 + 10 * (i - 1), PUMP[i - 1]);
            GregTechAPI.registerMetaTileEntity(950 + 10 * (i - 1), AIR_COLLECTOR[i - 1]);
        }

        TESLA_COIL = new MetaTileEntityTeslaCoil(gregtechId("tesla_coil"));
        GregTechAPI.registerMetaTileEntity(1001, TESLA_COIL);

        for (int i = 2; i < 6; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            QUANTUM_CHEST[i - 2] = new MetaTileEntityQuantumChest(gregtechId("quantum_chest." + voltageName), i, 64 * 64000 * (i - 1));
            QUANTUM_TANK[i - 2] = new MetaTileEntityQuantumTank(gregtechId("quantum_tank." + voltageName), i, 1000 * 64000 * (i - 1));
            GregTechAPI.registerMetaTileEntity(1010 + (i - 2), QUANTUM_CHEST[i - 2]);
            GregTechAPI.registerMetaTileEntity(1020 + (i - 2), QUANTUM_TANK[i - 2]);
        }

        for (int i = 1; i < 5; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            BLOCK_BREAKER[i - 1] = new MetaTileEntityBlockBreaker(gregtechId("block_breaker." + voltageName), i);
            GregTechAPI.registerMetaTileEntity(1030 + (i - 1), BLOCK_BREAKER[i - 1]);
        }

        //SSP MECH
        ELECTRIC_FURNACE_SSP[0] = GregTechAPI.registerMetaTileEntity(4100, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.uhv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 9));
        ELECTRIC_FURNACE_SSP[1] = GregTechAPI.registerMetaTileEntity(4101, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.uev"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 10));
        ELECTRIC_FURNACE_SSP[2] = GregTechAPI.registerMetaTileEntity(4102, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.uiv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 11));
        ELECTRIC_FURNACE_SSP[3] = GregTechAPI.registerMetaTileEntity(4103, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.umv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 12));
        ELECTRIC_FURNACE_SSP[4] = GregTechAPI.registerMetaTileEntity(4104, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.uxv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 13));
        ELECTRIC_FURNACE_SSP[5] = GregTechAPI.registerMetaTileEntity(4105, new SimpleMachineMetaTileEntity(gregtechId("electric_furnace.opv"), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, 14));

        MACERATOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4106, new MetaTileEntityMacerator(gregtechId("macerator.uhv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 9));
        MACERATOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4107, new MetaTileEntityMacerator(gregtechId("macerator.uev"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 10));
        MACERATOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4108, new MetaTileEntityMacerator(gregtechId("macerator.uiv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 11));
        MACERATOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4109, new MetaTileEntityMacerator(gregtechId("macerator.umv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 12));
        MACERATOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4110, new MetaTileEntityMacerator(gregtechId("macerator.uxv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 13));
        MACERATOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4111, new MetaTileEntityMacerator(gregtechId("macerator.opv"), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, 14));

        ALLOY_SMELTER_SSP[0] = GregTechAPI.registerMetaTileEntity(4112, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.uhv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 9));
        ALLOY_SMELTER_SSP[1] = GregTechAPI.registerMetaTileEntity(4113, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.uev"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 10));
        ALLOY_SMELTER_SSP[2] = GregTechAPI.registerMetaTileEntity(4114, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.uiv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 11));
        ALLOY_SMELTER_SSP[3] = GregTechAPI.registerMetaTileEntity(4115, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.umv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 12));
        ALLOY_SMELTER_SSP[4] = GregTechAPI.registerMetaTileEntity(4116, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.uxv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 13));
        ALLOY_SMELTER_SSP[5] = GregTechAPI.registerMetaTileEntity(4117, new SimpleMachineMetaTileEntity(gregtechId("alloy_smelter.opv"), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 14));

        AMPLIFABRICATOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4118, new SimpleMachineMetaTileEntity(gregtechId("amplifab.uhv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 9));
        AMPLIFABRICATOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4119, new SimpleMachineMetaTileEntity(gregtechId("amplifab.uev"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 10));
        AMPLIFABRICATOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4120, new SimpleMachineMetaTileEntity(gregtechId("amplifab.uiv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 11));
        AMPLIFABRICATOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4121, new SimpleMachineMetaTileEntity(gregtechId("amplifab.umv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 12));
        AMPLIFABRICATOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4122, new SimpleMachineMetaTileEntity(gregtechId("amplifab.uxv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 13));
        AMPLIFABRICATOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4123, new SimpleMachineMetaTileEntity(gregtechId("amplifab.opv"), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, 14));

        ARC_FURNACE_SSP[0] = GregTechAPI.registerMetaTileEntity(4124, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.uhv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 9, false));
        ARC_FURNACE_SSP[1] = GregTechAPI.registerMetaTileEntity(4125, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.uev"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 10, false));
        ARC_FURNACE_SSP[2] = GregTechAPI.registerMetaTileEntity(4126, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.uiv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 11, false));
        ARC_FURNACE_SSP[3] = GregTechAPI.registerMetaTileEntity(4127, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.umv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 12, false));
        ARC_FURNACE_SSP[4] = GregTechAPI.registerMetaTileEntity(4128, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.uxv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 13, false));
        ARC_FURNACE_SSP[5] = GregTechAPI.registerMetaTileEntity(4129, new SimpleMachineMetaTileEntity(gregtechId("arc_furnace.opv"), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, 14, false));

        ASSEMBLER_SSP[0] = GregTechAPI.registerMetaTileEntity(4130, new SimpleMachineMetaTileEntity(gregtechId("assembler.uhv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 9));
        ASSEMBLER_SSP[1] = GregTechAPI.registerMetaTileEntity(4131, new SimpleMachineMetaTileEntity(gregtechId("assembler.uev"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 10));
        ASSEMBLER_SSP[2] = GregTechAPI.registerMetaTileEntity(4132, new SimpleMachineMetaTileEntity(gregtechId("assembler.uiv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 11));
        ASSEMBLER_SSP[3] = GregTechAPI.registerMetaTileEntity(4133, new SimpleMachineMetaTileEntity(gregtechId("assembler.umv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 12));
        ASSEMBLER_SSP[4] = GregTechAPI.registerMetaTileEntity(4134, new SimpleMachineMetaTileEntity(gregtechId("assembler.uxv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 13));
        ASSEMBLER_SSP[5] = GregTechAPI.registerMetaTileEntity(4135, new SimpleMachineMetaTileEntity(gregtechId("assembler.opv"), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 14));

        AUTOCLAVE_SSP[0] = GregTechAPI.registerMetaTileEntity(4136, new SimpleMachineMetaTileEntity(gregtechId("autoclave.uhv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 9, false));
        AUTOCLAVE_SSP[1] = GregTechAPI.registerMetaTileEntity(4137, new SimpleMachineMetaTileEntity(gregtechId("autoclave.uev"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 10, false));
        AUTOCLAVE_SSP[2] = GregTechAPI.registerMetaTileEntity(4138, new SimpleMachineMetaTileEntity(gregtechId("autoclave.uiv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 11, false));
        AUTOCLAVE_SSP[3] = GregTechAPI.registerMetaTileEntity(4139, new SimpleMachineMetaTileEntity(gregtechId("autoclave.umv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 12, false));
        AUTOCLAVE_SSP[4] = GregTechAPI.registerMetaTileEntity(4140, new SimpleMachineMetaTileEntity(gregtechId("autoclave.uxv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 13, false));
        AUTOCLAVE_SSP[5] = GregTechAPI.registerMetaTileEntity(4141, new SimpleMachineMetaTileEntity(gregtechId("autoclave.opv"), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, 14, false));

        BENDER_SSP[0] = GregTechAPI.registerMetaTileEntity(4142, new SimpleMachineMetaTileEntity(gregtechId("bender.uhv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 9));
        BENDER_SSP[1] = GregTechAPI.registerMetaTileEntity(4143, new SimpleMachineMetaTileEntity(gregtechId("bender.uev"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 10));
        BENDER_SSP[2] = GregTechAPI.registerMetaTileEntity(4144, new SimpleMachineMetaTileEntity(gregtechId("bender.uiv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 11));
        BENDER_SSP[3] = GregTechAPI.registerMetaTileEntity(4145, new SimpleMachineMetaTileEntity(gregtechId("bender.umv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 12));
        BENDER_SSP[4] = GregTechAPI.registerMetaTileEntity(4146, new SimpleMachineMetaTileEntity(gregtechId("bender.uxv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 13));
        BENDER_SSP[5] = GregTechAPI.registerMetaTileEntity(4147, new SimpleMachineMetaTileEntity(gregtechId("bender.opv"), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, 14));

        BREWERY_SSP[0] = GregTechAPI.registerMetaTileEntity(4148, new SimpleMachineMetaTileEntity(gregtechId("brewery.uhv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 9));
        BREWERY_SSP[1] = GregTechAPI.registerMetaTileEntity(4149, new SimpleMachineMetaTileEntity(gregtechId("brewery.uev"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 10));
        BREWERY_SSP[2] = GregTechAPI.registerMetaTileEntity(4150, new SimpleMachineMetaTileEntity(gregtechId("brewery.uiv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 11));
        BREWERY_SSP[3] = GregTechAPI.registerMetaTileEntity(4151, new SimpleMachineMetaTileEntity(gregtechId("brewery.umv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 12));
        BREWERY_SSP[4] = GregTechAPI.registerMetaTileEntity(4152, new SimpleMachineMetaTileEntity(gregtechId("brewery.uxv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 13));
        BREWERY_SSP[5] = GregTechAPI.registerMetaTileEntity(4153, new SimpleMachineMetaTileEntity(gregtechId("brewery.opv"), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, 14));

        CANNER_SSP[0] = GregTechAPI.registerMetaTileEntity(4154, new SimpleMachineMetaTileEntity(gregtechId("canner.uhv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 9));
        CANNER_SSP[1] = GregTechAPI.registerMetaTileEntity(4155, new SimpleMachineMetaTileEntity(gregtechId("canner.uev"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 10));
        CANNER_SSP[2] = GregTechAPI.registerMetaTileEntity(4156, new SimpleMachineMetaTileEntity(gregtechId("canner.uiv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 11));
        CANNER_SSP[3] = GregTechAPI.registerMetaTileEntity(4157, new SimpleMachineMetaTileEntity(gregtechId("canner.umv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 12));
        CANNER_SSP[4] = GregTechAPI.registerMetaTileEntity(4158, new SimpleMachineMetaTileEntity(gregtechId("canner.uxv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 13));
        CANNER_SSP[5] = GregTechAPI.registerMetaTileEntity(4159, new SimpleMachineMetaTileEntity(gregtechId("canner.opv"), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, 14));

        CENTRIFUGE_SSP[0] = GregTechAPI.registerMetaTileEntity(4160, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.uhv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 9, false));
        CENTRIFUGE_SSP[1] = GregTechAPI.registerMetaTileEntity(4161, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.uev"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 10, false));
        CENTRIFUGE_SSP[2] = GregTechAPI.registerMetaTileEntity(4162, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.uiv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 11, false));
        CENTRIFUGE_SSP[3] = GregTechAPI.registerMetaTileEntity(4163, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.umv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 12, false));
        CENTRIFUGE_SSP[4] = GregTechAPI.registerMetaTileEntity(4164, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.uxv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 13, false));
        CENTRIFUGE_SSP[5] = GregTechAPI.registerMetaTileEntity(4165, new SimpleMachineMetaTileEntity(gregtechId("centrifuge.opv"), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, 14, false));

        CHEMICAL_BATH_SSP[0] = GregTechAPI.registerMetaTileEntity(4166, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.uhv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 9));
        CHEMICAL_BATH_SSP[1] = GregTechAPI.registerMetaTileEntity(4167, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.uev"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 10));
        CHEMICAL_BATH_SSP[2] = GregTechAPI.registerMetaTileEntity(4168, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.uiv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 11));
        CHEMICAL_BATH_SSP[3] = GregTechAPI.registerMetaTileEntity(4169, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.umv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 12));
        CHEMICAL_BATH_SSP[4] = GregTechAPI.registerMetaTileEntity(4170, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.uxv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 13));
        CHEMICAL_BATH_SSP[5] = GregTechAPI.registerMetaTileEntity(4171, new SimpleMachineMetaTileEntity(gregtechId("chemical_bath.opv"), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, 14));

        CHEMICAL_REACTOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4172, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.uhv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 9));
        CHEMICAL_REACTOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4173, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.uev"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 10));
        CHEMICAL_REACTOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4174, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.uiv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 11));
        CHEMICAL_REACTOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4175, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.umv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 12));
        CHEMICAL_REACTOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4176, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.uxv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 13));
        CHEMICAL_REACTOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4177, new SimpleMachineMetaTileEntity(gregtechId("chemical_reactor.opv"), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, 14));

        COMPRESSOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4178, new SimpleMachineMetaTileEntity(gregtechId("compressor.uhv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 9));
        COMPRESSOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4179, new SimpleMachineMetaTileEntity(gregtechId("compressor.uev"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 10));
        COMPRESSOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4180, new SimpleMachineMetaTileEntity(gregtechId("compressor.uiv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 11));
        COMPRESSOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4181, new SimpleMachineMetaTileEntity(gregtechId("compressor.umv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 12));
        COMPRESSOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4182, new SimpleMachineMetaTileEntity(gregtechId("compressor.uxv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 13));
        COMPRESSOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4183, new SimpleMachineMetaTileEntity(gregtechId("compressor.opv"), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, 14));

        CUTTER_SSP[0] = GregTechAPI.registerMetaTileEntity(4184, new SimpleMachineMetaTileEntity(gregtechId("cutter.uhv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 9));
        CUTTER_SSP[1] = GregTechAPI.registerMetaTileEntity(4185, new SimpleMachineMetaTileEntity(gregtechId("cutter.uev"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 10));
        CUTTER_SSP[2] = GregTechAPI.registerMetaTileEntity(4186, new SimpleMachineMetaTileEntity(gregtechId("cutter.uiv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 11));
        CUTTER_SSP[3] = GregTechAPI.registerMetaTileEntity(4187, new SimpleMachineMetaTileEntity(gregtechId("cutter.umv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 12));
        CUTTER_SSP[4] = GregTechAPI.registerMetaTileEntity(4188, new SimpleMachineMetaTileEntity(gregtechId("cutter.uxv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 13));
        CUTTER_SSP[5] = GregTechAPI.registerMetaTileEntity(4189, new SimpleMachineMetaTileEntity(gregtechId("cutter.opv"), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, 14));

        DISTILLERY_SSP[0] = GregTechAPI.registerMetaTileEntity(4190, new SimpleMachineMetaTileEntity(gregtechId("distillery.uhv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 9));
        DISTILLERY_SSP[1] = GregTechAPI.registerMetaTileEntity(4191, new SimpleMachineMetaTileEntity(gregtechId("distillery.uev"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 10));
        DISTILLERY_SSP[2] = GregTechAPI.registerMetaTileEntity(4192, new SimpleMachineMetaTileEntity(gregtechId("distillery.uiv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 11));
        DISTILLERY_SSP[3] = GregTechAPI.registerMetaTileEntity(4193, new SimpleMachineMetaTileEntity(gregtechId("distillery.umv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 12));
        DISTILLERY_SSP[4] = GregTechAPI.registerMetaTileEntity(4194, new SimpleMachineMetaTileEntity(gregtechId("distillery.uxv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 13));
        DISTILLERY_SSP[5] = GregTechAPI.registerMetaTileEntity(4195, new SimpleMachineMetaTileEntity(gregtechId("distillery.opv"), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, 14));

        ELECTROLYZER_SSP[0] = GregTechAPI.registerMetaTileEntity(4196, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.uhv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 9, false));
        ELECTROLYZER_SSP[1] = GregTechAPI.registerMetaTileEntity(4197, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.uev"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 10, false));
        ELECTROLYZER_SSP[2] = GregTechAPI.registerMetaTileEntity(4198, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.uiv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 11, false));
        ELECTROLYZER_SSP[3] = GregTechAPI.registerMetaTileEntity(4199, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.umv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 12, false));
        ELECTROLYZER_SSP[4] = GregTechAPI.registerMetaTileEntity(4200, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.uxv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 13, false));
        ELECTROLYZER_SSP[5] = GregTechAPI.registerMetaTileEntity(4201, new SimpleMachineMetaTileEntity(gregtechId("electrolyzer.opv"), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, 14, false));

        ELECTROMAGNETIC_SEPARATOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4202, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.uhv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 9));
        ELECTROMAGNETIC_SEPARATOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4203, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.uev"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 10));
        ELECTROMAGNETIC_SEPARATOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4204, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.uiv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 11));
        ELECTROMAGNETIC_SEPARATOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4205, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.umv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 12));
        ELECTROMAGNETIC_SEPARATOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4206, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.uxv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 13));
        ELECTROMAGNETIC_SEPARATOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4207, new SimpleMachineMetaTileEntity(gregtechId("electromagnetic_separator.opv"), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, 14));

        EXTRACTOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4208, new SimpleMachineMetaTileEntity(gregtechId("extractor.uhv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 9));
        EXTRACTOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4209, new SimpleMachineMetaTileEntity(gregtechId("extractor.uev"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 10));
        EXTRACTOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4210, new SimpleMachineMetaTileEntity(gregtechId("extractor.uiv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 11));
        EXTRACTOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4211, new SimpleMachineMetaTileEntity(gregtechId("extractor.umv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 12));
        EXTRACTOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4212, new SimpleMachineMetaTileEntity(gregtechId("extractor.uxv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 13));
        EXTRACTOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4213, new SimpleMachineMetaTileEntity(gregtechId("extractor.opv"), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, 14));

        EXTRUDER_SSP[0] = GregTechAPI.registerMetaTileEntity(4214, new SimpleMachineMetaTileEntity(gregtechId("extruder.uhv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 9));
        EXTRUDER_SSP[1] = GregTechAPI.registerMetaTileEntity(4215, new SimpleMachineMetaTileEntity(gregtechId("extruder.uev"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 10));
        EXTRUDER_SSP[2] = GregTechAPI.registerMetaTileEntity(4216, new SimpleMachineMetaTileEntity(gregtechId("extruder.uiv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 11));
        EXTRUDER_SSP[3] = GregTechAPI.registerMetaTileEntity(4217, new SimpleMachineMetaTileEntity(gregtechId("extruder.umv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 12));
        EXTRUDER_SSP[4] = GregTechAPI.registerMetaTileEntity(4218, new SimpleMachineMetaTileEntity(gregtechId("extruder.uxv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 13));
        EXTRUDER_SSP[5] = GregTechAPI.registerMetaTileEntity(4219, new SimpleMachineMetaTileEntity(gregtechId("extruder.opv"), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 14));

        FERMENTER_SSP[0] = GregTechAPI.registerMetaTileEntity(4220, new SimpleMachineMetaTileEntity(gregtechId("fermenter.uhv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 9));
        FERMENTER_SSP[1] = GregTechAPI.registerMetaTileEntity(4221, new SimpleMachineMetaTileEntity(gregtechId("fermenter.uev"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 10));
        FERMENTER_SSP[2] = GregTechAPI.registerMetaTileEntity(4222, new SimpleMachineMetaTileEntity(gregtechId("fermenter.uiv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 11));
        FERMENTER_SSP[3] = GregTechAPI.registerMetaTileEntity(4223, new SimpleMachineMetaTileEntity(gregtechId("fermenter.umv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 12));
        FERMENTER_SSP[4] = GregTechAPI.registerMetaTileEntity(4224, new SimpleMachineMetaTileEntity(gregtechId("fermenter.uxv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 13));
        FERMENTER_SSP[5] = GregTechAPI.registerMetaTileEntity(4225, new SimpleMachineMetaTileEntity(gregtechId("fermenter.opv"), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, 14));

        FLUID_CANNER_SSP[0] = GregTechAPI.registerMetaTileEntity(4226, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.uhv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 9));
        FLUID_CANNER_SSP[1] = GregTechAPI.registerMetaTileEntity(4227, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.uev"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 10));
        FLUID_CANNER_SSP[2] = GregTechAPI.registerMetaTileEntity(4228, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.uiv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 11));
        FLUID_CANNER_SSP[3] = GregTechAPI.registerMetaTileEntity(4229, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.umv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 12));
        FLUID_CANNER_SSP[4] = GregTechAPI.registerMetaTileEntity(4230, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.uxv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 13));
        FLUID_CANNER_SSP[5] = GregTechAPI.registerMetaTileEntity(4231, new SimpleMachineMetaTileEntity(gregtechId("fluid_canner.opv"), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, 14));

        FLUID_EXTRACTOR_SSP[0] = GregTechAPI.registerMetaTileEntity(4232, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.uhv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 9));
        FLUID_EXTRACTOR_SSP[1] = GregTechAPI.registerMetaTileEntity(4233, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.uev"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 10));
        FLUID_EXTRACTOR_SSP[2] = GregTechAPI.registerMetaTileEntity(4234, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.uiv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 11));
        FLUID_EXTRACTOR_SSP[3] = GregTechAPI.registerMetaTileEntity(4235, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.umv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 12));
        FLUID_EXTRACTOR_SSP[4] = GregTechAPI.registerMetaTileEntity(4236, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.uxv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 13));
        FLUID_EXTRACTOR_SSP[5] = GregTechAPI.registerMetaTileEntity(4237, new SimpleMachineMetaTileEntity(gregtechId("fluid_extractor.opv"), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, 14));

        FLUID_HEATER_SSP[0] = GregTechAPI.registerMetaTileEntity(4238, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.uhv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 9));
        FLUID_HEATER_SSP[1] = GregTechAPI.registerMetaTileEntity(4239, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.uev"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 10));
        FLUID_HEATER_SSP[2] = GregTechAPI.registerMetaTileEntity(4240, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.uiv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 11));
        FLUID_HEATER_SSP[3] = GregTechAPI.registerMetaTileEntity(4241, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.umv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 12));
        FLUID_HEATER_SSP[4] = GregTechAPI.registerMetaTileEntity(4242, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.uxv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 13));
        FLUID_HEATER_SSP[5] = GregTechAPI.registerMetaTileEntity(4243, new SimpleMachineMetaTileEntity(gregtechId("fluid_heater.opv"), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, 14));

        FLUID_SOLIDIFIER_SSP[0] = GregTechAPI.registerMetaTileEntity(4244, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.uhv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 9));
        FLUID_SOLIDIFIER_SSP[1] = GregTechAPI.registerMetaTileEntity(4245, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.uev"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 10));
        FLUID_SOLIDIFIER_SSP[2] = GregTechAPI.registerMetaTileEntity(4246, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.uiv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 11));
        FLUID_SOLIDIFIER_SSP[3] = GregTechAPI.registerMetaTileEntity(4247, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.umv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 12));
        FLUID_SOLIDIFIER_SSP[4] = GregTechAPI.registerMetaTileEntity(4248, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.uxv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 13));
        FLUID_SOLIDIFIER_SSP[5] = GregTechAPI.registerMetaTileEntity(4249, new SimpleMachineMetaTileEntity(gregtechId("fluid_solidifier.opv"), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, 14));

        FORGE_HAMMER_SSP[0] = GregTechAPI.registerMetaTileEntity(4250, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.uhv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 9));
        FORGE_HAMMER_SSP[1] = GregTechAPI.registerMetaTileEntity(4251, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.uev"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 10));
        FORGE_HAMMER_SSP[2] = GregTechAPI.registerMetaTileEntity(4252, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.uiv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 11));
        FORGE_HAMMER_SSP[3] = GregTechAPI.registerMetaTileEntity(4253, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.umv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 12));
        FORGE_HAMMER_SSP[4] = GregTechAPI.registerMetaTileEntity(4254, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.uxv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 13));
        FORGE_HAMMER_SSP[5] = GregTechAPI.registerMetaTileEntity(4255, new SimpleMachineMetaTileEntity(gregtechId("forge_hammer.opv"), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, 14));

        FORMING_PRESS_SSP[0] = GregTechAPI.registerMetaTileEntity(4256, new SimpleMachineMetaTileEntity(gregtechId("forming_press.uhv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 9));
        FORMING_PRESS_SSP[1] = GregTechAPI.registerMetaTileEntity(4257, new SimpleMachineMetaTileEntity(gregtechId("forming_press.uev"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 10));
        FORMING_PRESS_SSP[2] = GregTechAPI.registerMetaTileEntity(4258, new SimpleMachineMetaTileEntity(gregtechId("forming_press.uiv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 11));
        FORMING_PRESS_SSP[3] = GregTechAPI.registerMetaTileEntity(4259, new SimpleMachineMetaTileEntity(gregtechId("forming_press.umv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 12));
        FORMING_PRESS_SSP[4] = GregTechAPI.registerMetaTileEntity(4260, new SimpleMachineMetaTileEntity(gregtechId("forming_press.uxv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 13));
        FORMING_PRESS_SSP[5] = GregTechAPI.registerMetaTileEntity(4261, new SimpleMachineMetaTileEntity(gregtechId("forming_press.opv"), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, 14));

        LATHE_SSP[0] = GregTechAPI.registerMetaTileEntity(4262, new SimpleMachineMetaTileEntity(gregtechId("lathe.uhv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 9));
        LATHE_SSP[1] = GregTechAPI.registerMetaTileEntity(4263, new SimpleMachineMetaTileEntity(gregtechId("lathe.uev"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 10));
        LATHE_SSP[2] = GregTechAPI.registerMetaTileEntity(4264, new SimpleMachineMetaTileEntity(gregtechId("lathe.uiv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 11));
        LATHE_SSP[3] = GregTechAPI.registerMetaTileEntity(4265, new SimpleMachineMetaTileEntity(gregtechId("lathe.umv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 12));
        LATHE_SSP[4] = GregTechAPI.registerMetaTileEntity(4266, new SimpleMachineMetaTileEntity(gregtechId("lathe.uxv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 13));
        LATHE_SSP[5] = GregTechAPI.registerMetaTileEntity(4267, new SimpleMachineMetaTileEntity(gregtechId("lathe.opv"), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, 14));

        MICROWAVE_SSP[0] = GregTechAPI.registerMetaTileEntity(4268, new SimpleMachineMetaTileEntity(gregtechId("microwave.uhv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 9));
        MICROWAVE_SSP[1] = GregTechAPI.registerMetaTileEntity(4269, new SimpleMachineMetaTileEntity(gregtechId("microwave.uev"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 10));
        MICROWAVE_SSP[2] = GregTechAPI.registerMetaTileEntity(4270, new SimpleMachineMetaTileEntity(gregtechId("microwave.uiv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 11));
        MICROWAVE_SSP[3] = GregTechAPI.registerMetaTileEntity(4271, new SimpleMachineMetaTileEntity(gregtechId("microwave.umv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 12));
        MICROWAVE_SSP[4] = GregTechAPI.registerMetaTileEntity(4272, new SimpleMachineMetaTileEntity(gregtechId("microwave.uxv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 13));
        MICROWAVE_SSP[5] = GregTechAPI.registerMetaTileEntity(4273, new SimpleMachineMetaTileEntity(gregtechId("microwave.opv"), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, 14));

        MIXER_SSP[0] = GregTechAPI.registerMetaTileEntity(4274, new SimpleMachineMetaTileEntity(gregtechId("mixer.uhv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 9, false));
        MIXER_SSP[1] = GregTechAPI.registerMetaTileEntity(4275, new SimpleMachineMetaTileEntity(gregtechId("mixer.uev"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 10, false));
        MIXER_SSP[2] = GregTechAPI.registerMetaTileEntity(4276, new SimpleMachineMetaTileEntity(gregtechId("mixer.uiv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 11, false));
        MIXER_SSP[3] = GregTechAPI.registerMetaTileEntity(4277, new SimpleMachineMetaTileEntity(gregtechId("mixer.umv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 12, false));
        MIXER_SSP[4] = GregTechAPI.registerMetaTileEntity(4278, new SimpleMachineMetaTileEntity(gregtechId("mixer.uxv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 13, false));
        MIXER_SSP[5] = GregTechAPI.registerMetaTileEntity(4279, new SimpleMachineMetaTileEntity(gregtechId("mixer.opv"), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, 14, false));

        ORE_WASHER_SSP[0] = GregTechAPI.registerMetaTileEntity(4280, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.uhv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 9));
        ORE_WASHER_SSP[1] = GregTechAPI.registerMetaTileEntity(4281, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.uev"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 10));
        ORE_WASHER_SSP[2] = GregTechAPI.registerMetaTileEntity(4282, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.uiv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 11));
        ORE_WASHER_SSP[3] = GregTechAPI.registerMetaTileEntity(4283, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.umv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 12));
        ORE_WASHER_SSP[4] = GregTechAPI.registerMetaTileEntity(4284, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.uxv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 13));
        ORE_WASHER_SSP[5] = GregTechAPI.registerMetaTileEntity(4285, new SimpleMachineMetaTileEntity(gregtechId("ore_washer.opv"), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, 14));

        PACKER_SSP[0] = GregTechAPI.registerMetaTileEntity(4286, new SimpleMachineMetaTileEntity(gregtechId("packer.uhv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 9));
        PACKER_SSP[1] = GregTechAPI.registerMetaTileEntity(4287, new SimpleMachineMetaTileEntity(gregtechId("packer.uev"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 10));
        PACKER_SSP[2] = GregTechAPI.registerMetaTileEntity(4288, new SimpleMachineMetaTileEntity(gregtechId("packer.uiv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 11));
        PACKER_SSP[3] = GregTechAPI.registerMetaTileEntity(4289, new SimpleMachineMetaTileEntity(gregtechId("packer.umv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 12));
        PACKER_SSP[4] = GregTechAPI.registerMetaTileEntity(4290, new SimpleMachineMetaTileEntity(gregtechId("packer.uxv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 13));
        PACKER_SSP[5] = GregTechAPI.registerMetaTileEntity(4291, new SimpleMachineMetaTileEntity(gregtechId("packer.opv"), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, 14));

        UNPACKER_SSP[0] = GregTechAPI.registerMetaTileEntity(4292, new SimpleMachineMetaTileEntity(gregtechId("unpacker.uhv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 9));
        UNPACKER_SSP[1] = GregTechAPI.registerMetaTileEntity(4293, new SimpleMachineMetaTileEntity(gregtechId("unpacker.uev"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 10));
        UNPACKER_SSP[2] = GregTechAPI.registerMetaTileEntity(4294, new SimpleMachineMetaTileEntity(gregtechId("unpacker.uiv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 11));
        UNPACKER_SSP[3] = GregTechAPI.registerMetaTileEntity(4295, new SimpleMachineMetaTileEntity(gregtechId("unpacker.umv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 12));
        UNPACKER_SSP[4] = GregTechAPI.registerMetaTileEntity(4296, new SimpleMachineMetaTileEntity(gregtechId("unpacker.uxv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 13));
        UNPACKER_SSP[5] = GregTechAPI.registerMetaTileEntity(4297, new SimpleMachineMetaTileEntity(gregtechId("unpacker.opv"), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, 14));

        PLASMA_ARC_FURNACE_SSP[0] = GregTechAPI.registerMetaTileEntity(4298, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.uhv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 9, false));
        PLASMA_ARC_FURNACE_SSP[1] = GregTechAPI.registerMetaTileEntity(4299, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.uev"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 10, false));
        PLASMA_ARC_FURNACE_SSP[2] = GregTechAPI.registerMetaTileEntity(4300, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.uiv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 11, false));
        PLASMA_ARC_FURNACE_SSP[3] = GregTechAPI.registerMetaTileEntity(4301, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.umv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 12, false));
        PLASMA_ARC_FURNACE_SSP[4] = GregTechAPI.registerMetaTileEntity(4302, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.uxv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 13, false));
        PLASMA_ARC_FURNACE_SSP[5] = GregTechAPI.registerMetaTileEntity(4303, new SimpleMachineMetaTileEntity(gregtechId("plasma_arc_furnace.opv"), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, 14, false));

        POLARIZER_SSP[0] = GregTechAPI.registerMetaTileEntity(4304, new SimpleMachineMetaTileEntity(gregtechId("polarizer.uhv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 9));
        POLARIZER_SSP[1] = GregTechAPI.registerMetaTileEntity(4305, new SimpleMachineMetaTileEntity(gregtechId("polarizer.uev"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 10));
        POLARIZER_SSP[2] = GregTechAPI.registerMetaTileEntity(4306, new SimpleMachineMetaTileEntity(gregtechId("polarizer.uiv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 11));
        POLARIZER_SSP[3] = GregTechAPI.registerMetaTileEntity(4307, new SimpleMachineMetaTileEntity(gregtechId("polarizer.umv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 12));
        POLARIZER_SSP[4] = GregTechAPI.registerMetaTileEntity(4308, new SimpleMachineMetaTileEntity(gregtechId("polarizer.uxv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 13));
        POLARIZER_SSP[5] = GregTechAPI.registerMetaTileEntity(4309, new SimpleMachineMetaTileEntity(gregtechId("polarizer.opv"), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, 14));

        LASER_ENGRAVER_SSP[0] = GregTechAPI.registerMetaTileEntity(4310, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.uhv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 9));
        LASER_ENGRAVER_SSP[1] = GregTechAPI.registerMetaTileEntity(4311, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.uev"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 10));
        LASER_ENGRAVER_SSP[2] = GregTechAPI.registerMetaTileEntity(4312, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.uiv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 11));
        LASER_ENGRAVER_SSP[3] = GregTechAPI.registerMetaTileEntity(4313, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.umv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 12));
        LASER_ENGRAVER_SSP[4] = GregTechAPI.registerMetaTileEntity(4314, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.uxv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 13));
        LASER_ENGRAVER_SSP[5] = GregTechAPI.registerMetaTileEntity(4315, new SimpleMachineMetaTileEntity(gregtechId("laser_engraver.opv"), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, 14));

        SIFTER_SSP[0] = GregTechAPI.registerMetaTileEntity(4316, new SimpleMachineMetaTileEntity(gregtechId("sifter.uhv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 9));
        SIFTER_SSP[1] = GregTechAPI.registerMetaTileEntity(4317, new SimpleMachineMetaTileEntity(gregtechId("sifter.uev"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 10));
        SIFTER_SSP[2] = GregTechAPI.registerMetaTileEntity(4318, new SimpleMachineMetaTileEntity(gregtechId("sifter.uiv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 11));
        SIFTER_SSP[3] = GregTechAPI.registerMetaTileEntity(4319, new SimpleMachineMetaTileEntity(gregtechId("sifter.umv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 12));
        SIFTER_SSP[4] = GregTechAPI.registerMetaTileEntity(4320, new SimpleMachineMetaTileEntity(gregtechId("sifter.uxv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 13));
        SIFTER_SSP[5] = GregTechAPI.registerMetaTileEntity(4321, new SimpleMachineMetaTileEntity(gregtechId("sifter.opv"), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, 14));

        THERMAL_CENTRIFUGE_SSP[0] = GregTechAPI.registerMetaTileEntity(4322, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.uhv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 9));
        THERMAL_CENTRIFUGE_SSP[1] = GregTechAPI.registerMetaTileEntity(4323, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.uev"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 10));
        THERMAL_CENTRIFUGE_SSP[2] = GregTechAPI.registerMetaTileEntity(4324, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.uiv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 11));
        THERMAL_CENTRIFUGE_SSP[3] = GregTechAPI.registerMetaTileEntity(4325, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.umv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 12));
        THERMAL_CENTRIFUGE_SSP[4] = GregTechAPI.registerMetaTileEntity(4326, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.uxv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 13));
        THERMAL_CENTRIFUGE_SSP[5] = GregTechAPI.registerMetaTileEntity(4327, new SimpleMachineMetaTileEntity(gregtechId("thermal_centrifuge.opv"), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, 14));

        WIREMILL_SSP[0] = GregTechAPI.registerMetaTileEntity(4328, new SimpleMachineMetaTileEntity(gregtechId("wiremill.uhv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 9));
        WIREMILL_SSP[1] = GregTechAPI.registerMetaTileEntity(4329, new SimpleMachineMetaTileEntity(gregtechId("wiremill.uev"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 10));
        WIREMILL_SSP[2] = GregTechAPI.registerMetaTileEntity(4330, new SimpleMachineMetaTileEntity(gregtechId("wiremill.uiv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 11));
        WIREMILL_SSP[3] = GregTechAPI.registerMetaTileEntity(4331, new SimpleMachineMetaTileEntity(gregtechId("wiremill.umv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 12));
        WIREMILL_SSP[4] = GregTechAPI.registerMetaTileEntity(4332, new SimpleMachineMetaTileEntity(gregtechId("wiremill.uxv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 13));
        WIREMILL_SSP[5] = GregTechAPI.registerMetaTileEntity(4333, new SimpleMachineMetaTileEntity(gregtechId("wiremill.opv"), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, 14));

        BIO_LAB[0] = GregTechAPI.registerMetaTileEntity(4334, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.lv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,1));
        BIO_LAB[1] = GregTechAPI.registerMetaTileEntity(4335, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.mv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,2));
        BIO_LAB[2] = GregTechAPI.registerMetaTileEntity(4336, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.hv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,3));
        BIO_LAB[3] = GregTechAPI.registerMetaTileEntity(4337, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.ev"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,4));
        BIO_LAB[4] = GregTechAPI.registerMetaTileEntity(4338, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.iv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,5));
        BIO_LAB[5] = GregTechAPI.registerMetaTileEntity(4339, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.luv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,6));
        BIO_LAB[6] = GregTechAPI.registerMetaTileEntity(4340, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.zpm"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,7));
        BIO_LAB[7] = GregTechAPI.registerMetaTileEntity(4341, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.uv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,8));
        BIO_LAB[8] = GregTechAPI.registerMetaTileEntity(4342, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.uhv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,9));
        BIO_LAB[9] = GregTechAPI.registerMetaTileEntity(4343, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.uev"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,10));
        BIO_LAB[10] = GregTechAPI.registerMetaTileEntity(4344, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.uiv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,11));
        BIO_LAB[11] = GregTechAPI.registerMetaTileEntity(4345, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.umv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,12));
        BIO_LAB[12] = GregTechAPI.registerMetaTileEntity(4346, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.uxv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,13));
        BIO_LAB[13] = GregTechAPI.registerMetaTileEntity(4347, new SimpleMachineMetaTileEntity(gregtechId("bio_lab.opv"),RecipeMaps.BIO_LAB,Textures.BIO_LAB_OVERLAY,14));

        GEM_CUTTER[0] = GregTechAPI.registerMetaTileEntity(4348, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.hv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,3));
        GEM_CUTTER[1] = GregTechAPI.registerMetaTileEntity(4349, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.ev"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,4));
        GEM_CUTTER[2] = GregTechAPI.registerMetaTileEntity(4350, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.iv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,5));
        GEM_CUTTER[3] = GregTechAPI.registerMetaTileEntity(4351, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.luv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,6));
        GEM_CUTTER[4] = GregTechAPI.registerMetaTileEntity(4352, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.zpm"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,7));
        GEM_CUTTER[5] = GregTechAPI.registerMetaTileEntity(4353, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.uv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,8));
        GEM_CUTTER[6] = GregTechAPI.registerMetaTileEntity(4354, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.uhv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,9));
        GEM_CUTTER[7] = GregTechAPI.registerMetaTileEntity(4355, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.uev"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,10));
        GEM_CUTTER[8] = GregTechAPI.registerMetaTileEntity(4356, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.uiv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,11));
        GEM_CUTTER[9] = GregTechAPI.registerMetaTileEntity(4357, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.umv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,12));
        GEM_CUTTER[10] = GregTechAPI.registerMetaTileEntity(4358, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.uxv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,13));
        GEM_CUTTER[11] = GregTechAPI.registerMetaTileEntity(4359, new SimpleMachineMetaTileEntity(gregtechId("gem_cutter.opv"),RecipeMaps.GEM_CUTTER,Textures.GEM_CUTTER_OVERLAY,14));
    }

    private static ResourceLocation gregtechId(String name) {
        return new ResourceLocation(GTValues.MODID, name);
    }

}
