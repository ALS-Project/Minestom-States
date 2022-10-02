package fr.bretzel.minestom.states;

import fr.bretzel.minestom.states.state.BooleanState;
import fr.bretzel.minestom.states.state.Facing;
import fr.bretzel.minestom.states.state.PistonType;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class PistonHeadState extends BlockState {
    public PistonHeadState(Block alternative) {
        super(alternative);
    }

    public boolean isShort() {
        return get(BooleanState.Of("short"));
    }

    public void setShort(boolean s) {
        set(BooleanState.Of("short", s));
    }

    public PistonType getType() {
        return get(PistonType.class);
    }

    public void setType(PistonType type) {
        set(type);
    }

    public Facing getFacing() {
        return get(Facing.class);
    }

    public void setFacing(Facing facing) {
        set(facing);
    }

    @NotNull
    @Override
    public PistonHeadState clone() {
        return new PistonHeadState(block());
    }
}
