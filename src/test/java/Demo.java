import fr.bretzel.minestomstates.States;
import fr.bretzel.minestomstates.BlockStateManager;
import fr.bretzel.minestomstates.WaterloggedState;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;

public class Demo {

    public void demoWaterLogged() {
        //Get the block state of a block with the BlockStateManager.get(block)
        States state = BlockStateManager.get(Block.SEA_PICKLE);

        //Cast to a WaterLogged State
        WaterloggedState waterloggedState = (WaterloggedState) state;
        //Set the waterlogged to true
        waterloggedState.setWaterlogged(true);

        //Set the block to you instance
        Instance instance = MinecraftServer.getInstanceManager().getInstances().iterator().next();
        instance.setBlock(Pos.ZERO, waterloggedState.block());
    }
}
