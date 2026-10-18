/*    */ package com.norwood.mcheli.helper;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import com.norwood.mcheli.MCH_ItemRecipe;
/*    */ import java.util.Set;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.recipe.Recipe;
/*    */ import net.minecraft.recipe.Ingredient;
/*    */ import net.minecraft.recipe.ShapedRecipe;



/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "mcheli")
/*    */ public class MCH_Recipes
/*    */ {
/* 22 */   private static final Set<Recipe> registryWrapper = Sets.newLinkedHashSet();
/*    */   
/*    */   @Event/*    */   static void onRecipeRegisterEvent(RegistryEvent.Register<Recipe> event) {
/* 26 */     MCH_ItemRecipe.registerItemRecipe(event.getRegistry());
/*    */     
/* 28 */     for (Recipe recipe : registryWrapper) {
/* 29 */       event.getRegistry().register(recipe);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void register(String name, Recipe recipe) {
/* 34 */     registryWrapper.add((Recipe)recipe.setRegistryName(MCH_Utils.suffix(name)));
/*    */   }
/*    */   
/*    */   public static ShapedRecipe addShapedRecipe(String name, ItemStack output, Object... params) {
/* 38 */     CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(params);
/* 39 */     ShapedRecipe recipe = new ShapedRecipe("", primer.width, primer.height, primer.input, output);
/* 40 */     register(name, (Recipe)recipe);
/* 41 */     return recipe;
/*    */   }
/*    */   
/*    */   public static boolean canCraft(PlayerEntity player, Recipe recipe) {
/* 45 */     for (Ingredient ingredient : recipe.getIngredients()) {
/* 46 */       if (ingredient != Ingredient.EMPTY) {
/* 47 */         boolean flag = false;
/*    */         
/* 49 */         for (ItemStack itemstack : player.inventory.mainInventory) {
/* 50 */           if (ingredient.apply(itemstack)) {
/* 51 */             flag = true;
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/* 56 */         if (!flag) {
/* 57 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean consumeInventory(PlayerEntity player, Recipe recipe) {
/* 66 */     for (Ingredient ingredient : recipe.getIngredients()) {
/* 67 */       if (ingredient != Ingredient.EMPTY) {
/* 68 */         int i = 0;
/* 69 */         boolean flag = false;
/*    */         
/* 71 */         for (ItemStack itemstack : player.inventory.mainInventory) {
/* 72 */           if (ingredient.apply(itemstack)) {
/* 73 */             player.inventory.decrStackSize(i, 1);
/* 74 */             flag = true;
/*    */             
/*    */             break;
/*    */           } 
/* 78 */           i++;
/*    */         } 
/*    */         
/* 81 */         if (!flag) {
/* 82 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\MCH_Recipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */