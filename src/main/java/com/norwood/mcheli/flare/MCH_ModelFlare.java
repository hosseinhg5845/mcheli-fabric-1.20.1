/*    */ package com.norwood.mcheli.flare;
/*    */ import com.norwood.mcheli.wrapper.W_ModelBase;
/*    */ import net.minecraft.client.model.Model;
/*    */ import net.minecraft.client.model.ModelPart;


/*    */ 
/*    */ /*    */ public class MCH_ModelFlare extends W_ModelBase {
/* 10 */   public final ModelPart model = (new ModelPart((Model)this, 0, 0)).setTextureSize(4, 4);
/*    */   
/*    */   public MCH_ModelFlare() {
/* 13 */     this.model.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
/*    */   }
/*    */   
/*    */   public void renderModel(double yaw, double pitch, float par7) {
/* 17 */     this.model.render(par7);
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\flare\MCH_ModelFlare.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */