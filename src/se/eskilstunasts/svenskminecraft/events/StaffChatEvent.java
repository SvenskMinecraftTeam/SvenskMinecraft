package se.eskilstunasts.svenskmineccraft.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import se.eskilstunasts.svenskmineccraft.utils.Utilities;
import se.eskilstunasts.svenskmineccraft.commands.StaffChat;

public class StaffChatEvent implements Listener {

    private static String prefix = "§7[§eStaff§7] ";

    @EventHandler
    public void onStaff(AsyncPlayerChatEvent event)  {
        Player player = event.getPlayer();

        if(StaffChat.Chatt.contains(player)) {
            event.setCancelled(true);

            for(Player staff : Bukkit.getServer().getOnlinePlayers()) {
                if(staff.hasPermission("svenskminecraft.admin")) {
                    staff.sendMessage(prefix + player.getDisplayName() + ChatColor.RED + " > " + ChatColor.AQUA + event.getMessage());
                    Utilities.log("[Log] [STAFF] " + player.getName() + ": " + event.getMessage());
                }
            }
        }
    }
}
