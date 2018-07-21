package se.eskilstunasts.svenskmineccraft.events;

import org.bukkit.scheduler.BukkitRunnable;
import se.eskilstunasts.svenskmineccraft.Engine;

public class Save {

    public Save() {
        new BukkitRunnable() {
            public void run() {
                Save.this.oncePerMinute();
            }
        }.runTaskTimerAsynchronously(Engine.getInstance(), 0L, 6000L);
    }

    public void oncePerMinute() {
        new BukkitRunnable() {
            public void run() {
                Engine.getInstance().getServer().dispatchCommand(Engine.getInstance().getServer().getConsoleSender(), "save-all");
            }
        }.runTask(Engine.getInstance());
    }
}
