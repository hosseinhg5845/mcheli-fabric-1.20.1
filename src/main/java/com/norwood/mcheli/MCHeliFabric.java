package com.norwood.mcheli;

import com.norwood.mcheli.aircraft.MCH_AircraftInfoManager;
import com.norwood.mcheli.helper.info.ContentRegistries;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entrypoint for MCHeli on Fabric 1.20.1.
 *
 * Replaces the old Forge @Mod annotation-based bootstrap (MCH_MOD) with
 * Fabric's ModInitializer interface.
 *
 * All Forge registry events have been replaced with Fabric's
 * RegistryHelper calls (in MCH_Registries).
 */
public class MCHeliFabric implements ModInitializer {
    public static final String MOD_ID = "mcheli";
    public static final String MOD_NAME = "MC Helicopter Overdrive";
    public static final String VERSION = "1.1.4";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    private static boolean isServer = false;
    private static boolean isClient = false;

    @Override
    public void onInitialize() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[MCHeli] Starting MC Helicopter Overdrive v{} on Fabric 1.20.1...", VERSION);

        // Detect if we're running on a dedicated server or client
        isClient = FabricLoader.getInstance().getEnvironmentType().equals("CLIENT");
        isServer = !isClient;

        // Register all items, blocks, sounds, entities (in static blocks)
        MCH_Registries.initialize();

        // Register server lifecycle events
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            LOGGER.info("[MCHeli] Server starting, loading content...");
            long t = System.currentTimeMillis();
            MCH_ContentLoader.loadAll(server);
            LOGGER.info("[MCHeli] Content loaded in {} ms", System.currentTimeMillis() - t);
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            LOGGER.info("[MCHeli] Server stopping, cleaning up content...");
            ContentRegistries.clear();
        });

        // Initialize common systems (commands, network, etc.)
        MCH_Bootstrap.initializeCommon();

        long elapsed = System.currentTimeMillis() - startTime;
        LOGGER.info("[MCHeli] Mod initialization complete ({} ms)", elapsed);
    }

    public static boolean isClient() { return isClient; }
    public static boolean isServer() { return isServer; }
    public static Logger getLogger() { return LOGGER; }
}
