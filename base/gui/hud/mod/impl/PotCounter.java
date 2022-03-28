package base.gui.hud.mod.impl;

import base.event.EventManager;
import base.event.EventTarget;
import base.event.impl.EventUpdate;
import base.gui.hud.mod.HudMod;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;


public class PotCounter extends HudMod{
	
	public int potinv = 0;
	
	//§

	public PotCounter() {
		super("Pot Counter", 100, 120);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		
		//item count function in guiingame
		
		ItemStack potion = new ItemStack(Items.potionitem, 1, 16421);
		GuiIngame guiIngame = new GuiIngame(mc);
		itemcount(potion);
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(potion, this.getX(), this.getY());
		mc.getRenderItem().renderItemOverlayIntoGUI(this.fr, potion, getX(), getY(), potinv + "");
		RenderHelper.disableStandardItemLighting();
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		ItemStack potion = new ItemStack(Items.potionitem, 1, 16421);
		GuiIngame guiIngame = new GuiIngame(mc);
		itemcount(potion);
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(potion, this.getX(), this.getY());
		mc.getRenderItem().renderItemOverlayIntoGUI(this.fr, potion, getX(), getY(), potinv + "");
		RenderHelper.disableStandardItemLighting();
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 10;
	}
	
	@Override
	public int getHeight() {
		return 10;
	}
	
	public void itemcount(ItemStack stack) {
		
		
		potinv = 0;
			for(int i = 0; i < mc.thePlayer.inventory.getSizeInventory(); i++) {
				if(mc.thePlayer.inventory.getStackInSlot(i) != null && mc.thePlayer.inventory.getStackInSlot(i).getIsItemStackEqual(stack)) {
					potinv++;
				}
			}

	}

	
	
	
	

}

