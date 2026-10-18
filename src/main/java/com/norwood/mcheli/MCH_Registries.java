package com.norwood.mcheli;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds all Fabric registry calls for MCHeli.
 *
 * Replaces the Forge RegistryEvent.Register<T> system that the old
 * MCH_MOD, MCH_Items, MCH_Blocks, MCH_Recipes, MCH_Entities files used.
 *
 * In Fabric 1.20.1, all registry happens synchronously during mod
 * initialization (not via events).
 */
public class MCH_Registries {
    private static boolean initialized = false;

    public static final Map<String, Item> ITEMS = new HashMap<>();
    public static final Map<String, Block> BLOCKS = new HashMap<>();
    public static final Map<String, SoundEvent> SOUNDS = new HashMap<>();
    public static final Map<String, EntityType<?>> ENTITY_TYPES = new HashMap<>();

    public static void initialize() {
        if (initialized) return;
        initialized = true;

        // Note: Item/Block/Entity/Sound registration happens here in the future.
        // For the first iteration, only register a placeholder so that the
        // mod loads without crashing.
    }

    // === Helpers ===

    public static Item registerItem(String name, Item item) {
        Identifier id = new Identifier(MCHeliFabric.MOD_ID, name);
        Registry.register(Registries.ITEM, id, item);
        ITEMS.put(name, item);
        return item;
    }

    public static Block registerBlock(String name, Block block) {
        Identifier id = new Identifier(MCHeliFabric.MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        BLOCKS.put(name, block);
        return block;
    }

    public static SoundEvent registerSound(String name) {
        Identifier id = new Identifier(MCHeliFabric.MOD_ID, name);
        SoundEvent sound = SoundEvent.of(id);
        Registry.register(Registries.SOUND_EVENT, id, sound);
        SOUNDS.put(name, sound);
        return sound;
    }

    public static <T extends net.minecraft.entity.Entity> EntityType<T> registerEntity(
            String name, EntityType<T> type) {
        Identifier id = new Identifier(MCHeliFabric.MOD_ID, name);
        Registry.register(Registries.ENTITY_TYPE, id, type);
        ENTITY_TYPES.put(name, type);
        return type;
    }
}
