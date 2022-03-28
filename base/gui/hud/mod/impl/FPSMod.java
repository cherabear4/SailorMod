package base.gui.hud.mod.impl;

import java.awt.Color;

import base.gui.hud.mod.HudMod;
import net.minecraft.client.gui.Gui;


public class FPSMod extends HudMod{
	
	//§

	public FPSMod() {
		super("FPS", 100, 5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString("§6[§eCurrent FPS §f:" + mc.getDebugFPS() + "§6]", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString("§6[§eCurrent FPS §f:" + mc.getDebugFPS() + "§6]", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("§6[§eCurrent FPS §f:" + mc.getDebugFPS() + "§6]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	

}

