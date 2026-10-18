/*     */ package com.norwood.mcheli.block;
/*     */ import com.norwood.mcheli.MCH_Lib;
/*     */ import com.norwood.mcheli.MCH_MOD;
/*     */ import com.norwood.mcheli.helper.block.EnumDirection8;
/*     */ import com.norwood.mcheli.helper.block.properties.PropertyDirection8;
/*     */ import com.norwood.mcheli.wrapper.W_BlockContainer;
/*     */ import com.norwood.mcheli.wrapper.W_Item;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockEntityProvider;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.enums.PushResult;
/*     */ import net.minecraft.block.MapColor;
/*     */ import net.minecraft.state.property.Property;
/*     */ import net.minecraft.state.StateManager;
/*     */ import net.minecraft.block.BlockState;
/*     */ import net.minecraft.entity.LivingEntity;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.sound.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.block.entity.BlockEntity;
/*     */ import net.minecraft.util.math.Direction;
/*     */ import net.minecraft.util.Hand;
/*     */ import net.minecraft.sound.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.BlockView;
/*     */ import net.minecraft.world.World;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class MCH_DraftingTableBlock extends W_BlockContainer implements BlockEntityProvider {
/*  32 */   public static final PropertyDirection8 DIRECTION8 = PropertyDirection8.create("direction8");
/*     */   private final boolean isLighting;
/*     */   
/*     */   public MCH_DraftingTableBlock(int blockId, boolean isOn) {
/*  36 */     super(blockId, MapColor.IRON);
/*  37 */     setDefaultState(this.blockState.getBaseState().withProperty((Property)DIRECTION8, (Comparable)EnumDirection8.NORTH));
/*  38 */     setSoundType(SoundType.METAL);
/*  39 */     setHardness(0.2F);
/*  40 */     this.isLighting = isOn;
/*  41 */     if (isOn) {
/*  42 */       setLightLevel(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World world, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull PlayerEntity player, @NotNull Hand hand, @NotNull Direction facing, float par7, float par8, float par9) {
/*  49 */     if (!world.isRemote) {
/*  50 */       if (!player.isSneaking()) {
/*  51 */         MCH_Lib.DbgLog(player.world, "MCH_DraftingTableGui.MCH_DraftingTableGui OPEN GUI (%d, %d, %d)", new Object[] {
/*     */ 
/*     */               
/*  54 */               Integer.valueOf(pos.getX()), 
/*  55 */               Integer.valueOf(pos.getY()), 
/*  56 */               Integer.valueOf(pos.getZ())
/*     */             });
/*  58 */         player.openGui(MCH_MOD.instance, 4, world, pos.getX(), pos.getY(), pos.getZ());
/*     */       } else {
/*  60 */         EnumDirection8 dir = (EnumDirection8)state.getValue((Property)DIRECTION8);
/*  61 */         MCH_Lib.DbgLog(world, "MCH_DraftingTableBlock.onBlockActivated:yaw=%d Light %s", new Object[] { Integer.valueOf((int)dir.getAngle()), this.isLighting ? "OFF->ON" : "ON->OFF" });
/*  62 */         if (this.isLighting) {
/*  63 */           world.setBlockState(pos, MCH_MOD.blockDraftingTable.getDefaultState().withProperty((Property)DIRECTION8, (Comparable)dir), 2);
/*     */         } else {
/*  65 */           world.setBlockState(pos, MCH_MOD.blockDraftingTableLit.getDefaultState().withProperty((Property)DIRECTION8, (Comparable)dir), 2);
/*     */         } 
/*     */         
/*  68 */         world.playSound(null, pos, SoundEvents.UI_BUTTON_CLICK, SoundCategory.BLOCKS, 0.3F, 0.5F);
/*     */       } 
/*     */     }
/*     */     
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public BlockEntity createNewTileEntity(@NotNull World world, int a) {
/*  76 */     return new MCH_DraftingTableTileEntity();
/*     */   }
/*     */   
/*     */   public BlockEntity createNewTileEntity(World world) {
/*  80 */     return new MCH_DraftingTableTileEntity();
/*     */   }
/*     */   
/*     */   public boolean shouldCheckWeakPower(@NotNull BlockState state, @NotNull BlockView world, @NotNull BlockPos pos, @NotNull Direction side) {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isFullCube(BlockState state) {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isOpaqueCube(BlockState state) {
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(@NotNull BlockView world, @NotNull BlockPos pos, @NotNull PlayerEntity player) {
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canRenderInPass(int pass) {
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public PushResult getMobilityFlag(BlockState state) {
/* 104 */     return PushResult.DESTROY;
/*     */   }
/*     */   
/*     */   public BlockState getStateForPlacement(World worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {
/* 108 */     return getDefaultState().withProperty((Property)DIRECTION8, (Comparable)EnumDirection8.fromAngle(MCH_Lib.getRotate360(placer.rotationYaw)));
/*     */   }
/*     */   
/*     */   public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack itemStack) {
/* 112 */     float pyaw = (float)MCH_Lib.getRotate360(entity.rotationYaw);
/* 113 */     pyaw += 22.5F;
/* 114 */     int yaw = (int)(pyaw / 45.0F);
/* 115 */     if (yaw < 0) {
/* 116 */       yaw = yaw % 8 + 8;
/*     */     }
/*     */     
/* 119 */     world.setBlockState(pos, state.withProperty((Property)DIRECTION8, (Comparable)EnumDirection8.fromAngle(MCH_Lib.getRotate360(entity.rotationYaw))), 2);
/* 120 */     MCH_Lib.DbgLog(world, "MCH_DraftingTableBlock.onBlockPlacedBy:yaw=%d", new Object[] { Integer.valueOf(yaw) });
/*     */   }
/*     */   
/*     */   public boolean getUseNeighborBrightness(BlockState state) {
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public Item getItemDropped(BlockState state, Random rand, int fortune) {
/* 128 */     return W_Item.getItemFromBlock((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, BlockState state) {
/* 132 */     return new ItemStack((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */   
/*     */   protected ItemStack createStackedBlock(int meta) {
/* 136 */     return new ItemStack((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */   
/*     */   public int getMetaFromState(BlockState state) {
/* 140 */     return ((EnumDirection8)state.getValue((Property)DIRECTION8)).getIndex();
/*     */   }
/*     */   
/*     */   public BlockState getStateFromMeta(int meta) {
/* 144 */     return getDefaultState().withProperty((Property)DIRECTION8, (Comparable)EnumDirection8.getFront(meta));
/*     */   }
/*     */   
/*     */   protected StateManager createBlockState() {
/* 148 */     return new StateManager((Block)this, new Property[] { (Property)DIRECTION8 });
/*     */   }
/*     */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\block\MCH_DraftingTableBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */