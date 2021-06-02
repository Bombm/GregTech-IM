package gregtech.api.render;

import codechicken.lib.render.BlockRenderer.BlockFace;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.texture.TextureUtils.IIconRegister;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import codechicken.lib.vec.TransformationList;
import codechicken.lib.vec.uv.IconTransformation;
import codechicken.lib.vec.uv.UVTransformationList;
import gregtech.api.GTValues;
import gregtech.api.util.GTLog;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.render.OrientedOverlayRenderer.OverlayFace.*;

public class Textures {

    private static final ThreadLocal<BlockFace> blockFaces = ThreadLocal.withInitial(BlockFace::new);
    public static List<IIconRegister> iconRegisters = new ArrayList<>();

    public static ChestRenderer WOODEN_CHEST = new ChestRenderer("storage/wooden_chest");
    public static ChestRenderer METAL_CHEST = new ChestRenderer("storage/metal_chest");
    public static SafeRenderer SAFE = new SafeRenderer("storage/safe");

    public static TankRenderer WOODEN_TANK = new TankRenderer("storage/tank/wooden");
    public static TankRenderer METAL_TANK = new TankRenderer("storage/tank/metal");

    public static SimpleSidedCubeRenderer STEAM_CASING_BRONZE = new SimpleSidedCubeRenderer("casings/steam/bronze");
    public static SimpleSidedCubeRenderer STEAM_CASING_STEEL = new SimpleSidedCubeRenderer("casings/steam/steel");
    public static SimpleSidedCubeRenderer STEAM_BRICKED_CASING_BRONZE = new SimpleSidedCubeRenderer("casings/steam/bricked_bronze");
    public static SimpleSidedCubeRenderer STEAM_BRICKED_CASING_STEEL = new SimpleSidedCubeRenderer("casings/steam/bricked_steel");
    public static SimpleSidedCubeRenderer[] VOLTAGE_CASINGS = new SimpleSidedCubeRenderer[GTValues.V.length];

    public static SimpleSidedCubeRenderer MAGIC_ENERGY_ABSORBER = new SimpleSidedCubeRenderer("casings/magic/absorber/normal");
    public static SimpleSidedCubeRenderer MAGIC_ENERGY_ABSORBER_ACTIVE = new SimpleSidedCubeRenderer("casings/magic/absorber/active");

    public static SimpleSidedCubeRenderer MAGIC_ENERGY_CONVERTER = new SimpleSidedCubeRenderer("casings/magic/converter/normal");
    public static SimpleSidedCubeRenderer MAGIC_ENERGY_CONVERTER_ACTIVE = new SimpleSidedCubeRenderer("casings/magic/converter/active");

    public static SimpleCubeRenderer BRONZE_PLATED_BRICKS = new SimpleCubeRenderer("casings/solid/machine_bronze_plated_bricks");
    public static SimpleCubeRenderer PRIMITIVE_BRICKS = new SimpleCubeRenderer("casings/solid/machine_primitive_bricks");
    public static SimpleCubeRenderer PRIMITIVE_HEATER = new SimpleCubeRenderer("casings/solid/machine_casing_heater_block");
    public static SimpleCubeRenderer COKE_BRICKS = new SimpleCubeRenderer("casings/solid/machine_coke_bricks");
    public static SimpleCubeRenderer HEAT_PROOF_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_heatproof");
    public static SimpleCubeRenderer FROST_PROOF_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_frost_proof");
    public static SimpleCubeRenderer SOLID_STEEL_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_solid_steel");
    public static SimpleCubeRenderer CLEAN_STAINLESS_STEEL_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_clean_stainless_steel");
    public static SimpleCubeRenderer STABLE_TITANIUM_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_stable_titanium");
    public static SimpleCubeRenderer ROBUST_TUNGSTENSTEEL_CASING = new SimpleCubeRenderer("casings/solid/machine_casing_robust_tungstensteel");

    public static SimpleCubeRenderer BRONZE_FIREBOX = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_bronze");
    public static SimpleCubeRenderer BRONZE_FIREBOX_ACTIVE = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_bronze_active");
    public static SimpleCubeRenderer STEEL_FIREBOX = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_steel");
    public static SimpleCubeRenderer STEEL_FIREBOX_ACTIVE = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_steel_active");
    public static SimpleCubeRenderer TITANIUM_FIREBOX = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_titanium");
    public static SimpleCubeRenderer TITANIUM_FIREBOX_ACTIVE = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_titanium_active");
    public static SimpleCubeRenderer TUNGSTENSTEEL_FIREBOX = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_tungstensteel");
    public static SimpleCubeRenderer TUNGSTENSTEEL_FIREBOX_ACTIVE = new SimpleCubeRenderer("casings/firebox/machine_casing_firebox_tungstensteel_active");

    public static SimpleSidedCubeRenderer TESLA_COIL = new SimpleSidedCubeRenderer("casings/tesla_coil");
    public static SimpleOrientedCubeRenderer CRAFTING_TABLE = new SimpleOrientedCubeRenderer("casings/crafting_table");

    public static OrientedOverlayRenderer COAL_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/coal", FRONT);
    public static OrientedOverlayRenderer LAVA_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/lava", FRONT);
    public static OrientedOverlayRenderer SOLAR_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/solar", TOP);

    public static OrientedOverlayRenderer PRIMITIVE_BLAST_FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/primitive_blast_furnace", FRONT);
    public static OrientedOverlayRenderer COKE_OVEN_OVERLAY = new OrientedOverlayRenderer("machines/coke_oven", FRONT);
    public static OrientedOverlayRenderer PRIMITIVE_SMELTER_OVERLAY = new OrientedOverlayRenderer("machines/primitive_smelter", FRONT);
    public static OrientedOverlayRenderer MULTIBLOCK_WORKABLE_OVERLAY = new OrientedOverlayRenderer("machines/multiblock_workable", FRONT);
    public static LargeTurbineRenderer LARGE_TURBINE_ROTOR_RENDERER = new LargeTurbineRenderer();

    public static OrientedOverlayRenderer ALLOY_SMELTER_OVERLAY = new OrientedOverlayRenderer("machines/alloy_smelter", FRONT);
    public static OrientedOverlayRenderer FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/furnace", FRONT);
    public static OrientedOverlayRenderer ELECTRIC_FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/electric_furnace", FRONT);
    public static OrientedOverlayRenderer EXTRACTOR_OVERLAY = new OrientedOverlayRenderer("machines/extractor", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("machines/compressor", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer HAMMER_OVERLAY = new OrientedOverlayRenderer("machines/forge_hammer", FRONT);
    public static OrientedOverlayRenderer MACERATOR_OVERLAY = new OrientedOverlayRenderer("machines/macerator", FRONT, TOP);
    public static OrientedOverlayRenderer AMPLIFAB_OVERLAY = new OrientedOverlayRenderer("machines/amplifab", FRONT);
    public static OrientedOverlayRenderer ARC_FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/arc_furnace", FRONT, BOTTOM, SIDE);
    public static OrientedOverlayRenderer ASSEMBLER_OVERLAY = new OrientedOverlayRenderer("machines/assembler", FRONT, TOP);
    public static OrientedOverlayRenderer AUTOCLAVE_OVERLAY = new OrientedOverlayRenderer("machines/autoclave", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer BENDER_OVERLAY = new OrientedOverlayRenderer("machines/bender", FRONT);
    public static OrientedOverlayRenderer BREWERY_OVERLAY = new OrientedOverlayRenderer("machines/brewery", FRONT, SIDE);
    public static OrientedOverlayRenderer CANNER_OVERLAY = new OrientedOverlayRenderer("machines/canner", FRONT);
    public static OrientedOverlayRenderer CENTRIFUGE_OVERLAY = new OrientedOverlayRenderer("machines/centrifuge", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer CHEMICAL_BATH_OVERLAY = new OrientedOverlayRenderer("machines/chemical_bath", FRONT, SIDE);
    public static OrientedOverlayRenderer CHEMICAL_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/chemical_reactor", FRONT);
    public static OrientedOverlayRenderer CUTTER_OVERLAY = new OrientedOverlayRenderer("machines/cutter", FRONT);
    public static OrientedOverlayRenderer DISTILLERY_OVERLAY = new OrientedOverlayRenderer("machines/distillery", FRONT, SIDE);
    public static OrientedOverlayRenderer ELECTROLYZER_OVERLAY = new OrientedOverlayRenderer("machines/electrolyzer", FRONT, SIDE);
    public static OrientedOverlayRenderer ELECTROMAGNETIC_SEPARATOR_OVERLAY = new OrientedOverlayRenderer("machines/electromagnetic_separator", FRONT, TOP);
    public static OrientedOverlayRenderer EXTRUDER_OVERLAY = new OrientedOverlayRenderer("machines/extruder", FRONT, TOP);
    public static OrientedOverlayRenderer FERMENTER_OVERLAY = new OrientedOverlayRenderer("machines/fermenter", FRONT, SIDE);
    public static OrientedOverlayRenderer FLUID_CANNER_OVERLAY = new OrientedOverlayRenderer("machines/fluid_canner", FRONT, SIDE);
    public static OrientedOverlayRenderer FLUID_EXTRACTOR_OVERLAY = new OrientedOverlayRenderer("machines/fluid_extractor", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer FLUID_HEATER_OVERLAY = new OrientedOverlayRenderer("machines/fluid_heater", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer FLUID_SOLIDIFIER_OVERLAY = new OrientedOverlayRenderer("machines/fluid_solidifier", FRONT);
    public static OrientedOverlayRenderer FORGE_HAMMER_OVERLAY = new OrientedOverlayRenderer("machines/forge_hammer", FRONT);
    public static OrientedOverlayRenderer FORMING_PRESS_OVERLAY = new OrientedOverlayRenderer("machines/press", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer LATHE_OVERLAY = new OrientedOverlayRenderer("machines/lathe", FRONT);
    public static OrientedOverlayRenderer MICROWAVE_OVERLAY = new OrientedOverlayRenderer("machines/microwave", FRONT);
    public static OrientedOverlayRenderer MIXER_OVERLAY = new OrientedOverlayRenderer("machines/mixer", FRONT, SIDE, TOP);
    public static OrientedOverlayRenderer ORE_WASHER_OVERLAY = new OrientedOverlayRenderer("machines/ore_washer", FRONT, SIDE);
    public static OrientedOverlayRenderer PACKER_OVERLAY = new OrientedOverlayRenderer("machines/packer", FRONT);
    public static OrientedOverlayRenderer UNPACKER_OVERLAY = new OrientedOverlayRenderer("machines/unpacker", FRONT);
    public static OrientedOverlayRenderer PLASMA_ARC_FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/plasma_arc_furnace", BOTTOM, FRONT, SIDE);
    public static OrientedOverlayRenderer POLARIZER_OVERLAY = new OrientedOverlayRenderer("machines/polarizer", FRONT, TOP);
    public static OrientedOverlayRenderer LASER_ENGRAVER_OVERLAY = new OrientedOverlayRenderer("machines/laser_engraver", FRONT);
    public static OrientedOverlayRenderer SIFTER_OVERLAY = new OrientedOverlayRenderer("machines/sifter", FRONT, TOP);
    public static OrientedOverlayRenderer THERMAL_CENTRIFUGE_OVERLAY = new OrientedOverlayRenderer("machines/thermal_centrifuge", FRONT);
    public static OrientedOverlayRenderer WIREMILL_OVERLAY = new OrientedOverlayRenderer("machines/wiremill", FRONT, TOP);
    public static OrientedOverlayRenderer BIO_LAB_OVERLAY = new OrientedOverlayRenderer("machines/bio_lab", FRONT, TOP, BACK, SIDE);
    public static OrientedOverlayRenderer GEM_CUTTER_OVERLAY = new OrientedOverlayRenderer("machines/gem_cutter",FRONT,TOP);

    public static OrientedOverlayRenderer DIESEL_GENERATOR_OVERLAY = new OrientedOverlayRenderer("generators/diesel", TOP);
    public static OrientedOverlayRenderer GAS_TURBINE_OVERLAY = new OrientedOverlayRenderer("generators/gas_turbine", SIDE);
    public static OrientedOverlayRenderer STEAM_TURBINE_OVERLAY = new OrientedOverlayRenderer("generators/steam_turbine", SIDE);

    public static SimpleOverlayRenderer SCREEN = new SimpleOverlayRenderer("overlay/machine/overlay_screen");
    public static SimpleOverlayRenderer SHUTTER = new SimpleOverlayRenderer("overlay/machine/overlay_shutter");
    public static SimpleOverlayRenderer SOLAR_PANEL = new SimpleOverlayRenderer("cover/overlay_solar_panel");

    public static SimpleOverlayRenderer ROCK_CRUSHER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_rock_crusher");
    public static SimpleOverlayRenderer ROCK_CRUSHER_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_rock_crusher_active");

    public static SimpleOverlayRenderer PIPE_OUT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_pipe_out");
    public static SimpleOverlayRenderer PIPE_IN_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_pipe_in");
    public static SimpleOverlayRenderer FLUID_OUTPUT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_fluid_output");
    public static SimpleOverlayRenderer ITEM_OUTPUT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_item_output");
    public static SimpleOverlayRenderer ROTOR_HOLDER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_rotor_holder");
    public static SimpleOverlayRenderer ADV_PUMP_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_adv_pump");
    public static SimpleOverlayRenderer FILTER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_filter");
    public static SimpleOverlayRenderer HATCH_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_hatch");

    public static SimpleOverlayRenderer FLUID_FILTER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_fluid_filter");
    public static SimpleOverlayRenderer ITEM_FILTER_FILTER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_item_filter");
    public static SimpleOverlayRenderer ORE_DICTIONARY_FILTER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_ore_dictionary_filter");
    public static SimpleOverlayRenderer SMART_FILTER_FILTER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_smart_item_filter");
    public static SimpleOverlayRenderer MACHINE_CONTROLLER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_controller");

    public static SimpleOverlayRenderer ENERGY_OUT = new SimpleOverlayRenderer("overlay/machine/overlay_energy_out");
    public static SimpleOverlayRenderer ENERGY_IN = new SimpleOverlayRenderer("overlay/machine/overlay_energy_in");
    public static SimpleOverlayRenderer ENERGY_OUT_MULTI = new SimpleOverlayRenderer("overlay/machine/overlay_energy_out_multi");
    public static SimpleOverlayRenderer ENERGY_IN_MULTI = new SimpleOverlayRenderer("overlay/machine/overlay_energy_in_multi");

    public static SimpleOverlayRenderer CONVEYOR_OVERLAY = new SimpleOverlayRenderer("cover/overlay_conveyor");
    public static SimpleOverlayRenderer ARM_OVERLAY = new SimpleOverlayRenderer("cover/overlay_arm");
    public static SimpleOverlayRenderer PUMP_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_pump");

    public static SimpleOverlayRenderer AIR_VENT_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_air_vent");
    public static SimpleOverlayRenderer BLOWER_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_blower");
    public static SimpleOverlayRenderer BLOWER_ACTIVE_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_blower_active");

    public static SimpleOverlayRenderer AUTOMAINTENANCE = new SimpleOverlayRenderer("overlay/machine/overlay_automaintenance_idle");
    public static SimpleOverlayRenderer AUTOMAINTENANCE_ACTIVE = new SimpleOverlayRenderer("overlay/machine/overlay_automaintenance_active");
    public static SimpleOverlayRenderer MAINTENANCE = new SimpleOverlayRenderer("overlay/machine/overlay_maintenance");
    public static SimpleOverlayRenderer MINER_ACTIVE = new SimpleOverlayRenderer("overlay/machine/overlay_miner_active");

    public static SimpleOverlayRenderer ALLOY_SMELTER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/alloy_smelter/front");
    public static SimpleOverlayRenderer FURNACE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/furnace");
    public static SimpleOverlayRenderer ELECTRIC_FURNACE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/electric_furnace/front");
    public static SimpleOverlayRenderer EXTRACTOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/extractor/front");
    public static SimpleOverlayRenderer COMPRESSOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/compressor/front");
    public static SimpleOverlayRenderer HAMMER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/forge_hammer/front");
    public static SimpleOverlayRenderer MACERATOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/macerator/front");
    public static SimpleOverlayRenderer AMPLIFAB_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/amplifab/front");
    public static SimpleOverlayRenderer ARC_FURNACE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/arc_furnace/front");
    public static SimpleOverlayRenderer ASSEMBLER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/assembler/front");
    public static SimpleOverlayRenderer AUTOCLAVE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/autoclave/front");
    public static SimpleOverlayRenderer BENDER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/bender/front");
    public static SimpleOverlayRenderer BREWERY_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/brewery/front");
    public static SimpleOverlayRenderer CANNER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/canner/front");
    public static SimpleOverlayRenderer CENTRIFUGE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/centrifuge/front");
    public static SimpleOverlayRenderer CHEMICAL_BATH_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/chemical_bath/front");
    public static SimpleOverlayRenderer CHEMICAL_REACTOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/chemical_reactor/front");
    public static SimpleOverlayRenderer CUTTER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/cutter/front");
    public static SimpleOverlayRenderer DISTILLERY_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/distillery/front");
    public static SimpleOverlayRenderer ELECTROLYZER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/electrolyzer/front");
    public static SimpleOverlayRenderer ELECTROMAGNETIC_SEPARATOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/electromagnetic_separator/front");
    public static SimpleOverlayRenderer EXTRUDER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/extruder/front");
    public static SimpleOverlayRenderer FERMENTER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/fermenter/front");
    public static SimpleOverlayRenderer FLUID_CANNER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/fluid_canner/front");
    public static SimpleOverlayRenderer FLUID_EXTRACTOR_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/fluid_extractor/front");
    public static SimpleOverlayRenderer FLUID_HEATER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/fluid_heater/front");
    public static SimpleOverlayRenderer FLUID_SOLIDIFIER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/fluid_solidifier/front");
    public static SimpleOverlayRenderer FORGE_HAMMER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/forge_hammer/front");
    public static SimpleOverlayRenderer FORMING_PRESS_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/press/front");
    public static SimpleOverlayRenderer LATHE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/lathe/front");
    public static SimpleOverlayRenderer MICROWAVE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/microwave/front");
    public static SimpleOverlayRenderer MIXER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/mixer/front");
    public static SimpleOverlayRenderer ORE_WASHER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/ore_washer/front");
    public static SimpleOverlayRenderer PACKER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/packer/front");
    public static SimpleOverlayRenderer UNPACKER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/unpacker");
    public static SimpleOverlayRenderer PLASMA_ARC_FURNACE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/plasma_arc_furnace/front");
    public static SimpleOverlayRenderer POLARIZER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/polarizer/front");
    public static SimpleOverlayRenderer LASER_ENGRAVER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/laser_engraver/front");
    public static SimpleOverlayRenderer SIFTER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/sifter/front");
    public static SimpleOverlayRenderer THERMAL_CENTRIFUGE_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/thermal_centrifuge/front");
    public static SimpleOverlayRenderer WIREMILL_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/wiremill/front");
    public static SimpleOverlayRenderer BIO_LAB_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/bio_lab/front");
    public static SimpleOverlayRenderer GEM_CUTTER_OVERLAY_SIMPLE = new SimpleOverlayRenderer("machines/gem_cutter/front");

    static {
        for (int i = 0; i < VOLTAGE_CASINGS.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            VOLTAGE_CASINGS[i] = new SimpleSidedCubeRenderer("casings/voltage/" + voltageName);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void register(TextureMap textureMap) {
        GTLog.logger.info("Loading meta tile entity texture sprites...");
        for (IIconRegister iconRegister : iconRegisters) {
            iconRegister.registerIcons(textureMap);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void renderFace(CCRenderState renderState, Matrix4 translation, IVertexOperation[] ops, EnumFacing face, Cuboid6 bounds, TextureAtlasSprite sprite) {
        BlockFace blockFace = blockFaces.get();
        blockFace.loadCuboidFace(bounds, face.getIndex());
        UVTransformationList uvList = new UVTransformationList(new IconTransformation(sprite));
        if (face.getIndex() == 0) {
            uvList.prepend(new UVMirror(0, 0, bounds.min.z, bounds.max.z));
        }
        renderState.setPipeline(blockFace, 0, blockFace.verts.length,
                ArrayUtils.addAll(ops, new TransformationList(translation), uvList));
        renderState.render();
    }
}
