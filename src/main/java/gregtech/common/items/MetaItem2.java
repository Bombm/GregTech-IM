package gregtech.common.items;

import gregtech.api.GTValues;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.FoodStats;
import gregtech.api.items.metaitem.stats.IItemContainerItemProvider;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.RandomPotionEffect;
import gregtech.common.ConfigHolder;
import gregtech.common.items.behaviors.FacadeItem;
import gregtech.common.items.behaviors.ScannerBehavior;
import gregtech.common.items.behaviors.NanoSaberBehavior;
import gregtech.common.items.behaviors.TurbineRotorBehavior;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.DyeUtil.getOrdictColorName;
import static gregtech.common.items.MetaItems.*;

public class MetaItem2 extends MaterialMetaItem {

    public MetaItem2() {
        super(OrePrefix.toolHeadSword, OrePrefix.toolHeadPickaxe, OrePrefix.toolHeadShovel, OrePrefix.toolHeadAxe,
            OrePrefix.toolHeadHoe, OrePrefix.toolHeadHammer, OrePrefix.toolHeadFile, OrePrefix.toolHeadSaw,
            OrePrefix.toolHeadDrill, OrePrefix.toolHeadChainsaw, OrePrefix.toolHeadWrench, OrePrefix.toolHeadUniversalSpade,
            OrePrefix.toolHeadSense, null, OrePrefix.toolHeadBuzzSaw, OrePrefix.turbineBlade,
            OrePrefix.wireFine, OrePrefix.gearSmall, OrePrefix.rotor, OrePrefix.stickLong, OrePrefix.springSmall, OrePrefix.spring,
            OrePrefix.gemChipped, OrePrefix.gemFlawed, OrePrefix.gemFlawless, OrePrefix.gemExquisite, OrePrefix.gear,
            null, null, null, null, null);
    }

    @Override
    public void registerSubItems() {
        GELLED_TOLUENE = addItem(10, "gelled_toluene");

        IItemContainerItemProvider selfContainerItemProvider = itemStack -> itemStack;
        WOODEN_FORM_EMPTY = addItem(11, "wooden_form.empty");
        WOODEN_FORM_BRICK = addItem(12, "wooden_form.brick").addComponents(selfContainerItemProvider);

        COMPRESSED_CLAY = addItem(13, "compressed.clay");
        COMPRESSED_FIRECLAY = addItem(14, "compressed.fireclay");
        FIRECLAY_BRICK = addItem(15, "brick.fireclay");
        COKE_OVEN_BRICK = addItem(16, "brick.coke");

        BOTTLE_PURPLE_DRINK = addItem(100, "bottle.purple.drink").addComponents(new FoodStats(8, 0.2F, true, true, new ItemStack(Items.GLASS_BOTTLE), new RandomPotionEffect(MobEffects.HASTE, 800, 1, 90)));

        ENERGY_CRYSTAL = addItem(212, "energy_crystal").addComponents(ElectricStats.createRechargeableBattery(4000000L, GTValues.HV)).setModelAmount(8).setMaxStackSize(1);
        LAPOTRON_CRYSTAL = addItem(213, "lapotron_crystal").addComponents(ElectricStats.createRechargeableBattery(10000000L, GTValues.EV)).setModelAmount(8).setMaxStackSize(1);

        DYE_INDIGO = addItem(410, "dye.indigo").addOreDict("dyeBlue").setInvisible();
        for (int i = 0; i < EnumDyeColor.values().length; i++) {
            EnumDyeColor dyeColor = EnumDyeColor.values()[i];
            DYE_ONLY_ITEMS[i] = addItem(414 + i, "dye." + dyeColor.getName()).addOreDict(getOrdictColorName(dyeColor));
        }

        PLANT_BALL = addItem(570, "plant_ball").setBurnValue(75);
        ENERGIUM_DUST = addItem(572, "energium_dust");

        POWER_UNIT_LV = addItem(573, "power_unit.lv").addComponents(ElectricStats.createElectricItem(100000L, GTValues.LV)).setMaxStackSize(8);
        POWER_UNIT_MV = addItem(574, "power_unit.mv").addComponents(ElectricStats.createElectricItem(400000L, GTValues.MV)).setMaxStackSize(8);
        POWER_UNIT_HV = addItem(575, "power_unit.hv") .addComponents(ElectricStats.createElectricItem(1600000L, GTValues.HV)).setMaxStackSize(8);
        JACKHAMMER_BASE = addItem(576, "jackhammer_base").addComponents(ElectricStats.createElectricItem(1600000L, GTValues.HV)).setMaxStackSize(4);

        NANO_SABER = addItem(577, "nano_saber").addComponents(ElectricStats.createElectricItem(4000000L, GTValues.HV)).addComponents(new NanoSaberBehavior()).setMaxStackSize(1);
        ENERGY_FIELD_PROJECTOR = addItem(578, "energy_field_projector").addComponents(ElectricStats.createElectricItem(16000000L, GTValues.EV)).setMaxStackSize(1);
        SCANNER = addItem(579, "scanner").addComponents(ElectricStats.createElectricItem(200_000L, GTValues.LV), new ScannerBehavior(50));

        CARBON_FIBERS = addItem(504, "carbon.fibers");
        CARBON_MESH = addItem(505, "carbon.mesh");
        CARBON_PLATE = addItem(506, "carbon.plate");
        INGOT_MIXED_METAL = addItem(432, "ingot.mixed_metal");
        ADVANCED_ALLOY_PLATE = addItem(433, "plate.advanced_alloy");
        INGOT_IRIDIUM_ALLOY = addItem(434, "ingot.iridium_alloy");
        PLATE_IRIDIUM_ALLOY = addItem(435, "plate.iridium_alloy");
        NEUTRON_REFLECTOR = addItem(436, "neutron_reflector");

        SILICON_BOULE = addItem(439, "boule.silicon");
        GLOWSTONE_BOULE = addItem(437, "boule.glowstone");
        NAQUADAH_BOULE = addItem(438, "boule.naquadah");
        SILICON_WAFER = addItem(440, "wafer.silicon");
        GLOWSTONE_WAFER = addItem(441, "wafer.glowstone");
        NAQUADAH_WAFER = addItem(442, "wafer.naquadah");

        COATED_BOARD = addItem(443, "board.coated");
        EPOXY_BOARD = addItem(444, "board.epoxy");
        FIBER_BOARD = addItem(445, "board.fiber_reinforced");
        MULTILAYER_FIBER_BOARD = addItem(446, "board.multilayer.fiber_reinforced");
        PHENOLIC_BOARD = addItem(447, "board.phenolic");
        PLASTIC_BOARD = addItem(448, "board.plastic");
        WETWARE_BOARD = addItem(449, "board.wetware");

        VACUUM_TUBE = addItem(450, "circuit.vacuum_tube").setUnificationData(OrePrefix.circuit, Tier.Primitive);
        DIODE = addItem(451, "component.diode");
        CAPACITOR = addItem(452, "component.capacitor");
        GLASS_FIBER = addItem(453, "component.glass.fiber");
        GLASS_TUBE = addItem(454, "component.glass.tube");
        RESISTOR = addItem(455, "component.resistor");
        SMALL_COIL = addItem(456, "component.small_coil");
        SMD_DIODE = addItem(457, "component.smd.diode");
        SMD_CAPACITOR = addItem(458, "component.smd.capacitor");
        SMD_RESISTOR = addItem(459, "component.smd.resistor");
        SMD_TRANSISTOR = addItem(460, "component.smd.transistor");
        TRANSISTOR = addItem(461, "component.transistor");

        ADVANCED_SYSTEM_ON_CHIP_WAFER = addItem(462, "wafer.advanced_system_on_chip");
        INTEGRATED_LOGIC_CIRCUIT_WAFER = addItem(463, "wafer.integrated_logic_circuit");
        CENTRAL_PROCESSING_UNIT_WAFER = addItem(464, "wafer.central_processing_unit");
        HIGH_POWER_INTEGRATED_CIRCUIT_WAFER = addItem(465, "wafer.high_power_integrated_circuit");
        NAND_MEMORY_CHIP_WAFER = addItem(466, "wafer.nand_memory_chip");
        NANO_CENTRAL_PROCESSING_UNIT_WAFER = addItem(467, "wafer.nano_central_processing_unit");
        NOR_MEMORY_CHIP_WAFER = addItem(468, "wafer.nor_memory_chip");
        POWER_INTEGRATED_CIRCUIT_WAFER = addItem(469, "wafer.power_integrated_circuit");
        QBIT_CENTRAL_PROCESSING_UNIT_WAFER = addItem(470, "wafer.qbit_central_processing_unit");
        RANDOM_ACCESS_MEMORY_WAFER = addItem(471, "wafer.random_access_memory");
        SYSTEM_ON_CHIP_WAFER = addItem(472, "wafer.system_on_chip");

        CRYSTAL_CENTRAL_PROCESSING_UNIT = addItem(474, "crystal.central_processing_unit");
        CRYSTAL_SYSTEM_ON_CHIP = addItem(475, "crystal.system_on_chip");
        ADVANCED_SYSTEM_ON_CHIP = addItem(476, "plate.advanced_system_on_chip");
        INTEGRATED_LOGIC_CIRCUIT = addItem(477, "plate.integrated_logic_circuit");
        CENTRAL_PROCESSING_UNIT = addItem(478, "plate.central_processing_unit");
        HIGH_POWER_INTEGRATED_CIRCUIT = addItem(479, "plate.high_power_integrated_circuit");
        NAND_MEMORY_CHIP = addItem(480, "plate.nand_memory_chip");
        NANO_CENTRAL_PROCESSING_UNIT = addItem(481, "plate.nano_central_processing_unit");
        NOR_MEMORY_CHIP = addItem(482, "plate.nor_memory_chip");
        POWER_INTEGRATED_CIRCUIT = addItem(483, "plate.power_integrated_circuit");
        QBIT_CENTRAL_PROCESSING_UNIT = addItem(484, "plate.qbit_central_processing_unit");
        RANDOM_ACCESS_MEMORY = addItem(485, "plate.random_access_memory");
        SYSTEM_ON_CHIP = addItem(486, "plate.system_on_chip");

        BASIC_CIRCUIT_LV = addItem(487, "circuit.basic").setUnificationData(OrePrefix.circuit, Tier.Basic);
        BASIC_ELECTRONIC_CIRCUIT_LV = addItem(488, "circuit.basic_electronic").setUnificationData(OrePrefix.circuit, Tier.Basic);
        ADVANCED_CIRCUIT_PARTS_LV = addItem(507, "circuit.advanced_parts").setUnificationData(OrePrefix.circuit, Tier.Basic);

        GOOD_INTEGRATED_CIRCUIT_MV = addItem(489, "circuit.good").setUnificationData(OrePrefix.circuit, Tier.Good);
        ADVANCED_CIRCUIT_MV = addItem(490, "circuit.advanced").setUnificationData(OrePrefix.circuit, Tier.Good);

        PROCESSOR_ASSEMBLY_HV = addItem(491, "circuit.processor_assembly").setUnificationData(OrePrefix.circuit, Tier.Advanced);
        NANO_PROCESSOR_HV = addItem(492, "circuit.nano_processor").setUnificationData(OrePrefix.circuit, Tier.Advanced);

        NANO_PROCESSOR_ASSEMBLY_EV = addItem(493, "circuit.nano_processor_assembly").setUnificationData(OrePrefix.circuit, Tier.Extreme);
        QUANTUM_PROCESSOR_EV = addItem(494, "circuit.quantum_processor").setUnificationData(OrePrefix.circuit, Tier.Extreme);

        DATA_CONTROL_CIRCUIT_IV = addItem(495, "circuit.data_control").setUnificationData(OrePrefix.circuit, Tier.Elite);
        CRYSTAL_PROCESSOR_IV = addItem(496, "circuit.crystal_processor").setUnificationData(OrePrefix.circuit, Tier.Elite);

        ENERGY_FLOW_CIRCUIT_LUV = addItem(497, "circuit.energy_flow").setUnificationData(OrePrefix.circuit, Tier.Master);
        WETWARE_PROCESSOR_LUV = addItem(498, "circuit.wetware_processor").setUnificationData(OrePrefix.circuit, Tier.Master);

        WETWARE_PROCESSOR_ASSEMBLY_ZPM = addItem(499, "circuit.wetware_assembly").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        WETWARE_SUPER_COMPUTER_UV = addItem(500, "circuit.wetware_super_computer").setUnificationData(OrePrefix.circuit, Tier.Superconductor);
        WETWARE_MAINFRAME_MAX = addItem(501, "circuit.wetware_mainframe").setUnificationData(OrePrefix.circuit, Tier.Infinite);

        ENGRAVED_CRYSTAL_CHIP = addItem(502, "engraved.crystal_chip");
        ENGRAVED_LAPOTRON_CHIP = addItem(503, "engraved.lapotron_chip");

        TURBINE_ROTOR = addItem(508, "turbine_rotor").addComponents(new TurbineRotorBehavior());
        COVER_FACADE = addItem(509, "cover.facade").addComponents(new FacadeItem()).disableModelLoading();

        //ssp
        ENERGY_FLOW_MAINFRAME = addItem(610, "circuit.energy_flow_mainframe");
        ENERGY_FLOW_SUPERCOMPUTER = addItem(611, "circuit.energy_flow_supercomputer");

        NANO_MAINFRAME = addItem(612, "circuit.nano_mainframe");
        NANO_SUPERCOMPUTER = addItem(613, "circuit.nano_supercomputer");

        QUANTUM_MAINFRAME = addItem(614, "circuit.quantum_mainframe");
        QUANTUM_SUPERCOMPUTER = addItem(615, "circuit.quantum_supercomputer");

        BIOWARE = addItem(616, "circuit.bioware");
        BIOWARE_ASSEMBLY = addItem(617, "circuit.bioware_assembly");
        BIOWARE_MAINFRAME = addItem(618, "circuit.bioware_mainframe");
        BIOWARE_SUPERCOMPUTER = addItem(619, "circuit.bioware_supercomputer");

        HIGH_ENERGY = addItem(620, "circuit.high_energy");
        HIGH_ENERGY_FLOW = addItem(621, "circuit.high_energy_flow");
        HIGH_ENERGY_MAINFRAME = addItem(622, "circuit.high_energy_mainframe");
        HIGH_ENERGY_SUPERCOMPUTER = addItem(623, "circuit.high_energy_supercomputer");

        MICRO = addItem(624, "circuit.micro");
        MICRO_ASSEMBLY = addItem(625, "circuit.micro_assembly");
        MICRO_MAINFRAME = addItem(626, "circuit.micro_mainframe");
        MICRO_SUPERCOMPUTER = addItem(627, "circuit.micro_supercomputer");

        QUANTUM_MK2 = addItem(628, "circuit.quantum_mk2");
        QUANTUM_MK2_ASSEMBLY = addItem(629, "circuit.quantum_mk2_assembly");
        QUANTUM_MK2_MAINFRAME = addItem(630, "circuit.quantum_mk2_mainframe");
        QUANTUM_MK2_SUPERCOMPUTER = addItem(631, "circuit.quantum_mk2_supercomputer");

        BIO_BOARD  = addItem(632, "board.bio");
        HIGH_ENERGY_BOARD  = addItem(633, "board.high_energy");
        MICRO_BOARD  = addItem(634, "board.micro");
        QUANTUM_MK2_BOARD  = addItem(635, "board.quantum_mk2");

        BIOCELLS = addItem(636, "biocells");
        PLASMID_CELL = addItem(637, "plasmid_cell");

        AMERICIUM_BOULE = addItem(638, "boule.americium");
        EUROPIUM_BOULE = addItem(639, "boule.europium");
        GERMANIUM_BOULE = addItem(640, "boule.germanium");

        QPIC_WAFER = addItem(641, "wafer.qpic");
        NPIC_WAFER = addItem(642, "wafer.npic");
        UHPIC_WAFER = addItem(643,"wafer.uhpic");
        XORG_WAFER = addItem(644,"wafer.xorg");
        AMERICIUM_WAFER = addItem(645,"wafer.americium");
        EUROPIUM_WAFER = addItem(646,"wafer.europium");
        GERMANIUM_WAFER = addItem(647,"wafer.germanium");
        ASOC_SSP_WAFER = addItem(648,"wafer.asoc_ssp");
        CPU_SSP_WAFER = addItem(649,"wafer.cpu_ssp");
        ILC_SSP_WAFER = addItem(650,"wafer.ilc_ssp");
        QBIT_SSP_WAFER = addItem(651,"wafer.qbit_ssp");
        RAM_SSP_WAFER = addItem(652,"wafer.ram_ssp");
        SOC_SSP_WAFER = addItem(653,"wafer.soc_ssp");

        NANO_POWER_IC = addItem(654, "plate.nano_power_ic");
        QUANTUM_POWER_IC = addItem(655, "plate.quantum_power_ic");
        ASOC_SSP_PLATE = addItem(656,"plate.asoc_ssp");
        CPU_SSP_PLATE = addItem(657,"plate.cpu_ssp");
        ILC_SSP_PLATE = addItem(658,"plate.ilc_ssp");
        QBIT_SSP_PLATE = addItem(659,"plate.qbit_ssp");
        RAM_SSP_PLATE = addItem(660,"plate.ram_ssp");
        SOC_SSP_PLATE = addItem(661,"plate.soc_ssp");
        UHPIC_PLATE = addItem(662,"plate.ultra_high_power_ic");
        XORG_PLATE = addItem(663,"plate.xor_gate");



        FLUID_REGULATORS[0] = FLUID_REGULATOR_LV = addItem(700, "fluid.regulator.lv");
        FLUID_REGULATORS[1] = FLUID_REGULATOR_MV = addItem(701, "fluid.regulator.mv");
        FLUID_REGULATORS[2] = FLUID_REGULATOR_HV = addItem(702, "fluid.regulator.hv");
        FLUID_REGULATORS[3] = FLUID_REGULATOR_EV = addItem(703, "fluid.regulator.ev");
        FLUID_REGULATORS[4] = FLUID_REGULATOR_IV = addItem(704, "fluid.regulator.iv");
        FLUID_REGULATORS[5] = FLUID_REGULATOR_LUV = addItem(705, "fluid.regulator.luv");
        FLUID_REGULATORS[6] = FLUID_REGULATOR_ZPM = addItem(706, "fluid.regulator.zpm");
        FLUID_REGULATORS[7] = FLUID_REGULATOR_UV = addItem(707, "fluid.regulator.uv");
    }

    public void registerRecipes() {
        // Dyes recipes
        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 0))
            .outputs(new ItemStack(Items.DYE, 2, 1))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 1))
            .outputs(new ItemStack(Items.DYE, 2, 12))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 2))
            .outputs(new ItemStack(Items.DYE, 2, 13))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 3))
            .outputs(new ItemStack(Items.DYE, 2, 7))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 4))
            .outputs(new ItemStack(Items.DYE, 2, 1))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 5))
            .outputs(new ItemStack(Items.DYE, 2, 14))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 6))
            .outputs(new ItemStack(Items.DYE, 2, 7))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 7))
            .outputs(new ItemStack(Items.DYE, 2, 9))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.RED_FLOWER, 1, 8))
            .outputs(new ItemStack(Items.DYE, 2, 7))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.YELLOW_FLOWER, 1, 0))
            .outputs(new ItemStack(Items.DYE, 2, 11))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.DOUBLE_PLANT, 1, 0))
            .outputs(new ItemStack(Items.DYE, 3, 11))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.DOUBLE_PLANT, 1, 1))
            .outputs(new ItemStack(Items.DYE, 3, 13))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.DOUBLE_PLANT, 1, 4))
            .outputs(new ItemStack(Items.DYE, 3, 1))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.DOUBLE_PLANT, 1, 5))
            .outputs(new ItemStack(Items.DYE, 3, 9))
            .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Items.BEETROOT, 1))
            .outputs(new ItemStack(Items.DYE, 2, 1))
            .buildAndRegister();

        // Misc
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()))
            .outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Cocoa, 1))
            .duration(400)
            .EUt(2)
            .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Items.REEDS, 1))
            .outputs(new ItemStack(Items.SUGAR, 1))
            .duration(400)
            .EUt(2)
            .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.MELON_BLOCK, 1, 0))
            .outputs(new ItemStack(Items.MELON, 8, 0))
            .chancedOutput(new ItemStack(Items.MELON_SEEDS, 1), 8000, 500)
            .duration(400)
            .EUt(2)
            .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Blocks.PUMPKIN, 1, 0))
            .outputs(new ItemStack(Items.PUMPKIN_SEEDS, 4, 0))
            .duration(400)
            .EUt(2)
            .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(new ItemStack(Items.MELON, 1, 0))
            .outputs(new ItemStack(Items.MELON_SEEDS, 1, 0))
            .duration(400)
            .EUt(2)
            .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(CountableIngredient.from("blockWool", 1))
            .outputs(new ItemStack(Items.STRING, 3))
            .chancedOutput(new ItemStack(Items.STRING, 1), 2000, 800)
            .duration(400)
            .EUt(2)
            .buildAndRegister();
    }
}
