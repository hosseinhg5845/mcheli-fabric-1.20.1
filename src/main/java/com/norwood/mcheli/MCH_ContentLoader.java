package com.norwood.mcheli;

import net.minecraft.server.MinecraftServer;

/**
 * Loads all MCHeli content from the assets/mcheli/*.txt config files
 * on server start, similar to the old MCH_MOD.loadAircraftInfo() loop.
 */
public class MCH_ContentLoader {

    public static void loadAll(MinecraftServer server) {
        // TODO: parse all .txt config files in assets/mcheli/planes, helicopters,
        // tanks, vehicles, weapons, etc. and populate the info managers
        // (MCH_AircraftInfoManager, MCH_WeaponInfoManager, etc.)
    }
}
