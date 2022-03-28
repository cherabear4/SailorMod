package base.gui.hud.mod;

import java.util.ArrayList;

import base.gui.hud.mod.impl.FPSMod;
import base.gui.hud.mod.impl.Keystrokes;
import base.gui.hud.mod.impl.PotCounter;
import base.gui.hud.mod.impl.TargetHUD;
import base.gui.hud.mod.impl.TestMod;
import base.gui.hud.mod.impl.Xyz;
import base.mod.impl.FullBright;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public TestMod testMod;
	public FPSMod fps;
	public PotCounter potCounter;
	
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
	public Xyz xyz;
	
	
	public HudManager() {
		hudMods.add(testMod = new TestMod());
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(xyz = new Xyz());
		hudMods.add(potCounter = new PotCounter());
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
				m.draw();
			}
			
		}

	}
}
