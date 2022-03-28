package base;

import org.lwjgl.opengl.Display;

import base.event.EventManager;
import base.event.EventTarget;
import base.event.impl.ClientTick;
import base.gui.clickgui.ClickGUI;
import base.gui.hud.HUDConfigScreen;
import base.gui.hud.mod.HudManager;
import base.mod.ModManager;
import base.util.config.Config;
import net.minecraft.client.Minecraft;

public class Client {
	public String NAME = "SailorMod", VERSION = "B1", NAMEVER = NAME + " " + VERSION;
	public static Client INSTANCE = new Client();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public Config config;
	public HudManager hudManager;
	public ModManager modManager;
	
	
	public void startup() {
		
		eventManager = new EventManager();
		(this.config = new Config()).loadModConfig();
		hudManager = new HudManager();
		modManager = new ModManager();
		
		
	

		
		
		System.out.println("Starting up base client " + NAMEVER);
		Display.setTitle(Client.INSTANCE.NAME + " | " + VERSION + " | by" + " Piggydoe");
		EventManager.register(this);
		//SessionChanger.getInstance().setUserOffline("IhackedPiggy");
	}
	
	public void shutdown() {
		System.out.println("Shutting up mango client " + NAMEVER);
		config.saveModConfig();
		EventManager.unregister(this);

	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.HUD.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if (this.mc.gameSettings.keyBindInventory.isPressed()) {
            this.modManager.toggleSprint.toggle();
        }
		if(this.mc.gameSettings.FULL_BRIGHT.isPressed()) {
			this.modManager.fullBright.toggle();
		}
		
	}

}
