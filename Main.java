package me.DJBiokinetix;

/*
*	Plugin hecho para PlayCraft Network
*	plugin especial para links sociales
*	API: craftbukkit-1.7-R0.1
*	El plugin acepta cualquier links social
*	ya sea Facebook, Twitter, GitHub y pagina WEB
*	Compatible con la nueva version de SpiGot 1.7 / 1.8
*
*	Se puede agregar el metodo "onFoodLevelChange" para un lobby o kitpvp
*
*	@EventHandler
*	public void onFoodLevelChange(FoodLevelChangeEvent evt){
*	evt.setFoodLevel(20);
*	}
*
*
*/

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable(){
		getLogger().info("Plugin activado correctamente!");
		saveDefaultConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player jugador = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("Mensaje")){
			jugador.sendMessage(ChatColor.AQUA + "============" + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Code" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA + "===========");
			jugador.sendMessage(ChatColor.YELLOW + " » " + ChatColor.DARK_RED + ChatColor.BOLD + "Play" + " " + ChatColor.GREEN  + ChatColor.BOLD + "Craft" + ChatColor.YELLOW + ChatColor.BOLD + "Network" + " " + ChatColor.YELLOW + " «");
			jugador.sendMessage(ChatColor.AQUA + "Visita nuesta pagina de facebook »" + " " + Facebook);
			jugador.sendMessage(ChatColor.AQUA + "Siguenos en Twitter »" + " " + Twitter);
			jugador.sendMessage(ChatColor.AQUA + "¿Developer? Vista nuestro GitHub »" + " " + GitHub);
			jugador.sendMessage(ChatColor.AQUA + "Mira nuesta pagina web »" + " " + WEB);
			jugador.sendMessage(ChatColor.AQUA + "=============================");
		}if(cmd.getName().equalsIgnoreCase("configrl")){
			saveDefaultConfig();
			reloadConfig();
			jugador.sendMessage(ChatColor.GREEN + "¡Configuración recargada!");
		}if(cmd.getName().equalsIgnoreCase("IP")){
			sender.sendMessage(ChatColor.AQUA + "¡Invita a tus amigos al servidor!");
			sender.sendMessage(ChatColor.RED + IP);
		}
		return false;
	}
	
	@EventHandler
	public void AlEntrar(PlayerJoinEvent e){
		if(e.getPlayer().hasPermission("join.message")){
		String Facebook = getConfig().getString("Facebook").replaceAll("&", "&");
		String Twitter = getConfig().getString("Twitter").replaceAll("&", "&");
		String GitHub = getConfig().getString("GitHub").replaceAll("&", "&");
		String WEB = getConfig().getString("WEB").replaceAll("&", "&");
		Player jugador = e.getPlayer();
		jugador.sendMessage(ChatColor.AQUA + "============" + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Code" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA + "===========");
		jugador.sendMessage(ChatColor.YELLOW + " » " + ChatColor.DARK_RED + ChatColor.BOLD + "Play" + " " + ChatColor.GREEN  + ChatColor.BOLD + "Craft" + ChatColor.YELLOW + ChatColor.BOLD + "Network" + " " + ChatColor.YELLOW + " «");
		jugador.sendMessage(ChatColor.AQUA + "Visita nuesta pagina de facebook »" + " " + Facebook);
		jugador.sendMessage(ChatColor.AQUA + "Siguenos en Twitter »" + " " + Twitter);
		jugador.sendMessage(ChatColor.AQUA + "Developer? Vista nuestro GitHub »" + " " + GitHub);
		jugador.sendMessage(ChatColor.AQUA + "Mira nuesta pagina web »" + " " + WEB);
		jugador.sendMessage(ChatColor.AQUA + "=============================");
		}
	}
}

