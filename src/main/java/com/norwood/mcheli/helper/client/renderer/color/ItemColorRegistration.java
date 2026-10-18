/*    */ package com.norwood.mcheli.helper.client.renderer.color;
/*    */ 
/*    */ import com.norwood.mcheli.MCH_MOD;
/*    */ import com.norwood.mcheli.mob.MCH_ItemSpawnGunner;
/*    */ import net.minecraft.client.color.item.ItemColors;
/*    */ import net.minecraft.item.Item;


/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "mcheli", value = {Side.CLIENT})
/*    */ public class ItemColorRegistration
/*    */ {
/*    */   @Event/*    */   static void onRegisterItemColor(ColorHandlerEvent.Item event) {
/* 18 */     ItemColors itemColors = event.getItemColors();
/* 19 */     itemColors.registerItemColorHandler(MCH_ItemSpawnGunner::getColorFromItemStack, new Item[] { (Item)MCH_MOD.itemSpawnGunnerVsMonster, (Item)MCH_MOD.itemSpawnGunnerVsPlayer });
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\renderer\color\ItemColorRegistration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */