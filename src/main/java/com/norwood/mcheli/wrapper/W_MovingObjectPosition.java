/*    */ package com.norwood.mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.util.math.Direction;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.hit.BlockHitResult;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ public class W_MovingObjectPosition
/*    */ {
/*    */   public static boolean isHitTypeEntity(BlockHitResult m) {
/* 11 */     return (m != null && m.typeOfHit == BlockHitResult.Type.ENTITY);
/*    */   }
/*    */   
/*    */   public static boolean isHitTypeTile(BlockHitResult m) {
/* 15 */     return (m != null && m.typeOfHit == BlockHitResult.Type.BLOCK);
/*    */   }
/*    */   
/*    */   public static BlockHitResult newMOP(int p1, int p2, int p3, int p4, Vec3d p5, boolean p6) {
/* 19 */     return new BlockHitResult(p5, Direction.getFront(p4), new BlockPos(p1, p2, p3));
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\wrapper\W_MovingObjectPosition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */