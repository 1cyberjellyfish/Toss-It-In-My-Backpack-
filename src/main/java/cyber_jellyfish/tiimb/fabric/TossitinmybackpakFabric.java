//? if fabric {
/*package cyber_jellyfish.tiimb.fabric;

import cyber_jellyfish.tiimb.TIIMBClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//? if >1.21.1 {
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
//?} else {
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
//?}

public class TossitinmybackpakFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //? if >1.21.1 {
        KeyMappingHelper.registerKeyMapping(TIIMBClient.MOVE_KEY);
        //?} else {
        KeyBindingHelper.registerKeyBinding(TIIMBClient.MOVE_KEY);
        //?}
        ClientTickEvents.END_CLIENT_TICK.register(client -> TIIMBClient.onClientTick());
    }
}
*///?}
