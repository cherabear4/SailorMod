package base.gui.hud;

import java.awt.Color;
import java.io.IOException;

import base.Client;
import base.gui.clickgui.ClickGUI;
import base.gui.hud.mod.HudMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen{
	
	@Override
	public void initGui() {
		
		super.initGui();
		this.buttonList.add(new GuiButton(6340, this.width / 2 - 50, this.height / 2 - 10, 100, 20, "ClickGUI"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		for(HudMod m : Client.INSTANCE.hudManager.hudMods) {
				m.renderDummy(mouseX, mouseY);
			
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// TODO Auto-generated method stub
		super.actionPerformed(button);
		switch(button.id) {
		case 6340:
				mc.displayGuiScreen(new ClickGUI());
		}
	}
}
