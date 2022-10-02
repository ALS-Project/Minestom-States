package fr.bretzel.minestom.states;

import fr.bretzel.minestom.states.state.BooleanState;
import fr.bretzel.minestom.states.state.Facing;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class CampfireState extends WaterloggedState {

    private final BooleanState lit = BooleanState.Of("lit", true);
    private final BooleanState signal_fire = BooleanState.Of("signal_fire", false);
    private Facing facing = Facing.SELF;

    public CampfireState(Block alternative) {
        super(alternative);
    }

    public boolean getLit() {
        return get(lit);
    }

    public void setLit(boolean lit) {
        this.lit.setValue(lit);
        set(this.lit);
    }

    public boolean getSignalFire() {
        return get(signal_fire);
    }

    public void setSignalFire(boolean signalFire) {
        this.signal_fire.setValue(signalFire);
        set(signal_fire);
    }

    public Facing getFacing() {
        return get(facing);
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
        set(facing);
    }

    @Override
    public @NotNull CampfireState clone() {
        return new CampfireState(block());
    }
}
