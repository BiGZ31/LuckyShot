package fr.biigbossz.bow;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class bowjoin implements CommandExecutor {

	
	
private main main;
	
	
	public bowjoin(main main2) {
	this.main = main2;
}
	@Override

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		

		if (args.length == 0) {
			Inventory bow = Bukkit.createInventory(null, 9, "§6§lBow");
			
			ItemStack C = new ItemStack(Material.BOW, 1);
			ItemMeta checkpoint = C.getItemMeta();
			checkpoint.setDisplayName("§EJoin");
			checkpoint.setLore(Arrays.asList("", "§7To join the game do /bow join"));
			C.setItemMeta(checkpoint);
	    	
	    	
			ItemStack L = new ItemStack(Material.COMMAND, 1);
			ItemMeta leave = L.getItemMeta();
			leave.setDisplayName("§ESetup");
			leave.setLore(Arrays.asList("", "§7Click to setup the plugin"));
			L.setItemMeta(leave);
			
			ItemStack R = new ItemStack(Material.EMERALD, 1);
			ItemMeta remove = R.getItemMeta();
			remove.setDisplayName("§eRemove Cooldown");
			remove.setLore(Arrays.asList("", "§7Click to remove your cooldown (Admin)"));
			
			R.setItemMeta(remove);
			
	    	
	    	
	    	
	    	
	    	
	    	bow.setItem(0, C);
	    	bow.setItem(4, R);
	    	bow.setItem(8, L);
			
			
			p.openInventory(bow);
			return true;
		}
		
		if (args[0].equalsIgnoreCase("setup")) {
			if(p.hasPermission("bow.admin")) {
				Inventory setup = Bukkit.createInventory(null, 9, "§6§lBow Setup");
				
				ItemStack C = new ItemStack(Material.BOW, 1);
				ItemMeta checkpoint = C.getItemMeta();
				checkpoint.setDisplayName("§ESet Join Location");
				checkpoint.setLore(Arrays.asList("", "§7Click to set the join location"));
				C.setItemMeta(checkpoint);
		    	
		    	
				ItemStack L = new ItemStack(Material.REDSTONE, 1);
				ItemMeta leave = L.getItemMeta();
				leave.setDisplayName("§ESet Quit Location");
				leave.setLore(Arrays.asList("", "§7Click to set the leave location"));
				L.setItemMeta(leave);
				
				ItemStack R = new ItemStack(Material.COMMAND, 1);
				ItemMeta reload = R.getItemMeta();
				reload.setDisplayName("§EReload");
				reload.setLore(Arrays.asList("", "§7Click to reload"));
				R.setItemMeta(reload);
				
				ItemStack op = new ItemStack(Material.CHEST, 1);
				ItemMeta otherpl = op.getItemMeta();
				otherpl.setDisplayName("§EMy other plugins");
				otherpl.setLore(Arrays.asList("", "§7Click to view my other plugins"));
				op.setItemMeta(otherpl);
				
				ItemStack b = new ItemStack(Material.ARROW, 1);
				ItemMeta back = b.getItemMeta();
				back.setDisplayName("§cGo back");
				back.setLore(Arrays.asList("", "§7Click to go back"));
				b.setItemMeta(back);
		    	
				ItemStack V = new ItemStack(Material.DIAMOND, 1);
				ItemMeta ver = V.getItemMeta();
				ver.setDisplayName("§cAbout");
				ver.setLore(Arrays.asList("", "§7Version: 1.0", "§7Author: BiiGBosSZ"));
				V.setItemMeta(ver);
		    	
		    	
		    	
		    	
		    	setup.setItem(0, C);
		    	setup.setItem(1, L);
		    	setup.setItem(2, R);
		    	setup.setItem(4, op);
		    	setup.setItem(5, V);
		    	setup.setItem(8, b);
		    	
				
				
				p.openInventory(setup);
				
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("join")) {
			if(main.getConfig().getString("oldposloc.enabled").equals("true")) {///																				HERE !S
				bowlist.loc.put(p.getUniqueId(), p.getLocation());
			}
			if (bowlist.cooldown.containsKey(p.getUniqueId())) {
				long secondsleft = ((bowlist.cooldown.get(p.getUniqueId()) / 1000) + bowlist.cooldowntime) - (System.currentTimeMillis() / 1000);
				if (secondsleft > 0) {
					p.sendMessage("§aYou still need to wait "
							+secondsleft+ "§a seconds!");
					return true;
				}
				}
			if(bowlist.ingame.containsKey(p.getUniqueId())) {
				p.sendMessage(main.getConfig().getString("messages.ingame").replace("&", "§"));
				return true;
			}
			try {
				World w = Bukkit.getServer().getWorld(main.getConfig().getString("joinloc.world"));
	            double x = main.getConfig().getDouble("joinloc.x");
	            double y = main.getConfig().getDouble("joinloc.y");
	            double z = main.getConfig().getDouble("joinloc.z");
	            p.teleport(new Location(w, x, y, z));
			}catch(IllegalArgumentException exeption){
				p.sendMessage("§c§lERROR §CYou need to setup the Joining area !");
				return true;
			}
			
			bowlist.inventory.put(p.getUniqueId(), p.getInventory().getContents());
			
			
			
			
			
	            p.sendMessage(main.getConfig().getString("messages.join").replace("&", "§"));
				p.getInventory().clear();
				p.getInventory().addItem(new ItemStack(Material.BOW));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 5));
				bowlist.ingame.put(p.getUniqueId(), null);
				return true;
			}
		
		if (args[0].equalsIgnoreCase("reload")) {
			main.reloadConfig();
			main.saveConfig();
			p.sendMessage(main.getConfig().getString("messages.reload").replace("&", "§"));
			p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 5, 5);
			
		}
			
		
		
		return false;
	}

}
