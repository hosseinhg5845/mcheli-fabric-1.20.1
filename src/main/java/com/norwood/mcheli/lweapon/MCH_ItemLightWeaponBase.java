/*    */ package com.norwood.mcheli.lweapon;
/*    */ 
/*    */ import com.norwood.mcheli.wrapper.W_Item;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.entity.effect.StatusEffects;
/*    */ import net.minecraft.util.UseAction;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.entity.effect.StatusEffectEffect;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.Hand;
/*    */ import net.minecraft.world.World;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ItemLightWeaponBase
/*    */   extends W_Item {
/*    */   public final MCH_ItemLightWeaponBullet bullet;
/*    */   
/*    */   public MCH_ItemLightWeaponBase(int par1, MCH_ItemLightWeaponBullet bullet) {
/* 22 */     super(par1);
/* 23 */     setMaxDamage(10);
/* 24 */     setMaxStackSize(1);
/* 25 */     this.bullet = bullet;
/*    */   }
/*    */   
/*    */   public static String getName(ItemStack itemStack) {
/* 29 */     if (!itemStack.isEmpty() && itemStack.getItem() instanceof MCH_ItemLightWeaponBase) {
/* 30 */       String name = itemStack.getUnlocalizedName();
/* 31 */       int li = name.lastIndexOf(":");
/* 32 */       if (li >= 0) {
/* 33 */         name = name.substring(li + 1);
/*    */       }
/*    */       
/* 36 */       return name;
/*    */     } 
/* 38 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isHeld(@Nullable PlayerEntity player) {
/* 43 */     ItemStack is = (player != null) ? player.getHeldItemMainhand() : ItemStack.EMPTY;
/* 44 */     return (!is.isEmpty() && is.getItem() instanceof MCH_ItemLightWeaponBase && player.getItemInUseMaxCount() > 10);
/*    */   }
/*    */   
/*    */   public void onUsingTick(@NotNull ItemStack stack, LivingEntity player, int count) {
/* 48 */     StatusEffectInstance pe = player.getActivePotionEffect(StatusEffects.NIGHT_VISION);
/* 49 */     if (pe != null && pe.getDuration() < 220) {
/* 50 */       player.addPotionEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 250, 0, false, false));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean onEntitySwing(@NotNull LivingEntity entityLiving, @NotNull ItemStack stack) {
/* 55 */     return true;
/*    */   }
/*    */   @NotNull
/*    */   public UseAction getItemUseAction(@NotNull ItemStack par1ItemStack) {
/* 59 */     return UseAction.BOW;
/*    */   }
/*    */   
/*    */   public int getMaxItemUseDuration(@NotNull ItemStack par1ItemStack) {
/* 63 */     return 72000;
/*    */   }
/*    */   @NotNull
/*    */   public ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, PlayerEntity playerIn, @NotNull Hand handIn) {
/* 67 */     ItemStack itemstack = playerIn.getHeldItem(handIn);
/* 68 */     if (!itemstack.isEmpty()) {
/* 69 */       playerIn.setActiveHand(handIn);
/*    */     }
/*    */     
/* 72 */     return ActionResult.newResult(ActionResult.SUCCESS, itemstack);
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\lweapon\MCH_ItemLightWeaponBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */