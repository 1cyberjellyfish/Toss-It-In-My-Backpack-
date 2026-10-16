package cyber_jellyfish.tiimb;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;
//? if <=1.21.1 {
import net.minecraft.world.inventory.ClickType;
//?}
import net.minecraft.world.item.ItemStack;

public class ItemMover {

    public static void moveHeldItemToBackpack(Minecraft client) {
        if (client == null || client.player == null || client.gameMode == null) {
            return;
        }


        LocalPlayer player = client.player;

        if (player.isSpectator()) {
            return;
        }

        // Allow when playing in-game (screen == null) or when viewing player's own inventory
        //? if >1.21.1 {
        /*if (client.gui.screen() != null && !(client.gui.screen() instanceof InventoryScreen)) {
            return;
        }
        *///?} else {
        if (client.screen != null && !(client.screen instanceof InventoryScreen)) {
            return;
        }
        //?}

        // If cursor is already holding an item, avoid interfering
        if (!player.containerMenu.getCarried().isEmpty()) {
            return;
        }

        ItemStack heldStack = player.getMainHandItem();
        if (heldStack.isEmpty()) {
            return;
        }

        int containerId = player.inventoryMenu.containerId; // 0
        //? if >1.21.1 {
        /*int selectedHotbar = player.getInventory().getSelectedSlot();
        *///?} else {
        int selectedHotbar = player.getInventory().selected;
        //?}
        int handSlotIndex = 36 + selectedHotbar; // In InventoryMenu, hotbar is slots 36..44

        // 1. Pick up the held item stack from hotbar onto cursor
        click(client, containerId, handSlotIndex);

        if (player.containerMenu.getCarried().isEmpty()) {
            return;
        }

        int initialCount = player.containerMenu.getCarried().getCount();

        // 2. Phase 1: Try stacking with identical items in the main backpack (slots 9 to 35)
        // Slots 9..17 are top row, 18..26 middle, 27..35 bottom
        for (int slot = 9; slot <= 35; slot++) {
            if (player.containerMenu.getCarried().isEmpty()) {
                break;
            }

            ItemStack slotStack = player.containerMenu.getSlot(slot).getItem();
            if (slotStack.isEmpty()) {
                continue;
            }

            if (ItemStack.isSameItemSameComponents(slotStack, player.containerMenu.getCarried())
                    && slotStack.getCount() < slotStack.getMaxStackSize()) {
                click(client, containerId, slot);
            }
        }

        // 3. Phase 2: If items remain on cursor, find the first empty slot prioritizing the top row
        if (!player.containerMenu.getCarried().isEmpty()) {
            for (int slot = 9; slot <= 35; slot++) {
                if (player.containerMenu.getCarried().isEmpty()) {
                    break;
                }

                ItemStack slotStack = player.containerMenu.getSlot(slot).getItem();
                if (slotStack.isEmpty()) {
                    click(client, containerId, slot);
                    break;
                }
            }
        }

        int remainingCount = player.containerMenu.getCarried().isEmpty() ? 0 : player.containerMenu.getCarried().getCount();
        int movedCount = initialCount - remainingCount;

        // 4. Phase 3: Safety check - if inventory was full and items remain on cursor, return to hand
        if (!player.containerMenu.getCarried().isEmpty()) {
            click(client, containerId, handSlotIndex);
        }

        if (movedCount > 0) {
            // Tactile UI click sound on successful move
            client.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.6F));
        }

        if (remainingCount > 0) {
            // Smooth, clearly negative error sound when inventory cannot fit items (full)
            //? if >1.21.1 {
            /*client.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BUNDLE_INSERT_FAIL, 1.0F));
            *///?} else {
            client.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.DISPENSER_FAIL, 0.8F));
            //?}
        }
    }

    private static void click(Minecraft client, int containerId, int slotIndex) {
        //? if >1.21.1 {
        /*client.gameMode.handleContainerInput(containerId, slotIndex, 0, net.minecraft.world.inventory.ContainerInput.PICKUP, client.player);
        *///?} else {
        client.gameMode.handleInventoryMouseClick(containerId, slotIndex, 0, ClickType.PICKUP, client.player);
        //?}
    }
}
