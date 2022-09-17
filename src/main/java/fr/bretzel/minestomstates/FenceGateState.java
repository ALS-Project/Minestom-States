package fr.bretzel.minestomstates;

import fr.bretzel.minestomstates.state.BooleanState;
import fr.bretzel.minestomstates.state.Directional;
import fr.bretzel.minestomstates.state.Facing;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class FenceGateState extends WaterloggedState {
    public FenceGateState(Block block) {
        super(block);
    }

    public boolean inWall() {
        return get(BooleanState.Of("in_wall"));
    }

    public boolean isOpen() {
        return get(BooleanState.Of("open"));
    }

    public Facing getFacing() {
        return get(Facing.class);
    }

    public void setFacing(Facing facing) {
        set(facing);
    }

    public void setInWall(boolean bool) {
        set(BooleanState.Of("in_wall", bool));
    }

    public void setIsOpen(boolean bool) {
        set(BooleanState.Of("open", bool));
    }

    public boolean isParallel(BlockState state, Directional directional) {
        return state.getOr(Facing.class, Facing.SELF).getAxis() == directional.rotateY().getAxis();
    }

    @NotNull
    @Override
    public FenceGateState clone() {
        return new FenceGateState(block());
    }
}
