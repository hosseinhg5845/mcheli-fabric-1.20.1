/*    */ package com.norwood.mcheli.helper.client.renderer.item;
/*    */ 
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.item.ItemStack;


/*    */ 
/*    */ /*    */ public class BuiltInInvisibleItemRenderer
/*    */   implements IItemModelRenderer {
/*    */   public boolean shouldRenderer(ItemStack itemStack, ModelTransformationMode.TransformType transformType) {
/* 13 */     return (IItemModelRenderer.isFirstPerson(transformType) || IItemModelRenderer.isThirdPerson(transformType));
/*    */   }
/*    */   
/*    */   public void renderItem(ItemStack itemStack, LivingEntity entityLivingBase, ModelTransformationMode.TransformType transformType, float partialTicks) {}
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\renderer\item\BuiltInInvisibleItemRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */