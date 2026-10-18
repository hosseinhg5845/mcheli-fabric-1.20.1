/*    */ package com.norwood.mcheli.helper.client;
/*    */ 
/*    */ import com.norwood.mcheli.MCH_ViewEntityDummy;
/*    */ import com.norwood.mcheli.aircraft.MCH_EntityAircraft;
/*    */ import com.norwood.mcheli.tool.rangefinder.MCH_ItemRangeFinder;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ import net.minecraft.world.World;


/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "mcheli", value = {Side.CLIENT})
/*    */ public class MCH_CameraManager
/*    */ {
/*    */   private static final float DEF_THIRD_CAMERA_DIST = 4.0F;
/* 23 */   private static final Minecraft mc = Minecraft.getMinecraft();
/* 24 */   private static float cameraRoll = 0.0F;
/* 25 */   private static float cameraDistance = 4.0F;
/* 26 */   private static float cameraZoom = 1.0F;
/* 27 */   private static MCH_EntityAircraft ridingAircraft = null;
/*    */   
/*    */   @Event/*    */   static void onCameraSetupEvent(EntityViewRenderEvent.CameraSetup event) {
/* 31 */     float f = event.getEntity().getEyeHeight();
/* 32 */     if (mc.gameSettings.thirdPersonView > 0) {
/* 33 */       if (mc.gameSettings.thirdPersonView == 2) {
/* 34 */         RenderSystem.rotate(180.0F, 0.0F, 1.0F, 0.0F);
/*    */       }
/*    */       
/* 37 */       RenderSystem.translate(0.0F, 0.0F, -(cameraDistance - 4.0F));
/* 38 */       if (mc.gameSettings.thirdPersonView == 2) {
/* 39 */         RenderSystem.rotate(-180.0F, 0.0F, 1.0F, 0.0F);
/*    */       }
/*    */     } 
/*    */     
/* 43 */     MCH_EntityAircraft ridingEntity = ridingAircraft;
/* 44 */     if (ridingEntity != null && ridingEntity.canSwitchFreeLook() && ridingEntity.isPilot((Entity)mc.player)) {
/* 45 */       RenderSystem.translate(0.0F, -f, 0.0F);
/* 46 */       RenderSystem.rotate(cameraRoll, 0.0F, 0.0F, 1.0F);
/* 47 */       if (ridingEntity.isOverridePlayerPitch()) {
/* 48 */         RenderSystem.rotate(ridingEntity.rotationPitch, 1.0F, 0.0F, 0.0F);
/* 49 */         RenderSystem.rotate(ridingEntity.rotationYaw, 0.0F, 1.0F, 0.0F);
/* 50 */         event.setPitch(event.getPitch() - ridingEntity.rotationPitch);
/* 51 */         event.setYaw(event.getYaw() - ridingEntity.rotationYaw);
/*    */       } 
/*    */       
/* 54 */       RenderSystem.translate(0.0F, f, 0.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Event/*    */   static void onFOVModifierEvent(EntityViewRenderEvent.FOVModifier event) {
/* 60 */     MCH_ViewEntityDummy viewer = MCH_ViewEntityDummy.getInstance((World)mc.world);
/* 61 */     if (viewer == event.getEntity() || MCH_ItemRangeFinder.isUsingScope((PlayerEntity)mc.player)) {
/* 62 */       event.setFOV(event.getFOV() * 1.0F / cameraZoom);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void setCameraRoll(float roll) {
/* 67 */     roll = MathHelper.wrapDegrees(roll);
/* 68 */     cameraRoll = roll;
/*    */   }
/*    */   
/*    */   public static void setCameraZoom(float zoom) {
/* 72 */     cameraZoom = zoom;
/*    */   }
/*    */   
/*    */   public static float getThirdPeasonCameraDistance() {
/* 76 */     return cameraDistance;
/*    */   }
/*    */   
/*    */   public static void setThirdPeasonCameraDistance(float distance) {
/* 80 */     distance = MathHelper.clamp(distance, 4.0F, 60.0F);
/* 81 */     cameraDistance = distance;
/*    */   }
/*    */   
/*    */   public static void setRidingAircraft(@Nullable MCH_EntityAircraft aircraft) {
/* 85 */     ridingAircraft = aircraft;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\MCH_CameraManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */