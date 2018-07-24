package se.eskilstunasts.svenskminecraft.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerBed implements Listener {
    @EventHandler
    public void PlayerEvent(PlayerBedEnterEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getWorld() == Bukkit.getWorld("world") && Bukkit.getServer().getOnlinePlayers().size() > 1) {
            if (p.getWorld().getTime() >= 13000) {
                p.sendMessage(ChatColor.GREEN + "Du sover trots att det är personer inne!");
                p.getWorld().setTime(23400);
                Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.WHITE + " lade sig i sängen och gör dag till alla!");
            }
        } else {
            e.getPlayer().sendMessage(ChatColor.GREEN + "Zzz");
        }
    }
    @EventHandler
    public void PlayerEventLeave(PlayerBedLeaveEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getWorld() == Bukkit.getWorld("world")) {
            p.getWorld().setTime(0);
            Bukkit.broadcastMessage("Godmorgon!");
        }
    }
}