package cyber_jellyfish.tiimb;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class TIIMBClient {
    public static final String MOD_ID = "tossitinmybackpack";
    public static final String KEY_NAME = "key." + MOD_ID + ".move_item";

    //? if >1.21.1 {
    /*public static final KeyMapping.Category KEY_CATEGORY = KeyMapping.Category.INVENTORY;

    public static final KeyMapping MOVE_KEY = new KeyMapping(
            KEY_NAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            KEY_CATEGORY
    );
    *///?} else {
    public static final String KEY_CATEGORY = "key.categories." + MOD_ID;

    public static final KeyMapping MOVE_KEY = new KeyMapping(
            KEY_NAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            KEY_CATEGORY
    );
    //?}

    public static void onClientTick() {
        while (MOVE_KEY.consumeClick()) {
            ItemMover.moveHeldItemToBackpack(Minecraft.getInstance());
        }
    }
}
