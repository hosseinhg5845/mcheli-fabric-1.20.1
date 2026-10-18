package com.norwood.mcheli;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

/**
 * Stub for the MCHeli client-side bootstrap.
 * Will be filled in as the port progresses.
 */
public class MCH_ClientBootstrap {

    public static void registerKeyBindings() {
        // TODO: register all MCHeli keybindings (WASD, R, F, etc.)
    }

    public static void registerEntityRenderers() {
        // TODO: register entity renderers (F-22, F-35, bullets, etc.)
    }

    public static void registerHudOverlays() {
        // TODO: register HUD overlays (altitude, speed, fuel, radar)
    }

    public static void registerModelLoaders() {
        // TODO: register MQO and OBJ model loaders (custom loader needed in 1.20.1)
    }

    public static void registerClientPackets() {
        // TODO: register client packet handlers
    }

    public static void registerClientTick() {
        // TODO: register client tick handler
    }
}
