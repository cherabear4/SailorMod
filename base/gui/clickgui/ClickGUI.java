package base.gui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import base.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ClickGUI extends GuiScreen
{
    Minecraft mc;
    ArrayList<ModButton> modButtons;
    
    public ClickGUI() {
        this.mc = Minecraft.getMinecraft();
        this.modButtons = new ArrayList<ModButton>();
    }
    
    @Override
    public void initGui() {
    	this.modButtons.add(new ModButton(210, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.testMod));
		this.modButtons.add(new ModButton(280, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.targetHud));
		this.modButtons.add(new ModButton(350, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.keystrokes));
		this.modButtons.add(new ModButton(490, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.potCounter));
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        final FontRenderer fr = this.mc.fontRendererObj;
        super.drawScreen(mouseX, mouseY, partialTicks);
        //Gui.drawRect(127, 0, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(3, 144, 255).getRGB());
        Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0, 0, 0, 215).getRGB());
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        GlStateManager.scale(2.0f, 2.0f, 1.0f);
        GlStateManager.translate(-14.0f, 0.0f, 0.0f);
        Gui.drawCenteredString(fr, Client.INSTANCE.NAME + " GUI", 260, 10.0f, -1);
        GlStateManager.popMatrix();
        for (final ModButton m : this.modButtons) {
            m.draw();
        }
    }
    
    @Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for (final ModButton m : this.modButtons) {
            m.onClick(mouseX, mouseY, mouseButton);
        }
    }
}