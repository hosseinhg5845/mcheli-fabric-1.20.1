/*    */ package com.norwood.mcheli.wrapper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.ItemEntity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.entity.player.PlayerEntityMP;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.text.Text;
/*    */ import net.minecraft.text.LiteralText;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class W_EntityPlayer extends PlayerEntity {
/*    */   public W_EntityPlayer(World par1World, PlayerEntity player) {
/* 14 */     super(par1World, player.getGameProfile());
/*    */   }
/*    */   
/*    */   public static void closeScreen(Entity p) {
/* 18 */     if (p != null) {
/* 19 */       if (p.world.isRemote) {
/* 20 */         W_EntityPlayerSP.closeScreen(p);
/* 21 */       } else if (p instanceof ServerPlayerEntity) {
/* 22 */         ((ServerPlayerEntity)p).closeScreen();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static boolean hasItem(PlayerEntity player, Item item) {
/* 28 */     return (item != null && player.inventory.hasItemStack(new ItemStack(item)));
/*    */   }
/*    */   
/*    */   public static boolean consumeInventoryItem(PlayerEntity player, Item item) {
/* 32 */     int index = player.inventory.findSlotMatchingUnusedItem(new ItemStack(item));
/* 33 */     return player.inventory.decrStackSize(index, 1).isEmpty();
/*    */   }
/*    */   
/*    */   public static void addChatMessage(PlayerEntity player, String s) {
/* 37 */     player.sendMessage((Text)new LiteralText(s));
/*    */   }
/*    */   
/*    */   public static ItemEntity dropPlayerItemWithRandomChoice(PlayerEntity player, ItemStack item, boolean b1, boolean b2) {
/* 41 */     return player.dropItem(item, b1, b2);
/*    */   }
/*    */   
/*    */   public static boolean isPlayer(Entity entity) {
/* 45 */     return entity instanceof PlayerEntity;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\wrapper\W_EntityPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */