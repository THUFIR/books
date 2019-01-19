package my.books;

import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(String[] args) throws Exception {
        new App().driver();
    }

    private void driver() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        LOG.info(properties.toString());
        URI inputURI = new URI(properties.getProperty("html_input"));
        URI outputURI = new URI(properties.getProperty("output"));
        
    }


}
