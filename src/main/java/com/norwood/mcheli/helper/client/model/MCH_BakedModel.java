/*    */ package com.norwood.mcheli.helper.client.model;
/*    */ 
/*    */ import com.norwood.mcheli.helper.client.renderer.item.IItemModelRenderer;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import javax.vecmath.Matrix4f;
/*    */ import net.minecraft.block.BlockState;
/*    */ import net.minecraft.client.render.model.BakedQuad;
/*    */ import net.minecraft.client.render.model.BakedModel;
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.client.render.model.json.ItemOverrideList;
/*    */ import net.minecraft.client.texture.Sprite;
/*    */ import net.minecraft.util.math.Direction;


/*    */ import org.apache.commons.lang3.tuple.Pair;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ /*    */ public class MCH_BakedModel
/*    */   implements BakedModel
/*    */ {
/*    */   private final BakedModel bakedModel;
/*    */   private final IItemModelRenderer renderer;
/*    */   private final ItemOverrideList overrides;
/*    */   
/*    */   public MCH_BakedModel(BakedModel bakedModel, IItemModelRenderer renderer) {
/* 28 */     this.bakedModel = bakedModel;
/* 29 */     this.renderer = renderer;
/* 30 */     this.overrides = new MCH_ItemOverrideList(bakedModel);
/*    */   }
/*    */   @NotNull
/*    */   public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, long rand) {
/* 34 */     return this.bakedModel.getQuads(state, side, rand);
/*    */   }
/*    */   
/*    */   public boolean isAmbientOcclusion() {
/* 38 */     return this.bakedModel.isAmbientOcclusion();
/*    */   }
/*    */   
/*    */   public boolean isGui3d() {
/* 42 */     return this.bakedModel.isGui3d();
/*    */   }
/*    */   
/*    */   public boolean isBuiltInRenderer() {
/* 46 */     return (this.renderer.shouldRenderer(PooledModelParameters.getTargetRendererStack(), PooledModelParameters.getTransformType()) || this.bakedModel.isBuiltInRenderer());
/*    */   }
/*    */   @NotNull
/*    */   public Sprite getParticleTexture() {
/* 50 */     return this.bakedModel.getParticleTexture();
/*    */   }
/*    */   @Deprecated
/*    */   @NotNull
/*    */   public ModelTransformationMode getItemCameraTransforms() {
/* 55 */     return this.bakedModel.getItemCameraTransforms();
/*    */   }
/*    */   @NotNull
/*    */   public ItemOverrideList getOverrides() {
/* 59 */     return this.overrides;
/*    */   }
/*    */   
/*    */   public boolean isAmbientOcclusion(@NotNull BlockState state) {
/* 63 */     return this.bakedModel.isAmbientOcclusion(state);
/*    */   }
/*    */   @NotNull
/*    */   public Pair<? extends BakedModel, Matrix4f> handlePerspective(@NotNull ModelTransformationMode.TransformType cameraTransformType) {
/* 67 */     PooledModelParameters.setTransformType(cameraTransformType);
/* 68 */     Pair<? extends BakedModel, Matrix4f> pair = this.bakedModel.handlePerspective(cameraTransformType);
/* 69 */     return Pair.of(new MCH_BakedModel((BakedModel)pair.getLeft(), this.renderer), pair.getRight());
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\model\MCH_BakedModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */