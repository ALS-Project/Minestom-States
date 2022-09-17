package fr.bretzel.minestomstates;

import fr.bretzel.minestomstates.error.StateError;
import fr.bretzel.minestomstates.error.UnknownBlockStatesKey;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.item.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.mutable.MutableNBTCompound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockState {
    private final HashMap<String, String> block_states = new HashMap<>();

    private Block block;

    private BlockHandler blockHandler;
    private NBTCompound blockNbt;

    protected BlockState(Block block) {
        this.block = block;
        //Copy All Entry
        block_states.putAll(block.properties());
    }

    @ApiStatus.Internal
    private void private_set(String key, String value) {
        if (!block_states.containsKey(key)) {
            throw new UnknownBlockStatesKey("Unknown key " + key + " for block states of " + block().name());
        } else {
            block_states.remove(key);
            block_states.put(key.toLowerCase(), value.toLowerCase());
        }
    }

    public void set(State<?> key, State<?> value) {
        private_set(key.getKey(), value.getValue());
    }

    public <T> void set(State<T> key, T value) {
        private_set(key.getKey(), String.valueOf(value));
    }

    public void set(State<?> state) {
        private_set(state.getKey(), state.getValue());
    }

    public <T> T get(State<T> stateKey) {
        return stateKey.parse(block_states.get(stateKey.getKey()));
    }

    public <T extends State<T>> T get(Class<T> type) {
        if (type.isEnum()) {
            return get(type.getEnumConstants()[0]);
        } else {
            throw new StateError("Error, you need to specify a key for the blocksate " + type.getSimpleName());
        }
    }

    public <T extends State<T>> T get(State<?> key, Class<T> type) {
        if (type.isEnum()) {
            return type.getEnumConstants()[0].parse(getRaw(key.getKey()));
        } else {
            throw new StateError("Error, you need to specify a key for the blocksate " + type.getSimpleName());
        }
    }

    public <T extends State<T>> T getOr(Class<T> stateKey, T miss) {
        try {
            return miss.getClass().equals(stateKey) ? get(stateKey) : miss;
        } catch (Exception e) {
            return miss;
        }
    }

    public boolean has(State<?> stateKey) {
        return block_states.containsKey(stateKey.getKey());
    }

    public boolean has(Class<? extends State<?>> type) {
        if (type.isEnum()) {
            return block_states.containsKey(type.getEnumConstants()[0].getKey());
        } else {
            throw new StateError("Error, you need to specify a key for the blocksate " + type.getSimpleName());
        }
    }

    @Deprecated
    public boolean has(String key) {
        return block_states.containsKey(key);
    }

    @Deprecated
    public String getRaw(State<?> stateKey) {
        return block_states.get(stateKey.getKey());
    }

    @Deprecated
    public String getRaw(String key) {
        return block_states.get(key);
    }

    @SafeVarargs
    public final <T> List<T> getStates(State<T>... stateKeys) {
        List<T> list = new ArrayList<>();
        for (State<T> stateKey : stateKeys)
            list.add(get(stateKey));
        return list;
    }

    public <T extends State<T>> List<T> getAllStateValue(Class<T> type) {
        if (type.isEnum()) {
            List<T> valueT = new ArrayList<>();
            T valueState = type.getEnumConstants()[0];

            for (Map.Entry<String, String> entry : block_states.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(valueState.getKey())) {
                    valueT.add(valueState.parse(entry.getValue()));
                }
            }

            return valueT;
        } else {
            throw new StateError("Error, you need to specify a key for the blocksate " + type.getSimpleName());
        }
    }

    public void setBlockHandler(BlockHandler blockHandler) {
        this.blockHandler = blockHandler;
    }

    public void setBlockNbt(ItemStack stack) {
        NBTCompound itemNBT = stack.toItemNBT();

        if (itemNBT.containsKey("tag")) {
            MutableNBTCompound nbt = itemNBT.getCompound("tag").toMutableCompound();
            nbt.remove("id");
            nbt.remove("Count");
            if (nbt.containsKey("BlockEntityTag")) {
                this.blockNbt = nbt.getCompound("BlockEntityTag");
            } else {
                this.blockNbt = nbt.toCompound();
            }
        }
    }

    public Block block() {
        if (blockHandler != null)
            block = block.withHandler(blockHandler);

        if (blockNbt != null)
            block = block.withNbt(blockNbt);

        return block.withProperties(map());
    }

    public HashMap<String, String> map() {
        return block_states;
    }

    public void withBlock(Block block) {
        block_states.clear();
        this.block = block;
        this.blockNbt = null;
        this.blockHandler = null;
        block_states.putAll(block.properties());
    }

    @Override
    public String toString() {
        return "BlockState{" +
                "states=" + "" +
                ", block=" + block.namespace() +
                '}';
    }
}
