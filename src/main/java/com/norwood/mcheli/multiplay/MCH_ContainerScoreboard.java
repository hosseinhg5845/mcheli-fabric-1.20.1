/*    */ package com.norwood.mcheli.multiplay;
/*    */ 
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.screen.ScreenHandler;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ContainerScoreboard extends ScreenHandler {
/*    */   public final PlayerEntity thePlayer;
/*    */   
/*    */   public MCH_ContainerScoreboard(PlayerEntity player) {
/* 11 */     this.thePlayer = player;
/*    */   }
/*    */   
/*    */   public boolean canInteractWith(@NotNull PlayerEntity player) {
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\multiplay\MCH_ContainerScoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */