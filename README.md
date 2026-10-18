# MCHeli Fabric 1.20.1 Edition

A port of [MCHeli Overdrive](https://github.com/hosseinhg5845/F22) to Minecraft 1.20.1 using Fabric.

## Goal

Provide a working port of MCHeli to Minecraft 1.20.1 Fabric, with full graphics and features identical to the original 1.12.2 mod.

## Status

🚧 **Work in progress**. The source has been remapped from MCP mappings to Yarn (Mojang official mappings) for Fabric 1.20.1, and all Forge API references have been stripped. Build is being iteratively fixed — see `gradle-build.log` in the latest GitHub Actions run.

## Tech Stack

- **Minecraft**: 1.20.1 (Java Edition)
- **Mod Loader**: Fabric Loader 0.15+
- **Mappings**: Yarn 1.20.1+build.10
- **Build**: Fabric Loom 1.6
- **Java**: 17

## Building Locally

```bash
# Requires JDK 17
./gradlew build
# Output: build/libs/mcheli-fabric-fabric-1.1.4.jar
```

## Repository Structure

```
├── build.gradle          # Fabric Loom build configuration
├── gradle.properties     # Versions (MC, Fabric, mappings)
├── settings.gradle
├── src/main/
│   ├── java/com/norwood/mcheli/
│   │   ├── MCHeliFabric.java          # Fabric ModInitializer entrypoint
│   │   ├── MCHeliFabricClient.java     # Fabric ClientModInitializer entrypoint
│   │   ├── MCH_Registries.java        # Fabric item/block/sound/entity registry
│   │   ├── MCH_Bootstrap.java         # Common-side bootstrap (commands, network)
│   │   ├── MCH_ClientBootstrap.java    # Client-side bootstrap (keys, renderers, HUD)
│   │   ├── MCH_ContentLoader.java     # Config .txt file parser
│   │   └── ... (all original MCHeli classes, ported)
│   └── resources/
│       ├── fabric.mod.json
│       ├── mcheli.mixins.json
│       └── assets/mcheli/             # Original mod assets (textures, models, sounds)
└── .github/workflows/build.yml        # CI build via GitHub Actions
```

## Credits

- Original MCHeli by EMB4 / MrNorwood / Murachiki27 / RagexPrince683
- Fabric 1.20.1 port by the F-22 Edition team
