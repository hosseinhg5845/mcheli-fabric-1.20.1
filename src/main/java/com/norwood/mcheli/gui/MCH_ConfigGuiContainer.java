/*    */ package com.norwood.mcheli.gui;
/*    */ 
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.screen.ScreenHandler;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ConfigGuiContainer extends ScreenHandler {
/*    */   public final PlayerEntity player;
/*    */   
/*    */   public MCH_ConfigGuiContainer(PlayerEntity player) {
/* 12 */     this.player = player;
/*    */   }
/*    */   
/*    */   public void detectAndSendChanges() {
/* 16 */     super.detectAndSendChanges();
/*    */   }
/*    */   
/*    */   public boolean canInteractWith(@NotNull PlayerEntity player) {
/* 20 */     return true;
/*    */   }
/*    */   @NotNull
/*    */   public ItemStack transferStackInSlot(@NotNull PlayerEntity par1EntityPlayer, int par2) {
/* 24 */     return ItemStack.EMPTY;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\gui\MCH_ConfigGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */