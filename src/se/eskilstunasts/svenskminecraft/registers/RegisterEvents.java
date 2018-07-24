package se.eskilstunasts.svenskmineccraft.registers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import se.eskilstunasts.svenskmineccraft.Engine;
import se.eskilstunasts.svenskmineccraft.commands.StaffChat;
import se.eskilstunasts.svenskmineccraft.events.ChatFormat;
import se.eskilstunasts.svenskmineccraft.events.JoinEvent;
import se.eskilstunasts.svenskmineccraft.events.StaffChatEvent;

public class RegisterEvents {

    Engine engine;

    public RegisterEvents(Engine engine) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinEvent(), engine);
        pm.registerEvents(new ChatFormat(), engine);
        pm.registerEvents(new StaffChatEvent(), engine);
        pm.registerEvents(new PlayerBed(), engine);
        engine.getCommand("sc").setExecutor(new StaffChat());
    }
}
