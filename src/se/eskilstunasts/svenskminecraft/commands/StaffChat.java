package se.eskilstunasts.svenskmineccraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class StaffChat implements CommandExecutor {

    public static ArrayList<Player> Chatt = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Du måste vara en spelare för att kunna göra detta kommando!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length > 1) {
            player.sendMessage(ChatColor.RED + "Användning: /sc");
            return true;
        }

        if (args.length == 0) {
            if (!(player.hasPermission("svenskminecraft.admin"))) {
                player.sendMessage(ChatColor.RED + "Du har inte tillräckligt med rättigheter för att kunna göra detta kommando.");
                return true;
            }

            if (Chatt.contains(player)) {
                Chatt.remove(player);
                player.sendMessage(ChatColor.RED + "Staffchatten har blivit inaktiverad!");
                return true;
            } else {
                Chatt.add(player);
                player.sendMessage(ChatColor.GREEN + "Staffchatten har blivit aktiverad!");
                return true;
            }
        }
        return false;
    }
}
