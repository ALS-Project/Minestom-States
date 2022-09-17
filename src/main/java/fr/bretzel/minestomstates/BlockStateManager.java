package fr.bretzel.minestomstates;

import net.minestom.server.instance.block.Block;

public class BlockStateManager {

    public static BlockState get(Block block) {
        if (block == Block.BELL)
            return new BellState(block);
        else if (block == Block.CAMPFIRE || block == Block.SOUL_CAMPFIRE)
            return new CampfireState(block);
        else if (block == Block.LECTERN)
            return new LecternState(block);
        else if (block == Block.PISTON_HEAD)
            return new PistonHeadState(block);
        else if (block == Block.SCAFFOLDING)
            return new ScaffoldingState(block);
        else if (block.name().endsWith("stairs"))
            return new StairsSate(block);
        else if (block.name().contains("fence_gate"))
            return new FenceGateState(block);
        else if (block.name().contains("wall"))
            return new WallState(block);
        else if (block.properties().containsKey("axis"))
            return new AxisBlockStates(block);
        return new BlockState(block);
    }
}
