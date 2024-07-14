package fr.biigbossz.bow;

import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("bow").setExecutor(new bowjoin(this));
		getServer().getPluginManager().registerEvents(new bowlist(this), this);
	}

}
