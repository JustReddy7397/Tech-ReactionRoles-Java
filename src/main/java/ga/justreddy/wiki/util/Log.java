package ga.justreddy.wiki.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author JustReddy
 */
public class Log {

    private static final Logger LOGGER = Logger.getLogger("ReactionRoles");

    public static void log(String message) {
        LOGGER.log(Level.INFO, message);
    }

    public static void warn(String message) {
        LOGGER.log(Level.WARNING, message);
    }

    public static void error(String message) {
        LOGGER.log(Level.SEVERE, message);
    }

}
