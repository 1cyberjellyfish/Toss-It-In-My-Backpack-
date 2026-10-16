//? if neoforge {
package cyber_jellyfish.tiimb.neoforge;

import cyber_jellyfish.tiimb.TIIMBClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(TIIMBClient.MOD_ID)
public class TossitinmybackpakNeoForge {
    public TossitinmybackpakNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(this::registerKeyMappings);
            NeoForge.EVENT_BUS.addListener(this::onClientTick);
        }
    }

    private void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TIIMBClient.MOVE_KEY);
    }

    private void onClientTick(ClientTickEvent.Post event) {
        TIIMBClient.onClientTick();
    }
}
//?}
