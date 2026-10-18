/*    */ package com.norwood.mcheli.uav;
/*    */ 
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.entity.player.PlayerInventory;
/*    */ import net.minecraft.screen.ScreenHandler;
/*    */ import net.minecraft.inventory.Inventory;
/*    */ import net.minecraft.screen.slot.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ContainerUavStation extends ScreenHandler {
/*    */   protected final MCH_EntityUavStation uavStation;
/*    */   
/*    */   public MCH_ContainerUavStation(PlayerInventory inventoryPlayer, MCH_EntityUavStation te) {
/* 15 */     this.uavStation = te;
/* 16 */     addSlotToContainer(new Slot((Inventory)this.uavStation, 0, 20, 20));
/* 17 */     bindPlayerInventory(inventoryPlayer);
/*    */   }
/*    */   
/*    */   public boolean canInteractWith(@NotNull PlayerEntity player) {
/* 21 */     return this.uavStation.isUsableByPlayer(player);
/*    */   }
/*    */   
/*    */   public void onCraftMatrixChanged(@NotNull Inventory par1IInventory) {
/* 25 */     super.onCraftMatrixChanged(par1IInventory);
/*    */   }
/*    */   protected void bindPlayerInventory(PlayerInventory inventoryPlayer) {
/*    */     int i;
/* 29 */     for (i = 0; i < 3; i++) {
/* 30 */       for (int j = 0; j < 9; j++) {
/* 31 */         addSlotToContainer(new Slot((Inventory)inventoryPlayer, 9 + j + i * 9, 8 + j * 18, 84 + i * 18));
/*    */       }
/*    */     } 
/*    */     
/* 35 */     for (i = 0; i < 9; i++)
/* 36 */       addSlotToContainer(new Slot((Inventory)inventoryPlayer, i, 8 + i * 18, 142)); 
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ItemStack transferStackInSlot(@NotNull PlayerEntity player, int slot) {
/* 41 */     return ItemStack.EMPTY;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mchel\\uav\MCH_ContainerUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */