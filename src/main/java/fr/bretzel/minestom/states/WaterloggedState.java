package fr.bretzel.minestom.states;

import fr.bretzel.minestom.states.state.BooleanState;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class WaterloggedState extends BlockState {
    private final BooleanState waterlogged = BooleanState.Of("waterlogged", false);

    protected WaterloggedState(Block block) {
        super(block);
    }

    public boolean getWaterlogged() {
        return get(waterlogged);
    }

    public void setWaterlogged(boolean waterlogged) {
        this.waterlogged.setValue(waterlogged);
        set(this.waterlogged);
    }

    @NotNull
    @Override
    public WaterloggedState clone() {
        return new WaterloggedState(block());
    }
}
