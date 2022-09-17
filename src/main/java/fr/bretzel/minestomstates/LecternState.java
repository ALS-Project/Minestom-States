package fr.bretzel.minestomstates;

import fr.bretzel.minestomstates.state.BooleanState;
import fr.bretzel.minestomstates.state.Facing;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class LecternState extends BlockState {

    public LecternState(Block block) {
        super(block);
    }

    public Facing getFacing() {
        return getOr(Facing.class, Facing.NORTH);
    }

    public boolean hasBook() {
        return get(BooleanState.Of("has_book"));
    }

    public void setHasBook(boolean book) {
        set(BooleanState.Of("has_book", book));
    }

    @NotNull
    @Override
    public LecternState clone() {
        return new LecternState(block());
    }
}
