/*    */ package com.norwood.mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.nbt.NbtCompound;
/*    */ import net.minecraft.nbt.NbtIntArray;
/*    */ import net.minecraft.nbt.NbtList;
/*    */ 
/*    */ public class W_NBTTag {
/*    */   public static final int TAG_COMPOUND = 10;
/*    */   
/*    */   public static NbtCompound tagAt(NbtList list, int i) {
/* 11 */     return (list != null) ? list.getCompoundTagAt(i) : null;
/*    */   }
/*    */   
/*    */   public static NbtList getTagList(NbtCompound nbt, String s, int i) {
/* 15 */     return nbt.getTagList(s, i);
/*    */   }
/*    */   
/*    */   public static NbtIntArray newTagIntArray(String s, int[] n) {
/* 19 */     return new NbtIntArray(n);
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\wrapper\W_NBTTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */