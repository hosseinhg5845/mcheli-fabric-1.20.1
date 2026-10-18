/*    */ package com.norwood.mcheli.helper.client.model.loader;
/*    */ 
/*    */ import com.norwood.mcheli.helper.client._IModelCustom;
/*    */ import com.norwood.mcheli.helper.client._ModelFormatException;
/*    */ import com.norwood.mcheli.wrapper.modelloader.W_WavefrontObject;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.resource.Resource;
/*    */ import net.minecraft.resource.ResourceManager;
/*    */ import net.minecraft.util.ResourceLocation;


/*    */ 
/*    */ /*    */ public class WavefrontModelLoader
/*    */   implements IVertexModelLoader
/*    */ {
/*    */   public _IModelCustom load(ResourceManager resourceManager, ResourceLocation location) throws IOException, _ModelFormatException {
/* 18 */     ResourceLocation modelLocation = withExtension(location);
/* 19 */     Resource resource = resourceManager.getResource(modelLocation);
/* 20 */     return (_IModelCustom)new W_WavefrontObject(modelLocation, resource);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getExtension() {
/* 25 */     return "obj";
/*    */   }
/*    */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\helper\client\model\loader\WavefrontModelLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */