/*     */ package com.norwood.mcheli.tool;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.norwood.mcheli.MCH_MOD;
/*     */ import com.norwood.mcheli.aircraft.MCH_EntityAircraft;
/*     */ import com.norwood.mcheli.aircraft.MCH_EntitySeat;
/*     */ import com.norwood.mcheli.wrapper.W_Item;
/*     */ import com.norwood.mcheli.wrapper.W_WorldFunc;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.MapColor;
/*     */ import net.minecraft.block.BlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.LivingEntity;
/*     */ import net.minecraft.entity.attribute.EntityAttributes;
/*     */ import net.minecraft.entity.attribute.EntityAttributeModifier;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.entity.EquipmentSlot;
/*     */ import net.minecraft.util.UseAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NbtCompound;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.Hand;
/*     */ import net.minecraft.util.math.Box;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.hit.BlockHitResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;

/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class MCH_ItemWrench
/*     */   extends W_Item {
/*  38 */   private static final Random rand = new Random();
/*     */   private final Item.ToolMaterial toolMaterial;
/*     */   private final float damageVsEntity;
/*     */   
/*     */   public MCH_ItemWrench(int itemId, Item.ToolMaterial material) {
/*  43 */     super(itemId);
/*  44 */     this.toolMaterial = material;
/*  45 */     this.maxStackSize = 1;
/*  46 */     setMaxDamage(material.getMaxUses());
/*  47 */     this.damageVsEntity = 4.0F + material.getAttackDamage();
/*     */   }
/*     */   
/*     */   public static float getUseAnimSmooth(ItemStack stack, float partialTicks) {
/*  51 */     int i = Math.abs(getUseAnimCount(stack) - 8);
/*  52 */     int j = Math.abs(getUseAnimPrevCount(stack) - 8);
/*  53 */     return j + (i - j) * partialTicks;
/*     */   }
/*     */   
/*     */   public static int getUseAnimPrevCount(ItemStack stack) {
/*  57 */     return getAnimCount(stack, "MCH_WrenchAnimPrev");
/*     */   }
/*     */   
/*     */   public static int getUseAnimCount(ItemStack stack) {
/*  61 */     return getAnimCount(stack, "MCH_WrenchAnim");
/*     */   }
/*     */   
/*     */   public static void setUseAnimCount(ItemStack stack, int n, int prev) {
/*  65 */     setAnimCount(stack, "MCH_WrenchAnim", n);
/*  66 */     setAnimCount(stack, "MCH_WrenchAnimPrev", prev);
/*     */   }
/*     */   
/*     */   public static int getAnimCount(ItemStack stack, String name) {
/*  70 */     if (!stack.hasTagCompound()) {
/*  71 */       stack.setTagCompound(new NbtCompound());
/*     */     }
/*     */     
/*  74 */     if (stack.getTagCompound().hasKey(name)) {
/*  75 */       return stack.getTagCompound().getInteger(name);
/*     */     }
/*  77 */     stack.getTagCompound().setInteger(name, 0);
/*  78 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setAnimCount(ItemStack stack, String name, int n) {
/*  83 */     if (!stack.hasTagCompound()) {
/*  84 */       stack.setTagCompound(new NbtCompound());
/*     */     }
/*     */     
/*  87 */     stack.getTagCompound().setInteger(name, n);
/*     */   }
/*     */   
/*     */   private static BlockHitResult rayTrace(LivingEntity entity, double dist, float tick) {
/*  91 */     Vec3d vec3 = new Vec3d(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ);
/*  92 */     Vec3d vec31 = entity.getLook(tick);
/*  93 */     Vec3d vec32 = vec3.addVector(vec31.x * dist, vec31.y * dist, vec31.z * dist);
/*  94 */     return entity.world.rayTraceBlocks(vec3, vec32, false, false, true);
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(BlockState blockIn) {
/*  98 */     MapColor material = blockIn.getMaterial();
/*  99 */     return (material == MapColor.IRON || material instanceof net.minecraft.block.MapColorLogic);
/*     */   }
/*     */   
/*     */   public float getDestroySpeed(@NotNull ItemStack stack, BlockState state) {
/* 103 */     MapColor material = state.getMaterial();
/* 104 */     if (material == MapColor.IRON) {
/* 105 */       return 20.5F;
/*     */     }
/* 107 */     return (material instanceof net.minecraft.block.MapColorLogic) ? 5.5F : 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hitEntity(@NotNull ItemStack itemStack, @NotNull LivingEntity entity, LivingEntity player) {
/* 112 */     if (!player.world.isRemote) {
/* 113 */       if (rand.nextInt(40) == 0) {
/* 114 */         entity.entityDropItem(new ItemStack(W_Item.getItemByName("iron_ingot"), 1, 0), 0.0F);
/* 115 */       } else if (rand.nextInt(20) == 0) {
/* 116 */         entity.entityDropItem(new ItemStack(W_Item.getItemByName("gunpowder"), 1, 0), 0.0F);
/*     */       } 
/*     */     }
/*     */     
/* 120 */     itemStack.damageItem(2, player);
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   public void onPlayerStoppedUsing(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull LivingEntity entityLiving, int timeLeft) {
/* 125 */     setUseAnimCount(stack, 0, 0);
/*     */   }
/*     */   
/*     */   public void onUsingTick(@NotNull ItemStack stack, LivingEntity player, int count) {
/* 129 */     if (player.world.isRemote) {
/* 130 */       MCH_EntityAircraft ac = getMouseOverAircraft(player);
/* 131 */       if (ac != null) {
/* 132 */         int cnt = getUseAnimCount(stack);
/* 133 */         int prev = cnt;
/* 134 */         if (cnt <= 0) {
/* 135 */           cnt = 16;
/*     */         } else {
/* 137 */           cnt--;
/*     */         } 
/*     */         
/* 140 */         setUseAnimCount(stack, cnt, prev);
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     if (!player.world.isRemote && count < getMaxItemUseDuration(stack) && count % 20 == 0) {
/* 145 */       MCH_EntityAircraft ac = getMouseOverAircraft(player);
/* 146 */       if (ac != null && ac.getHP() > 0 && ac.repair(10)) {
/* 147 */         stack.damageItem(1, player);
/* 148 */         W_WorldFunc.MOD_playSoundEffect(player.world, (int)ac.posX, (int)ac.posY, (int)ac.posZ, "wrench", 1.0F, 0.9F + rand.nextFloat() * 0.2F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onUpdate(@NotNull ItemStack item, @NotNull World world, @NotNull Entity entity, int n, boolean b) {
/* 154 */     if (entity instanceof PlayerEntity) { PlayerEntity player = (PlayerEntity)entity;
/* 155 */       ItemStack itemStack = player.getHeldItemMainhand();
/* 156 */       if (itemStack == item) {
/* 157 */         MCH_MOD.proxy.setCreativeDigDelay(0);
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public MCH_EntityAircraft getMouseOverAircraft(LivingEntity entity) {
/* 163 */     BlockHitResult m = getMouseOver(entity, 1.0F);
/* 164 */     MCH_EntityAircraft ac = null;
/* 165 */     if (m != null) {
/* 166 */       if (m.entityHit instanceof MCH_EntityAircraft)
/* 167 */       { ac = (MCH_EntityAircraft)m.entityHit; }
/* 168 */       else { Entity entity1 = m.entityHit; if (entity1 instanceof MCH_EntitySeat) { MCH_EntitySeat seat = (MCH_EntitySeat)entity1;
/* 169 */           if (seat.getParent() != null) {
/* 170 */             ac = seat.getParent();
/*     */           } }
/*     */          }
/*     */     
/*     */     }
/* 175 */     return ac;
/*     */   }
/*     */ 
/*     */   
/*     */   private BlockHitResult getMouseOver(LivingEntity user, float tick) {
/* 180 */     double d0 = 4.0D;
/* 181 */     BlockHitResult objectMouseOver = rayTrace(user, d0, tick);
/* 182 */     double d1 = d0;
/* 183 */     Vec3d vec3 = new Vec3d(user.posX, user.posY + user.getEyeHeight(), user.posZ);
/* 184 */     if (objectMouseOver != null) {
/* 185 */       d1 = objectMouseOver.hitVec.distanceTo(vec3);
/*     */     }
/*     */     
/* 188 */     Vec3d vec31 = user.getLook(tick);
/* 189 */     Vec3d vec32 = vec3.addVector(vec31.x * d0, vec31.y * d0, vec31.z * d0);
/* 190 */     Entity pointedEntity = null;
/* 191 */     Vec3d vec33 = null;
/* 192 */     float f1 = 1.0F;
/*     */     
/* 194 */     List<Entity> list = user.world.getEntitiesWithinAABBExcludingEntity((Entity)user, user.getEntityBoundingBox().expand(vec31.x * d0, vec31.y * d0, vec31.z * d0).grow(f1, f1, f1));
/* 195 */     double d2 = d1;
/*     */     
/* 197 */     for (Entity entity : list) {
/* 198 */       if (entity.canBeCollidedWith()) {
/* 199 */         float f2 = entity.getCollisionBorderSize();
/* 200 */         Box axisalignedbb = entity.getEntityBoundingBox().grow(f2, f2, f2);
/* 201 */         BlockHitResult movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
/* 202 */         if (axisalignedbb.contains(vec3)) {
/* 203 */           if (0.0D < d2 || d2 == 0.0D) {
/* 204 */             pointedEntity = entity;
/* 205 */             vec33 = (movingobjectposition == null) ? vec3 : movingobjectposition.hitVec;
/* 206 */             d2 = 0.0D;
/*     */           }  continue;
/* 208 */         }  if (movingobjectposition != null) {
/* 209 */           double d3 = vec3.distanceTo(movingobjectposition.hitVec);
/* 210 */           if (d3 < d2 || d2 == 0.0D) {
/* 211 */             if (entity != user.getRidingEntity() || entity.canRiderInteract()) {
/* 212 */               pointedEntity = entity;
/* 213 */               vec33 = movingobjectposition.hitVec;
/* 214 */               d2 = d3; continue;
/* 215 */             }  if (d2 == 0.0D) {
/* 216 */               pointedEntity = entity;
/* 217 */               vec33 = movingobjectposition.hitVec;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     if (pointedEntity != null && (d2 < d1 || objectMouseOver == null)) {
/* 225 */       objectMouseOver = new BlockHitResult(pointedEntity, vec33);
/*     */     }
/*     */     
/* 228 */     return objectMouseOver;
/*     */   }
/*     */   
/*     */   public boolean onBlockDestroyed(@NotNull ItemStack itemStack, @NotNull World world, BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
/* 232 */     if (state.getBlockHardness(world, pos) != 0.0D) {
/* 233 */       itemStack.damageItem(2, entity);
/*     */     }
/*     */     
/* 236 */     return true;
/*     */   }
/*     */   
/*     */   /*     */   public boolean isFull3D() {
/* 241 */     return true;
/*     */   }
/*     */   @NotNull
/*     */   public UseAction getItemUseAction(@NotNull ItemStack itemStack) {
/* 245 */     return UseAction.BLOCK;
/*     */   }
/*     */   
/*     */   public int getMaxItemUseDuration(@NotNull ItemStack itemStack) {
/* 249 */     return 72000;
/*     */   }
/*     */   @NotNull
/*     */   public ActionResult<ItemStack> onItemRightClick(@NotNull World world, PlayerEntity player, @NotNull Hand handIn) {
/* 253 */     player.setActiveHand(handIn);
/* 254 */     return ActionResult.newResult(ActionResult.SUCCESS, player.getHeldItem(handIn));
/*     */   }
/*     */   
/*     */   public int getItemEnchantability() {
/* 258 */     return this.toolMaterial.getEnchantability();
/*     */   }
/*     */   
/*     */   public String getToolMaterialName() {
/* 262 */     return this.toolMaterial.toString();
/*     */   }
/*     */   
/*     */   public boolean getIsRepairable(@NotNull ItemStack item1, @NotNull ItemStack item2) {
/* 266 */     ItemStack mat = this.toolMaterial.getRepairItemStack();
/* 267 */     return ((!mat.isEmpty() && OreDictionary.itemMatches(mat, item2, false)) || super.getIsRepairable(item1, item2));
/*     */   }
/*     */   @NotNull
/*     */   public Multimap<String, EntityAttributeModifier> getItemAttributeModifiers(@NotNull EquipmentSlot equipmentSlot) {
/* 271 */     Multimap<String, EntityAttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
/* 272 */     if (equipmentSlot == EquipmentSlot.MAINHAND) {
/* 273 */       multimap.put(EntityAttributes.ATTACK_DAMAGE.getName(), new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damageVsEntity, 0));
/*     */     }
/*     */     
/* 276 */     return multimap;
/*     */   }
/*     */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\tool\MCH_ItemWrench.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */