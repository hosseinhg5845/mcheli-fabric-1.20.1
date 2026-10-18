/*    */ package com.norwood.mcheli;
/*    */ 
/*    */ import net.minecraft.client.model.Model;
/*    */ import net.minecraft.client.model.ModelPart;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_TEST_ModelRenderer extends ModelPart {
/*    */   public MCH_TEST_ModelRenderer(Model par1ModelBase) {
/*  9 */     super(par1ModelBase);
/*    */   }
/*    */   
/*    */   public void render(float par1) {
/* 13 */     GL11.glPushMatrix();
/* 14 */     GL11.glScaled(0.2D, -0.2D, 0.2D);
/* 15 */     MCH_ModelManager.render("helicopters", "ah-64");
/* 16 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\MCH_TEST_ModelRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */