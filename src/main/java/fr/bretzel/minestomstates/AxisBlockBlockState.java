package fr.bretzel.minestomstates;

import fr.bretzel.minestomstates.state.Axis;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class AxisBlockBlockState extends WaterloggedState {
    public AxisBlockBlockState(Block alternative) {
        super(alternative);
    }

    public Axis getAxis() {
        return get(Axis.class);
    }

    public void setAxis(Axis axis) {
        set(axis);
    }

    @NotNull
    @Override
    public AxisBlockBlockState clone() {
        return new AxisBlockBlockState(block());
    }
}
