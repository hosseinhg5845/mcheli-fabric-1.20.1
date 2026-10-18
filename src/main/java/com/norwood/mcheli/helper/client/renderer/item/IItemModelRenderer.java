/*    */ package com.norwood.mcheli.helper.client.renderer.item;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.render.model.json.ModelTransformationMode;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.item.ItemStack;


/*    */ 
/*    */ /*    */ public interface IItemModelRenderer
/*    */ {
/*    */   static boolean isFirstPerson(ModelTransformationMode.TransformType type) {
/* 14 */     return (type == ModelTransformationMode.TransformType.FIRST_PERSON_LEFT_HAND || type == ModelTransformationMode.TransformType.FIRST_PERSON_RIGHT_HAND);
/*    */   }
/*    */   
/*    */   static boolean isThirdPerson(ModelTransformationMode.TransformType type) {
/* 18 */     return (type == ModelTransformationMode.TransformType.THIRD_PERSON_LEFT_HAND || type == ModelTransformationMode.TransformType.THIRD_PERSON_RIGHT_HAND);
/*    */   }
/*    */   
/*    */   boolean shouldRenderer(ItemStack paramItemStack, ModelTransformationMode.TransformType paramTransformType);
/*    */   
/*    */   void renderItem(ItemStack paramItemStack, @Nullable LivingEntity paramEntityLivingBase, ModelTransformationMode.TransformType paramTransformType, float paramFloat);
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\renderer\item\IItemModelRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */