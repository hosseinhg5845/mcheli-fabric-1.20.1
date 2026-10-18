/*    */ package com.norwood.mcheli.aircraft;
/*    */ 
/*    */ import com.norwood.mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.nbt.NbtCompound;
/*    */ import net.minecraft.entity.damage.DamageSource;
/*    */ import net.minecraft.util.Hand;
/*    */ import net.minecraft.util.math.Box;
/*    */ import net.minecraft.world.World;


/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class MCH_EntityHitBox extends W_Entity {
/*    */   public MCH_EntityAircraft parent;
/*    */   public int debugId;
/*    */   
/*    */   public MCH_EntityHitBox(World world) {
/* 20 */     super(world);
/* 21 */     setSize(1.0F, 1.0F);
/* 22 */     this.motionX = 0.0D;
/* 23 */     this.motionY = 0.0D;
/* 24 */     this.motionZ = 0.0D;
/* 25 */     this.parent = null;
/* 26 */     this.ignoreFrustumCheck = true;
/* 27 */     this.isImmuneToFire = true;
/*    */   }
/*    */   
/*    */   public MCH_EntityHitBox(World world, MCH_EntityAircraft ac, float w, float h) {
/* 31 */     this(world);
/* 32 */     setPosition(ac.posX, ac.posY + 1.0D, ac.posZ);
/* 33 */     this.prevPosX = ac.posX;
/* 34 */     this.prevPosY = ac.posY + 1.0D;
/* 35 */     this.prevPosZ = ac.posZ;
/* 36 */     this.parent = ac;
/* 37 */     setSize(w, h);
/*    */   }
/*    */   
/*    */   protected boolean canTriggerWalking() {
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public Box getCollisionBox(Entity par1Entity) {
/* 45 */     return par1Entity.getEntityBoundingBox();
/*    */   }
/*    */   
/*    */   public Box getCollisionBoundingBox() {
/* 49 */     return getEntityBoundingBox();
/*    */   }
/*    */   
/*    */   public double getMountedYOffset() {
/* 53 */     return -0.3D;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 58 */     return (this.parent != null && this.parent.attackEntityFrom(par1DamageSource, par2));
/*    */   }
/*    */   
/*    */   public boolean canBeCollidedWith() {
/* 62 */     return !this.isDead;
/*    */   }
/*    */   
/*    */   public void setDead() {
/* 66 */     super.setDead();
/*    */   }
/*    */   
/*    */   public void onUpdate() {
/* 70 */     super.onUpdate();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeEntityToNBT(@NotNull NbtCompound par1NBTTagCompound) {}
/*    */ 
/*    */   
/*    */   protected void readEntityFromNBT(@NotNull NbtCompound par1NBTTagCompound) {}
/*    */   
/*    */   /*    */   public float getShadowSize() {
/* 81 */     return 0.0F;
/*    */   }
/*    */   
/*    */   public boolean processInitialInteract(@NotNull PlayerEntity player, @NotNull Hand hand) {
/* 85 */     return (this.parent != null && this.parent.processInitialInteract(player, hand));
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\aircraft\MCH_EntityHitBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */