package fr.biigbossz.bow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.BlockIterator;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;


public class bowlist implements Listener {
private main main;
	
	
	public bowlist(main main) {
	this.main = main;
	}
	
	static HashMap<UUID,Long> ingame = new HashMap<UUID,Long>();
	static HashMap<UUID, ItemStack[]> inventory = new HashMap<>();
	static HashMap<UUID,Long> cooldown = new HashMap<UUID,Long>();
	static HashMap<UUID, Location> loc = new HashMap<UUID, Location>();
	static int cooldowntime = 86400;
	private HashMap<Block, Material> iron = new HashMap<Block, Material>();
	private HashMap<Block, Material> gold = new HashMap<Block, Material>();
	private HashMap<Block, Material> diamond = new HashMap<Block, Material>();
	
	@EventHandler
	public boolean onProjectileHit(ProjectileHitEvent event){

	    Projectile arrow = event.getEntity();
	    Player p = (Player) arrow.getShooter();
	    World world = arrow.getWorld();
	    BlockIterator bi = new BlockIterator(world, arrow.getLocation().toVector(), arrow.getVelocity().normalize(), 0, 4);
	    Block hit = null;
	    if(ingame.containsKey(p.getUniqueId())) {

	    while(bi.hasNext())
	    {
	        hit = bi.next();
	        if(hit.getType() !=Material.AIR) //Grass/etc should be added probably since arrows doesn't collide with them
	        {
	            break;
	        }
	    }
	    if(hit.getType() ==Material.IRON_BLOCK) {
		    
	    	p.sendMessage(main.getConfig().getString("messages.iron").replace("&", "§"));
	        p.getLocation().getWorld().playSound(p.getLocation() ,Sound.ENTITY_ARROW_HIT_PLAYER, 5, 5);
	        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	        Bukkit.dispatchCommand(console, main.getConfig().getString("commands.iron").replace("%player%", p.getPlayer().getName()));
	        iron.put(hit, hit.getType());
	        hit.setType(Material.GLOWSTONE);
	    }
	    
	    
	    
	    if(hit.getType() ==Material.GOLD_BLOCK) {
	    
	    	p.sendMessage(main.getConfig().getString("messages.gold").replace("&", "§"));
	        p.getLocation().getWorld().playSound(p.getLocation() ,Sound.ENTITY_ARROW_HIT_PLAYER, 5, 5);
	        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	        Bukkit.dispatchCommand(console, main.getConfig().getString("commands.gold").replace("%player%", p.getPlayer().getName()));
	        gold.put(hit, hit.getType());
	        hit.setType(Material.GLOWSTONE);

	    }
	    
	    
	    
	    if(hit.getType() ==Material.DIAMOND_BLOCK) {
	    	p.sendMessage(main.getConfig().getString("messages.diamond").replace("&", "§"));
	        p.getLocation().getWorld().playSound(p.getLocation() ,Sound.ENTITY_FIREWORK_LARGE_BLAST, 5, 5);
	        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	        Bukkit.dispatchCommand(console, main.getConfig().getString("commands.diamond").replace("%player%", p.getPlayer().getName()));
	        diamond.put(hit, hit.getType());
	        hit.setType(Material.GLOWSTONE);
	    }
	        
	    }
		return false;
	    }
	
	
	    ///########################################IVENTAIRE FIN DE GAME ARC######################################################
	    @EventHandler
	    public void onmovecheckinv(PlayerMoveEvent event){ 
			Player player = event.getPlayer();
			 if(ingame.containsKey(player.getUniqueId())) {
				
				
				if(!player.getInventory().contains(Material.ARROW)) {
				Inventory inv = Bukkit.createInventory(null, 9, "§7Shop");
				///kit basique
				ItemStack l = new ItemStack(Material.REDSTONE_BLOCK, 1);
				ItemMeta leave = l.getItemMeta();
				leave.setDisplayName(main.getConfig().getString("items.leave.name").replace("&", "§"));
				leave.setLore(Arrays.asList("", main.getConfig().getString("items.leave.lore").replace("&", "§")));
				leave.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				leave.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				l.setItemMeta(leave);
				/// kit tank
				ItemStack s = new ItemStack(Material.COAL_BLOCK, 1);
				ItemMeta séparation = s.getItemMeta();
				séparation.setDisplayName(main.getConfig().getString("items.info.name").replace("&", "§"));
				séparation.setLore(Arrays.asList("", main.getConfig().getString("items.info.lore").replace("&", "§")));
				s.setItemMeta(séparation);
				
				///kit speed
				ItemStack a = new ItemStack(Material.EMERALD_BLOCK, 1);
				ItemMeta achete = a.getItemMeta();
				achete.setDisplayName(main.getConfig().getString("items.buymore.name").replace("&", "§"));
				achete.setLore(Arrays.asList("", main.getConfig().getString("items.buymore.lore").replace("&", "§")));
				achete.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				achete.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				a.setItemMeta(achete);
				
				inv.setItem(0, a);
				inv.setItem(1, a);
				inv.setItem(2, a);
				inv.setItem(3, a);
				inv.setItem(4, s);
				inv.setItem(5, l);
				inv.setItem(6, l);
				inv.setItem(7, l);
				inv.setItem(8, l);
				
				
				
				
				player.openInventory(inv);
				}
			}
	    }
	    @EventHandler
		public void onclickininv(InventoryClickEvent event) {
			Inventory inv = event.getInventory();
			Player player = (Player) event.getWhoClicked();
			ItemStack current = event.getCurrentItem();
			
			

			if(inv.getName().equalsIgnoreCase("§7Shop")) {
				event.setCancelled(true);
				
				if(current.getType() == Material.REDSTONE_BLOCK) {
					try {
					    if(main.getConfig().getString("oldposloc.enabled").equals("false")) {
					World w = Bukkit.getServer().getWorld(main.getConfig().getString("leaveloc.world"));
		            double x = main.getConfig().getDouble("leaveloc.x");
		            double y = main.getConfig().getDouble("leaveloc.y");
		            double z = main.getConfig().getDouble("leaveloc.z");
		            player.teleport(new Location(w, x, y, z));
					}
					} catch (IllegalArgumentException exception) {
					    player.sendMessage("§c§lERROR §CYou need to setup the Quit area !");
					    player.getInventory().addItem(new ItemStack(Material.ARROW));
					    player.closeInventory();
					    return;
					}
		            ingame.remove(player.getUniqueId());
		            cooldown.put(player.getUniqueId(), System.currentTimeMillis());
		            player.getInventory().setContents(inventory.get(player.getUniqueId()));
					player.sendMessage(main.getConfig().getString("messages.leave").replace("&", "§"));
					iron.keySet().forEach(b ->{
			            b.setType(Material.IRON_BLOCK);
			        });	
					iron.clear();
					gold.keySet().forEach(b ->{
			            b.setType(Material.GOLD_BLOCK);
			        });	
					gold.clear();
					diamond.keySet().forEach(b ->{
			            b.setType(Material.DIAMOND_BLOCK);
			        });	
					diamond.clear();
					if(main.getConfig().getString("oldposloc.enabled").equals("true")) {
						player.teleport(loc.get(player.getUniqueId()));
						loc.remove(player.getUniqueId());
					}
					
					
				}
				if(current.getType() == Material.COAL_BLOCK) {
					player.getLocation().getWorld().playSound(player.getLocation(), Sound.BLOCK_STONE_PLACE, 5, 5);
					
				}
				if(current.getType() == Material.EMERALD_BLOCK) {
					player.sendMessage(main.getConfig().getString("messages.store").replace("&", "§"));
					player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADING, 5, 5);
					
					
				}
			}
			
			
			
			if(inv.getName().equalsIgnoreCase("§6§lBow Setup")) {
				event.setCancelled(true);
				
				if(current.getType() == Material.BOW) {
					player.sendMessage("§7[§c!§7] You have set the join location !");
					main.getConfig().set("joinloc.world", player.getWorld().getName());
					main.getConfig().set("joinloc.y",player.getLocation().getY());
					main.getConfig().set("joinloc.x",player.getLocation().getX());
					main.getConfig().set("joinloc.z",player.getLocation().getZ());
					main.saveConfig();
					main.reloadConfig();
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 5);
			
				}
				if(current.getType() == Material.REDSTONE) {
					player.sendMessage("§7[§c!§7] You have set the Quit location !");
					main.getConfig().set("leaveloc.world", player.getWorld().getName());
					main.getConfig().set("leaveloc.y",player.getLocation().getY());
					main.getConfig().set("leaveloc.x",player.getLocation().getX());
					main.getConfig().set("leaveloc.z",player.getLocation().getZ());
					main.saveConfig();
					main.reloadConfig();
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 5);
			
				}
				
				if(current.getType() == Material.COMMAND) {
					player.closeInventory();
					TextComponent message = new TextComponent("§bClick here to confirm");
					message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/bow reload"));
					player.spigot().sendMessage(message);
					
				}
				
				if(current.getType() == Material.ARROW) {
					player.performCommand("bow");
					player.getWorld().playSound(player.getLocation(), Sound.BLOCK_STONE_BREAK, 5, 5);
					
				}
				
				if(current.getType() == Material.CHEST) {///																							other plugins list
					player.getWorld().playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 5, 5);
					Inventory plugins = Bukkit.createInventory(null, 9, "§6§LMy Plugins");
					
					ItemStack skull4 = new ItemStack(Material.SKULL_ITEM, 1);///									lf
			    	SkullMeta skullMeta4 = (SkullMeta) skull4.getItemMeta();
			    	skull4.setDurability((short) 3);
			    	skullMeta4.setDisplayName("§4Lobby Fighting");
			    	skullMeta4.setLore(Arrays.asList("","§7A plugin to enable pvp at your lobby", "§7Version: §c1.0"));
			    	skullMeta4.setOwner("BiiGBosSZ");
			    	
			    	skull4.setItemMeta(skullMeta4);
			    	
			    	
			    	ItemStack bo = new ItemStack(Material.BOW, 1);
					ItemMeta bow = bo.getItemMeta();
					bow.setDisplayName("§cBow Cosmetics");
					bow.setLore(Arrays.asList("", "§7Win cosmetics with great aim !"));
					bo.setItemMeta(bow);
					
			    	
			    	ItemStack battery = new ItemStack(Material.SKULL_ITEM, 1);///										cat
			    	SkullMeta skullMeta5 = (SkullMeta) battery.getItemMeta();
			    	battery.setDurability((short) 3);
			    	skullMeta5.setDisplayName("§eAudible Chat");
			    	skullMeta5.setLore(Arrays.asList("","§7Make sounds when you talk !", "§7Version: §e1.0"));
			    	skullMeta5.setOwner("Dora_Aventureira");
			    	
			    	battery.setItemMeta(skullMeta5);
			    	
			    	ItemStack b = new ItemStack(Material.ARROW, 1);
					ItemMeta back = b.getItemMeta();
					back.setDisplayName("§cGo back");
					back.setLore(Arrays.asList("", "§7Click to go back"));
					b.setItemMeta(back);
			    	
			    	
			    	
			    	
					plugins.setItem(0, skull4);
					plugins.setItem(1, battery);
					plugins.setItem(2, bo);
					plugins.setItem(8, b);
					
					
					player.openInventory(plugins);
					return;
					
					
				}
				
				
			}
			
			if(inv.getName().equalsIgnoreCase("§6§LMy Plugins")) {
				event.setCancelled(true);
				
				if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§4Lobby Fighting")){
					player.sendMessage("§7Plugin website: §bhttps://www.spigotmc.org/resources/%E2%9A%94%EF%B8%8F-lobby-fighting-%E2%9A%94%EF%B8%8F-pvp-in-all-your-lobbies.99813");
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRONGOLEM_ATTACK, 5, 5);
					return;
				}
				
				if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§eAudible Chat")){
					player.sendMessage("§7Plugin website: §bhttps://www.spigotmc.org");
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_AMBIENT, 5, 5);
					return;
				}
				if(current.getType() == Material.ARROW) {
					player.performCommand("bow setup");
					player.getWorld().playSound(player.getLocation(), Sound.BLOCK_STONE_BREAK, 5, 5);
				}
				if(current.getType() == Material.BOW) {
					player.sendMessage("§7Plugin website: §bhttps://www.spigotmc.org");
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 5, 5);
				}
				
			}
			
			
			
			
			if(inv.getName().equalsIgnoreCase("§6§lBow")) {
				event.setCancelled(true);
				if(current.getType() == Material.EMERALD) {
					if(player.hasPermission("bow.admin"));
					cooldown.remove(player.getUniqueId());
					player.sendMessage(main.getConfig().getString("messages.cooldownremove").replace("&", "§"));
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
					
				}
				
				if(current.getType() == Material.BOW) {
					player.performCommand("bow join");
					
				}
				if(current.getType() == Material.COMMAND) {
					player.performCommand("bow setup");
				}
				
			}
			
		}
	    @EventHandler
		public void leaveingame(PlayerQuitEvent event) {
	    	Player p =event.getPlayer();
	    	if(ingame.containsKey(p.getUniqueId())) {
	    		cooldown.put(p.getUniqueId(), System.currentTimeMillis());
	    		ingame.remove(p.getUniqueId());
	    	iron.keySet().forEach(b ->{
	            b.setType(Material.IRON_BLOCK);
	        });	
			iron.clear();
			gold.keySet().forEach(b ->{
	            b.setType(Material.GOLD_BLOCK);
	        });	
			gold.clear();
			diamond.keySet().forEach(b ->{
	            b.setType(Material.DIAMOND_BLOCK);
	        });	
			diamond.clear();
	    	}
	    }
	

}
