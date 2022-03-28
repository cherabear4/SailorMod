package base.mod;

import java.util.ArrayList;

import base.mod.impl.FullBright;
import base.mod.impl.ToggleSprint;

public class ModManager {
	
	public ToggleSprint toggleSprint;
	public FullBright fullBright;
	
	public ArrayList<Mod> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		mods.add(toggleSprint = new ToggleSprint());
		mods.add(fullBright = new FullBright());
	}

}
