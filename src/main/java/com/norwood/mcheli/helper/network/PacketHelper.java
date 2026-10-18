/*    */ package com.norwood.mcheli.helper.network;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import io.netty.handler.codec.EncoderException;
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.recipe.Recipe;
/*    */ import net.minecraft.nbt.NbtIo;
/*    */ import net.minecraft.nbt.NbtSizeValidator;
/*    */ import net.minecraft.nbt.NbtCompound;
/*    */ import net.minecraft.util.ResourceLocation;

/*    */ 
/*    */ public class PacketHelper {
/*    */   public static void writeCompoundTag(DataOutputStream dos, @Nullable NbtCompound nbt) throws IOException {
/* 20 */     if (nbt == null) {
/* 21 */       dos.writeByte(0);
/*    */     } else {
/* 23 */       dos.writeByte(1);
/*    */       
/*    */       try {
/* 26 */         NbtIo.write(nbt, dos);
/* 27 */       } catch (IOException var3) {
/* 28 */         throw new EncoderException(var3);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static NbtCompound readCompoundTag(ByteArrayDataInput data) {
/* 35 */     byte b0 = data.readByte();
/* 36 */     if (b0 == 0) {
/* 37 */       return null;
/*    */     }
/*    */     try {
/* 40 */       return NbtIo.read((DataInput)data, new NbtSizeValidator(2097152L));
/* 41 */     } catch (IOException var3) {
/* 42 */       throw new EncoderException(var3);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void writeItemStack(DataOutputStream dos, ItemStack itemstack) throws IOException {
/* 48 */     if (itemstack.isEmpty()) {
/* 49 */       dos.writeShort(-1);
/*    */     } else {
/* 51 */       dos.writeShort(Item.getIdFromItem(itemstack.getItem()));
/* 52 */       dos.writeByte(itemstack.getCount());
/* 53 */       dos.writeShort(itemstack.getMetadata());
/* 54 */       NbtCompound nbttagcompound = null;
/* 55 */       if (itemstack.getItem().isDamageable() || itemstack.getItem().getShareTag()) {
/* 56 */         nbttagcompound = itemstack.getItem().getNBTShareTag(itemstack);
/*    */       }
/*    */       
/* 59 */       writeCompoundTag(dos, nbttagcompound);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ItemStack readItemStack(ByteArrayDataInput data) throws IOException {
/* 64 */     int i = data.readShort();
/* 65 */     if (i < 0) {
/* 66 */       return ItemStack.EMPTY;
/*    */     }
/* 68 */     int j = data.readByte();
/* 69 */     int k = data.readShort();
/* 70 */     ItemStack itemstack = new ItemStack(Item.getItemById(i), j, k);
/* 71 */     itemstack.getItem().readNBTShareTag(itemstack, readCompoundTag(data));
/* 72 */     return itemstack;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void writeRecipe(DataOutputStream dos, Recipe recipe) throws IOException {
/* 77 */     dos.writeUTF(recipe.getRegistryName().toString());
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static Recipe readRecipe(ByteArrayDataInput data) {
/* 82 */     return (Recipe)ForgeRegistries.RECIPES.getValue(new ResourceLocation(data.readUTF()));
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\network\PacketHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */