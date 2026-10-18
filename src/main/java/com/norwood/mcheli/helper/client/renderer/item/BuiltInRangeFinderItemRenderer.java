/*    */ package com.norwood.mcheli.helper.client.renderer.item;
/*    */ 
/*    */ import com.norwood.mcheli.MCH_ModelManager;
/*    */ import com.norwood.mcheli.tool.rangefinder.MCH_ItemRangeFinder;
/*    */ import com.norwood.mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.Hand;


/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ /*    */ public class BuiltInRangeFinderItemRenderer
/*    */   implements IItemModelRenderer {
/*    */   public boolean shouldRenderer(ItemStack itemStack, ModelTransformationMode.TransformType transformType) {
/* 19 */     return (IItemModelRenderer.isFirstPerson(transformType) || IItemModelRenderer.isThirdPerson(transformType) || transformType == ModelTransformationMode.TransformType.GROUND);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderItem(ItemStack itemStack, LivingEntity entity, ModelTransformationMode.TransformType transformType, float partialTicks) {
/* 24 */     GL11.glPushMatrix();
/* 25 */     W_McClient.MOD_bindTexture("textures/rangefinder.png");
/* 26 */     boolean flag = true;
/* 27 */     if (IItemModelRenderer.isFirstPerson(transformType)) {
/* 28 */       flag = (entity instanceof PlayerEntity && !MCH_ItemRangeFinder.isUsingScope((PlayerEntity)entity));
/* 29 */       if (entity.isHandActive() && entity.getActiveHand() == Hand.MAIN_HAND) {
/* 30 */         GL11.glTranslated(0.6563000082969666D, 0.34380000829696655D, 0.009999999776482582D);
/*    */       }
/*    */     } 
/*    */     
/* 34 */     if (flag) {
/* 35 */       MCH_ModelManager.render("rangefinder");
/*    */     }
/*    */     
/* 38 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\renderer\item\BuiltInRangeFinderItemRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */