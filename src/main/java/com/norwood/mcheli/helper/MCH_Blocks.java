/*    */ package com.norwood.mcheli.helper;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;


/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "mcheli")
/*    */ public class MCH_Blocks
/*    */ {
/* 15 */   private static final Set<Block> registryWrapper = Sets.newLinkedHashSet();
/*    */   
/*    */   @Event/*    */   static void onBlockRegisterEvent(RegistryEvent.Register<Block> event) {
/* 19 */     for (Block block : registryWrapper) {
/* 20 */       event.getRegistry().register(block);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void register(Block block, String name) {
/* 25 */     registryWrapper.add((Block)block.setRegistryName(MCH_Utils.suffix(name)));
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\MCH_Blocks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */