import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Redirect {
    private static final Logger LOGGER = Logger.getLogger(Redirect.class.getName());

    public Redirect() {};

    public static void redirectToUrl(String link) {
        try {
            URI url = new URI(link);

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(url);
            } else {
                Runtime.getRuntime().exec(new String[] {"xdg-open", url.toString()});
            }
        } catch (IOException | URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "Failed to redirect to URL", e);
        }
    }
}
