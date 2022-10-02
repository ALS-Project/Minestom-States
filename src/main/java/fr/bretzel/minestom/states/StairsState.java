package fr.bretzel.minestom.states;

import fr.bretzel.minestom.states.state.Half;
import fr.bretzel.minestom.states.state.Facing;
import fr.bretzel.minestom.states.state.StairsShape;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class StairsState extends WaterloggedState {

    public StairsState(Block block) {
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
    public StairsState clone() {
        return new StairsState(block());
    }
}
