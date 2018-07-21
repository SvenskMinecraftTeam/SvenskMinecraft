package se.eskilstunasts.svenskmineccraft.utils;

import se.eskilstunasts.svenskmineccraft.Engine;

import java.util.logging.Level;

public class Utilities {

    public static void log(String message) {
        Engine.getInstance().getLogger().log(Level.WARNING, message);
    }

}
