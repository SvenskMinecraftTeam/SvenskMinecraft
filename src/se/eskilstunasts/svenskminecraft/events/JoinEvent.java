package se.eskilstunasts.svenskmineccraft.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import se.eskilstunasts.svenskmineccraft.Engine;
import se.eskilstunasts.svenskmineccraft.utils.Utilities;

import java.io.File;
import java.io.IOException;

public class JoinEvent implements Listener {

    private static JoinEvent joinEvent;

    public static JoinEvent getJoinEvent() {
        return joinEvent;
    }

    public static File PlayerDataFile;
    public static FileConfiguration PlayerDataConfig;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        PlayerDataFile = new File("plugins/SvenskMinecraft/" + player.getUniqueId() + ".yml");
        PlayerDataConfig = new YamlConfiguration();

        if (!PlayerDataFile.exists()) {
            try {
                PlayerDataConfig.save(PlayerDataFile);
                PlayerDataConfig.createSection("Användarnamn");
                PlayerDataConfig.createSection("IP-adress");
                PlayerDataConfig.createSection("Vad mer vill vi spara?");
                PlayerDataConfig.save(PlayerDataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PlayerDataConfig.set("Användarnamn", player.getName());
        PlayerDataConfig.set("IP-adress", player.getAddress().getAddress().getHostAddress());
        try {
            PlayerDataConfig.save(PlayerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utilities.log("[Log] " + player.getName() + " anslöt sig");

        Location location = new Location(player.getWorld(), 187, 71, 191);

        if (!player.hasPlayedBefore()) {
            player.teleport(location);
            Engine.getInstance().getServer().broadcastMessage(player.getName() + " anslöt sig till servern för första gången.");
            player.sendMessage(ChatColor.GREEN + "-----------------------");
            player.sendMessage("Välkommen till Svensk Minecraft SMP!");
            player.sendMessage("");
            player.sendMessage(ChatColor.RED + "Läs skyltarna runt dig, sedan är det bara att börja spela!");
            player.sendMessage("Hoppas du får flera trevliga vistelser!");
            player.sendMessage(ChatColor.GREEN + "-----------------------");
        } else {
            player.sendMessage(ChatColor.GREEN + "Välkommen tillbaka till Svensk Minecraft SMP!");
        }
    }
}
