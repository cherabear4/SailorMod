package base.gui.hud.mod.impl;

import base.gui.hud.mod.HudMod;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;

public class TargetHUD extends HudMod{
	
	EntityLivingBase target;

	public TargetHUD() {
		super("TargetHUD", 850, 20);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		renderTargetHud();
		//Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 0/*170*/).getRGB());
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		fr.drawStringWithShadow(mc.thePlayer.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow((int)mc.thePlayer.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(mc.thePlayer.getName() + 30), getY() + 30, 20, 50, 0, mc.thePlayer);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}
	
	private void renderTargetHud() {
		if(!(mc.pointedEntity instanceof EntityItemFrame)) {
		target = (EntityLivingBase) mc.pointedEntity;
		
		if(target != null) {
		fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName() + 30), getY() + 30, 20, 50, 0, target);
		}

	}
	}


}
