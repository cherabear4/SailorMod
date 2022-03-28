package base.gui.hud.mod.impl;

import java.awt.Color;

import base.gui.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

//authors: eric golde/quickdaffy


public class Xyz extends HudMod{
	
	//§

	public Xyz() {
		super("coordinates", 5, 450);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		 Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 60, this.getY() + this.getHeight(), new Color(0, 0, 0, 170).getRGB());
	       this.fr.drawString("§6[§ePos X§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
	       this.fr.drawString("§6[§ePos Y§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 12, -1);
	       this.fr.drawString("§6[§ePos Z§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 22, -1);
	       super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 60, this.getY() + this.getHeight(), new Color(0, 0, 0, 170).getRGB());
		this.fr.drawString("§6[§ePos X§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
	       this.fr.drawString("§6[§ePos Y§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 12, -1);
	       this.fr.drawString("§6[§ePos Z§6] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 22, -1);
        super.renderDummy(mouseX, mouseY);
	}
	
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return 30;
	}

}

