/*    */ package com.norwood.mcheli.aircraft;
/*    */ 
/*    */ import com.norwood.mcheli.wrapper.W_Item;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.Hand;
/*    */ import net.minecraft.util.collection.DefaultedList;
/*    */ import net.minecraft.world.World;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ItemFuel
/*    */   extends W_Item
/*    */ {
/*    */   public MCH_ItemFuel(int itemID) {
/* 17 */     super(itemID);
/* 18 */     setMaxDamage(600);
/* 19 */     setMaxStackSize(1);
/* 20 */     setNoRepair();
/* 21 */     setFull3D();
/*    */   }
/*    */   @NotNull
/*    */   public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, @NotNull Hand handIn) {
/* 25 */     ItemStack stack = player.getHeldItem(handIn);
/* 26 */     if (!world.isRemote && stack.isItemDamaged() && !player.capabilities.isCreativeMode) {
/* 27 */       refuel(stack, player, 1);
/* 28 */       refuel(stack, player, 0);
/* 29 */       return new ActionResult(ActionResult.SUCCESS, stack);
/*    */     } 
/* 31 */     return new ActionResult(ActionResult.PASS, stack);
/*    */   }
/*    */ 
/*    */   
/*    */   private void refuel(ItemStack stack, PlayerEntity player, int coalType) {
/* 36 */     DefaultedList<ItemStack> nonNullList = player.inventory.mainInventory;
/*    */     
/* 38 */     for (int i = 0; i < nonNullList.size(); i++) {
/* 39 */       ItemStack is = nonNullList.get(i);
/* 40 */       if (!is.isEmpty() && is.getItem() instanceof net.minecraft.item.ItemCoal && is.getMetadata() == coalType) {
/* 41 */         for (int j = 0; is.getCount() > 0 && stack.isItemDamaged() && j < 64; j++) {
/* 42 */           int damage = stack.getMetadata() - ((coalType == 1) ? 75 : 100);
/* 43 */           if (damage < 0) {
/* 44 */             damage = 0;
/*    */           }
/*    */           
/* 47 */           stack.setItemDamage(damage);
/* 48 */           is.shrink(1);
/*    */         } 
/*    */         
/* 51 */         if (is.getCount() <= 0)
/* 52 */           nonNullList.set(i, ItemStack.EMPTY); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\aircraft\MCH_ItemFuel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */