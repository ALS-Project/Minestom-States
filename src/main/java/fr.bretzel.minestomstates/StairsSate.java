package fr.bretzel.minestomstates;

import fr.bretzel.minestomstates.state.Facing;
import fr.bretzel.minestomstates.state.Half;
import fr.bretzel.minestomstates.state.StairsShape;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class StairsSate extends WaterloggedState {

    public StairsSate(Block block) {
        super(block);
    }

    public Facing getFacing() {
        return get(Facing.class);
    }

    public void setFacing(Facing facing) {
        set(facing);
    }

    public Half getHalf() {
        return get(Half.class);
    }

    public void setHalf(Half half) {
        set(half);
    }

    public StairsShape getShape() {
        return get(StairsShape.class);
    }

    public void setShape(StairsShape stairsShape) {
        set(stairsShape);
    }

    @NotNull
    @Override
    public StairsSate clone() {
        return new StairsSate(block());
    }
}
