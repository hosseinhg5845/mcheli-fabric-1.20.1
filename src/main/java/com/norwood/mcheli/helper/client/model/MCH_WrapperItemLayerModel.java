/*    */ package com.norwood.mcheli.helper.client.model;
/*    */ 
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.client.render.model.BakedModel;
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.client.render.model.json.JsonModel;
/*    */ import net.minecraft.client.texture.Sprite;
/*    */ import net.minecraft.client.render.VertexFormat;
/*    */ import net.minecraft.util.ResourceLocation;





/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_WrapperItemLayerModel
/*    */   implements IModel
/*    */ {
/*    */   private final ItemLayerModel model;
/*    */   private final JsonModel raw;
/*    */   
/*    */   public MCH_WrapperItemLayerModel(JsonModel modelBlock) {
/* 30 */     this.raw = modelBlock;
/* 31 */     this.model = new ItemLayerModel(modelBlock);
/*    */   }
/*    */   @NotNull
/*    */   public Collection<ResourceLocation> getTextures() {
/* 35 */     return this.model.getTextures();
/*    */   }
/*    */   @NotNull
/*    */   public IModel retexture(@NotNull ImmutableMap<String, String> textures) {
/* 39 */     return (IModel)this.model.retexture(textures);
/*    */   }
/*    */   @NotNull
/*    */   public BakedModel bake(@NotNull IModelState state, @NotNull VertexFormat format, @NotNull Function<ResourceLocation, Sprite> bakedTextureGetter) {
/* 43 */     ModelTransformationMode transforms = this.raw.getAllTransforms();
/* 44 */     Map<ModelTransformationMode.TransformType, TRSRTransformation> tMap = Maps.newEnumMap(ModelTransformationMode.TransformType.class);
/* 45 */     tMap.putAll((Map<? extends ModelTransformationMode.TransformType, ? extends TRSRTransformation>)PerspectiveMapWrapper.getTransforms(transforms));
/* 46 */     tMap.putAll((Map<? extends ModelTransformationMode.TransformType, ? extends TRSRTransformation>)PerspectiveMapWrapper.getTransforms(state));
/* 47 */     SimpleModelState simpleModelState = new SimpleModelState(ImmutableMap.copyOf(tMap), state.apply(Optional.empty()));
/* 48 */     return this.model.bake((IModelState)simpleModelState, format, bakedTextureGetter);
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\model\MCH_WrapperItemLayerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */