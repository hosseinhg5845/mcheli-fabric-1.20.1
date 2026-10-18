package com.norwood.mcheli.helper.client.model;

import net.minecraft.client.render.model.json.JsonModel;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.ResourceLocation;



import org.jetbrains.annotations.NotNull;

public enum LegacyModelLoader implements ICustomModelLoader {
    INSTANCE;

    public static final String VARIANT = "mcheli_legacy";
    static final String TEMPLATE;

    static {
        TEMPLATE = "{'parent':'item/generated','textures':{'layer0':'__item__'}}".replaceAll("'", "\"");
    }

    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {}

    public boolean accepts(@NotNull ResourceLocation modelLocation) {
        Identifier location;
        if (modelLocation instanceof Identifier) {
            location = (Identifier) modelLocation;
        } else {
            return false;
        }
        return (location.getResourceDomain().equals("mcheli") && location.getVariant().equals(VARIANT));
    }

    @NotNull
    public IModel loadModel(ResourceLocation modelLocation) throws Exception {
        String path = modelLocation.getResourceDomain() + ":items/" + modelLocation.getResourcePath();
        JsonModel modelblock = JsonModel.deserialize(TEMPLATE.replaceAll("__item__", path));
        modelblock.parent = ModelLoaderRegistry.getModel(modelblock.getParentLocation()).asVanillaModel().get();
        return new MCH_WrapperItemLayerModel(modelblock);
    }
}
