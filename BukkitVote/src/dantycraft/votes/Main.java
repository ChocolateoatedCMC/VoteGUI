package dantycraft.votes;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	//This Plugin Was Made For DantyCraft And Is Now Public By The Owner Of DantyCraft!
	
	//Variables For Configuration:
	public String TopText = getConfig().getString("TopText");
	
	public String itemName1 = getConfig().getString("item1");
	public String itemName2 = getConfig().getString("item2");
	public String itemName3 = getConfig().getString("item3");
	
	public String itemLore1 = getConfig().getString("item1Lore");
	public String itemLore2 = getConfig().getString("item2Lore");
	public String itemLore3 = getConfig().getString("item3Lore");
	
	public String itemLink1 = getConfig().getString("item1Link");
	public String itemLink2 = getConfig().getString("item2Link");
	public String itemLink3 = getConfig().getString("item3Link");
	

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("vote")) {
			Player player = (Player) sender;
			player.openInventory(vote);
			player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
		}
		return false;
	}

	private ItemStack createItem(Material material, int amount, int shrt,
			String displayname, String lore) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return item;
	}

	public static Inventory vote;
	{
		vote = Bukkit
				.createInventory(null, 9, TopText);
		// 3/6
		vote.setItem(
				1,
				createItem(Material.FIREWORK, 1, (short) 0,
						itemName1, itemLore1));
		vote.setItem(
				4,
				createItem(Material.FIREWORK, 1, (short) 0, itemName2,
						itemLore2));
		vote.setItem(
				7,
				createItem(Material.FIREWORK, 1, (short) 0, itemName3,
						itemLore3));
	}

	@EventHandler
	public void clickItem(InventoryClickEvent event) {
		Player clicker = (Player) event.getWhoClicked();

		if (event.getInventory().getName().equals(Main.vote.getName())) {
			event.setCancelled(true);

			if (event.getCurrentItem() == null) {
				return;
			}
			if (!event.getCurrentItem().hasItemMeta()) {
				return;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName()
					.equals(itemName1)) {
				clicker.closeInventory();
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("-----------------------");
				clicker.sendMessage(" Click Here To Vote:");
				clicker.sendMessage(itemLink1);
				clicker.sendMessage("-----------------------");
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName()
					.equals(itemName2)) {
				clicker.closeInventory();
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("");
				clicker.sendMessage("-----------------------");
				clicker.sendMessage(" Click Here To Vote:");
				clicker.sendMessage(itemLink2);
				clicker.sendMessage("-----------------------");
			}

		}if(event.getCurrentItem().getItemMeta().getDisplayName().equals(itemName3)){
			clicker.closeInventory();
			clicker.sendMessage("");
			clicker.sendMessage("");
			clicker.sendMessage("");
			clicker.sendMessage("");
			clicker.sendMessage("");
			clicker.sendMessage("-----------------------");
			clicker.sendMessage(" Click Here To Vote:");
			clicker.sendMessage(itemLink3);
			clicker.sendMessage("-----------------------");
		}

	}

}
