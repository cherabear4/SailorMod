package base.gui.hud.mod.impl;

import base.Client;
import base.gui.hud.mod.HudMod;

public class TestMod extends HudMod{

	public TestMod() {
		super(Client.INSTANCE.NAME, 5, 5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		//Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 0/*170*/).getRGB());
		fr.drawString(name, getX(), getY(), -1 );
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString(name, getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	


}
