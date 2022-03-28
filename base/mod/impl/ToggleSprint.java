package base.mod.impl;


import base.event.EventTarget;
import base.event.impl.EventUpdate;
import base.mod.Category;
import base.mod.Mod;
import net.minecraft.potion.Potion;

public class ToggleSprint extends Mod{

	public ToggleSprint() {
		super("ToggleSprint", "Toggle Sprint", Category.MISC);
		// TODO Auto-generated constructor stub
	}
	
	@EventTarget
	private void onUpdate(EventUpdate event) {
		if(this.isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionX != 0 
				&&  mc.thePlayer.motionZ != 0) 
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindRight.isKeyDown())
		{
			if (mc.gameSettings.keyBindForward) {
				mc.thePlayer.setSprinting(true);
		}
		}

	}

	

	@Override

	public void onDisable() {

		super.onDisable();

		

		mc.thePlayer.setSprinting(false);

	}
}
