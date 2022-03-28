package base.mod.impl;

import base.event.EventManager;
import base.event.EventTarget;
import base.event.impl.EventUpdate;
import base.mod.Category;
import base.mod.Mod;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FullBright extends Mod{

	public FullBright() {
		super("FullBright", "mod", Category.WORLD);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.removePotionEffect(Potion.nightVision.getId());
		EventManager.unregister(this);
		super.onDisable();
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 5201, 1));

	}

}
