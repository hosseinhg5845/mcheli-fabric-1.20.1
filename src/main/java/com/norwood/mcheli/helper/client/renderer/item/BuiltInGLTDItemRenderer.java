/*    */ package com.norwood.mcheli.helper.client.renderer.item;
/*    */ 
/*    */ import com.norwood.mcheli.gltd.MCH_RenderGLTD;
/*    */ import com.norwood.mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.item.ItemStack;


/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ /*    */ public class BuiltInGLTDItemRenderer
/*    */   implements IItemModelRenderer {
/*    */   public boolean shouldRenderer(ItemStack itemStack, ModelTransformationMode.TransformType transformType) {
/* 16 */     return (IItemModelRenderer.isFirstPerson(transformType) || IItemModelRenderer.isThirdPerson(transformType) || transformType == ModelTransformationMode.TransformType.GROUND);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderItem(ItemStack itemStack, LivingEntity entityLivingBase, ModelTransformationMode.TransformType transformType, float partialTicks) {
/* 21 */     GL11.glPushMatrix();
/* 22 */     GL11.glEnable(2884);
/* 23 */     W_McClient.MOD_bindTexture("textures/gltd.png");
/* 24 */     GL11.glEnable(32826);
/* 25 */     GL11.glEnable(2903);
/* 26 */     MCH_RenderGLTD.model.renderAll();
/* 27 */     GL11.glDisable(32826);
/* 28 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\renderer\item\BuiltInGLTDItemRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */