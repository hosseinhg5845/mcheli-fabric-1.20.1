/*    */ package com.norwood.mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.entity.LivingEntity;





/*    */ 
/*    */ public class W_ClientEventHook {
/*    */   @Event/*    */   public void onEvent_MouseEvent(MouseEvent event) {
/* 14 */     mouseEvent(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseEvent(MouseEvent event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_renderLivingEventSpecialsPre(RenderLivingEvent.Specials.Pre<LivingEntity> event) {
/* 22 */     renderLivingEventSpecialsPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventSpecialsPre(RenderLivingEvent.Specials.Pre<LivingEntity> event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_renderLivingEventSpecialsPost(RenderLivingEvent.Specials.Post<LivingEntity> event) {
/* 30 */     renderLivingEventSpecialsPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventSpecialsPost(RenderLivingEvent.Specials.Post<LivingEntity> event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_renderLivingEventPre(RenderLivingEvent.Pre<LivingEntity> event) {
/* 38 */     renderLivingEventPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventPre(RenderLivingEvent.Pre<LivingEntity> event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_renderLivingEventPost(RenderLivingEvent.Post<LivingEntity> event) {
/* 46 */     renderLivingEventPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventPost(RenderLivingEvent.Post<LivingEntity> event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_renderPlayerPre(RenderPlayerEvent.Pre event) {
/* 54 */     renderPlayerPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPlayerPre(RenderPlayerEvent.Pre event) {}
/*    */   
/*    */   @Event/*    */   public void Event_renderPlayerPost(RenderPlayerEvent.Post event) {
/* 62 */     renderPlayerPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPlayerPost(RenderPlayerEvent.Post event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_WorldEventUnload(WorldEvent.Unload event) {
/* 70 */     worldEventUnload(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void worldEventUnload(WorldEvent.Unload event) {}
/*    */   
/*    */   @Event/*    */   public void onEvent_EntityJoinWorldEvent(EntityJoinWorldEvent event) {
/* 78 */     entityJoinWorldEvent(event);
/*    */   }
/*    */   
/*    */   public void entityJoinWorldEvent(EntityJoinWorldEvent event) {}
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\wrapper\W_ClientEventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */