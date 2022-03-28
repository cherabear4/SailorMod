package base.util.config;

import java.io.File;
import java.io.IOException;

import base.Client;
import base.gui.hud.mod.HudMod;


public class Config {
	
	public File configFolder = new File("Client");
	public File modsFolder = new File("Client/Mods");
		
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("Client/Mods/ModConfiguration.clientconfig"));
	
	public void saveModConfig() {
		if(!configFolder.exists()) {
			configFolder.mkdirs();		
			}
		
		if(!modsFolder.exists()) {
			modsFolder.mkdirs();
		}
		
		System.out.println("Saving Mod Configuration");
		
		for(HudMod m : Client.INSTANCE.hudManager.hudMods) {
			configToSave.set(m.name.toLowerCase() + " x", m.getX());
			configToSave.set(m.name.toLowerCase() + " y", m.getY());
			configToSave.set(m.name.toLowerCase() + " enabled", m.isEnabled());
		}
		
		try {
			configToSave.save();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Mod Config Save Failed");
		}
		
		

	}
	
	public void loadModConfig() {
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("Client/Mods/ModConfiguration.clientconfig"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
