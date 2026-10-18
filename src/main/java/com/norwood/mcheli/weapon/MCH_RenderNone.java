/*    */ package com.norwood.mcheli.weapon;
/*    */ import com.norwood.mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.client.render.entity.EntityRendererManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;

/*    */ 
/*    */ /*    */ public class MCH_RenderNone extends MCH_RenderBulletBase<W_Entity> {
/* 12 */   public static final IRenderFactory<W_Entity> FACTORY = MCH_RenderNone::new;
/*    */   
/*    */   protected MCH_RenderNone(EntityRenderDispatcher renderManager) {
/* 15 */     super(renderManager);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBullet(W_Entity entity, double posX, double posY, double posZ, float yaw, float partialTickTime) {}
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(W_Entity entity) {
/* 23 */     return TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\weapon\MCH_RenderNone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */