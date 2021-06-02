package gregtech.api.metatileentity;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public interface Miner {

    enum Type {
        LV(4096, 1, 0, "", 1),
        MV(2048, 2, 0, "", 2),
        HV(1024, 3, 0, "", 4),
        EV(512, 4, 0, "", 8),
        IV(256, 5, 1, "", 16),
        LuV(128, 6, 1, "", 32),
        ZPM(64, 7, 1, "", 64),
        UV(32, 8, 2, "", 128),
        UHV(16, 9, 2, "", 256),
        UEV(8, 10, 2, "", 512),
        UIV(4, 12, 3, "", 1024),
        UMV(2, 14, 3, "", 2048),
        UXV(1, 16, 3, "", 4096);

        public final int tick;
        public final int chunk;
        public final int fortune;
        public final int drillingFluidConsumePerTick;
        public final String fortuneString;

        Type(int tick, int chunk, int fortune, String fortuneString, int drillingFluidConsumePerTick) {
            this.tick = tick;
            this.chunk = chunk;
            this.fortune = fortune;
            this.drillingFluidConsumePerTick = drillingFluidConsumePerTick;
            this.fortuneString = fortuneString;
        }

    }

    Type getType();

    World getWorld();

    long getTimer();

    default long getNbBlock() {
        return 1L;
    }

    List orePrefixes = Arrays.asList(OrePrefix.ore);

    static List<BlockPos> getBlockToMinePerChunk(Miner miner, AtomicLong x, AtomicLong y, AtomicLong z, ChunkPos chunkPos) {
        List<BlockPos> blocks = new ArrayList<>();
        for (int i = 0; i < miner.getNbBlock(); i++) {
            if (y.get() >= 0 && miner.getTimer() % miner.getType().tick == 0) {
                if (z.get() <= chunkPos.getZEnd()) {
                    if (x.get() <= chunkPos.getXEnd()) {
                        BlockPos blockPos = new BlockPos(x.get(), y.get(), z.get());
                        Block block = miner.getWorld().getBlockState(blockPos).getBlock();
                        if (miner.getWorld().getTileEntity(blockPos) == null) {
                            if (isOre(block)) {
                                blocks.add(blockPos);
                            }
                        }
                        x.incrementAndGet();
                    } else {
                        x.set(chunkPos.getXStart());
                        z.incrementAndGet();
                    }
                } else {
                    z.set(chunkPos.getZStart());
                    y.decrementAndGet();
                }
            }
        }
        return blocks;
    }

    static boolean isOre(Block block) {
        OrePrefix orePrefix = OreDictUnifier.getPrefix(new ItemStack(block));
        return orePrefix != null && orePrefixes.contains(orePrefix);
    }


    static String fortuneString(int fortuneLevel) {

        final TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int l =  map.floorKey(fortuneLevel);
        if ( fortuneLevel == l ) {
            return map.get(fortuneLevel);
        }
        return map.get(l) + fortuneString(fortuneLevel-l);
    }

}
