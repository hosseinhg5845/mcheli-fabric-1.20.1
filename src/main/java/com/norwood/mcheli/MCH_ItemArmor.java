/*    */ package com.norwood.mcheli;
/*    */ 
/*    */ import com.norwood.mcheli.wrapper.W_ItemArmor;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.render.entity.model.BipedEntityModel;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.EquipmentSlot;
/*    */ import net.minecraft.item.ItemStack;


/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_ItemArmor
/*    */   extends W_ItemArmor {
/*    */   public static final String HELMET_TEXTURE = "mcheli:textures/helicopters/ah-64.png";
/*    */   public static final String CHESTPLATE_TEXTURE = "mcheli:textures/armor/plate.png";
/*    */   public static final String LEGGINGS_TEXTURE = "mcheli:textures/armor/leg.png";
/*    */   public static final String BOOTS_TEXTURE = "mcheli:textures/armor/boots.png";
/* 20 */   public static MCH_TEST_ModelBiped model = null;
/*    */   
/*    */   public MCH_ItemArmor(int par1, int par3, int par4) {
/* 23 */     super(par1, par3, par4);
/*    */   }
/*    */   
/*    */   public String getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, @NotNull String type) {
/* 27 */     if (slot == EquipmentSlot.HEAD)
/* 28 */       return "mcheli:textures/helicopters/ah-64.png"; 
/* 29 */     if (slot == EquipmentSlot.CHEST)
/* 30 */       return "mcheli:textures/armor/plate.png"; 
/* 31 */     if (slot == EquipmentSlot.LEGS) {
/* 32 */       return "mcheli:textures/armor/leg.png";
/*    */     }
/* 34 */     return (slot == EquipmentSlot.FEET) ? "mcheli:textures/armor/boots.png" : "none";
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   /*    */   public BipedEntityModel getArmorModel(@NotNull LivingEntity entityLiving, @NotNull ItemStack itemStack, @NotNull EquipmentSlot armorSlot, @NotNull BipedEntityModel _default) {
/* 41 */     if (model == null) {
/* 42 */       model = new MCH_TEST_ModelBiped();
/*    */     }
/*    */     
/* 45 */     return (armorSlot == EquipmentSlot.HEAD) ? model : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\MCH_ItemArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */