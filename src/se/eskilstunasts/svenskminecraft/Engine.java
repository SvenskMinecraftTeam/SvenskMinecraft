package se.eskilstunasts.svenskmineccraft;

import org.bukkit.plugin.java.JavaPlugin;
import se.eskilstunasts.svenskmineccraft.events.Save;
import se.eskilstunasts.svenskmineccraft.registers.RegisterEvents;

public class Engine extends JavaPlugin {
    public static String prefix = "§7[§eSvenskMinecraft§7] ";
    Save save;

    private static Engine instance;
    public static Engine getInstance() {
        return instance;
    }

    String name = getDescription().getName();

    public void onEnable() {
        instance = this;
        this.save = new Save();
        new RegisterEvents(this);
        getLogger().info(name + "[Aktiverat]");
    }

    public void onDisable() {
        getLogger().info(name + "[Inaktiverat]");
    }

}