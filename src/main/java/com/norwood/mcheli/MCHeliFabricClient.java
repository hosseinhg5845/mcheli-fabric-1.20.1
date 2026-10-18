package com.norwood.mcheli;

import com.norwood.mcheli.aircraft.MCH_AircraftInfoManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client-side entrypoint for MCHeli on Fabric 1.20.1.
 *
 * Replaces the old Forge @SidedProxy(ProxyClient.class) system.
 * Handles:
 *   - Registering keybindings
 *   - Registering entity renderers
 *   - Registering HUD overlays
 *   - Registering model loaders (MQO and OBJ)
 *   - Registering client-side packet handlers
 */
public class MCHeliFabricClient implements ClientModInitializer {
    public static final Logger CLIENT_LOGGER = LoggerFactory.getLogger("MCHeli Client");

    @Override
    public void onInitializeClient() {
        long startTime = System.currentTimeMillis();
        CLIENT_LOGGER.info("[MCHeli Client] Initializing client side...");

        // Register key bindings (WASD-throttle, R-reload, F-flare, etc.)
        MCH_ClientBootstrap.registerKeyBindings();

        // Register entity renderers (F-22, F-35, helis, bullets, etc.)
        MCH_ClientBootstrap.registerEntityRenderers();

        // Register HUD overlays (drawn each frame on the client)
        MCH_ClientBootstrap.registerHudOverlays();

        // Register custom model loaders (MQO and OBJ)
        MCH_ClientBootstrap.registerModelLoaders();

        // Register client packet handlers
        MCH_ClientBootstrap.registerClientPackets();

        // Register client tick event
        MCH_ClientBootstrap.registerClientTick();

        long elapsed = System.currentTimeMillis() - startTime;
        CLIENT_LOGGER.info("[MCHeli Client] Client initialization complete ({} ms)", elapsed);
    }
}
