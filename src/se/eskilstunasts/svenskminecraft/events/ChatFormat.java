package se.eskilstunasts.svenskmineccraft.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import se.eskilstunasts.svenskmineccraft.utils.Utilities;

public class ChatFormat implements Listener {

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("svenskminecraft.admin")) {
            event.setFormat(ChatColor.RED + player.getName() + "§8: §7" + event.getMessage());
            Utilities.log("[Log] " + player.getName() + ": " + event.getMessage());
        } else if (player.hasPermission("svenskminecraft.veteran")) {
            event.setFormat(ChatColor.GOLD + player.getName() + "§8: §7" + event.getMessage());
            Utilities.log("[Log] " + player.getName() + ": " + event.getMessage());
        } else {
            event.setFormat(ChatColor.LIGHT_PURPLE + player.getName() + "§8: §7" + event.getMessage());
            Utilities.log("[Log] " + player.getName() + ": " + event.getMessage());
        }

    }
}
