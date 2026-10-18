/*     */ package com.norwood.mcheli.multiplay;
/*     */ 
/*     */ import com.norwood.mcheli.wrapper.W_McClient;
/*     */ import com.norwood.mcheli.wrapper.W_ScaledResolution;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.gui.DrawableHelperButton;
/*     */ import net.minecraft.client.gui.DrawableHelperTextField;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.util.Formatting;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_GuiScoreboard_CreateTeam
/*     */   extends MCH_GuiScoreboard_Base
/*     */ {
/*  16 */   private static final String[] colorNames = new String[] { "RESET", "BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA", "DARK_RED", "DARK_PURPLE", "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN", "AQUA", "RED", "LIGHT_PURPLE", "YELLOW" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean friendlyFire = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ButtonWidget buttonCreateTeamOK;
/*     */ 
/*     */ 
/*     */   
/*     */   private ButtonWidget buttonCreateTeamFF;
/*     */ 
/*     */ 
/*     */   
/*     */   private TextFieldWidget editCreateTeamName;
/*     */ 
/*     */ 
/*     */   
/*  38 */   private int lastTeamColor = 0;
/*     */   
/*     */   public MCH_GuiScoreboard_CreateTeam(MCH_IGuiScoreboard switcher, PlayerEntity player) {
/*  41 */     super(switcher, player);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  46 */     super.initGui();
/*  47 */     W_ScaledResolution w_ScaledResolution = new W_ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
/*  48 */     int factor = (w_ScaledResolution.getScaleFactor() > 0) ? w_ScaledResolution.getScaleFactor() : 1;
/*  49 */     this.guiLeft = 0;
/*  50 */     this.guiTop = 0;
/*  51 */     int x = this.mc.displayWidth / 2 / factor;
/*  52 */     int y = this.mc.displayHeight / 2 / factor;
/*  53 */     ButtonWidget buttonCTNextC = new ButtonWidget(576, x + 40, y - 20, 40, 20, ">");
/*  54 */     ButtonWidget buttonCTPrevC = new ButtonWidget(577, x - 80, y - 20, 40, 20, "<");
/*  55 */     this.buttonCreateTeamFF = new ButtonWidget(560, x - 80, y + 20, 160, 20, "");
/*  56 */     this.buttonCreateTeamOK = new ButtonWidget(528, x - 80, y + 60, 80, 20, "OK");
/*  57 */     ButtonWidget buttonCTCancel = new ButtonWidget(544, x, y + 60, 80, 20, "Cancel");
/*  58 */     this.editCreateTeamName = new TextFieldWidget(599, this.fontRenderer, x - 80, y - 55, 160, 20);
/*  59 */     this.editCreateTeamName.setText("");
/*  60 */     this.editCreateTeamName.setTextColor(-1);
/*  61 */     this.editCreateTeamName.setMaxStringLength(16);
/*  62 */     this.editCreateTeamName.setFocused(true);
/*  63 */     this.listGui.add(buttonCTNextC);
/*  64 */     this.listGui.add(buttonCTPrevC);
/*  65 */     this.listGui.add(this.buttonCreateTeamFF);
/*  66 */     this.listGui.add(this.buttonCreateTeamOK);
/*  67 */     this.listGui.add(buttonCTCancel);
/*  68 */     this.listGui.add(this.editCreateTeamName);
/*     */   }
/*     */   
/*     */   public void updateScreen() {
/*  72 */     String teamName = this.editCreateTeamName.getText();
/*  73 */     this.buttonCreateTeamOK.enabled = (!teamName.isEmpty() && teamName.length() <= 16);
/*  74 */     this.editCreateTeamName.updateCursorCounter();
/*  75 */     this.buttonCreateTeamFF.displayString = "Friendly Fire : " + (friendlyFire ? "ON" : "OFF");
/*     */   }
/*     */ 
/*     */   
/*     */   public void acviveScreen() {
/*  80 */     this.editCreateTeamName.setText("");
/*  81 */     this.editCreateTeamName.setFocused(true);
/*     */   }
/*     */   
/*     */   protected void keyTyped(char c, int code) {
/*  85 */     if (code == 1) {
/*  86 */       switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */     } else {
/*  88 */       this.editCreateTeamName.textboxKeyTyped(c, code);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/*  93 */     this.editCreateTeamName.mouseClicked(mouseX, mouseY, mouseButton);
/*  94 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */   
/*     */   protected void actionPerformed(@NotNull ButtonWidget btn) {
/*  98 */     if (btn.enabled) {
/*  99 */       String teamName; switch (btn.id) {
/*     */         case 528:
/* 101 */           teamName = this.editCreateTeamName.getText();
/* 102 */           if (!teamName.isEmpty() && teamName.length() <= 16) {
/* 103 */             MCH_PacketIndMultiplayCommand.send(768, "scoreboard teams add " + teamName);
/* 104 */             MCH_PacketIndMultiplayCommand.send(768, "scoreboard teams option " + teamName + " color " + colorNames[this.lastTeamColor]);
/* 105 */             MCH_PacketIndMultiplayCommand.send(768, "scoreboard teams option " + teamName + " friendlyfire " + friendlyFire);
/*     */           } 
/*     */           
/* 108 */           switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */           break;
/*     */         case 544:
/* 111 */           switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */           break;
/*     */         case 560:
/* 114 */           friendlyFire = !friendlyFire;
/*     */           break;
/*     */         case 576:
/* 117 */           this.lastTeamColor++;
/* 118 */           if (this.lastTeamColor >= colorNames.length) {
/* 119 */             this.lastTeamColor = 0;
/*     */           }
/*     */           break;
/*     */         case 577:
/* 123 */           this.lastTeamColor--;
/* 124 */           if (this.lastTeamColor < 0) {
/* 125 */             this.lastTeamColor = colorNames.length - 1;
/*     */           }
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
/* 133 */     drawList(this.mc, this.fontRenderer, true);
/* 134 */     W_ScaledResolution w_ScaledResolution = new W_ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
/* 135 */     int factor = (w_ScaledResolution.getScaleFactor() > 0) ? w_ScaledResolution.getScaleFactor() : 1;
/* 136 */     W_McClient.MOD_bindTexture("textures/gui/mp_new_team.png");
/* 137 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 138 */     int x = (this.mc.displayWidth / factor - 222) / 2;
/* 139 */     int y = (this.mc.displayHeight / factor - 200) / 2;
/* 140 */     drawTexturedModalRect(x, y, 0, 0, 222, 200);
/* 141 */     x = this.mc.displayWidth / 2 / factor;
/* 142 */     y = this.mc.displayHeight / 2 / factor;
/* 143 */     drawCenteredString("Create team", x, y - 85, -1);
/* 144 */     drawCenteredString("AbstractTeam name", x, y - 70, -1);
/* 145 */     Formatting ecf = Formatting.getValueByName(colorNames[this.lastTeamColor]);
/* 146 */     drawCenteredString(ecf + "AbstractTeam Color" + ecf, x, y - 13, -1);
/* 147 */     this.editCreateTeamName.drawTextBox();
/*     */   }
/*     */ }


/* Location:              C:\Users\ASUS\Desktop\De-Compile\plmcjar\mchelionukebeta.jar!\com\norwood\mcheli\multiplay\MCH_GuiScoreboard_CreateTeam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */