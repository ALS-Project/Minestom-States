package fr.bretzel.minestom.states;

import fr.bretzel.minestom.states.state.BooleanState;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class ScaffoldingState extends WaterloggedState {
    public ScaffoldingState(Block block) {
        super(block);
    }

    public boolean hasBottom() {
        return get(BooleanState.Of("bottom"));
    }

    public void setBottom(boolean bottom) {
        set(BooleanState.Of("bottom", bottom));
    }

    @NotNull
    @Override
    public ScaffoldingState clone() {
        return new ScaffoldingState(block());
    }
}
